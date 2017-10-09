package com.jewelry.core.service.impl;

import com.jewelry.core.entity.ProductEntity;
import com.jewelry.core.repository.ProductRepository;
import com.jewelry.core.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductEntity findOne(int id) {
        return productRepository.findOne(id);
    }

    @Override
    public Page<ProductEntity> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public ProductEntity save(ProductEntity entity) {
        return productRepository.save(entity);
    }

    @Override
    public int delete(int id) {
        try {
            productRepository.delete(id);
        } catch (Exception e){
            return -1;
        }
        return 0;
    }

    @Override
    public List<ProductEntity> batchSave(List<ProductEntity> entities) {
        return productRepository.save(entities);
    }
}
