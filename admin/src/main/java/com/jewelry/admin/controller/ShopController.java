package com.jewelry.admin.controller;

import com.jewelry.admin.model.ResultBean;
import com.jewelry.core.entity.Shop;
import com.jewelry.core.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lier on 2017/9/30.
 */
@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping(value = {"", "/"})
    public String index(){
        return "shop/index";
    }

    @GetMapping("/findOne")
    @ResponseBody
    public ResultBean<Shop> get(int id){
        Shop shop = shopService.findOne(id);
        ResultBean<Shop> resultBean = new ResultBean<>();
        if(shop != null){
            resultBean.setCode(0);
            resultBean.setData(shop);
            resultBean.setMessage("查询成功！");
        } else {
            resultBean.setCode(-1);
            resultBean.setMessage("查无记录！");
        }
        return resultBean;
    }

    @GetMapping("/findAll")
    @ResponseBody
    public ResultBean<Page<Shop>> findAll(@PageableDefault(size = 20, sort = "id", direction = Sort.Direction.ASC)Pageable pageable){
        Page<Shop> entityPage = shopService.findAll(pageable);
        ResultBean<Page<Shop>> resultBean = new ResultBean<>();
        resultBean.setCode(0);
        resultBean.setMessage("查询结束！");
        resultBean.setData(entityPage);
        return resultBean;
    }

    @PostMapping("/add")
    @ResponseBody
    public ResultBean<Shop> add(Shop entity){
        Shop shop = shopService.save(entity);
        ResultBean<Shop> resultBean = new ResultBean<>();
        resultBean.setCode(0);
        resultBean.setData(shop);
        resultBean.setMessage("添加成功！");
        return resultBean;
    }

    @PostMapping("/delete")
    @ResponseBody
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
    @ResponseBody
    public ResultBean<Shop> update(Shop entity){
        Shop shop = shopService.save(entity);
        ResultBean<Shop> resultBean = new ResultBean<>(0, "更新成功", shop);
        return resultBean;
    }

}
