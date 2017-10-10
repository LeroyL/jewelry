package com.jewelry.core.service.impl;

import com.jewelry.core.entity.ProductFieldAttr;
import com.jewelry.core.repository.ProductFieldAttrRepository;
import com.jewelry.core.service.ProductFieldAttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
@Service("productFieldAttrService")
public class ProductFieldAttrServiceImpl implements ProductFieldAttrService {

    @Autowired
    private ProductFieldAttrRepository productFieldAttrRepository;

    @Override
    public ProductFieldAttr findOne(int id) {
        return productFieldAttrRepository.findOne(id);
    }

    @Override
    public Page<ProductFieldAttr> findAll(Pageable pageable) {
        return productFieldAttrRepository.findAll(pageable);
    }

    @Override
    public ProductFieldAttr save(ProductFieldAttr entity) {
        return productFieldAttrRepository.save(entity);
    }

    @Override
    public int delete(int id) {
        try {
            productFieldAttrRepository.delete(id);
        } catch (Exception e){
            return -1;
        }
        return 0;
    }

    @Override
    public List<ProductFieldAttr> batchSave(List<ProductFieldAttr> entities) {
        return productFieldAttrRepository.save(entities);
    }

    @Override
    public List<ProductFieldAttr> findByFieldId(int fieldId) {
        return productFieldAttrRepository.findByFid(fieldId);
    }
}
