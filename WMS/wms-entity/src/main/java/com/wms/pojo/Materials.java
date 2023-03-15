package com.wms.pojo;

import com.wms.common.DateUtils;

import java.util.Date;

/**
 * 物品表
 */
public class Materials {
    /**
     * 主键id;主键id
     */
    private long id;
    /**
     * 物品名称;物品名曾
     */
    private String materialsName;
    /**
     * 物品编号;物品编号
     */
    private String materialsNumber;
    /**
     * 库位id;库位id
     */
    private int storageLocationId;
    /**库位名称*/
    private String storageLocationName;
    /** 货架 */
    private String goodsShelf;
    /** 库存数量;库存数量 */
    private int inventoryNumber;
    /**
     * 备注;备注
     */
    private String remark;
    /**
     * 创建人;创建人
     */
    private String createdBy;
    /**
     * 创建时间;创建时间
     */
    private Date createdTime;
    /**
     * 创建时间;创建时间
     */
    private String createdTimeStr;
    /**
     * 更新人;更新人
     */
    private String updatedBy;
    /**
     * 更新时间;更新时间
     */
    private Date updatedTime;
    /**
     * 更新时间;更新时间
     */
    private String updatedTimeStr;

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

    public int getStorageLocationId() {
        return storageLocationId;
    }

    public void setStorageLocationId(int storageLocationId) {
        this.storageLocationId = storageLocationId;
    }

    public String getStorageLocationName() {
        return storageLocationName;
    }

    public void setStorageLocationName(String storageLocationName) {
        this.storageLocationName = storageLocationName;
    }

    public int getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(int inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
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

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getCreatedTimeStr() {
        return createdTimeStr;
    }

    public void setCreatedTimeStr(String createdTimeStr) {
        this.createdTimeStr = createdTimeStr;
    }

    public String getUpdatedTimeStr() {
        return updatedTimeStr;
    }

    public void setUpdatedTimeStr(String updatedTimeStr) {
        this.updatedTimeStr = updatedTimeStr;
    }

    public String getGoodsShelf() {
        return goodsShelf;
    }

    public void setGoodsShelf(String goodsShelf) {
        this.goodsShelf = goodsShelf;
    }

    @Override
    public String toString() {
        return "Materials{" +
                "id=" + id +
                ", materialsName='" + materialsName + '\'' +
                ", materialsNumber='" + materialsNumber + '\'' +
                ", storageLocationId=" + storageLocationId +
                ", storageLocationName='" + storageLocationName + '\'' +
                ", goodsShelf='" + goodsShelf + '\'' +
                ", inventoryNumber=" + inventoryNumber +
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
