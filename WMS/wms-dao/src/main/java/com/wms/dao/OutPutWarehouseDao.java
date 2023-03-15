package com.wms.dao;

import com.wms.pojo.OutPutWarehouse;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface OutPutWarehouseDao {

    /**
     * 添加出入库申请记录
     * @param outPutWarehouse
     * @throws Exception
     */
    @Insert("insert into out_put_warehouse (materialsName,materialsNumber,materialsId,applyPerson,applyNumber,applyStatus,auditStatus,remark) values (#{materialsName},#{materialsNumber},#{materialsId},#{applyPerson},#{applyNumber},#{applyStatus},#{auditStatus},#{remark})")
    void addOutPutWarehouseRecord(OutPutWarehouse outPutWarehouse) throws Exception;

    /**
     * 查询出入库记录
     * @return
     * @throws Exception
     */
    @Select("select * from out_put_warehouse")
    List<OutPutWarehouse> selectOutPutWarehouseRecord() throws Exception;

    /**
     * 根据id查询出入库记录
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from out_put_warehouse where id = #{id}")
    OutPutWarehouse selectOutPutWarehouseRecordById(Integer id) throws Exception;

    /**
     * 更新审核状态
     * @throws Exception
     */
    @Update("update out_put_warehouse set auditStatus = #{auditStatus} where id =#{id}")
    void updateOutPutWarehouse(@Param("id") Integer id,@Param("auditStatus") Integer auditStatus) throws Exception;

}