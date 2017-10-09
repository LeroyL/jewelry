package com.jewelry.core.service.impl;

import com.jewelry.core.entity.BillsEntity;
import com.jewelry.core.repository.BillsRepository;
import com.jewelry.core.service.BillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
@Service("billService")
public class BillsServiceImpl implements BillsService {

    @Autowired
    private BillsRepository billsRepository;

    @Override
    public BillsEntity findOne(int id) {
        return billsRepository.getOne(id);
    }

    @Override
    public Page<BillsEntity> findAll(Pageable pageable) {
        return billsRepository.findAll(pageable);
    }

    @Override
    public BillsEntity save(BillsEntity entity) {
        return billsRepository.save(entity);
    }

    @Override
    public int delete(int id) {
        try {
            billsRepository.delete(id);
        } catch (Exception e){
            return -1;
        }
        return 0;
    }

    @Override
    public List<BillsEntity> batchSave(List<BillsEntity> entities) {
        return billsRepository.save(entities);
    }
}
