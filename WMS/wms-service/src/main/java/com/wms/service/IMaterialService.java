package com.wms.service;

import com.wms.pojo.Materials;

import java.util.List;

public interface IMaterialService {

    /** 查询所有物品 */
    List<Materials> selectProductAll(Integer page,Integer size,String materialsName) throws Exception;

    /**
     * 添加物品
     * @param material
     * @return
     */
    void addMaterial(Materials material) throws Exception;

    /**
     * 编辑物品信息
     * @param materials
     * @throws Exception
     */
    void updateMaterials(Materials materials) throws Exception;

    /**
     * 根据id查询物品
     * @throws Exception
     */
    Materials selectMaterialsById(String id) throws Exception;

    /**
     * 删除单个物品
     * @param id
     */
    void delMaterials(String id) throws Exception;

    /**
     * 批量删除数据
     * @param ids
     * @throws Exception
     */
    void delMaterialsList(List<String> ids) throws Exception;

}
