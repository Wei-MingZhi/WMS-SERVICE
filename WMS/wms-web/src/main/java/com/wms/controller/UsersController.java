package com.wms.controller;

import com.github.pagehelper.PageInfo;
import com.wms.common.DateUtils;
import com.wms.pojo.Role;
import com.wms.pojo.Users;
import com.wms.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    /**
     * 查询所有人员
     * @param page
     * @param size
     * @param userName
     * @return
     * @throws Exception
     */
    @RequestMapping("/users-list.do")
    public ModelAndView selectUsersAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,
                                       @RequestParam(name = "size",required = true,defaultValue = "10")Integer size,
                                       @RequestParam(name = "userName",required = false,defaultValue = "")String userName) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Users> usersList = usersService.selectUsersAll(page, size, userName);
        if (!CollectionUtils.isEmpty(usersList)) {
            for (Users users : usersList) {
                // 时间格式转换
                String createdTime = DateUtils.dateToString(users.getCreatedTime());
                users.setCreatedTimeStr(createdTime);
            }
        }
        PageInfo pageInfo = new PageInfo(usersList);
        modelAndView.addObject("usersList",pageInfo);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    /**
     * 添加人员信息
     * @param users
     * @return
     * @throws Exception
     */
    @RequestMapping("/add-users.do")
    public String addUsers(Users users) throws Exception {
        usersService.addUsers(users);
        return "redirect:/users/users-list.do";
    }

    /**
     * 根据id查询
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/users-by-id.do")
    public ModelAndView selectUsersById(@RequestParam(name = "id", required = true) String id) throws Exception{
        ModelAndView modelAndView = selectUserToRoleShare(id);
        modelAndView.setViewName("user-show");
        return modelAndView;
    }

    /**
     * 删除人员
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/del-user.do")
    public String delUser(@RequestParam(name = "id",required = true) String userId) throws Exception {
        usersService.delUser(userId);
        return "redirect:/users/users-list.do";
    }

    /**
     * 根据id查询人员可以添加的角色
     * @param userId
     * @return
     * @throws Exception
     */
    @RequestMapping("/select-user-role.do")
    public ModelAndView selectUserAndRole(@RequestParam(name = "id", required = true)String userId) throws Exception {
        ModelAndView modelAndView = selectUserRoleShare(userId);
        modelAndView.setViewName("user-role-add");
        return modelAndView;
    }

    /**
     * 人员添加角色
     * @param userId
     * @param roleId
     * @return
     * @throws Exception
     */
    @RequestMapping("/add-user-to-role.do")
    public ModelAndView addUserToRole(@RequestParam(name = "userId", required = true) String userId,
                                @RequestParam(name = "roleId", required = true) String roleId) throws Exception{
        if (!ObjectUtils.isEmpty(roleId)) {
            usersService.addUserToRole(userId,roleId);
        }
        ModelAndView modelAndView = selectUserRoleShare(userId);
        modelAndView.setViewName("user-role-add");
        return modelAndView;
    }

    /**
     * 根据人员id删除角色
     * @param userId
     * @return
     * @throws Exception
     */
    @RequestMapping("/del-user-role.do")
    public ModelAndView delUserToRole(@RequestParam(name = "userId",required = true) String userId,
                                      @RequestParam(name = "roleId",required = true)String roleId) throws Exception {
        usersService.delUserToRole(userId,roleId);
        ModelAndView modelAndView = selectUserToRoleShare(userId);
        modelAndView.setViewName("user-show");
        return modelAndView;
    }

    /**
     * 根据人员id查询角色公共抽取
     * @param userId
     * @return
     * @throws Exception
     */
    public ModelAndView selectUserToRoleShare(String userId) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        Users users = usersService.selectUsersById(userId);
        modelAndView.addObject("users",users);
        return modelAndView;
    }

    /**
     * 根据id查询人员可以添加的角色公共抽取
     * @param userId
     * @return
     * @throws Exception
     */
    public ModelAndView selectUserRoleShare(String userId) throws Exception {
        // 根据id查询人员
        Users users = usersService.selectUsersById(userId);
        // 根据人员id查询可以添加的角色
        List<Role> roleList = usersService.selectOtherRole(userId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("users",users);
        modelAndView.addObject("roleList", roleList);
        return modelAndView;
    }


}
