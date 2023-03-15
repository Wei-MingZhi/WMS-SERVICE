package com.wms.service;

import com.wms.pojo.StorageLocation;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StorageLocationService {

    /**
     * 查询所有库区库位
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    List<StorageLocation> selectStorageLocationAll(Integer page,Integer size,String storageLocationName) throws Exception;

    /**
     * 查询所有库区库位-下拉框
     * @return
     * @throws Exception
     */
    List<StorageLocation> selectStorageLocationAList() throws Exception;

    /**
     * 添加库区库位
     * @param storageLocation
     * @throws Exception
     */
    void addStorageLocation(StorageLocation storageLocation) throws Exception;


    /**
     * 更新库位库区信息
     * @param storageLocation
     * @throws Exception
     */
    void updateStorageLocation(StorageLocation storageLocation) throws Exception;

    /**
     * 根据id查询库区库位信息
     * @param id
     * @return
     * @throws Exception
     */
    StorageLocation selectStorageLocationById(String id) throws Exception;

    /**
     * 删除单个库区库位
     * @param id
     */
    void delStorageLocation(String id) throws Exception;

    /**
     * 批量删除库区数据
     * @param ids
     * @throws Exception
     */
    void delStorageLocationList(List<String> ids) throws Exception;


}
