package com.wms.service;

import com.wms.pojo.Role;
import com.wms.pojo.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * 人员管理
 * 继承security的UserDetailsService去实现权限控制
 */
public interface UsersService extends UserDetailsService {

    /**
     * 查询所有人员
     * @param userName
     * @return
     * @throws Exception
     */
    List<Users> selectUsersAll(Integer page, Integer size, String userName) throws Exception;

    /**
     * 添加人员
     * @param users
     * @throws Exception
     */
    void addUsers(Users users) throws Exception;

    /**
     * 根据id查询人员信息
     * @param id
     * @return
     * @throws Exception
     */
    Users selectUsersById(String id) throws Exception;

    /**
     * 删除人员
     * @param id
     * @throws Exception
     */
    void delUser(String id) throws Exception;

    /**
     * 根据人员id查询可以添加的角色
     * @param userId
     * @return
     * @throws Exception
     */
    List<Role> selectOtherRole(String userId) throws Exception;

    /**
     * 人员添加角色
     * @param userId
     * @param roleId
     * @throws Exception
     */
    void addUserToRole(String userId, String roleId) throws Exception;

    /**
     * 根据人员id删除角色
     * @param id
     * @throws Exception
     */
    void delUserToRole(String userId,String roleId) throws Exception;

}
