package com.zbhaha.mp.controller;

import com.baomidou.mybatisplus.extension.api.ApiController;
import com.zbhaha.mp.dto.*;
import com.zbhaha.mp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/")
public class UserController extends ApiController {
    @Autowired
    private IUserService userService;

    @ResponseBody
    @RequestMapping(value = "get", method = RequestMethod.POST)
    public GetUserRes getById(@RequestBody GetUserReq request) {
        return userService.getBy(request);

    }

    @ResponseBody
    @RequestMapping(value = "list", method = RequestMethod.POST)
    public GetUsersRes listBy(@RequestBody GetUsersReq request) {
        return userService.listBy(request);
    }

    @ResponseBody
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public UserRes insert(@RequestBody UserReq request) {
        return userService.insert(request);
    }

    @ResponseBody
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public UserRes update(@RequestBody UserReq request) {
        return userService.update(request);
    }

    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public UserRes delete(@RequestBody UserReq request) {
        return userService.delete(request);
    }
}
