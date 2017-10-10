package com.jewelry.core.service.impl;

import com.jewelry.core.entity.GoodField;
import com.jewelry.core.repository.GoodsFieldRepository;
import com.jewelry.core.service.GoodsFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
@Service("goodsFieldService")
public class GoodsFieldServiceImpl implements GoodsFieldService {

    @Autowired
    private GoodsFieldRepository goodsFieldRepository;

    @Override
    public GoodField findOne(int id) {
        return goodsFieldRepository.findOne(id);
    }

    @Override
    public Page<GoodField> findAll(Pageable pageable) {
        return goodsFieldRepository.findAll(pageable);
    }

    @Override
    public GoodField save(GoodField entity) {
        return goodsFieldRepository.save(entity);
    }

    @Override
    public int delete(int id) {
        try {
            goodsFieldRepository.delete(id);
        } catch (Exception e) {
            return -1;
        }
        return 0;
    }

    @Override
    public List<GoodField> batchSave(List<GoodField> entities) {
        return goodsFieldRepository.save(entities);
    }

    @Override
    public List<GoodField> findByGoodId(int goodId) {
        return goodsFieldRepository.findByGid(goodId);
    }

    @Override
    public void deleteByGoodId(int goodId) {
        goodsFieldRepository.deleteByGid(goodId);
    }
}
