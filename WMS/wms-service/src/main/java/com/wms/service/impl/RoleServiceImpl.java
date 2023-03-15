package com.wms.service.impl;

import com.wms.dao.RoleDao;
import com.wms.pojo.Permission;
import com.wms.pojo.Role;
import com.wms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    /**
     * 查询所有的角色
     * @return
     * @throws Exception
     */
    @Override
    public List<Role> selectRoleAll() throws Exception {
        return roleDao.selectRoleAll();
    }

    /**
     * 根据id查询角色
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public List<Role> selectRoleAllById(String id) throws Exception {
        return roleDao.selectRoleByIdList(Integer.valueOf(id));
    }

    /**
     * 根据角色id查询资源权限
     * @param roleId
     * @return
     * @throws Exception
     */
    @Override
    public List<Role> selectPermissionByRoleId(String roleId) throws Exception {
        return roleDao.selectPermissionByRoleId(Integer.valueOf(roleId));
    }

    /**
     * 添加角色
     * @param role
     * @throws Exception
     */
    @Override
    public void addRole(Role role) throws Exception {
        roleDao.addRole(role);
    }

    /**
     * 删除角色
     * @param id
     * @throws Exception
     */
    @Override
    public void delRole(String id) throws Exception {
        roleDao.delRole(Integer.valueOf(id));
    }

    /**
     * 根据id查询角色信息
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Role selectRoleById(String id) throws Exception {
        return roleDao.selectRoleById(Integer.valueOf(id));
    }

    /**
     * 根据角色id查询可以添加的权限资源
     * @param roleId
     * @return
     * @throws Exception
     */
    @Override
    public List<Permission> selectRoleOtherPermission(String roleId) throws Exception {
        return roleDao.selectRoleOtherPermission(Integer.valueOf(roleId));
    }

    /**
     * 批量添加角色资源权限
     * @param permissionIds
     * @param roleId
     * @throws Exception
     */
    @Override
    public void addRoleAndPermissionList(String roleId, String[] permissionIds) throws Exception {
        if (!ObjectUtils.isEmpty(permissionIds)) {
            for (String permissionId : permissionIds) {
                roleDao.addRoleAndPermission(Integer.valueOf(roleId), Integer.valueOf(permissionId));
            }
        }
    }

    /**
     * 单个添加角色资源权限
     * @param permissionId
     * @param roleId
     * @throws Exception
     */
    @Override
    public void addRoleAndPermission(String roleId, String permissionId) throws Exception {
        roleDao.addRoleAndPermission(Integer.valueOf(roleId), Integer.valueOf(permissionId));
    }

    /**
     * 根据角色id和资源权限id删除对应的资源权限
     * @param roleId
     * @param permissionId
     * @throws Exception
     */
    @Override
    public void delRoleToPermission(String roleId, String permissionId) throws Exception {
        roleDao.delRoleToPermission(Integer.valueOf(roleId),Integer.valueOf(permissionId));
    }
}
