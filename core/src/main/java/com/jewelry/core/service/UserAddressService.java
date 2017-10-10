package com.jewelry.core.service;

import com.jewelry.core.entity.UserAddress;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
public interface UserAddressService extends BaseService<UserAddress> {
    List<UserAddress> findByUserId(int userId);
}
