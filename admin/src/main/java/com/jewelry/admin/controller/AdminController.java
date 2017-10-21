package com.jewelry.admin.controller;

import com.jewelry.admin.config.Constants;
import com.jewelry.admin.model.ResultBean;
import com.jewelry.core.entity.Administrator;
import com.jewelry.core.service.AdministratorService;
import com.jewelry.core.utils.FileUploadUtil;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {

    private RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('a', 'z').build();

    @Autowired
    private AdministratorService administratorService;

    @GetMapping(value = {"", "/", "/index"})
    public String index(HttpServletRequest request){
        Administrator administrator = (Administrator) request.getSession().getAttribute(Constants.SESSION_ADMIN);
        if(administrator == null){
            return "redirect:/login";
        }
        return "index";
    }

    @GetMapping("/login")
    public ModelAndView login(HttpServletRequest request){
        Administrator administrator = (Administrator) request.getSession().getAttribute(Constants.SESSION_ADMIN);
        if(administrator != null){
            return new ModelAndView("redirect:/index");
        }
        String random = generator.generate(6);
        request.getSession().setAttribute(Constants.SESSION_LOGIN_CODE, random);
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
        }else if(!password.equals(MD5Utils.hash(administrator.getPassword() + request.getSession().getAttribute(Constants.SESSION_LOGIN_CODE)))){
            resultBean = new ResultBean(-2, "账号或密码错误");
        } else {
            request.getSession().setAttribute(Constants.SESSION_ADMIN, administrator);
            request.getSession().removeAttribute(Constants.SESSION_LOGIN_CODE);
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

    @PostMapping("/file/upload")
    @ResponseBody
    public ResultBean fileUpload(HttpServletRequest request, @RequestParam MultipartFile[] files){
        if(files == null || files.length == 0){
            return new ResultBean(-1, "未检测到文件!");
        }
        String host = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        List<String> fileList = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            String sourceName = file.getOriginalFilename();
            String prefix = request.getSession().getServletContext().getRealPath("") + "/WEB-INF/classes/static/upload/";
            String dir = FileUploadUtil.getFileDir(prefix);
            File fileDir = new File(dir);
            if(!fileDir.exists()){
                fileDir.mkdirs();
            }
            String fileName = dir + FileUploadUtil.getFileName(sourceName);
            String uri = host + fileName.substring(fileName.indexOf("/static/upload/"));
            File dist = new File(fileName);
            try {
                file.transferTo(dist);
                fileList.add(uri);
            } catch (IOException e) {
                e.printStackTrace();
                return new ResultBean(-2, "保存文件" + sourceName + "失败!");
            }
        }
        return new ResultBean(0, "文件上传成功", fileList);
    }
}
