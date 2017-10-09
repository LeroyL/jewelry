package com.jewelry.core.repository;

import com.jewelry.core.entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {

    List<Administrator> findByAccountAndPassword(String account, String password);
}
