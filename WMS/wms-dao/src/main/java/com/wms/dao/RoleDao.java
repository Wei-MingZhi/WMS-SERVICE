package com.wms.dao;

import com.wms.pojo.Permission;
import com.wms.pojo.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 角色控制dao
 */
public interface RoleDao {

    /**
     * 查询所有角色
     * @return
     * @throws Exception
     */
    @Select("select * from `role`")
    List<Role> selectRoleAll() throws Exception;

    /**
     * 根据userId查询
     * @param userId
     * @return
     * @throws Exception
     */
    @Select("select * from `role` where id in (select roleId from users_role where userId = #{userId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissionList", column = "id", javaType = List.class, many = @Many(select = "com.wms.dao.PermissionDao.selectPermissionById"))
    })
    List<Role> selectRoleByIdList(Integer userId) throws Exception;

    /**
     * 根据角色权限查询对应的资源权限
     * @param roleId
     * @return
     * @throws Exception
     */
    @Select("select * from `role` where id = #{roleId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissionList", column = "id", javaType = List.class, many = @Many(select = "com.wms.dao.PermissionDao.selectPermissionById"))
    })
    List<Role> selectPermissionByRoleId(Integer roleId) throws Exception;

    /**
     * 添加角色
     * @param role
     * @throws Exception
     */
    @Insert("insert into `role` (roleName,roleDesc) values (#{roleName},#{roleDesc})")
    void addRole(Role role) throws Exception;

    /**
     * 删除角色
     * @param id
     * @throws Exception
     */
    @Delete("delete from `role` where id = #{id}")
    void delRole(Integer id) throws Exception;

    /**
     * 根据id查询角色信息
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from `role` where id = #{id}")
    Role selectRoleById(Integer id) throws Exception;

    /**
     * 查询角色可以添加的权限
     * @param roleId
     * @return
     * @throws Exception
     */
    @Select("select * from permission where id not in(select permissionId from role_permission where roleId = #{roleId})")
    List<Permission> selectRoleOtherPermission(Integer roleId) throws Exception;

    /**
     * 添加角色权限资源
     * @param permissionId
     * @param roleId
     * @throws Exception
     */
    @Insert("insert into role_permission (roleId, permissionId) values (#{roleId}, #{permissionId})")
    void addRoleAndPermission(@Param("roleId")Integer roleId, @Param("permissionId")Integer permissionId) throws Exception;

    /**
     * 根据角色id和资源权限id删除对应的资源权限
     * @param roleId
     * @param permissionId
     * @throws Exception
     */
    @Delete("delete from role_permission where roleId = #{roleId} and permissionId = #{permissionId}")
    void delRoleToPermission(@Param("roleId")Integer roleId, @Param("permissionId")Integer permissionId) throws Exception;

}
