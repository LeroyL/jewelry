package com.jewelry.core.repository;

import com.jewelry.core.entity.ShopAdvertising;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
public interface ShopAdvertisingRepository extends JpaRepository<ShopAdvertising, Integer> {

    List<ShopAdvertising> findByShopId(int shopId);
}
