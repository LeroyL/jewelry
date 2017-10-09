package com.jewelry.admin.controller;

import com.jewelry.admin.model.ResultBean;
import com.jewelry.core.entity.ProductEntity;
import com.jewelry.core.entity.ProductFieldAttrEntity;
import com.jewelry.core.entity.ProductFieldEntity;
import com.jewelry.core.service.ProductFieldAttrService;
import com.jewelry.core.service.ProductFieldService;
import com.jewelry.core.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductFieldService productFieldService;

    @Autowired
    private ProductFieldAttrService productFieldAttrService;

    @GetMapping("/findOne")
    public ResultBean<ProductEntity> get(int id){
        ProductEntity productEntity = productService.findOne(id);
        ResultBean<ProductEntity> resultBean = new ResultBean<>();
        if(productEntity != null){
            resultBean.setCode(0);
            resultBean.setData(productEntity);
            resultBean.setMessage("查询成功！");
        } else {
            resultBean.setCode(-1);
            resultBean.setMessage("查无记录！");
        }
        return resultBean;
    }

    @GetMapping("/findAll")
    public ResultBean<Page<ProductEntity>> findAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC)Pageable pageable){
        Page<ProductEntity> entityPage = productService.findAll(pageable);
        ResultBean<Page<ProductEntity>> resultBean = new ResultBean<>();
        resultBean.setCode(0);
        resultBean.setMessage("查询结束！");
        resultBean.setData(entityPage);
        return resultBean;
    }

    @PostMapping("/add")
    public ResultBean<ProductEntity> add(ProductEntity entity){
        ProductEntity productEntity = productService.save(entity);
        ResultBean<ProductEntity> resultBean = new ResultBean<>();
        resultBean.setCode(0);
        resultBean.setData(productEntity);
        resultBean.setMessage("添加成功！");
        return resultBean;
    }

    @PostMapping("/delete")
    public ResultBean delete(int id){
        int delResult = productService.delete(id);
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
    public ResultBean<ProductEntity> update(ProductEntity entity){
        ProductEntity productEntity = productService.save(entity);
        ResultBean<ProductEntity> resultBean = new ResultBean<>(0, "更新成功", productEntity);
        return resultBean;
    }

    @GetMapping("/field/find")
    public ResultBean<List<ProductFieldEntity>> findFieldByProductId(int productId){
        List<ProductFieldEntity> entities = productFieldService.findByProductId(productId);
        ResultBean<List<ProductFieldEntity>> resultBean = new ResultBean<>(0, "查询完成", entities);
        return resultBean;
    }

    @PostMapping("/field/add")
    public ResultBean<ProductFieldEntity> addField(ProductFieldEntity entity){
        ProductFieldEntity fieldEntity = productFieldService.save(entity);
        ResultBean<ProductFieldEntity> resultBean = new ResultBean<>(0, "添加成功", fieldEntity);
        return resultBean;
    }

    @PostMapping("/field/update")
    public ResultBean<ProductFieldEntity> updateField(ProductFieldEntity entity){
        ProductFieldEntity fieldEntity = productFieldService.save(entity);
        ResultBean<ProductFieldEntity> resultBean = new ResultBean<>(0, "更新成功", fieldEntity);
        return resultBean;
    }

    @GetMapping("/field/attr/find")
    public ResultBean<List<ProductFieldAttrEntity>> findFieldAttrByFieldId(int fieldId){
        List<ProductFieldAttrEntity> entities = productFieldAttrService.findByFieldId(fieldId);
        ResultBean<List<ProductFieldAttrEntity>> resultBean = new ResultBean<>(0, "查询完成", entities);
        return resultBean;
    }

    @PostMapping("field/attr/add")
    public ResultBean<ProductFieldAttrEntity> addFieldAttr(ProductFieldAttrEntity entity){
        ProductFieldAttrEntity attrEntity = productFieldAttrService.save(entity);
        ResultBean<ProductFieldAttrEntity> resultBean = new ResultBean<>(0, "添加成功", attrEntity);
        return resultBean;
    }

    @PostMapping("/field/attr/update")
    public ResultBean<ProductFieldAttrEntity> updateFieldAttr(ProductFieldAttrEntity entity){
        ProductFieldAttrEntity fieldAttrEntity = productFieldAttrService.save(entity);
        ResultBean<ProductFieldAttrEntity> resultBean = new ResultBean<>(0, "更新成功", fieldAttrEntity);
        return resultBean;
    }
}
