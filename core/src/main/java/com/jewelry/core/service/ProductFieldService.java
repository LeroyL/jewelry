package com.jewelry.core.service;

import com.jewelry.core.entity.ProductField;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
public interface ProductFieldService extends BaseService<ProductField> {
    List<ProductField> findByProductId(int productId);
}
