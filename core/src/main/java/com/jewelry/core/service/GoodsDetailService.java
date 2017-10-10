package com.jewelry.core.service;

import com.jewelry.core.entity.GoodsDetail;

/**
 * Created by lier on 2017/9/29.
 */
public interface GoodsDetailService extends BaseService<GoodsDetail> {
    GoodsDetail findByGoodId(int goodId);

    void deleteByGoodId(int goodId);
}
