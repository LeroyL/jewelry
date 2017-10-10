package com.jewelry.core.service.impl;

import com.jewelry.core.entity.ShopAdvertising;
import com.jewelry.core.repository.ShopAdvertisingRepository;
import com.jewelry.core.service.ShopAdvertisingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
@Service("shopAdvertisingService")
public class ShopAdvertisingServiceImpl implements ShopAdvertisingService {

    @Autowired
    private ShopAdvertisingRepository shopAdvertisingRepository;

    @Override
    public ShopAdvertising findOne(int id) {
        return shopAdvertisingRepository.findOne(id);
    }

    @Override
    public Page<ShopAdvertising> findAll(Pageable pageable) {
        return shopAdvertisingRepository.findAll(pageable);
    }

    @Override
    public ShopAdvertising save(ShopAdvertising entity) {
        return shopAdvertisingRepository.save(entity);
    }

    @Override
    public int delete(int id) {
        try {
            shopAdvertisingRepository.delete(id);
        } catch (Exception e){
            return -1;
        }
        return 0;
    }

    @Override
    public List<ShopAdvertising> batchSave(List<ShopAdvertising> entities) {
        return shopAdvertisingRepository.save(entities);
    }
}
