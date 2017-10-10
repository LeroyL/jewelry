package com.jewelry.admin.service.impl;

import com.jewelry.admin.model.ShopVo;
import com.jewelry.admin.service.ShopBusinessService;
import com.jewelry.core.entity.Shop;
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
    public Shop save(ShopVo shopVo) {
        Shop shop = new Shop();
        if(shopVo.getId() != null){
            shop.setId(shopVo.getId());
        }
        shop.setTitle(shopVo.getTitle());
        shop.setLogo(shopVo.getLogo());
        shop.setDescription(shopVo.getDescription());
        shop.setOwnerId(shopVo.getOwnerId());
        shop.setStatus(shopVo.getStatus());
        shop.setCreateTime(shopVo.getCreateTime() == null ? new Timestamp(System.currentTimeMillis()) : shopVo.getCreateTime());
        return shopService.save(shop);
    }
}
