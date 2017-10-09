package com.jewelry.core.service;

import com.jewelry.core.entity.GoodsDetailEntity;

/**
 * Created by lier on 2017/9/29.
 */
public interface GoodsDetailService extends BaseService<GoodsDetailEntity> {
    GoodsDetailEntity findByGoodId(int goodId);
}
