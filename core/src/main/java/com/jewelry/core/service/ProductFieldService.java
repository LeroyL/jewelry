package com.jewelry.core.service;

import com.jewelry.core.entity.ProductFieldEntity;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
public interface ProductFieldService extends BaseService<ProductFieldEntity> {
    List<ProductFieldEntity> findByProductId(int productId);
}
