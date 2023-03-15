package com.wms.service;

import com.wms.pojo.Permission;

import java.util.List;

public interface PermissionService {

    /**
     * 查询所有资源权限
     * @return
     * @throws Exception
     */
    List<Permission> selectPermissionAll(Integer page, Integer size, String permissionName) throws Exception;

    /**
     * 添加权限资源
     * @param permission
     * @throws Exception
     */
    void addPermission(Permission permission) throws Exception;

    /**
     * 删除权限
     * @param id
     * @throws Exception
     */
    void delPermission(String id) throws Exception;

}
