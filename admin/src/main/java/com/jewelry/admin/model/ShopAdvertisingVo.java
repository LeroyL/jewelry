package com.jewelry.admin.model;

/**
 * 店铺广告
 * Created by lier on 2017/9/30.
 */
public class ShopAdvertisingVo {

    /** 店铺ID */
    private Integer shopId;
    /** 图片地址 */
    private String image;
    /** 广告链接 */
    private String link;
    /** 广告描述 */
    private String description;

    public ShopAdvertisingVo() {
    }

    public ShopAdvertisingVo(Integer shopId, String image, String link, String description) {
        this.shopId = shopId;
        this.image = image;
        this.link = link;
        this.description = description;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ShopAdvertisingVo{" +
                "shopId=" + shopId +
                ", image='" + image + '\'' +
                ", link='" + link + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
