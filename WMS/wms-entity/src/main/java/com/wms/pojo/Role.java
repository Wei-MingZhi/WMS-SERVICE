package com.wms.pojo;


import java.util.List;

public class Role {

  private long id;
  private String roleName;
  private String roleDesc;
  private List<Permission> permissionList;
  private List<Users> usersList;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public String getRoleDesc() {
    return roleDesc;
  }

  public void setRoleDesc(String roleDesc) {
    this.roleDesc = roleDesc;
  }

  public List<Permission> getPermissionList() {
    return permissionList;
  }

  public void setPermissionList(List<Permission> permissionList) {
    this.permissionList = permissionList;
  }

  public List<Users> getUsersList() {
    return usersList;
  }

  public void setUsersList(List<Users> usersList) {
    this.usersList = usersList;
  }
}
