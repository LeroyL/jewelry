package com.jewelry.core.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by lier on 2017/9/29.
 */
@Entity
@Table(name = "shopping_cart", schema = "smart_mall")
public class ShoppingCartEntity {
    private int id;
    private Integer userId;
    private Integer shopId;
    private Integer goodSkuId;
    private Integer goodNumber;
    private Timestamp createTime;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id", nullable = true)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "shop_id", nullable = true)
    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    @Basic
    @Column(name = "good_sku_id", nullable = true)
    public Integer getGoodSkuId() {
        return goodSkuId;
    }

    public void setGoodSkuId(Integer goodSkuId) {
        this.goodSkuId = goodSkuId;
    }

    @Basic
    @Column(name = "good_number", nullable = true)
    public Integer getGoodNumber() {
        return goodNumber;
    }

    public void setGoodNumber(Integer goodNumber) {
        this.goodNumber = goodNumber;
    }

    @Basic
    @Column(name = "create_time", nullable = true)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShoppingCartEntity that = (ShoppingCartEntity) o;

        if (id != that.id) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (shopId != null ? !shopId.equals(that.shopId) : that.shopId != null) return false;
        if (goodSkuId != null ? !goodSkuId.equals(that.goodSkuId) : that.goodSkuId != null) return false;
        if (goodNumber != null ? !goodNumber.equals(that.goodNumber) : that.goodNumber != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (shopId != null ? shopId.hashCode() : 0);
        result = 31 * result + (goodSkuId != null ? goodSkuId.hashCode() : 0);
        result = 31 * result + (goodNumber != null ? goodNumber.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
