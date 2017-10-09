package com.jewelry.core.repository;

import com.jewelry.core.entity.GoodsImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
public interface GoodsImageRepostitory extends JpaRepository<GoodsImageEntity, Integer> {

    List<GoodsImageEntity> findByGid(int goodId);

    void deleteByGid(int goodId);
}
