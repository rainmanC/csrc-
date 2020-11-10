package com.cc.controller;

import com.cc.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author:洛无极
 * @Date:2020/11/5
 */
@Controller
public class ContentController {
    @Autowired
    private ContentService headContentServiceImpl;

    @GetMapping("/")
    public String getRequest(){
         return "index";
    }

    @GetMapping("/getHtml")
    public String getHtml(){
        headContentServiceImpl.sendRequest();
        return "success";
    }
}
