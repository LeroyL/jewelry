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
    public ResultBean<Good> find(int goodId) {
        Good entity = goodsService.findOne(goodId);
        ResultBean<Good> resultBean = new ResultBean<>(0, "查询完成", entity);
        return resultBean;
    }

    @GetMapping("/image/find")
    public ResultBean<List<GoodImage>> findImageByGoodId(int goodId) {
        List<GoodImage> imageEntities = goodsImageService.findByGoodId(goodId);
        ResultBean<List<GoodImage>> resultBean = new ResultBean<>(0, "查询完成", imageEntities);
        return resultBean;
    }

    @GetMapping("/detail/find")
    public ResultBean<GoodsDetail> findDetailByGoodId(int goodId) {
        GoodsDetail detailEntity = goodsDetailService.findByGoodId(goodId);
        ResultBean<GoodsDetail> resultBean = new ResultBean<>(0, "查询完成", detailEntity);
        return resultBean;
    }

    @GetMapping("/field/find")
    public ResultBean<List<GoodField>> findFieldByGoodId(int goodId) {
        List<GoodField> fieldEntities = goodsFieldService.findByGoodId(goodId);
        ResultBean<List<GoodField>> resultBean = new ResultBean<>(0, "查询完成", fieldEntities);
        return resultBean;
    }

    @GetMapping("/sku/find")
    public ResultBean<List<GoodSKU>> findSkuByGoodId(int goodId) {
        List<GoodSKU> skuEntities = goodSkuService.findByGoodId(goodId);
        ResultBean<List<GoodSKU>> resultBean = new ResultBean<>(0, "查询完成", skuEntities);
        return resultBean;
    }

    @GetMapping("/findAll")
    public ResultBean<Page<Good>> findAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Good> entityPage = goodsService.findAll(pageable);
        ResultBean<Page<Good>> resultBean = new ResultBean<>();
        resultBean.setCode(0);
        resultBean.setMessage("查询结束！");
        resultBean.setData(entityPage);
        return resultBean;
    }

    @PostMapping("/add")
    public ResultBean<Good> add(Good good) {
        Good entity = goodsService.save(good);
        ResultBean<Good> resultBean = new ResultBean<>(0, "保存成功", entity);
        return resultBean;
    }

    @PostMapping("/image/add")
    public ResultBean<List<GoodImage>> addImage(int goodId, String[] images) {
        List<GoodImage> imageEntities = null;
        if (images.length > 0) {
            List<GoodImage> imageEntityList = new ArrayList<>();
            for (String path : images) {
                GoodImage entity = new GoodImage();
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
    public ResultBean<GoodsDetail> addDetail(int goodId, String detail) {
        GoodsDetail entity = null;
        int code;
        String message;
        if (!StringUtils.isEmpty(detail)) {
            GoodsDetail detailEntity = new GoodsDetail();
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
    public ResultBean<List<GoodField>> addField(HttpServletRequest request, int goodId){
        int code = -1;
        String message = "保存失败";
        List<GoodField> fieldEntities = null;
        //TODO：商品参数保存
        return new ResultBean<>(code, message, fieldEntities);
    }

    @PostMapping("/sku/add")
    public ResultBean<GoodSKU> addSKU(GoodSKU entity){
        GoodSKU skuEntity = goodSkuService.save(entity);
        return new ResultBean<>(0, "保存成功", skuEntity);
    }

    @PostMapping("/update")
    public ResultBean<Good> update(Good good) {
        Good entity = goodsService.save(good);
        ResultBean<Good> resultBean = new ResultBean<>(0, "保存成功", entity);
        return resultBean;
    }

    @PostMapping("/image/update")
    public ResultBean<List<GoodImage>> updateImage(GoodImage[] entities){
        List<GoodImage> imageEntities = goodsImageService.batchSave(Arrays.asList(entities));
        return new ResultBean<>(0, "保存成功", imageEntities);
    }

    @PostMapping("/detail/update")
    public ResultBean<GoodsDetail> updateDetail(GoodsDetail entity){
        GoodsDetail detailEntity = goodsDetailService.save(entity);
        return new ResultBean<>(0, "保存成功", detailEntity);
    }

    @PostMapping("/field/update")
    public ResultBean<List<GoodField>> updateField(GoodField[] entities){
        List<GoodField> fieldEntities = goodsFieldService.batchSave(Arrays.asList(entities));
        return new ResultBean<>(0, "保存成功", fieldEntities);
    }

    @PostMapping("/sku/update")
    public ResultBean<GoodSKU> updateSKU(GoodSKU entity){
        GoodSKU skuEntity = goodSkuService.save(entity);
        return new ResultBean<>(0, "保存成功", skuEntity);
    }

    @PostMapping("/delete")
    public ResultBean delete(int goodId){
        //TODO: 删除前要先校验商品是否已下架
        Good good = goodsService.findOne(goodId);
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
