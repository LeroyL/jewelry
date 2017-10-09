package com.jewelry.admin.controller;

import com.jewelry.admin.model.ResultBean;
import com.jewelry.core.entity.OrdersEntity;
import com.jewelry.core.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrdersService ordersService;

    @GetMapping("/find")
    public ResultBean<OrdersEntity> find(int orderId){
        OrdersEntity entity = ordersService.findOne(orderId);
        return new ResultBean<>(0, "查询完成", entity);
    }

    @GetMapping("/findAll")
    public ResultBean<Page<OrdersEntity>> findAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<OrdersEntity> entityPage = ordersService.findAll(pageable);
        return new ResultBean<>(0, "查询完成", entityPage);
    }

    @PostMapping("/update")
    public ResultBean<OrdersEntity> update(OrdersEntity entity){
        OrdersEntity ordersEntity = ordersService.save(entity);
        return new ResultBean<>(0, "保存成功", ordersEntity);
    }
}
