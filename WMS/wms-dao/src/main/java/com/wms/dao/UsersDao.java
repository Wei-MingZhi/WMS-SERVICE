package com.wms.dao;

import com.wms.pojo.Role;
import com.wms.pojo.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UsersDao {

    /**
     * 查询所有人员信息
     * @param userName
     * @return
     * @throws Exception
     */
    @Select("select * from users where userName like concat('%',#{userName},'%')")
    List<Users> selectUserAll(String userName) throws Exception;

    /**
     * 添加人员信息
     * @param users
     * @throws Exception
     */
    @Insert("insert into users (userName,userNumber,password,iphone,email,remark,createdBy,updateBy) values (#{userName},#{userNumber},#{password},#{iphone},#{email},#{remark},#{createdBy},#{updateBy})")
    void addUser(Users users) throws Exception;

    /**
     * 根据id查询人员信息
     * @param id
     * @throws Exception
     */
    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "userName", column = "userName"),
            @Result(property = "userNumber", column = "userNumber"),
            @Result(property = "password", column = "password"),
            @Result(property = "iphone", column = "iphone"),
            @Result(property = "email", column = "email"),
            @Result(property = "remark", column = "remark"),
            @Result(property = "createdBy", column = "createdBy"),
            @Result(property = "createdTime", column = "createdTime"),
            @Result(property = "updateBy", column = "updateBy"),
            @Result(property = "updateTime", column = "updateTime"),
            @Result(property = "roleList", column = "id", javaType = java.util.List.class, many = @Many(select = "com.wms.dao.RoleDao.selectRoleByIdList"))
    })
    Users selectUsersById(Integer id) throws Exception;


    @Select("select * from users where userName = #{userName}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "userName", column = "userName"),
            @Result(property = "userNumber", column = "userNumber"),
            @Result(property = "password", column = "password"),
            @Result(property = "iphone", column = "iphone"),
            @Result(property = "email", column = "email"),
            @Result(property = "remark", column = "remark"),
            @Result(property = "createdBy", column = "createdBy"),
            @Result(property = "createdTime", column = "createdTime"),
            @Result(property = "updateBy", column = "updateBy"),
            @Result(property = "updateTime", column = "updateTime"),
            @Result(property = "roleList", column = "id", javaType = java.util.List.class, many = @Many(select = "com.wms.dao.RoleDao.selectRoleByIdList"))
    })
    Users selectByUserName(String userName) throws Exception;

    /**
     * 删除人员
     * @param id
     * @throws Exception
     */
    @Delete("delete from users where id=#{id}")
    void delUser(Integer id) throws Exception;

    /**
     * 查询人员可以添加的角色
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from `role` where id not in(select roleId from users_role where userId = #{id})")
    List<Role> selectOtherRole(Integer id) throws Exception;

    /**
     * 给人员添加角色
     * @param userId
     * @param roleId
     * @throws Exception
     */
    @Insert("insert into users_role(userId,roleId) values (#{userId},#{roleId})")
    void addUserToRole(@Param("userId") Integer userId, @Param("roleId") Integer roleId) throws Exception;

    /**
     * 根据人员id删除角色
     * @param id
     * @throws Exception
     */
    @Delete("delete from users_role where userId = #{userId} and roleId = #{roleId}")
    void delUserToRole(@Param("userId")Integer userId,@Param("roleId")Integer roleId) throws Exception;
}
