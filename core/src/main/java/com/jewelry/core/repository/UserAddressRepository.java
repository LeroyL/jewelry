package com.jewelry.core.repository;

import com.jewelry.core.entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
public interface UserAddressRepository extends JpaRepository<UserAddress, Integer> {

    List<UserAddress> findByUserId(int userId);
}
