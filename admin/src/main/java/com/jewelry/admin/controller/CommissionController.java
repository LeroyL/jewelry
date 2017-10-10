package com.jewelry.admin.controller;

import com.jewelry.admin.model.ResultBean;
import com.jewelry.core.entity.Commission;
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
    public ResultBean<Commission> get(int id){
        Commission commission = commissionService.findOne(id);
        ResultBean<Commission> resultBean = new ResultBean<>();
        if(commission != null){
            resultBean.setCode(0);
            resultBean.setData(commission);
            resultBean.setMessage("查询成功！");
        } else {
            resultBean.setCode(-1);
            resultBean.setMessage("查无记录！");
        }
        return resultBean;
    }

    @GetMapping("/findAll")
    public ResultBean<Page<Commission>> findAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC)Pageable pageable){
        Page<Commission> entityPage = commissionService.findAll(pageable);
        ResultBean<Page<Commission>> resultBean = new ResultBean<>();
        resultBean.setCode(0);
        resultBean.setMessage("查询结束！");
        resultBean.setData(entityPage);
        return resultBean;
    }

    @PostMapping("/add")
    public ResultBean<Commission> add(Commission entity){
        Commission commission = commissionService.save(entity);
        ResultBean<Commission> resultBean = new ResultBean<>();
        resultBean.setCode(0);
        resultBean.setData(commission);
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
    public ResultBean<Commission> update(Commission entity){
        Commission commission = commissionService.save(entity);
        ResultBean<Commission> resultBean = new ResultBean<>(0, "更新成功", commission);
        return resultBean;
    }
}
