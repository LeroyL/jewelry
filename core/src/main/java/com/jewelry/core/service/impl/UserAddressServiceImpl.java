package com.jewelry.core.service.impl;

import com.jewelry.core.entity.UserAddress;
import com.jewelry.core.repository.UserAddressRepository;
import com.jewelry.core.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
@Service("userAddressService")
public class UserAddressServiceImpl implements UserAddressService {

    @Autowired
    private UserAddressRepository userAddressRepository;

    @Override
    public UserAddress findOne(int id) {
        return userAddressRepository.findOne(id);
    }

    @Override
    public Page<UserAddress> findAll(Pageable pageable) {
        return userAddressRepository.findAll(pageable);
    }

    @Override
    public UserAddress save(UserAddress entity) {
        return userAddressRepository.save(entity);
    }

    @Override
    public int delete(int id) {
        try {
            userAddressRepository.delete(id);
        } catch (Exception e){
            return -1;
        }
        return 0;
    }

    @Override
    public List<UserAddress> batchSave(List<UserAddress> entities) {
        return userAddressRepository.save(entities);
    }

    @Override
    public List<UserAddress> findByUserId(int userId) {
        return userAddressRepository.findByUserId(userId);
    }
}
