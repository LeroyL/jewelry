package com.jewelry.core.service.impl;

import com.jewelry.core.repository.ProductTypeRepository;
import com.jewelry.core.service.ProductTypeService;
import com.jewelry.core.entity.ProductTypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
@Service("productTypeService")
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Override
    public ProductTypeEntity findOne(int id) {
        return productTypeRepository.findOne(id);
    }

    @Override
    public Page<ProductTypeEntity> findAll(Pageable pageable) {
        return productTypeRepository.findAll(pageable);
    }

    @Override
    public ProductTypeEntity save(ProductTypeEntity entity) {
        return productTypeRepository.save(entity);
    }

    @Override
    public int delete(int id) {
        try {
            productTypeRepository.delete(id);
        } catch (Exception e) {
            return -1;
        }
        return 0;
    }

    @Override
    public List<ProductTypeEntity> batchSave(List<ProductTypeEntity> entities) {
        return productTypeRepository.save(entities);
    }
}
