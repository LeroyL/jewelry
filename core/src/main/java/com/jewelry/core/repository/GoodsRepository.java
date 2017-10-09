package com.jewelry.core.repository;

import com.jewelry.core.entity.GoodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lier on 2017/9/29.
 */
public interface GoodsRepository extends JpaRepository<GoodsEntity, Integer> {
}
