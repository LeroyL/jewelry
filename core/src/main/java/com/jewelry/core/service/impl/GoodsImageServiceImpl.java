package com.jewelry.core.service.impl;

import com.jewelry.core.entity.GoodImage;
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
    public GoodImage findOne(int id) {
        return goodsImageRepostitory.findOne(id);
    }

    @Override
    public Page<GoodImage> findAll(Pageable pageable) {
        return goodsImageRepostitory.findAll(pageable);
    }

    @Override
    public GoodImage save(GoodImage entity) {
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
    public List<GoodImage> batchSave(List<GoodImage> entities) {
        return goodsImageRepostitory.save(entities);
    }

    @Override
    public List<GoodImage> findByGoodId(int goodId) {
        return goodsImageRepostitory.findByGid(goodId);
    }

    @Override
    public void deleteByGoodId(int goodId) {
        goodsImageRepostitory.deleteByGid(goodId);
    }
}
