package com.jewelry.core.service.impl;

import com.jewelry.core.repository.ProductTypeRepository;
import com.jewelry.core.service.ProductTypeService;
import com.jewelry.core.entity.ProductType;
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
    public ProductType findOne(int id) {
        return productTypeRepository.findOne(id);
    }

    @Override
    public Page<ProductType> findAll(Pageable pageable) {
        return productTypeRepository.findAll(pageable);
    }

    @Override
    public ProductType save(ProductType entity) {
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
    public List<ProductType> batchSave(List<ProductType> entities) {
        return productTypeRepository.save(entities);
    }
}
