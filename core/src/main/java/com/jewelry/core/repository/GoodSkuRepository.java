package com.jewelry.core.repository;

import com.jewelry.core.entity.GoodSKU;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
public interface GoodSkuRepository extends JpaRepository<GoodSKU, Integer> {

    List<GoodSKU> findByGoodId(int goodId);

    void deleteByGoodId(int goodId);
}
