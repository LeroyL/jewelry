package com.jewelry.core.service.impl;

import com.jewelry.core.entity.Good;
import com.jewelry.core.repository.GoodsRepository;
import com.jewelry.core.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    @Override
    public Good findOne(int id) {
        return goodsRepository.findOne(id);
    }

    @Override
    public Page<Good> findAll(Pageable pageable) {
        return goodsRepository.findAll(pageable);
    }

    @Override
    public Good save(Good entity) {
        return goodsRepository.save(entity);
    }

    @Override
    public int delete(int id) {
        try {
            goodsRepository.delete(id);
        } catch (Exception e) {
            return -1;
        }
        return 0;
    }

    @Override
    public List<Good> batchSave(List<Good> entities) {
        return goodsRepository.save(entities);
    }
}
