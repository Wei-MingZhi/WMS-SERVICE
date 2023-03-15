package com.wms.pojo;

import java.util.Date;
import java.util.List;

/**
 * 用户表
 */
public class Users {

  private long id;
  private String userName;
  private String userNumber;
  private String password;
  private String iphone;
  private String email;
  private String remark;
  private String createdBy;
  private Date createdTime;
  private String createdTimeStr;
  private String updateBy;
  private Date updateTime;
  private String updateTimeStr;
  private List<Role> roleList;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserNumber() {
    return userNumber;
  }

  public void setUserNumber(String userNumber) {
    this.userNumber = userNumber;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getIphone() {
    return iphone;
  }

  public void setIphone(String iphone) {
    this.iphone = iphone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public Date getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

  public String getCreatedTimeStr() {
    return createdTimeStr;
  }

  public void setCreatedTimeStr(String createdTimeStr) {
    this.createdTimeStr = createdTimeStr;
  }

  public String getUpdateBy() {
    return updateBy;
  }

  public void setUpdateBy(String updateBy) {
    this.updateBy = updateBy;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public String getUpdateTimeStr() {
    return updateTimeStr;
  }

  public void setUpdateTimeStr(String updateTimeStr) {
    this.updateTimeStr = updateTimeStr;
  }

  public List<Role> getRoleList() {
    return roleList;
  }

  public void setRoleList(List<Role> roleList) {
    this.roleList = roleList;
  }

  @Override
  public String toString() {
    return "Users{" +
            "id=" + id +
            ", userName='" + userName + '\'' +
            ", userNumber='" + userNumber + '\'' +
            ", password='" + password + '\'' +
            ", iphone='" + iphone + '\'' +
            ", email='" + email + '\'' +
            ", remark='" + remark + '\'' +
            ", createdBy='" + createdBy + '\'' +
            ", createdTime=" + createdTime +
            ", createdTimeStr='" + createdTimeStr + '\'' +
            ", updateBy='" + updateBy + '\'' +
            ", updateTime=" + updateTime +
            ", updateTimeStr='" + updateTimeStr + '\'' +
            ", roleList=" + roleList +
            '}';
  }
}
