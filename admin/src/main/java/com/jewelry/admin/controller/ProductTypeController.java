package com.jewelry.admin.controller;

import com.jewelry.admin.model.ResultBean;
import com.jewelry.core.entity.ProductTypeEntity;
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
    public ResultBean<ProductTypeEntity> get(int id){
        ProductTypeEntity productTypeEntity = productTypeService.findOne(id);
        ResultBean<ProductTypeEntity> resultBean = new ResultBean<>();
        if(productTypeEntity != null){
            resultBean.setCode(0);
            resultBean.setData(productTypeEntity);
            resultBean.setMessage("查询成功！");
        } else {
            resultBean.setCode(-1);
            resultBean.setMessage("查无记录！");
        }
        return resultBean;
    }

    @GetMapping("/findAll")
    public ResultBean<Page<ProductTypeEntity>> findAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC)Pageable pageable){
        Page<ProductTypeEntity> entityPage = productTypeService.findAll(pageable);
        ResultBean<Page<ProductTypeEntity>> resultBean = new ResultBean<>();
        resultBean.setCode(0);
        resultBean.setMessage("查询结束！");
        resultBean.setData(entityPage);
        return resultBean;
    }

    @PostMapping("/add")
    public ResultBean<ProductTypeEntity> add(ProductTypeEntity entity){
        ProductTypeEntity productTypeEntity = productTypeService.save(entity);
        ResultBean<ProductTypeEntity> resultBean = new ResultBean<>();
        resultBean.setCode(0);
        resultBean.setData(productTypeEntity);
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
    public ResultBean<ProductTypeEntity> update(ProductTypeEntity entity){
        ProductTypeEntity productTypeEntity = productTypeService.save(entity);
        ResultBean<ProductTypeEntity> resultBean = new ResultBean<>(0, "更新成功", productTypeEntity);
        return resultBean;
    }
}
