package com.jewelry.admin.service.impl;

import com.jewelry.admin.model.ShopVo;
import com.jewelry.admin.service.ShopBusinessService;
import com.jewelry.core.entity.ShopEntity;
import com.jewelry.core.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * Created by lier on 2017/9/30.
 */
@Service("shopBusinessService")
public class ShopBusinessServiceImpl implements ShopBusinessService {

    @Autowired
    private ShopService shopService;

    @Override
    public ShopEntity save(ShopVo shopVo) {
        ShopEntity shopEntity = new ShopEntity();
        if(shopVo.getId() != null){
            shopEntity.setId(shopVo.getId());
        }
        shopEntity.setTitle(shopVo.getTitle());
        shopEntity.setLogo(shopVo.getLogo());
        shopEntity.setDescription(shopVo.getDescription());
        shopEntity.setOwnerId(shopVo.getOwnerId());
        shopEntity.setStatus(shopVo.getStatus());
        shopEntity.setCreateTime(shopVo.getCreateTime() == null ? new Timestamp(System.currentTimeMillis()) : shopVo.getCreateTime());
        return shopService.save(shopEntity);
    }
}
