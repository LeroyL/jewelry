package com.jewelry.core.repository;

import com.jewelry.core.entity.ProductFieldAttr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
public interface ProductFieldAttrRepository extends JpaRepository<ProductFieldAttr, Integer> {

    List<ProductFieldAttr> findByFid(int fid);
}
