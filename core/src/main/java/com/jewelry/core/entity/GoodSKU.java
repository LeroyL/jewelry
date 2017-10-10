package com.jewelry.core.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by lier on 2017/9/29.
 */
@Entity
@Table(name = "good_sku", schema = "smart_mall")
public class GoodSKU {
    private int id;
    private Integer goodId;
    private String skuTitle;
    private String skuIcon;
    private BigDecimal price;
    private BigDecimal discountPrice;
    private Integer stock;
    private Integer status;
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
    @Column(name = "gid", nullable = true)
    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    @Basic
    @Column(name = "sku_title", nullable = true, length = 255)
    public String getSkuTitle() {
        return skuTitle;
    }

    public void setSkuTitle(String skuTitle) {
        this.skuTitle = skuTitle;
    }

    @Basic
    @Column(name = "sku_icon", nullable = true, length = 255)
    public String getSkuIcon() {
        return skuIcon;
    }

    public void setSkuIcon(String skuIcon) {
        this.skuIcon = skuIcon;
    }

    @Basic
    @Column(name = "price", nullable = true, precision = 2)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "discount_price", nullable = true, precision = 2)
    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Basic
    @Column(name = "stock", nullable = true)
    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Basic
    @Column(name = "status", nullable = true)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

        GoodSKU that = (GoodSKU) o;

        if (id != that.id) return false;
        if (goodId != null ? !goodId.equals(that.goodId) : that.goodId != null) return false;
        if (skuTitle != null ? !skuTitle.equals(that.skuTitle) : that.skuTitle != null) return false;
        if (skuIcon != null ? !skuIcon.equals(that.skuIcon) : that.skuIcon != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (discountPrice != null ? !discountPrice.equals(that.discountPrice) : that.discountPrice != null)
            return false;
        if (stock != null ? !stock.equals(that.stock) : that.stock != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (goodId != null ? goodId.hashCode() : 0);
        result = 31 * result + (skuTitle != null ? skuTitle.hashCode() : 0);
        result = 31 * result + (skuIcon != null ? skuIcon.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (discountPrice != null ? discountPrice.hashCode() : 0);
        result = 31 * result + (stock != null ? stock.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
