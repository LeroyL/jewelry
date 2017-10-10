package com.jewelry.core.repository;

import com.jewelry.core.entity.GoodsDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
public interface GoodsDetailRepository extends JpaRepository<GoodsDetail, Integer> {

    List<GoodsDetail> findByGid(int goodId);

    void deleteByGid(int goodId);
}
