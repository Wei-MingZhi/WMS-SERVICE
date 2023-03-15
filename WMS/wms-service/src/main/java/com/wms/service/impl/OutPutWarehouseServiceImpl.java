package com.wms.service.impl;

import com.github.pagehelper.PageHelper;
import com.wms.common.DateUtils;
import com.wms.common.GetCurrentUserName;
import com.wms.dao.IMaterialsDao;
import com.wms.dao.OutPutWarehouseDao;
import com.wms.pojo.Materials;
import com.wms.pojo.OutPutWarehouse;
import com.wms.service.OutPutWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
@Transactional
public class OutPutWarehouseServiceImpl implements OutPutWarehouseService {

    @Autowired
    private OutPutWarehouseDao outPutWarehouseDao;
    @Autowired
    private IMaterialsDao iMaterialsDao;

    /**
     * 添加出入库记录
     * @param outPutWarehouse
     * @throws Exception
     */
    @Override
    public void addOutPutWarehouseRecord(OutPutWarehouse outPutWarehouse) throws Exception {
        if (!ObjectUtils.isEmpty(outPutWarehouse)) {
            outPutWarehouse.setApplyPerson(GetCurrentUserName.getCurrentUserUserName().getUsername());
            outPutWarehouse.setAuditStatus(0);
            outPutWarehouseDao.addOutPutWarehouseRecord(outPutWarehouse);
        }

    }

    /**
     * 查询出入库记录
     * @return
     * @throws Exception
     */
    @Override
    public List<OutPutWarehouse> selectOutPutWarehouseRecord(Integer page, Integer size) throws Exception {
        PageHelper.startPage(page,size);
        List<OutPutWarehouse> outPutWarehouseList = outPutWarehouseDao.selectOutPutWarehouseRecord();
        outPutWarehouseList.forEach(i -> {
            if (i.getApplyTime() != null) {
                i.setApplyTimeStr(DateUtils.dateToString(i.getApplyTime()));
            }
        });
        return outPutWarehouseList;
    }

    /**
     * 跟新审核状态
     * @param id
     * @param auditStatus
     * @throws Exception
     */
    @Override
    public void updateOutPutWarehouse(String id, String auditStatus) throws Exception {
        // 批准后更改物品库存数量
        if ("1".equals(auditStatus)) {
            // 根据id查询出入库记录
            OutPutWarehouse outPutWarehouse = outPutWarehouseDao.selectOutPutWarehouseRecordById(Integer.valueOf(id));
            // 根据物品出入库记录中的物品id查询物品信息
            Materials materials = iMaterialsDao.selectMaterialsById(outPutWarehouse.getMaterialsId());
            // 更新库存信息
            materials.setInventoryNumber(materials.getInventoryNumber()-outPutWarehouse.getApplyNumber());
            iMaterialsDao.updateMaterials(materials);
        }
        outPutWarehouseDao.updateOutPutWarehouse(Integer.valueOf(id),Integer.valueOf(auditStatus));
    }


}
