package com.jewelry.admin.controller;

import com.jewelry.admin.model.ResultBean;
import com.jewelry.core.entity.CommissionEntity;
import com.jewelry.core.service.CommissionService;
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
@RequestMapping("/commission")
public class CommissionController {
    
    @Autowired
    private CommissionService commissionService;

    @GetMapping("/findOne")
    public ResultBean<CommissionEntity> get(int id){
        CommissionEntity commissionEntity = commissionService.findOne(id);
        ResultBean<CommissionEntity> resultBean = new ResultBean<>();
        if(commissionEntity != null){
            resultBean.setCode(0);
            resultBean.setData(commissionEntity);
            resultBean.setMessage("查询成功！");
        } else {
            resultBean.setCode(-1);
            resultBean.setMessage("查无记录！");
        }
        return resultBean;
    }

    @GetMapping("/findAll")
    public ResultBean<Page<CommissionEntity>> findAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC)Pageable pageable){
        Page<CommissionEntity> entityPage = commissionService.findAll(pageable);
        ResultBean<Page<CommissionEntity>> resultBean = new ResultBean<>();
        resultBean.setCode(0);
        resultBean.setMessage("查询结束！");
        resultBean.setData(entityPage);
        return resultBean;
    }

    @PostMapping("/add")
    public ResultBean<CommissionEntity> add(CommissionEntity entity){
        CommissionEntity commissionEntity = commissionService.save(entity);
        ResultBean<CommissionEntity> resultBean = new ResultBean<>();
        resultBean.setCode(0);
        resultBean.setData(commissionEntity);
        resultBean.setMessage("添加成功！");
        return resultBean;
    }

    @PostMapping("/delete")
    public ResultBean delete(int id){
        int delResult = commissionService.delete(id);
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(delResult);
        if(delResult == 0){
            resultBean.setMessage("删除成功！");
        } else {
            resultBean.setMessage("删除失败！");
        }
        return resultBean;
    }

    @PostMapping("/update")
    public ResultBean<CommissionEntity> update(CommissionEntity entity){
        CommissionEntity commissionEntity = commissionService.save(entity);
        ResultBean<CommissionEntity> resultBean = new ResultBean<>(0, "更新成功", commissionEntity);
        return resultBean;
    }
}
