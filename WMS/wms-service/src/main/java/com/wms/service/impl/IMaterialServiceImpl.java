package com.wms.service.impl;

import com.github.pagehelper.PageHelper;
import com.wms.common.GetCurrentUserName;
import com.wms.dao.IMaterialsDao;
import com.wms.pojo.Materials;
import com.wms.service.IMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
@Transactional
public class IMaterialServiceImpl implements IMaterialService {

    @Autowired
    private IMaterialsDao iMaterialsDao;

    /**
     * 查询所有物品
     * @param page
     * @param size
     * @param materialsName
     * @return
     * @throws Exception
     */
    @Override
    public List<Materials> selectProductAll(Integer page,Integer size,String materialsName) throws Exception {
        PageHelper.startPage(page,size);
        return iMaterialsDao.selectMaterialsAll(materialsName);

    }

    /**
     * 添加物品
     * @param material
     * @throws Exception
     */
    @Override
    public void addMaterial(Materials material) throws Exception {
        if (!ObjectUtils.isEmpty(material)) {
            material.setCreatedBy(GetCurrentUserName.getCurrentUserUserName().getUsername());
            material.setUpdatedBy(GetCurrentUserName.getCurrentUserUserName().getUsername());
            iMaterialsDao.addMaterial(material);
        }

    }

    /**
     * 更新物品
     * @param materials
     * @throws Exception
     */
    @Override
    public void updateMaterials(Materials materials) throws Exception {
        iMaterialsDao.updateMaterials(materials);
    }

    /**
     * 根据id查询物品
     * @param id
     * @throws Exception
     */
    @Override
    public Materials selectMaterialsById(String id) throws Exception {
        return iMaterialsDao.selectMaterialsById(Integer.valueOf(id));
    }

    /**
     * 删除单个物品
     * @param id
     * @throws Exception
     */
    @Override
    public void delMaterials(String id) throws Exception {
        iMaterialsDao.delMaterial(Integer.valueOf(id));
    }

    /**
     * 批量删除物品
     * @param ids
     * @throws Exception
     */
    @Override
    public void delMaterialsList(List<String> ids) throws Exception {
        if (!CollectionUtils.isEmpty(ids)) {
            ids.forEach(i ->{
                if (!i.isEmpty()){
                    iMaterialsDao.delMaterial(Integer.valueOf(i));
                }
            });
        }
    }
}
