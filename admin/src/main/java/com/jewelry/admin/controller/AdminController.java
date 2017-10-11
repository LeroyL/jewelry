package com.jewelry.admin.controller;

import com.jewelry.admin.model.ResultBean;
import com.jewelry.core.entity.Administrator;
import com.jewelry.core.service.AdministratorService;
import com.jewelry.core.utils.MD5Utils;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

@Controller
public class AdminController {

    private RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('a', 'z').build();

    @Autowired
    private AdministratorService administratorService;

    @GetMapping(value = {"", "/", "/index"})
    public String index(HttpServletRequest request){
        Administrator administrator = (Administrator) request.getSession().getAttribute("current_administrator");
        if(administrator == null){
            return "redirect:/login";
        }
        return "index";
    }

    @GetMapping("/login")
    public ModelAndView login(HttpServletRequest request){
        Administrator administrator = (Administrator) request.getSession().getAttribute("current_administrator");
        if(administrator != null){
            return new ModelAndView("redirect:/index");
        }
        String random = generator.generate(6);
        request.getSession().setAttribute("login_str", random);
        return new ModelAndView("login").addObject("code", random);
    }

    @PostMapping("/logining")
    @ResponseBody
    public ResultBean logining(HttpServletRequest request, String account, String password){
        ResultBean resultBean;
        //password = MD5(MD5(password + account) + code)，这个操作在客户端中完成
        Administrator administrator = administratorService.findByAccount(account);
        if(administrator == null) {
            resultBean = new ResultBean(-1, "账号或密码错误");
        }else if(!password.equals(MD5Utils.hash(administrator.getPassword() + request.getSession().getAttribute("login_str")))){
            resultBean = new ResultBean(-2, "账号或密码错误");
        } else {
            request.getSession().setAttribute("current_administrator", administrator);
            request.getSession().removeAttribute("login_str");
            resultBean = new ResultBean(0, "登录成功");
        }
        return resultBean;
    }

    @GetMapping("/admin/find")
    @ResponseBody
    public ResultBean<Administrator> findAdmin(int adminId){
        Administrator administrator = administratorService.findOne(adminId);
        return new ResultBean<>(0, "查询完成", administrator);
    }

    @GetMapping("/admin/findAll")
    @ResponseBody
    public ResultBean<Page<Administrator>> findAllAdmin(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        Page<Administrator> page = administratorService.findAll(pageable);
        return new ResultBean<>(0, "查询完成", page);
    }

    @PostMapping("/admin/add")
    @ResponseBody
    public ResultBean<Administrator> addAdmin(String account, String password, String name){
        Administrator byAccount = administratorService.findByAccount(account);
        if(byAccount != null){
            return new ResultBean<>(-1, "账号已存在");
        }
        Administrator administrator = new Administrator();
        administrator.setAccount(account);
        administrator.setPassword(MD5Utils.hash(password + account));
        administrator.setName(name);
        administrator.setCreateTime(new Timestamp(System.currentTimeMillis()));
        Administrator admin = administratorService.save(administrator);
        return new ResultBean<>(0, "添加成功", admin);
    }

    @PostMapping("/admin/update")
    @ResponseBody
    public ResultBean<Administrator> updateAdmin(Administrator administrator){
        Administrator admin = administratorService.save(administrator);
        return new ResultBean<>(0, "更新成功", admin);
    }

    @PostMapping("/admin/delete")
    @ResponseBody
    public ResultBean deleteAdmin(int adminId){
        int result = administratorService.delete(adminId);
        int code = result;
        String message = (code == 0 ? "删除成功" : "删除失败");
        return new ResultBean(code, message);
    }
}
