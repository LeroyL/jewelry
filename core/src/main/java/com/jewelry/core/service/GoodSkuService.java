package com.jewelry.core.service;

import com.jewelry.core.entity.GoodSKU;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
public interface GoodSkuService extends BaseService<GoodSKU> {
    List<GoodSKU> findByGoodId(int goodId);

    void deleteByGoodId(int goodId);
}
