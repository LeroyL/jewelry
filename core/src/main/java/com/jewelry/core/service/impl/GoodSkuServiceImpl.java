package com.jewelry.core.service.impl;

import com.jewelry.core.entity.GoodSKU;
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
    public GoodSKU findOne(int id) {
        return goodSkuRepository.findOne(id);
    }

    @Override
    public Page<GoodSKU> findAll(Pageable pageable) {
        return goodSkuRepository.findAll(pageable);
    }

    @Override
    public GoodSKU save(GoodSKU entity) {
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
    public List<GoodSKU> batchSave(List<GoodSKU> entities) {
        return goodSkuRepository.save(entities);
    }

    @Override
    public List<GoodSKU> findByGoodId(int goodId) {
        return goodSkuRepository.findByGoodId(goodId);
    }

    @Override
    public void deleteByGoodId(int goodId) {
        goodSkuRepository.deleteByGoodId(goodId);
    }
}
