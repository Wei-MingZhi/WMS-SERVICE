package com.wms.service.impl;

import com.github.pagehelper.PageHelper;
import com.wms.dao.PermissionDao;
import com.wms.pojo.Permission;
import com.wms.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    /**
     * 查询所有资源权限
     * @return
     * @throws Exception
     */
    @Override
    public List<Permission> selectPermissionAll(Integer page, Integer size, String permissionName) throws Exception {
        PageHelper.startPage(page,size);
        return permissionDao.selectPermissionAll(permissionName);
    }

    /**
     * 添加权限资源
     * @param permission
     * @throws Exception
     */
    @Override
    public void addPermission(Permission permission) throws Exception {
        permissionDao.addPermission(permission);
    }

    /**
     * 删除权限
     * @param id
     * @throws Exception
     */
    @Override
    public void delPermission(String id) throws Exception {
        permissionDao.delPermission(Integer.valueOf(id));
    }
}
