package com.zbhaha.mp.controller;

import com.baomidou.mybatisplus.extension.api.ApiController;
import com.zbhaha.mp.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
public class UserController extends ApiController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @GetMapping("getbyid/{id}")
    public String getById(@PathVariable String id) {
        LOGGER.info("param id is :{}", id);
        return userService.getById(id).toString();
    }
}
