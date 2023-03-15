package com.wms.service;

import com.wms.pojo.OutPutWarehouse;

import java.util.List;

public interface OutPutWarehouseService {

    /**
     * 添加出入库申请记录
     * @param outPutWarehouse
     * @throws Exception
     */
    void addOutPutWarehouseRecord(OutPutWarehouse outPutWarehouse) throws Exception;

    /**
     * 查询出入库记录
     * @return
     * @throws Exception
     */
    List<OutPutWarehouse> selectOutPutWarehouseRecord(Integer page, Integer size) throws Exception;

    /**
     * 更新审核状态
     * @param id
     * @param auditStatus
     * @throws Exception
     */
    void updateOutPutWarehouse(String id, String auditStatus) throws Exception;

}
