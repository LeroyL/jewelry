package com.jewelry.core.service;

import com.jewelry.core.entity.ProductFieldAttrEntity;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
public interface ProductFieldAttrService extends BaseService<ProductFieldAttrEntity> {
    List<ProductFieldAttrEntity> findByFieldId(int fieldId);
}
