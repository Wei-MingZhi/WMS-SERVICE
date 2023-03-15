package com.wms.controller;

import com.wms.pojo.Permission;
import com.wms.pojo.Role;
import com.wms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 查询所有角色
     * @return
     * @throws Exception
     */
    @RequestMapping("/role-list.do")
    public ModelAndView selectRoleAll() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.selectRoleAll();
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    /**
     * 根据id查询角色
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/role-by-id.do")
    public ModelAndView selectRoleById(String id) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.selectPermissionByRoleId(id);
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("role-show");
        return modelAndView;
    }

    /**
     * 添加角色
     * @param role
     * @return
     * @throws Exception
     */
    @RequestMapping("/add-role.do")
    public String addRole(Role role) throws Exception {
        roleService.addRole(role);
        return "redirect:/role/role-list.do";
    }

    /**
     * 删除角色
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/del-role.do")
    public String delRole(String id) throws Exception {
        roleService.delRole(id);
        return "redirect:/role/role-list.do";
    }

    /**
     * 根据角色id查询角色可以添加的权限资源
     * @param roleId
     * @return
     * @throws Exception
     */
    @RequestMapping("/select-role-permission.do")
    public ModelAndView selectRoleOtherPermission(@RequestParam(name = "roleId",required = true) String roleId) throws Exception {
        ModelAndView modelAndView = selectRoleIdToPermission(roleId);
        modelAndView.setViewName("role-add-permission");
        return modelAndView;
    }

    /**
     * 批量添加角色资源权限
     * @param permissionIds
     * @param roleId
     * @return
     * @throws Exception
     */
    @RequestMapping("/add-role-permission-list.do")
    public String addRoleAndPermissionList(@RequestParam(name = "roleId", required = true)String roleId,
                                      @RequestParam(name = "ids", required = true)String[] permissionIds) throws Exception{
        roleService.addRoleAndPermissionList(roleId,permissionIds);
        return "redirect:/role/role-list.do";
    }


    /**
     * 单个添加角色资源权限
     * @param permissionId
     * @param roleId
     * @return
     * @throws Exception
     */
    @RequestMapping("/add-role-permission.do")
    public ModelAndView addRoleAndPermission(@RequestParam(name = "roleId", required = true)String roleId,
                                             @RequestParam(name = "permissionId", required = true)String permissionId) throws Exception{

        roleService.addRoleAndPermission(roleId,permissionId);
        ModelAndView modelAndView = selectRoleIdToPermission(roleId);
        modelAndView.setViewName("role-add-permission");
        return modelAndView;
    }

    /**
     * 根据roleId查询资源权限公共抽取
     * @param roleId
     * @return
     * @throws Exception
     */
    public ModelAndView selectRoleIdToPermission(String roleId) throws Exception {
        // 根据角色id查询角色信息
        Role role = roleService.selectRoleById(roleId);
        // 根据角色id查询可以添加的资源权限
        List<Permission> permissionList = roleService.selectRoleOtherPermission(roleId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("role",role);
        modelAndView.addObject("permissionList",permissionList);
        return modelAndView;
    }

    /**
     * 根据角色id和资源权限id删除对应的资源权限
     * @param roleId
     * @param permissionId
     * @return
     * @throws Exception
     */
    public ModelAndView delRoleAndPermission(@RequestParam(name = "roleId", required = true)String roleId,
                                             @RequestParam(name = "permissionId", required = true)String permissionId) throws Exception {
        roleService.delRoleToPermission(roleId,permissionId);
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.selectPermissionByRoleId(roleId);
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("role-show");
        return modelAndView;
    }


}
