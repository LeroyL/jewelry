package com.jewelry.core.service.impl;

import com.jewelry.core.entity.ShopOwnerEntity;
import com.jewelry.core.repository.ShopOwnerRepository;
import com.jewelry.core.service.ShopOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
@Service("shopOwnerService")
public class ShopOwnerServiceImpl implements ShopOwnerService {

    @Autowired
    private ShopOwnerRepository shopOwnerRepository;

    @Override
    public ShopOwnerEntity findOne(int id) {
        return shopOwnerRepository.findOne(id);
    }

    @Override
    public Page<ShopOwnerEntity> findAll(Pageable pageable) {
        return shopOwnerRepository.findAll(pageable);
    }

    @Override
    public ShopOwnerEntity save(ShopOwnerEntity entity) {
        return shopOwnerRepository.save(entity);
    }

    @Override
    public int delete(int id) {
        try {
            shopOwnerRepository.delete(id);
        } catch (Exception e){
            return -1;
        }
        return 0;
    }

    @Override
    public List<ShopOwnerEntity> batchSave(List<ShopOwnerEntity> entities) {
        return shopOwnerRepository.save(entities);
    }
}
