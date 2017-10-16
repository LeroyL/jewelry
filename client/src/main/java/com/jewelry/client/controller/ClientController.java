package com.jewelry.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lier on 2017/10/16.
 */
@Controller
public class ClientController {

    @RequestMapping(value = {"", "/"})
    @ResponseBody
    public String index(){
        return "Hello world";
    }
}
