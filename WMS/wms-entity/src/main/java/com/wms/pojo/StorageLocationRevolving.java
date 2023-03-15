package com.wms.pojo;


import java.util.Date;

public class StorageLocationRevolving {

    private long id;
    private int materialsId;
    private String materialsName;
    private String materialsNumber;
    private long storageLocationId;
    private String storageLocationName;
    private String goodsShelf;
    private String tStorageLocationName;
    private String tGoodsShelf;
    private String applyPerson;
    private Date applyTime;
    private String applyTimeStr;
    private int auditStatus;
    private String auditStatusStr;
    private String remark;

    public long getId() {
      return id;
    }

    public void setId(long id) {
      this.id = id;
    }

    public String getMaterialsName() {
      return materialsName;
    }

    public void setMaterialsName(String materialsName) {
      this.materialsName = materialsName;
    }

    public String getMaterialsNumber() {
      return materialsNumber;
    }

    public void setMaterialsNumber(String materialsNumber) {
      this.materialsNumber = materialsNumber;
    }

    public long getStorageLocationId() {
      return storageLocationId;
    }

    public void setStorageLocationId(long storageLocationId) {
      this.storageLocationId = storageLocationId;
    }

    public String getStorageLocationName() {
      return storageLocationName;
    }

    public void setStorageLocationName(String storageLocationName) {
      this.storageLocationName = storageLocationName;
    }

    public String getGoodsShelf() {
      return goodsShelf;
    }

    public void setGoodsShelf(String goodsShelf) {
      this.goodsShelf = goodsShelf;
    }

    public String gettStorageLocationName() {
      return tStorageLocationName;
    }

    public void settStorageLocationName(String tStorageLocationName) {
      this.tStorageLocationName = tStorageLocationName;
    }

    public String gettGoodsShelf() {
      return tGoodsShelf;
    }

    public void settGoodsShelf(String tGoodsShelf) {
      this.tGoodsShelf = tGoodsShelf;
    }

    public String getApplyPerson() {
      return applyPerson;
    }

    public void setApplyPerson(String applyPerson) {
      this.applyPerson = applyPerson;
    }

    public Date getApplyTime() {
      return applyTime;
    }

    public void setApplyTime(Date applyTime) {
      this.applyTime = applyTime;
    }

    public int getAuditStatus() {
      return auditStatus;
    }

    public void setAuditStatus(int auditStatus) {
      this.auditStatus = auditStatus;
    }

    public String getAuditStatusStr() {
      // 0：待审核/1：同意申请/2：驳回
      if (auditStatus == 0) {
        auditStatusStr = "待审核";
      }
      if (auditStatus == 1) {
        auditStatusStr = "批准";
      }
      if (auditStatus == 2) {
        auditStatusStr = "驳回";
      }
      return auditStatusStr;
    }

    public void setAuditStatusStr(String auditStatusStr) {
      this.auditStatusStr = auditStatusStr;
    }

    public String getApplyTimeStr() {
        return applyTimeStr;
    }

    public void setApplyTimeStr(String applyTimeStr) {
        this.applyTimeStr = applyTimeStr;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getMaterialsId() {
        return materialsId;
    }

    public void setMaterialsId(int materialsId) {
        this.materialsId = materialsId;
    }

    @Override
    public String toString() {
        return "StorageLocationRevolving{" +
                "id=" + id +
                ", materialsId=" + materialsId +
                ", materialsName='" + materialsName + '\'' +
                ", materialsNumber='" + materialsNumber + '\'' +
                ", storageLocationId=" + storageLocationId +
                ", storageLocationName='" + storageLocationName + '\'' +
                ", goodsShelf='" + goodsShelf + '\'' +
                ", tStorageLocationName='" + tStorageLocationName + '\'' +
                ", tGoodsShelf='" + tGoodsShelf + '\'' +
                ", applyPerson='" + applyPerson + '\'' +
                ", applyTime=" + applyTime +
                ", applyTimeStr='" + applyTimeStr + '\'' +
                ", auditStatus=" + auditStatus +
                ", auditStatusStr='" + auditStatusStr + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
