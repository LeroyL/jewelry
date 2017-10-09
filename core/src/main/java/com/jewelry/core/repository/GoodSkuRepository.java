package com.jewelry.core.repository;

import com.jewelry.core.entity.GoodSkuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
public interface GoodSkuRepository extends JpaRepository<GoodSkuEntity, Integer> {

    List<GoodSkuEntity> findByGoodId(int goodId);
}
