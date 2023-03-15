package com.wms.dao;

import com.wms.pojo.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionDao {

    /**
     * 查询所有资源权限
     * @return
     * @throws Exception
     */
    @Select("select * from permission where permissionName like concat('%',#{permissionName},'%')")
    List<Permission> selectPermissionAll(String permissionName) throws Exception;

    /**
     * 根据角色id查询资源权限
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from permission where id in (select permissionId from role_permission where roleId = #{id} )")
    List<Permission> selectPermissionById(Integer id) throws Exception;

    /**
     * 添加权限资源
     * @param permission
     * @throws Exception
     */
    @Insert("insert into permission (permissionName, url) values (#{permissionName},#{url})")
    void addPermission(Permission permission) throws Exception;

    /**
     * 删除权限
     * @param id
     * @throws Exception
     */
    @Delete("delete from permission where id = #{id}")
    void delPermission(Integer id) throws Exception;
}
