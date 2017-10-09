package com.jewelry.admin.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * Created by lier on 2017/9/30.
 */
public class ShopVo {

    private Integer id;
    @NotBlank(message = "店铺名称不能为空")
    @Length(min = 1, max = 30, message = "店铺名称应当在1-20个字以内")
    private String title;
    @NotBlank(message = "店铺LOGO不能为空")
    private String logo;
    private String description;
    @NotNull(message = "店铺归属人不能为空")
    private Integer ownerId;
    private Integer status;
    private Timestamp createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
