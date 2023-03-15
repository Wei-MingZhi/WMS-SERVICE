package com.wms.dao;

import com.wms.pojo.Materials;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IMaterialsDao {

    /** 查询所有物品 */
    @Select("select * from materials where materialsName like concat('%',#{materialsName},'%')")
    List<Materials> selectMaterialsAll(String materialsName) throws Exception;

    /**
     * 添加物品
     */
    @Insert("INSERT INTO materials ( materialsName, materialsNumber, storageLocationId, inventoryNumber, remark, createdBy, updateBy, storageLocationName,goodsShelf) VALUES (#{materialsName}, #{materialsNumber}, #{storageLocationId}, #{inventoryNumber}, #{remark}, #{createdBy}, #{updatedBy}, #{storageLocationName},#{goodsShelf})")
    void addMaterial(Materials material) throws Exception;

    /**
     * 更新物品信息
     * @param materials
     * @throws Exception
     */
    @Update("update materials set materialsName=#{materialsName},materialsNumber=#{materialsNumber},storageLocationName=#{storageLocationName},goodsShelf=#{goodsShelf},inventoryNumber=#{inventoryNumber},remark=#{remark} where id=#{id}")
    void updateMaterials(Materials materials) throws Exception;

    @Select("select * from materials where id= #{id}")
    Materials selectMaterialsById(Integer id) throws Exception;

    /**
     * 删除单个物品
     * @param id
     */
    @Delete("delete from materials where id=#{id}")
    void delMaterial(int id);


}
