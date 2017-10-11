package com.jewelry.core.service.impl;

import com.jewelry.core.entity.Administrator;
import com.jewelry.core.repository.AdministratorRepository;
import com.jewelry.core.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("administratorService")
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorRepository administratorRepository;

    @Override
    public Administrator findOne(int id) {
        return administratorRepository.findOne(id);
    }

    @Override
    public Page<Administrator> findAll(Pageable pageable) {
        return administratorRepository.findAll(pageable);
    }

    @Override
    public Administrator save(Administrator entity) {
        return administratorRepository.save(entity);
    }

    @Override
    public int delete(int id) {
        try {
            administratorRepository.delete(id);
        } catch (Exception e) {
            return -1;
        }
        return 0;
    }

    @Override
    public List<Administrator> batchSave(List<Administrator> entities) {
        return administratorRepository.save(entities);
    }

    @Override
    public Administrator findByAccountAndPassword(String account, String password) {
        List<Administrator> list = administratorRepository.findByAccountAndPassword(account, password);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public Administrator findByAccount(String account) {
        List<Administrator> list = administratorRepository.findByAccount(account);
        return list.isEmpty() ? null : list.get(0);
    }
}
