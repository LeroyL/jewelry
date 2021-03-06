package com.jewelry.admin.controller;

import com.jewelry.admin.model.ResultBean;
import com.jewelry.core.entity.ProductType;
import com.jewelry.core.service.ProductTypeAttrService;
import com.jewelry.core.service.ProductTypeService;
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
@RequestMapping("/productType")
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    @Autowired
    private ProductTypeAttrService productTypeAttrService;

    @GetMapping("/findOne")
    public ResultBean<ProductType> get(int id){
        ProductType productType = productTypeService.findOne(id);
        ResultBean<ProductType> resultBean = new ResultBean<>();
        if(productType != null){
            resultBean.setCode(0);
            resultBean.setData(productType);
            resultBean.setMessage("查询成功！");
        } else {
            resultBean.setCode(-1);
            resultBean.setMessage("查无记录！");
        }
        return resultBean;
    }

    @GetMapping("/findAll")
    public ResultBean<Page<ProductType>> findAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC)Pageable pageable){
        Page<ProductType> entityPage = productTypeService.findAll(pageable);
        ResultBean<Page<ProductType>> resultBean = new ResultBean<>();
        resultBean.setCode(0);
        resultBean.setMessage("查询结束！");
        resultBean.setData(entityPage);
        return resultBean;
    }

    @PostMapping("/add")
    public ResultBean<ProductType> add(ProductType entity){
        ProductType productType = productTypeService.save(entity);
        ResultBean<ProductType> resultBean = new ResultBean<>();
        resultBean.setCode(0);
        resultBean.setData(productType);
        resultBean.setMessage("添加成功！");
        return resultBean;
    }

    @PostMapping("/delete")
    public ResultBean delete(int id){
        int delResult = productTypeService.delete(id);
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
    public ResultBean<ProductType> update(ProductType entity){
        ProductType productType = productTypeService.save(entity);
        ResultBean<ProductType> resultBean = new ResultBean<>(0, "更新成功", productType);
        return resultBean;
    }
}
