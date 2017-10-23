package com.jewelry.admin.controller;

import com.jewelry.admin.model.ResultBean;
import com.jewelry.core.entity.ShopOwner;
import com.jewelry.core.service.ShopOwnerService;
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
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/shopOwner")
public class ShopOwnerController {

    @Autowired
    private ShopOwnerService shopOwnerService;

    @GetMapping({"", "/"})
    public String index(){
        return "shop/owner/index";
    }

    @GetMapping("/findOne")
    public ModelAndView get(int id, String oper){
        ShopOwner shopOwner = shopOwnerService.findOne(id);
        ShopOwner agent = null;
        if(shopOwner.getAgentShopOwnerId() != null){
            agent = shopOwnerService.findOne(shopOwner.getAgentShopOwnerId());
        }
        String view;
        if (!StringUtils.isEmpty(oper) && oper.equals("edit")) {
            view = "shop/shopOwner/edit";
        } else {
            view = "shop/shopOwner/show";
        }
        return new ModelAndView(view).addObject("shopOwner", shopOwner).addObject("agent", agent);
    }

    @GetMapping("/findAll")
    public ModelAndView findAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC)Pageable pageable){
        Page<ShopOwner> entityPage = shopOwnerService.findAll(pageable);
        return new ModelAndView("shop/owner/index").addObject("showOwners", entityPage);
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
