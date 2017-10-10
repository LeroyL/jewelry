package com.jewelry.core.service.impl;

import com.jewelry.core.entity.ProductField;
import com.jewelry.core.repository.ProductFieldRepository;
import com.jewelry.core.service.ProductFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
@Service("productFieldService")
public class ProductFieldServiceImpl implements ProductFieldService {

    @Autowired
    private ProductFieldRepository productFieldRepository;

    @Override
    public ProductField findOne(int id) {
        return productFieldRepository.findOne(id);
    }

    @Override
    public Page<ProductField> findAll(Pageable pageable) {
        return productFieldRepository.findAll(pageable);
    }

    @Override
    public ProductField save(ProductField entity) {
        return productFieldRepository.save(entity);
    }

    @Override
    public int delete(int id) {
        try {
            productFieldRepository.delete(id);
        } catch (Exception e){
            return -1;
        }
        return 0;
    }

    @Override
    public List<ProductField> batchSave(List<ProductField> entities) {
        return productFieldRepository.save(entities);
    }

    @Override
    public List<ProductField> findByProductId(int productId) {
        return productFieldRepository.findBySpuId(productId);
    }
}
