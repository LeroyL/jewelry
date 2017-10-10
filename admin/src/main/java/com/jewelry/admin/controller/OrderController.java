package com.jewelry.admin.controller;

import com.jewelry.admin.model.ResultBean;
import com.jewelry.core.entity.Order;
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
    public ResultBean<Order> find(int orderId){
        Order entity = ordersService.findOne(orderId);
        return new ResultBean<>(0, "查询完成", entity);
    }

    @GetMapping("/findAll")
    public ResultBean<Page<Order>> findAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Order> entityPage = ordersService.findAll(pageable);
        return new ResultBean<>(0, "查询完成", entityPage);
    }

    @PostMapping("/update")
    public ResultBean<Order> update(Order entity){
        Order order = ordersService.save(entity);
        return new ResultBean<>(0, "保存成功", order);
    }
}
