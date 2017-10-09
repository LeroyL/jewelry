package com.jewelry.core.service;

import com.jewelry.core.entity.GoodSkuEntity;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
public interface GoodSkuService extends BaseService<GoodSkuEntity> {
    List<GoodSkuEntity> findByGoodId(int goodId);
}
