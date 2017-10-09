package com.jewelry.admin.controller;

import com.jewelry.admin.model.ResultBean;
import com.jewelry.core.entity.UserAddressEntity;
import com.jewelry.core.entity.UsersEntity;
import com.jewelry.core.service.UserAddressService;
import com.jewelry.core.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private UserAddressService userAddressService;

    @GetMapping("/find")
    public ResultBean<UsersEntity> find(int userId) {
        UsersEntity entity = usersService.findOne(userId);
        return new ResultBean<>(0, "查询完成", entity);
    }

    @GetMapping("/findAll")
    public ResultBean<Page<UsersEntity>> findAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<UsersEntity> entityPage = usersService.findAll(pageable);
        return new ResultBean<>(0, "查询完成", entityPage);
    }

    @PostMapping("/update")
    public ResultBean<UsersEntity> update(UsersEntity entity) {
        UsersEntity ordersEntity = usersService.save(entity);
        return new ResultBean<>(0, "保存成功", ordersEntity);
    }

    @GetMapping("/address/find")
    public ResultBean<UserAddressEntity> findAddress(int addressId) {
        UserAddressEntity entity = userAddressService.findOne(addressId);
        return new ResultBean<>(0, "查询完成", entity);
    }

    @GetMapping("/address/findAll")
    public ResultBean<List<UserAddressEntity>> findUserAddress(int userId){
        List<UserAddressEntity> entities = userAddressService.findByUserId(userId);
        return new ResultBean<>(0, "查询完成", entities);
    }

    @PostMapping("/address/update")
    public ResultBean<UserAddressEntity> updateAddress(UserAddressEntity entity){
        UserAddressEntity addressEntity = userAddressService.save(entity);
        return new ResultBean<>(0, "更新完成", addressEntity);
    }
}
