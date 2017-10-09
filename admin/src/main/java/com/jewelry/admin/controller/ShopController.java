package com.jewelry.admin.controller;

import com.jewelry.admin.model.ResultBean;
import com.jewelry.admin.model.ShopVo;
import com.jewelry.admin.service.ShopBusinessService;
import com.jewelry.core.entity.ShopEntity;
import com.jewelry.core.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by lier on 2017/9/30.
 */
@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping("/findOne")
    public ResultBean<ShopEntity> get(int id){
        ShopEntity shopEntity = shopService.findOne(id);
        ResultBean<ShopEntity> resultBean = new ResultBean<>();
        if(shopEntity != null){
            resultBean.setCode(0);
            resultBean.setData(shopEntity);
            resultBean.setMessage("查询成功！");
        } else {
            resultBean.setCode(-1);
            resultBean.setMessage("查无记录！");
        }
        return resultBean;
    }

    @GetMapping("/findAll")
    public ResultBean<Page<ShopEntity>> findAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC)Pageable pageable){
        Page<ShopEntity> entityPage = shopService.findAll(pageable);
        ResultBean<Page<ShopEntity>> resultBean = new ResultBean<>();
        resultBean.setCode(0);
        resultBean.setMessage("查询结束！");
        resultBean.setData(entityPage);
        return resultBean;
    }

    @PostMapping("/add")
    public ResultBean<ShopEntity> add(ShopEntity entity){
        ShopEntity shopEntity = shopService.save(entity);
        ResultBean<ShopEntity> resultBean = new ResultBean<>();
        resultBean.setCode(0);
        resultBean.setData(shopEntity);
        resultBean.setMessage("添加成功！");
        return resultBean;
    }

    @PostMapping("/delete")
    public ResultBean delete(int id){
        int delResult = shopService.delete(id);
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
    public ResultBean<ShopEntity> update(ShopEntity entity){
        ShopEntity shopEntity = shopService.save(entity);
        ResultBean<ShopEntity> resultBean = new ResultBean<>(0, "更新成功", shopEntity);
        return resultBean;
    }

}
