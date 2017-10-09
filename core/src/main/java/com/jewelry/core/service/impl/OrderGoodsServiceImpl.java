package com.jewelry.core.service.impl;

import com.jewelry.core.service.OrderGoodsService;
import com.jewelry.core.entity.OrderGoodsEntity;
import com.jewelry.core.repository.OrderGoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
@Service("orderGoodsService")
public class OrderGoodsServiceImpl implements OrderGoodsService {

    @Autowired
    private OrderGoodsRepository orderGoodsRepository;

    @Override
    public OrderGoodsEntity findOne(int id) {
        return orderGoodsRepository.findOne(id);
    }

    @Override
    public Page<OrderGoodsEntity> findAll(Pageable pageable) {
        return orderGoodsRepository.findAll(pageable);
    }

    @Override
    public OrderGoodsEntity save(OrderGoodsEntity entity) {
        return orderGoodsRepository.save(entity);
    }

    @Override
    public int delete(int id) {
        try {
            orderGoodsRepository.delete(id);
        } catch (Exception e){
            return -1;
        }
        return 0;
    }

    @Override
    public List<OrderGoodsEntity> batchSave(List<OrderGoodsEntity> entities) {
        return orderGoodsRepository.save(entities);
    }
}
