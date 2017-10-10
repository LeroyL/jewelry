package com.jewelry.admin.controller;

import com.jewelry.admin.model.ResultBean;
import com.jewelry.core.entity.ShopOwner;
import com.jewelry.core.service.ShopOwnerService;
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
@RequestMapping("/shopOwner")
public class ShopOwnerController {

    @Autowired
    private ShopOwnerService shopOwnerService;

    @GetMapping("/findOne")
    public ResultBean<ShopOwner> get(int id){
        ShopOwner shopOwner = shopOwnerService.findOne(id);
        ResultBean<ShopOwner> resultBean = new ResultBean<>();
        if(shopOwner != null){
            resultBean.setCode(0);
            resultBean.setData(shopOwner);
            resultBean.setMessage("查询成功！");
        } else {
            resultBean.setCode(-1);
            resultBean.setMessage("查无记录！");
        }
        return resultBean;
    }

    @GetMapping("/findAll")
    public ResultBean<Page<ShopOwner>> findAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC)Pageable pageable){
        Page<ShopOwner> entityPage = shopOwnerService.findAll(pageable);
        ResultBean<Page<ShopOwner>> resultBean = new ResultBean<>();
        resultBean.setCode(0);
        resultBean.setMessage("查询结束！");
        resultBean.setData(entityPage);
        return resultBean;
    }

    @PostMapping("/add")
    public ResultBean<ShopOwner> add(ShopOwner entity){
        ShopOwner shopOwner = shopOwnerService.save(entity);
        ResultBean<ShopOwner> resultBean = new ResultBean<>();
        resultBean.setCode(0);
        resultBean.setData(shopOwner);
        resultBean.setMessage("添加成功！");
        return resultBean;
    }

    @PostMapping("/delete")
    public ResultBean delete(int id){
        int delResult = shopOwnerService.delete(id);
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
    public ResultBean<ShopOwner> update(ShopOwner entity){
        ShopOwner shopOwner = shopOwnerService.save(entity);
        ResultBean<ShopOwner> resultBean = new ResultBean<>(0, "更新成功", shopOwner);
        return resultBean;
    }

}
