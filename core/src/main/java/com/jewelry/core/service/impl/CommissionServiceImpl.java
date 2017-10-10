package com.jewelry.core.service.impl;

import com.jewelry.core.repository.CommissionRepository;
import com.jewelry.core.service.CommissionService;
import com.jewelry.core.entity.Commission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
@Service("commissionService")
public class CommissionServiceImpl implements CommissionService {

    @Autowired
    private CommissionRepository commissionRepository;

    @Override
    public Commission findOne(int id) {
        return commissionRepository.findOne(id);
    }

    @Override
    public Page<Commission> findAll(Pageable pageable) {
        return commissionRepository.findAll(pageable);
    }

    @Override
    public Commission save(Commission entity) {
        return commissionRepository.save(entity);
    }

    @Override
    public int delete(int id) {
        try {
            commissionRepository.delete(id);
        } catch (Exception e) {
            return -1;
        }
        return 0;
    }

    @Override
    public List<Commission> batchSave(List<Commission> entities) {
        return commissionRepository.save(entities);
    }
}
