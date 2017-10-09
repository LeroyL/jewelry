package com.jewelry.core.service.impl;

import com.jewelry.core.entity.ShopEntity;
import com.jewelry.core.repository.ShopRepository;
import com.jewelry.core.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
@Service("shopService")
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Override
    public ShopEntity findOne(int id) {
        return shopRepository.findOne(id);
    }

    @Override
    public Page<ShopEntity> findAll(Pageable pageable) {
        return shopRepository.findAll(pageable);
    }

    @Override
    public ShopEntity save(ShopEntity entity) {
        return shopRepository.save(entity);
    }

    @Override
    public int delete(int id) {
        try {
            shopRepository.delete(id);
        } catch (Exception e){
            return -1;
        }
        return 0;
    }

    @Override
    public List<ShopEntity> batchSave(List<ShopEntity> entities) {
        return shopRepository.save(entities);
    }
}
