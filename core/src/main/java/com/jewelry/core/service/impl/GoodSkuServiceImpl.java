package com.jewelry.core.service.impl;

import com.jewelry.core.entity.GoodSkuEntity;
import com.jewelry.core.repository.GoodSkuRepository;
import com.jewelry.core.service.GoodSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
@Service("goodSkuService")
public class GoodSkuServiceImpl implements GoodSkuService {

    @Autowired
    private GoodSkuRepository goodSkuRepository;

    @Override
    public GoodSkuEntity findOne(int id) {
        return goodSkuRepository.findOne(id);
    }

    @Override
    public Page<GoodSkuEntity> findAll(Pageable pageable) {
        return goodSkuRepository.findAll(pageable);
    }

    @Override
    public GoodSkuEntity save(GoodSkuEntity entity) {
        return goodSkuRepository.save(entity);
    }

    @Override
    public int delete(int id) {
        try {
            goodSkuRepository.delete(id);
        } catch (Exception e){
            return -1;
        }
        return 0;
    }

    @Override
    public List<GoodSkuEntity> batchSave(List<GoodSkuEntity> entities) {
        return goodSkuRepository.save(entities);
    }

    @Override
    public List<GoodSkuEntity> findByGoodId(int goodId) {
        return goodSkuRepository.findByGoodId(goodId);
    }
}
