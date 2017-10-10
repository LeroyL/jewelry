package com.jewelry.core.service.impl;

import com.jewelry.core.repository.GoodsDetailRepository;
import com.jewelry.core.service.GoodsDetailService;
import com.jewelry.core.entity.GoodsDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
@Service("goodsDetailService")
public class GoodsDetailServiceImpl implements GoodsDetailService {

    @Autowired
    private GoodsDetailRepository goodsDetailRepository;

    @Override
    public GoodsDetail findOne(int id) {
        return goodsDetailRepository.findOne(id);
    }

    @Override
    public Page<GoodsDetail> findAll(Pageable pageable) {
        return goodsDetailRepository.findAll(pageable);
    }

    @Override
    public GoodsDetail save(GoodsDetail entity) {
        return goodsDetailRepository.save(entity);
    }

    @Override
    public int delete(int id) {
        try {
            goodsDetailRepository.delete(id);
        } catch (Exception e) {
            return -1;
        }
        return 0;
    }

    @Override
    public List<GoodsDetail> batchSave(List<GoodsDetail> entities) {
        return goodsDetailRepository.save(entities);
    }

    @Override
    public GoodsDetail findByGoodId(int goodId) {
        List<GoodsDetail> entities = goodsDetailRepository.findByGid(goodId);
        return entities.isEmpty() ? null : entities.get(0);
    }

    @Override
    public void deleteByGoodId(int goodId) {
        goodsDetailRepository.deleteByGid(goodId);
    }
}
