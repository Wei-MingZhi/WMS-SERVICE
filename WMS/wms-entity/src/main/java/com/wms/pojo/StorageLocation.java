package com.wms.pojo;


import java.util.Date;

/**
 * 库位库区管理
 */
public class StorageLocation {

    private long id;
    private String storageLocationNumber;
    private String shelfNumber;
    private String remark;
    private String createdBy;
    private Date createdTime;
    private String createdTimeStr;
    private String updatedBy;
    private Date updatedTime;
    private String updatedTimeStr;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getStorageLocationNumber() {
    return storageLocationNumber;
  }

  public void setStorageLocationNumber(String storageLocationNumber) {
    this.storageLocationNumber = storageLocationNumber;
  }


  public String getShelfNumber() {
    return shelfNumber;
  }

  public void setShelfNumber(String shelfNumber) {
    this.shelfNumber = shelfNumber;
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

  public void setCreatedTime(java.sql.Timestamp createdTime) {
    this.createdTime = createdTime;
  }


  public String getUpdatedBy() {
    return updatedBy;
  }

  public void setUpdatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
  }


  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(java.sql.Timestamp updatedTime) {
    this.updatedTime = updatedTime;
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

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getUpdatedTimeStr() {
        return updatedTimeStr;
    }

    public void setUpdatedTimeStr(String updatedTimeStr) {
        this.updatedTimeStr = updatedTimeStr;
    }

    @Override
    public String toString() {
        return "StorageLocation{" +
                "id=" + id +
                ", storageLocationNumber='" + storageLocationNumber + '\'' +
                ", shelfNumber='" + shelfNumber + '\'' +
                ", remark='" + remark + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdTime=" + createdTime +
                ", createdTimeStr='" + createdTimeStr + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedTime=" + updatedTime +
                ", updatedTimeStr='" + updatedTimeStr + '\'' +
                '}';
    }
}
