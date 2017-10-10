package com.jewelry.core.service.impl;

import com.jewelry.core.entity.User;
import com.jewelry.core.repository.UsersRepository;
import com.jewelry.core.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
@Service("usersService")
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public User findOne(int id) {
        return usersRepository.findOne(id);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return usersRepository.findAll(pageable);
    }

    @Override
    public User save(User entity) {
        return usersRepository.save(entity);
    }

    @Override
    public int delete(int id) {
        try {
            usersRepository.delete(id);
        } catch (Exception e){
            return -1;
        }
        return 0;
    }

    @Override
    public List<User> batchSave(List<User> entities) {
        return usersRepository.save(entities);
    }
}
