package com.wms.service;

import com.wms.pojo.Permission;
import com.wms.pojo.Role;

import java.util.List;

public interface RoleService {

    /**
     * 查询所有角色
     * @return
     * @throws Exception
     */
    List<Role> selectRoleAll() throws Exception;

    /**
     * 根据userId查询角色
     * @param id
     * @return
     * @throws Exception
     */
    List<Role> selectRoleAllById(String userId) throws Exception;

    /**
     * 根据角色id查询资源权限
     * @param roleId
     * @return
     * @throws Exception
     */
    List<Role> selectPermissionByRoleId(String roleId) throws Exception;

    /**
     * 添加角色
     * @param role
     * @throws Exception
     */
    void addRole(Role role) throws Exception;

    /**
     * 删除角色
     * @param id
     * @throws Exception
     */
    void delRole(String id) throws Exception;


    /**
     * 根据id查询角色信息
     * @param id
     * @return
     * @throws Exception
     */
    Role selectRoleById(String id) throws Exception;

    /**
     * 根据roleId查询可以添加的权限资源
     * @param roleId
     * @return
     * @throws Exception
     */
    List<Permission> selectRoleOtherPermission(String roleId) throws Exception;

    /**
     * 批量添加角色权限资源
     * @param permissionIds
     * @param roleId
     * @throws Exception
     */
    void addRoleAndPermissionList(String roleId, String[] permissionIds) throws Exception;

    /**
     * 单个添加角色权限资源
     * @param permissionId
     * @param roleId
     * @throws Exception
     */
    void addRoleAndPermission(String roleId, String permissionId) throws Exception;

    /**
     * 根据角色id和资源权限id删除对应的资源权限
     * @param roleId
     * @param permissionId
     * @throws Exception
     */
    void delRoleToPermission(String roleId, String permissionId) throws Exception;

}
