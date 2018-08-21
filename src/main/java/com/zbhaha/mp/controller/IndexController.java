package com.zbhaha.mp.controller;

import com.baomidou.mybatisplus.extension.api.ApiController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController extends ApiController {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getById() {
        return "forward:/pages/index/index.html";
    }
}
