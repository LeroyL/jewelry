package com.jewelry.core.repository;

import com.jewelry.core.entity.ProductField;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
public interface ProductFieldRepository extends JpaRepository<ProductField, Integer> {

    List<ProductField> findBySpuId(int spuId);
}
