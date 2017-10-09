package com.jewelry.core.repository;

import com.jewelry.core.entity.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lier on 2017/9/29.
 */
public interface OrdersRepository extends JpaRepository<OrdersEntity, Integer> {
}
