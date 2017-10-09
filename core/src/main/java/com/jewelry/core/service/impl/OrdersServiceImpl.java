package com.jewelry.core.service.impl;

import com.jewelry.core.entity.OrdersEntity;
import com.jewelry.core.repository.OrdersRepository;
import com.jewelry.core.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public OrdersEntity findOne(int id) {
        return ordersRepository.findOne(id);
    }

    @Override
    public Page<OrdersEntity> findAll(Pageable pageable) {
        return ordersRepository.findAll(pageable);
    }

    @Override
    public OrdersEntity save(OrdersEntity entity) {
        return ordersRepository.save(entity);
    }

    @Override
    public int delete(int id) {
        try {
            ordersRepository.delete(id);
        } catch (Exception e) {
            return -1;
        }
        return 0;
    }

    @Override
    public List<OrdersEntity> batchSave(List<OrdersEntity> entities) {
        return ordersRepository.save(entities);
    }
}
