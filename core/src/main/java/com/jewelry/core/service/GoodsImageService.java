package com.jewelry.core.service;

import com.jewelry.core.entity.GoodsImageEntity;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
public interface GoodsImageService extends BaseService<GoodsImageEntity> {
    List<GoodsImageEntity> findByGoodId(int goodId);
}
