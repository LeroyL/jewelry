package com.jewelry.core.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by lier on 2017/9/29.
 */
@Entity
@Table(name = "order_goods", schema = "smart_mall")
public class OrderGood {
    private int id;
    private Integer orderId;
    private Integer goodId;
    private String goodTitle;
    private String goodIcon;
    private String goodSpec;
    private Integer goodNum;
    private BigDecimal goodPrice;
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
    @Column(name = "order_id", nullable = true)
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "good_id", nullable = true)
    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    @Basic
    @Column(name = "good_title", nullable = true, length = 255)
    public String getGoodTitle() {
        return goodTitle;
    }

    public void setGoodTitle(String goodTitle) {
        this.goodTitle = goodTitle;
    }

    @Basic
    @Column(name = "good_icon", nullable = true, length = 255)
    public String getGoodIcon() {
        return goodIcon;
    }

    public void setGoodIcon(String goodIcon) {
        this.goodIcon = goodIcon;
    }

    @Basic
    @Column(name = "good_spec", nullable = true, length = 255)
    public String getGoodSpec() {
        return goodSpec;
    }

    public void setGoodSpec(String goodSpec) {
        this.goodSpec = goodSpec;
    }

    @Basic
    @Column(name = "good_num", nullable = true)
    public Integer getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(Integer goodNum) {
        this.goodNum = goodNum;
    }

    @Basic
    @Column(name = "good_price", nullable = true, precision = 2)
    public BigDecimal getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(BigDecimal goodPrice) {
        this.goodPrice = goodPrice;
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

        OrderGood that = (OrderGood) o;

        if (id != that.id) return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (goodId != null ? !goodId.equals(that.goodId) : that.goodId != null) return false;
        if (goodTitle != null ? !goodTitle.equals(that.goodTitle) : that.goodTitle != null) return false;
        if (goodIcon != null ? !goodIcon.equals(that.goodIcon) : that.goodIcon != null) return false;
        if (goodSpec != null ? !goodSpec.equals(that.goodSpec) : that.goodSpec != null) return false;
        if (goodNum != null ? !goodNum.equals(that.goodNum) : that.goodNum != null) return false;
        if (goodPrice != null ? !goodPrice.equals(that.goodPrice) : that.goodPrice != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + (goodId != null ? goodId.hashCode() : 0);
        result = 31 * result + (goodTitle != null ? goodTitle.hashCode() : 0);
        result = 31 * result + (goodIcon != null ? goodIcon.hashCode() : 0);
        result = 31 * result + (goodSpec != null ? goodSpec.hashCode() : 0);
        result = 31 * result + (goodNum != null ? goodNum.hashCode() : 0);
        result = 31 * result + (goodPrice != null ? goodPrice.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
