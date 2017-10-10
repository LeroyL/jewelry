package com.jewelry.core.service.impl;

import com.jewelry.core.entity.Shop;
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
    public Shop findOne(int id) {
        return shopRepository.findOne(id);
    }

    @Override
    public Page<Shop> findAll(Pageable pageable) {
        return shopRepository.findAll(pageable);
    }

    @Override
    public Shop save(Shop entity) {
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
    public List<Shop> batchSave(List<Shop> entities) {
        return shopRepository.save(entities);
    }
}
