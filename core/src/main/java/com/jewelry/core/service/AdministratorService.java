package com.jewelry.core.service;

import com.jewelry.core.entity.Administrator;

public interface AdministratorService extends BaseService<Administrator> {

    Administrator findByAccountAndPassword(String account, String password);

    Administrator findByAccount(String account);
}
