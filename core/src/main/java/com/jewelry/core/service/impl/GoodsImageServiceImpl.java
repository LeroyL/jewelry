package com.jewelry.core.service.impl;

import com.jewelry.core.entity.GoodsImageEntity;
import com.jewelry.core.repository.GoodsImageRepostitory;
import com.jewelry.core.service.GoodsImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
@Service("goodsImageService")
public class GoodsImageServiceImpl implements GoodsImageService {

    @Autowired
    private GoodsImageRepostitory goodsImageRepostitory;

    @Override
    public GoodsImageEntity findOne(int id) {
        return goodsImageRepostitory.findOne(id);
    }

    @Override
    public Page<GoodsImageEntity> findAll(Pageable pageable) {
        return goodsImageRepostitory.findAll(pageable);
    }

    @Override
    public GoodsImageEntity save(GoodsImageEntity entity) {
        return goodsImageRepostitory.save(entity);
    }

    @Override
    public int delete(int id) {
        try {
            goodsImageRepostitory.delete(id);
        } catch (Exception e) {
            return -1;
        }
        return 0;
    }

    @Override
    public List<GoodsImageEntity> batchSave(List<GoodsImageEntity> entities) {
        return goodsImageRepostitory.save(entities);
    }

    @Override
    public List<GoodsImageEntity> findByGoodId(int goodId) {
        return goodsImageRepostitory.findByGid(goodId);
    }
}
