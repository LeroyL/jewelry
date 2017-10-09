package com.jewelry.core.service.impl;

import com.jewelry.core.entity.ProductTypeAttrEntity;
import com.jewelry.core.repository.ProductTypeAttrRepository;
import com.jewelry.core.service.ProductTypeAttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
@Service("productTypeAttrService")
public class ProductTypeAttrServiceImpl implements ProductTypeAttrService {

    @Autowired
    private ProductTypeAttrRepository productTypeAttrRepository;

    @Override
    public ProductTypeAttrEntity findOne(int id) {
        return productTypeAttrRepository.findOne(id);
    }

    @Override
    public Page<ProductTypeAttrEntity> findAll(Pageable pageable) {
        return productTypeAttrRepository.findAll(pageable);
    }

    @Override
    public ProductTypeAttrEntity save(ProductTypeAttrEntity entity) {
        return productTypeAttrRepository.save(entity);
    }

    @Override
    public int delete(int id) {
        try {
            productTypeAttrRepository.delete(id);
        } catch (Exception e){
            return -1;
        }
        return 0;
    }

    @Override
    public List<ProductTypeAttrEntity> batchSave(List<ProductTypeAttrEntity> entities) {
        return productTypeAttrRepository.save(entities);
    }
}
