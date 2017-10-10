package com.jewelry.core.service;

import com.jewelry.core.entity.GoodImage;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
public interface GoodsImageService extends BaseService<GoodImage> {
    List<GoodImage> findByGoodId(int goodId);

    void deleteByGoodId(int goodId);
}
