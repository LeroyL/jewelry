package com.jewelry.admin.controller;

import com.jewelry.admin.model.ResultBean;
import com.jewelry.core.entity.Shop;
import com.jewelry.core.entity.ShopAdvertising;
import com.jewelry.core.entity.ShopOwner;
import com.jewelry.core.service.ShopAdvertisingService;
import com.jewelry.core.service.ShopOwnerService;
import com.jewelry.core.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by lier on 2017/9/30.
 */
@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @Autowired
    private ShopAdvertisingService shopAdvertisingService;

    @Autowired
    private ShopOwnerService shopOwnerService;

    @GetMapping(value = {"", "/"})
    public String index() {
        return "shop/index";
    }

    @GetMapping("/findOne")
    public ModelAndView get(int id, String oper) {
        Shop shop = shopService.findOne(id);
        List<ShopAdvertising> advertisingList = shopAdvertisingService.findByShopId(id);
        ShopOwner shopOwner = shopOwnerService.findOne(shop.getOwnerId());
        String view;
        if (!StringUtils.isEmpty(oper) && oper.equals("edit")) {
            view = "shop/edit";
        } else {
            view = "shop/show";
        }
        return new ModelAndView(view).addObject("shop", shop).addObject("adverts", advertisingList).addObject("owner", shopOwner);
    }

    @GetMapping("/findAll")
    public ModelAndView findAll(@PageableDefault(size = 20, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Shop> entityPage = shopService.findAll(pageable);
        return new ModelAndView("shop/list").addObject("shops", entityPage);
    }

    @GetMapping("/add")
    public String add(){
        return "shop/add";
    }

    @PostMapping("/save")
    @ResponseBody
    public ResultBean<Shop> add(Shop entity) {
        Shop shop = shopService.save(entity);
        ResultBean<Shop> resultBean = new ResultBean<>();
        resultBean.setCode(0);
        resultBean.setData(shop);
        resultBean.setMessage("添加成功！");
        return resultBean;
    }

    @PostMapping("/delete")
    @ResponseBody
    public ResultBean delete(int id) {
        int delResult = shopService.delete(id);
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(delResult);
        if (delResult == 0) {
            resultBean.setMessage("删除成功！");
        } else {
            resultBean.setMessage("删除失败！");
        }
        return resultBean;
    }

    @PostMapping("/update")
    @ResponseBody
    public ResultBean<Shop> update(Shop entity) {
        Shop shop = shopService.save(entity);
        ResultBean<Shop> resultBean = new ResultBean<>(0, "更新成功", shop);
        return resultBean;
    }

}
