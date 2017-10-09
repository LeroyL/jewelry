package com.jewelry.core.repository;

import com.jewelry.core.entity.ProductFieldAttrEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
public interface ProductFieldAttrRepository extends JpaRepository<ProductFieldAttrEntity, Integer> {

    List<ProductFieldAttrEntity> findByFid(int fid);
}
