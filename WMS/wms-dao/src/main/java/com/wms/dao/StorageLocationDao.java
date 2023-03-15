package com.wms.dao;


import com.wms.pojo.StorageLocation;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StorageLocationDao {

    /**
     * 查询所有库位
     * @return
     * @throws Exception
     */
    @Select("select * from storage_location where storageLocationNumber like concat('%',#{storageLocationName},'%')")
    List<StorageLocation> selectStorageLocationAll(String storageLocationName) throws Exception ;

    /**
     * 添加库位库区信息
     * @param storageLocation
     * @throws Exception
     */
    @Insert("insert into storage_location (storageLocationNumber,shelfNumber,remark,createdBy,updatedBy) values (#{storageLocationNumber},#{shelfNumber},#{remark},#{createdBy},#{updatedBy})")
    void addStorageLocation(StorageLocation storageLocation) throws Exception;

    /**
     * 更新库位库区信息
     * @param storageLocation
     * @throws Exception
     */
    @Update("update storage_location set storageLocationNumber=#{storageLocationNumber},shelfNumber=#{shelfNumber},remark=#{remark} where id=#{id}")
    void updateStorageLocation(StorageLocation storageLocation) throws Exception;

    /**
     * 根据id查询库区库位信息
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from storage_location where id = #{id}")
    StorageLocation selectStorageLocationById(Integer id) throws Exception;

    /**
     * 删除库位信息
     * @param id
     * @throws Exception
     */
    @Delete("delete from storage_location where id=#{id}")
    void delStorageLocation(Integer id) throws Exception;
}
