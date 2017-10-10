package com.jewelry.core.service;

import com.jewelry.core.entity.GoodField;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
public interface GoodsFieldService extends BaseService<GoodField> {
    List<GoodField> findByGoodId(int goodId);

    void deleteByGoodId(int goodId);
}
