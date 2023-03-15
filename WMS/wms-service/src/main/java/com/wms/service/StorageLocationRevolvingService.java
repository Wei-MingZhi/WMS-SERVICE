package com.wms.service;

import com.wms.pojo.StorageLocationRevolving;

import java.util.List;

public interface StorageLocationRevolvingService {

    /**
     * 查询物品申请记录
     * @param materialName
     * @return
     * @throws Exception
     */
    List<StorageLocationRevolving> selectStorageLocationRevolvingRecord(Integer page,Integer size,String materialsName) throws Exception;

    /**
     * 添加物品库位周转申请记录
     * @param storageLocationRevolving
     * @throws Exception
     */
    void addStorageLocationRevolvingRecord(StorageLocationRevolving storageLocationRevolving) throws Exception;

    /**
     * 更新物品库位周转的审核状态
     * @param id
     * @param auditStatus
     * @throws Exception
     */
    void updateStorageLocationRevolving(String id, String auditStatus) throws Exception;

}
