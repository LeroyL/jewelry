package com.jewelry.admin.controller;

import com.jewelry.admin.model.ResultBean;
import com.jewelry.core.entity.*;
import com.jewelry.core.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/good")
public class GoodController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsImageService goodsImageService;

    @Autowired
    private GoodsDetailService goodsDetailService;

    @Autowired
    private GoodsFieldService goodsFieldService;

    @Autowired
    private GoodSkuService goodSkuService;

    @GetMapping("/find")
    public ResultBean<GoodsEntity> find(int goodId) {
        GoodsEntity entity = goodsService.findOne(goodId);
        ResultBean<GoodsEntity> resultBean = new ResultBean<>(0, "查询完成", entity);
        return resultBean;
    }

    @GetMapping("/image/find")
    public ResultBean<List<GoodsImageEntity>> findImageByGoodId(int goodId) {
        List<GoodsImageEntity> imageEntities = goodsImageService.findByGoodId(goodId);
        ResultBean<List<GoodsImageEntity>> resultBean = new ResultBean<>(0, "查询完成", imageEntities);
        return resultBean;
    }

    @GetMapping("/detail/find")
    public ResultBean<GoodsDetailEntity> findDetailByGoodId(int goodId) {
        GoodsDetailEntity detailEntity = goodsDetailService.findByGoodId(goodId);
        ResultBean<GoodsDetailEntity> resultBean = new ResultBean<>(0, "查询完成", detailEntity);
        return resultBean;
    }

    @GetMapping("/field/find")
    public ResultBean<List<GoodsFieldEntity>> findFieldByGoodId(int goodId) {
        List<GoodsFieldEntity> fieldEntities = goodsFieldService.findByGoodId(goodId);
        ResultBean<List<GoodsFieldEntity>> resultBean = new ResultBean<>(0, "查询完成", fieldEntities);
        return resultBean;
    }

    @GetMapping("/sku/find")
    public ResultBean<List<GoodSkuEntity>> findSkuByGoodId(int goodId) {
        List<GoodSkuEntity> skuEntities = goodSkuService.findByGoodId(goodId);
        ResultBean<List<GoodSkuEntity>> resultBean = new ResultBean<>(0, "查询完成", skuEntities);
        return resultBean;
    }

    @GetMapping("/findAll")
    public ResultBean<Page<GoodsEntity>> findAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<GoodsEntity> entityPage = goodsService.findAll(pageable);
        ResultBean<Page<GoodsEntity>> resultBean = new ResultBean<>();
        resultBean.setCode(0);
        resultBean.setMessage("查询结束！");
        resultBean.setData(entityPage);
        return resultBean;
    }

    @PostMapping("/add")
    public ResultBean<GoodsEntity> add(GoodsEntity goodsEntity) {
        GoodsEntity entity = goodsService.save(goodsEntity);
        ResultBean<GoodsEntity> resultBean = new ResultBean<>(0, "保存成功", entity);
        return resultBean;
    }

    @PostMapping("/image/add")
    public ResultBean<List<GoodsImageEntity>> addImage(int goodId, String[] images) {
        List<GoodsImageEntity> imageEntities = null;
        if (images.length > 0) {
            List<GoodsImageEntity> imageEntityList = new ArrayList<>();
            for (String path : images) {
                GoodsImageEntity entity = new GoodsImageEntity();
                entity.setGid(goodId);
                entity.setImage(path);
                entity.setStatus(1);
                entity.setCreateTime(new Timestamp(System.currentTimeMillis()));
                imageEntityList.add(entity);
            }
            imageEntities = goodsImageService.batchSave(imageEntityList);
        }
        int code = (imageEntities == null ? -1 : 0);
        String message = (code < 0 ? "保持失败" : "保存成功");
        return new ResultBean<>(code, message, imageEntities);
    }

    @PostMapping("/detail/add")
    public ResultBean<GoodsDetailEntity> addDetail(int goodId, String detail) {
        GoodsDetailEntity entity = null;
        int code;
        String message;
        if (!StringUtils.isEmpty(detail)) {
            GoodsDetailEntity detailEntity = new GoodsDetailEntity();
            detailEntity.setGid(goodId);
            detailEntity.setDetail(detail);
            detailEntity.setCreateTime(new Timestamp(System.currentTimeMillis()));
            try {
                entity = goodsDetailService.save(detailEntity);
                code = 0;
                message = "保存成功";
            } catch (Exception e) {
                code = -2;
                message = "保存失败";
            }
        } else {
            code = -1;
            message = "商品详情为空";
        }
        return new ResultBean<>(code, message, entity);
    }

    @PostMapping("/field/add")
    public ResultBean<List<GoodsFieldEntity>> addField(HttpServletRequest request, int goodId){
        int code = -1;
        String message = "保存失败";
        List<GoodsFieldEntity> fieldEntities = null;
        //TODO
        return new ResultBean<>(code, message, fieldEntities);
    }

    @PostMapping("/sku/add")
    public ResultBean<GoodSkuEntity> addSKU(GoodSkuEntity entity){
        GoodSkuEntity skuEntity = goodSkuService.save(entity);
        return new ResultBean<>(0, "保存成功", skuEntity);
    }

    @PostMapping("/update")
    public ResultBean<GoodsEntity> update(GoodsEntity goodsEntity) {
        GoodsEntity entity = goodsService.save(goodsEntity);
        ResultBean<GoodsEntity> resultBean = new ResultBean<>(0, "保存成功", entity);
        return resultBean;
    }

    @PostMapping("/image/update")
    public ResultBean<List<GoodsImageEntity>> updateImage(GoodsImageEntity[] entities){
        List<GoodsImageEntity> imageEntities = goodsImageService.batchSave(Arrays.asList(entities));
        return new ResultBean<>(0, "保存成功", imageEntities);
    }

    @PostMapping("/detail/update")
    public ResultBean<GoodsDetailEntity> updateDetail(GoodsDetailEntity entity){
        GoodsDetailEntity detailEntity = goodsDetailService.save(entity);
        return new ResultBean<>(0, "保存成功", detailEntity);
    }

    @PostMapping("/field/update")
    public ResultBean<List<GoodsFieldEntity>> updateField(GoodsFieldEntity[] entities){
        List<GoodsFieldEntity> fieldEntities = goodsFieldService.batchSave(Arrays.asList(entities));
        return new ResultBean<>(0, "保存成功", fieldEntities);
    }

    @PostMapping("/sku/update")
    public ResultBean<GoodSkuEntity> updateSKU(GoodSkuEntity entity){
        GoodSkuEntity skuEntity = goodSkuService.save(entity);
        return new ResultBean<>(0, "保存成功", skuEntity);
    }

    @PostMapping("/delete")
    public ResultBean delete(int goodId){
        //TODO: 删除前要先校验商品是否已下架
        GoodsEntity good = goodsService.findOne(goodId);
        if(good.getStatus() == 1){
            return new ResultBean(-1, "只能删除已下架的商品");
        }
        goodSkuService.deleteByGoodId(goodId);
        goodsFieldService.deleteByGoodId(goodId);
        goodsDetailService.deleteByGoodId(goodId);
        goodsImageService.deleteByGoodId(goodId);
        goodsService.delete(goodId);
        return new ResultBean(0, "删除成功");
    }
}
