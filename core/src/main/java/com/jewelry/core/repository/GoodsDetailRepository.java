package com.jewelry.core.repository;

import com.jewelry.core.entity.GoodsDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
public interface GoodsDetailRepository extends JpaRepository<GoodsDetailEntity, Integer> {

    List<GoodsDetailEntity> findByGid(int goodId);
}
