package com.jewelry.core.service;

import com.jewelry.core.entity.GoodsFieldEntity;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
public interface GoodsFieldService extends BaseService<GoodsFieldEntity> {
    List<GoodsFieldEntity> findByGoodId(int goodId);
}
