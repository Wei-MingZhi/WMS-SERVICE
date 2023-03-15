package com.wms.controller;

import com.github.pagehelper.PageInfo;
import com.wms.pojo.Permission;
import com.wms.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    /**
     * 查询所有资源权限
     * @return
     * @throws Exception
     */
    @RequestMapping("/permission-list.do")
    public ModelAndView selectPermissionAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,
                                            @RequestParam(name = "size",required = true,defaultValue = "10")Integer size,
                                            @RequestParam(name = "permissionName", required = true,defaultValue = "")String permissionName) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        List<Permission> permissionList = permissionService.selectPermissionAll(page,size,permissionName);
        PageInfo pageInfo = new PageInfo(permissionList);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("permission-list");
        return modelAndView;
    }

    /**
     * 添加权限资源
     * @param permission
     * @return
     * @throws Exception
     */
    @RequestMapping("/add-permission.do")
    public String addPermission(Permission permission) throws Exception {
        permissionService.addPermission(permission);
        return "redirect:/permission/permission-list.do";
    }

    /**
     * 删除资源权限
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/del-permission.do")
    public String delPermission(String id) throws Exception {
        permissionService.delPermission(id);
        return "redirect:/permission/permission-list.do";
    }

}
