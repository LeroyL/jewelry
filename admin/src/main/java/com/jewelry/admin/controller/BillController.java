package com.jewelry.admin.controller;

import com.jewelry.admin.model.ResultBean;
import com.jewelry.core.entity.Bill;
import com.jewelry.core.service.BillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bill")
public class BillController {
    
    @Autowired
    private BillsService billsService;

    @GetMapping("/find")
    public ResultBean<Bill> find(int billId){
        Bill entity = billsService.findOne(billId);
        return new ResultBean<>(0, "查询完成", entity);
    }

    @GetMapping("/findAll")
    public ResultBean<Page<Bill>> findAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Bill> entityPage = billsService.findAll(pageable);
        return new ResultBean<>(0, "查询完成", entityPage);
    }

//    @PostMapping("/update")
//    public ResultBean<BillsEntity> update(BillsEntity entity){
//        BillsEntity ordersEntity = billsService.save(entity);
//        return new ResultBean<>(0, "保存成功", ordersEntity);
//    }
}
