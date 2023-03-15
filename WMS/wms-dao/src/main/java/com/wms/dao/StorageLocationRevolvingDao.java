package com.wms.dao;

import com.wms.pojo.StorageLocationRevolving;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StorageLocationRevolvingDao {

    /**
     * 查询物品周转申请记录
     * @param materialName
     * @return
     * @throws Exception
     */
    @Select("select * from storage_location_revolving where materialsName like concat('%',#{materialName},'%')")
    List<StorageLocationRevolving> selectStorageLocationRevolvingRecord(String materialName) throws Exception;

    /**
     * 根据id查询物品周转申请记录
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from storage_location_revolving where id = #{id}")
    StorageLocationRevolving selectStorageLocationRevolvingRecordById(Integer id) throws Exception;

    /**
     * 添加物品库位周转记录
     * @param storageLocationRevolving
     * @throws Exception
     */
    @Insert("insert into storage_location_revolving (materialsName,materialsNumber,materialsId,storageLocationId,storageLocationName,goodsShelf,tStorageLocationName,tGoodsShelf,applyPerson,auditStatus) values " +
            "(#{materialsName},#{materialsNumber},#{materialsId},#{storageLocationId},#{storageLocationName},#{goodsShelf},#{tStorageLocationName},#{tGoodsShelf},#{applyPerson},#{auditStatus})")
    void addStorageLocationRevolvingRecord(StorageLocationRevolving storageLocationRevolving) throws Exception;


    /**
     * 更新物品库位周转的审核状态
     * @param id
     * @param auditStatus
     * @throws Exception
     */
    @Update("update storage_location_revolving set auditStatus = #{auditStatus} where id = #{id}")
    void updateStorageLocationRevolving(@Param("id") Integer id, @Param("auditStatus") Integer auditStatus) throws Exception;


}
