package com.wms.pojo;

import java.util.Date;

public class OutPutWarehouse {

  private long id;
  private int materialsId;
  private String materialsName;
  private String materialsNumber;
  private String applyPerson;
  private int applyNumber;
  private int applyStatus;
  private String applyStatusStr;
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

  public String getApplyPerson() {
    return applyPerson;
  }

  public void setApplyPerson(String applyPerson) {
    this.applyPerson = applyPerson;
  }

  public int getApplyNumber() {
    return applyNumber;
  }

  public void setApplyNumber(int applyNumber) {
    this.applyNumber = applyNumber;
  }

  public int getApplyStatus() {
    return applyStatus;
  }

  public void setApplyStatus(int applyStatus) {
    this.applyStatus = applyStatus;
  }

  public String getApplyStatusStr() {
    // （0：出库/1：入库）
    if (applyStatus == 0) {
      applyStatusStr = "出库";
    }
    if (applyStatus == 1) {
      applyStatusStr = "入库";
    }
    return applyStatusStr;
  }

  public void setApplyStatusStr(String applyStatusStr) {
    this.applyStatusStr = applyStatusStr;
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
    // （0：待审核/1：同意申请/2：驳回）
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

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getApplyTimeStr() {
    return applyTimeStr;
  }

  public void setApplyTimeStr(String applyTimeStr) {
    this.applyTimeStr = applyTimeStr;
  }

  public int getMaterialsId() {
    return materialsId;
  }

  public void setMaterialsId(int materialsId) {
    this.materialsId = materialsId;
  }

  @Override
  public String toString() {
    return "OutPutWarehouse{" +
            "id=" + id +
            ", materialsId=" + materialsId +
            ", materialsName='" + materialsName + '\'' +
            ", materialsNumber='" + materialsNumber + '\'' +
            ", applyPerson='" + applyPerson + '\'' +
            ", applyNumber=" + applyNumber +
            ", applyStatus=" + applyStatus +
            ", applyStatusStr='" + applyStatusStr + '\'' +
            ", applyTime=" + applyTime +
            ", applyTimeStr='" + applyTimeStr + '\'' +
            ", auditStatus=" + auditStatus +
            ", auditStatusStr='" + auditStatusStr + '\'' +
            ", remark='" + remark + '\'' +
            '}';
  }
}
