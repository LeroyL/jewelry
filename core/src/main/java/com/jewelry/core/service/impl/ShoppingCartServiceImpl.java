package com.jewelry.core.service.impl;

import com.jewelry.core.entity.ShoppingCartEntity;
import com.jewelry.core.repository.ShoppingCartRepository;
import com.jewelry.core.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
@Service("shoppingCartService")
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Override
    public ShoppingCartEntity findOne(int id) {
        return shoppingCartRepository.findOne(id);
    }

    @Override
    public Page<ShoppingCartEntity> findAll(Pageable pageable) {
        return shoppingCartRepository.findAll(pageable);
    }

    @Override
    public ShoppingCartEntity save(ShoppingCartEntity entity) {
        return shoppingCartRepository.save(entity);
    }

    @Override
    public int delete(int id) {
        try {
            shoppingCartRepository.delete(id);
        } catch (Exception e){
            return -1;
        }
        return 0;
    }

    @Override
    public List<ShoppingCartEntity> batchSave(List<ShoppingCartEntity> entities) {
        return shoppingCartRepository.save(entities);
    }
}
