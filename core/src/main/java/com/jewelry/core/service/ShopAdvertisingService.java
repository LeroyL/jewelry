package com.jewelry.core.service;

import com.jewelry.core.entity.ShopAdvertising;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
public interface ShopAdvertisingService extends BaseService<ShopAdvertising> {
    List<ShopAdvertising> findByShopId(int id);
}
