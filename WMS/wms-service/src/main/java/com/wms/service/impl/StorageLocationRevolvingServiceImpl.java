package com.wms.service.impl;

import com.github.pagehelper.PageHelper;
import com.wms.common.DateUtils;
import com.wms.common.GetCurrentUserName;
import com.wms.dao.IMaterialsDao;
import com.wms.dao.StorageLocationRevolvingDao;
import com.wms.pojo.Materials;
import com.wms.pojo.StorageLocationRevolving;
import com.wms.service.StorageLocationRevolvingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@Transactional
public class StorageLocationRevolvingServiceImpl implements StorageLocationRevolvingService {

    @Autowired
    private StorageLocationRevolvingDao storageLocationRevolvingDao;
    @Autowired
    private IMaterialsDao iMaterialsDao;

    /**
     * 查询物品申请记录
     * @param page
     * @param size
     * @param materialsName
     * @return
     * @throws Exception
     */
    @Override
    public List<StorageLocationRevolving> selectStorageLocationRevolvingRecord(Integer page,Integer size,String materialsName) throws Exception {
        PageHelper.startPage(page,size);
        List<StorageLocationRevolving> storageLocationRevolvingList = storageLocationRevolvingDao.selectStorageLocationRevolvingRecord(materialsName);
        if (!CollectionUtils.isEmpty(storageLocationRevolvingList)) {
            storageLocationRevolvingList.forEach(i -> {
                i.setApplyTimeStr(i.getApplyTime()!=null? DateUtils.dateToString(i.getApplyTime()): "");
            });
        }
        return storageLocationRevolvingList;
    }

    /**
     * 添加物品周转记录
     * @param storageLocationRevolving
     * @throws Exception
     */
    @Override
    public void addStorageLocationRevolvingRecord(StorageLocationRevolving storageLocationRevolving) throws Exception {
        storageLocationRevolving.setApplyPerson(GetCurrentUserName.getCurrentUserUserName().getUsername());
        storageLocationRevolving.setAuditStatus(0);
        storageLocationRevolvingDao.addStorageLocationRevolvingRecord(storageLocationRevolving);
    }

    /**
     * 更新物品库位周转的审核状态
     * @param id
     * @param auditStatus
     * @throws Exception
     */
    @Override
    public void updateStorageLocationRevolving(String id, String auditStatus) throws Exception {
        // 审核批准后修改库区库位
        if ("1".equals(auditStatus)) {
            // 根据id查询物品周转申请记录
            StorageLocationRevolving storageLocationRevolving = storageLocationRevolvingDao.selectStorageLocationRevolvingRecordById(Integer.valueOf(id));
            // 用物品周转申请记录里的物品id查询物品信息
            Materials materials = iMaterialsDao.selectMaterialsById(storageLocationRevolving.getMaterialsId());
            materials.setStorageLocationName(storageLocationRevolving.gettStorageLocationName());
            materials.setGoodsShelf(storageLocationRevolving.gettGoodsShelf());
            // 修改物品的库区库位信息
            iMaterialsDao.updateMaterials(materials);
        }
        storageLocationRevolvingDao.updateStorageLocationRevolving(Integer.valueOf(id),Integer.valueOf(auditStatus));
    }
}
