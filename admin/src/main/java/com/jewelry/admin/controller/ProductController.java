package com.jewelry.admin.controller;

import com.jewelry.admin.model.ResultBean;
import com.jewelry.core.entity.Product;
import com.jewelry.core.entity.ProductFieldAttr;
import com.jewelry.core.entity.ProductField;
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
    public ResultBean<Product> get(int id){
        Product product = productService.findOne(id);
        ResultBean<Product> resultBean = new ResultBean<>();
        if(product != null){
            resultBean.setCode(0);
            resultBean.setData(product);
            resultBean.setMessage("查询成功！");
        } else {
            resultBean.setCode(-1);
            resultBean.setMessage("查无记录！");
        }
        return resultBean;
    }

    @GetMapping("/findAll")
    public ResultBean<Page<Product>> findAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC)Pageable pageable){
        Page<Product> entityPage = productService.findAll(pageable);
        ResultBean<Page<Product>> resultBean = new ResultBean<>();
        resultBean.setCode(0);
        resultBean.setMessage("查询结束！");
        resultBean.setData(entityPage);
        return resultBean;
    }

    @PostMapping("/add")
    public ResultBean<Product> add(Product entity){
        Product product = productService.save(entity);
        ResultBean<Product> resultBean = new ResultBean<>();
        resultBean.setCode(0);
        resultBean.setData(product);
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
    public ResultBean<Product> update(Product entity){
        Product product = productService.save(entity);
        ResultBean<Product> resultBean = new ResultBean<>(0, "更新成功", product);
        return resultBean;
    }

    @GetMapping("/field/find")
    public ResultBean<List<ProductField>> findFieldByProductId(int productId){
        List<ProductField> entities = productFieldService.findByProductId(productId);
        ResultBean<List<ProductField>> resultBean = new ResultBean<>(0, "查询完成", entities);
        return resultBean;
    }

    @PostMapping("/field/add")
    public ResultBean<ProductField> addField(ProductField entity){
        ProductField fieldEntity = productFieldService.save(entity);
        ResultBean<ProductField> resultBean = new ResultBean<>(0, "添加成功", fieldEntity);
        return resultBean;
    }

    @PostMapping("/field/update")
    public ResultBean<ProductField> updateField(ProductField entity){
        ProductField fieldEntity = productFieldService.save(entity);
        ResultBean<ProductField> resultBean = new ResultBean<>(0, "更新成功", fieldEntity);
        return resultBean;
    }

    @GetMapping("/field/attr/find")
    public ResultBean<List<ProductFieldAttr>> findFieldAttrByFieldId(int fieldId){
        List<ProductFieldAttr> entities = productFieldAttrService.findByFieldId(fieldId);
        ResultBean<List<ProductFieldAttr>> resultBean = new ResultBean<>(0, "查询完成", entities);
        return resultBean;
    }

    @PostMapping("field/attr/add")
    public ResultBean<ProductFieldAttr> addFieldAttr(ProductFieldAttr entity){
        ProductFieldAttr attrEntity = productFieldAttrService.save(entity);
        ResultBean<ProductFieldAttr> resultBean = new ResultBean<>(0, "添加成功", attrEntity);
        return resultBean;
    }

    @PostMapping("/field/attr/update")
    public ResultBean<ProductFieldAttr> updateFieldAttr(ProductFieldAttr entity){
        ProductFieldAttr fieldAttrEntity = productFieldAttrService.save(entity);
        ResultBean<ProductFieldAttr> resultBean = new ResultBean<>(0, "更新成功", fieldAttrEntity);
        return resultBean;
    }
}
