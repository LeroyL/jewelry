package com.jewelry.admin.service;

import com.jewelry.admin.model.ShopVo;
import com.jewelry.core.entity.Shop;

/**
 * Created by lier on 2017/9/30.
 */
public interface ShopBusinessService {

    Shop save(ShopVo shopVo);
}
