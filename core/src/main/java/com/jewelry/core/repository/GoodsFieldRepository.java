package com.jewelry.core.repository;

import com.jewelry.core.entity.GoodsFieldEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
public interface GoodsFieldRepository extends JpaRepository<GoodsFieldEntity, Integer> {

    List<GoodsFieldEntity> findByGid(int goodId);
}
