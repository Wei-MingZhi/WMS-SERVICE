package com.wms.service.impl;

import com.github.pagehelper.PageHelper;
import com.wms.common.BCryptPasswordEncoderUtils;
import com.wms.common.GetCurrentUserName;
import com.wms.dao.UsersDao;
import com.wms.pojo.Role;
import com.wms.pojo.Users;
import com.wms.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service("usersService")
@Transactional
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    /**
     * 查询人员信息
     * @param page
     * @param size
     * @param userName
     * @return
     * @throws Exception
     */
    @Override
    public List<Users> selectUsersAll(Integer page, Integer size, String userName) throws Exception {
        PageHelper.startPage(page,size);
        return usersDao.selectUserAll(userName);
    }

    /**
     * 添加人员信息
     * @param users
     * @throws Exception
     */
    @Override
    public void addUsers(Users users) throws Exception {
        if (!ObjectUtils.isEmpty(users)) {
            // 对密码进行加密
            users.setPassword(BCryptPasswordEncoderUtils.passwordEncoder(users.getPassword()));
            // 获取当前登录用户
            users.setCreatedBy(GetCurrentUserName.getCurrentUserUserName().getUsername());
            users.setUpdateBy(GetCurrentUserName.getCurrentUserUserName().getUsername());
            usersDao.addUser(users);
        }
    }

    /**
     * 根据id查询人员信息
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Users selectUsersById(String id) throws Exception {
        return usersDao.selectUsersById(Integer.valueOf(id));
    }

    /**
     * 删除人员
     * @param id
     * @throws Exception
     */
    @Override
    public void delUser(String id) throws Exception {
        usersDao.delUser(Integer.valueOf(id));
    }

    /**
     * 查询人员可以添加的角色
     * @param userId
     * @return
     * @throws Exception
     */
    @Override
    public List<Role> selectOtherRole(String userId) throws Exception {
        return usersDao.selectOtherRole(Integer.valueOf(userId));
    }

    @Override
    public void addUserToRole(String userId, String roleId) throws Exception {
        if (!ObjectUtils.isEmpty(roleId)) {
                usersDao.addUserToRole(Integer.valueOf(userId),Integer.valueOf(roleId));
        }
    }

    /**
     * 根据人员id删除角色
     * @param id
     * @throws Exception
     */
    @Override
    public void delUserToRole(String userId, String roleId) throws Exception {
        usersDao.delUserToRole(Integer.valueOf(userId),Integer.valueOf(roleId));
    }

    /**
     * 登录权限认证
     * @param userName
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Users users = null;
        try {
            users = usersDao.selectByUserName(userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        User user = new User(users.getUserName(), users.getPassword(), getAuthority(users.getRoleList()));
        return user;
    }

    public List<SimpleGrantedAuthority> getAuthority(List<Role> roleList) {
        List<SimpleGrantedAuthority> simpleGrantedAuthoritieList = new ArrayList<>();
        for (Role role : roleList) {
            simpleGrantedAuthoritieList.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return simpleGrantedAuthoritieList;
    }

}
