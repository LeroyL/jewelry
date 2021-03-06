package com.jewelry.core.repository;

import com.jewelry.core.entity.GoodField;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
public interface GoodsFieldRepository extends JpaRepository<GoodField, Integer> {

    List<GoodField> findByGid(int goodId);

    void deleteByGid(int goodId);
}
