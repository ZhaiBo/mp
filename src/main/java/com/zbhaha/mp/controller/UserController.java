package com.zbhaha.mp.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zbhaha.mp.dto.GetUserReq;
import com.zbhaha.mp.dto.GetUserRes;
import com.zbhaha.mp.dto.GetUsersReq;
import com.zbhaha.mp.dto.GetUsersRes;
import com.zbhaha.mp.entity.User;
import com.zbhaha.mp.service.IUserService;
import com.zbhaha.mp.utils.CheckUtils;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user/")
public class UserController extends ApiController {
    @Autowired
    private IUserService userService;

    @ResponseBody
    @RequestMapping(value = "get", method = RequestMethod.POST)
    public GetUserRes getById(@RequestBody GetUserReq request) {
        GetUserRes response = new GetUserRes();
        CheckUtils.checkNotNull(request.getUid(), "用户id");
        User user = userService.getById(request.getUid());
        BeanUtils.copyProperties(user, response);
        response.setSuccess();
        return response;
    }

    @ResponseBody
    @RequestMapping(value = "list", method = RequestMethod.POST)
    public GetUsersRes listBy(@RequestBody GetUsersReq request) {
        String pageIndex = request.getPageIndex();
        String pageSize = request.getPageSize();
        CheckUtils.checkNotNull(pageIndex, "pageIndex");
        CheckUtils.checkNotNull(pageSize, "pageSize");

        //构造查询条件
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        Map<String, Object> condition = new HashMap<String, Object>(8);
        //condition.put(User.UID, "1");
        wrapper.like(User.NAME, "%" + request.getName() + "%");
        //wrapper.eq(User.UID,"1");
        //wrapper.between("id", 1, 3);
        wrapper.allEq(condition);
        wrapper.orderByDesc(User.UID);


        //分页查询
        Page<User> pageParam = new Page<User>(Long.parseLong(pageIndex), Long.parseLong(pageSize));
        IPage<User> pageData = userService.page(pageParam, wrapper);

        GetUsersRes response = new GetUsersRes();
        response.setList(pageData.getRecords());
        response.setTotalPages(pageData.getPages());
        response.setTotalRecords(pageData.getTotal());
        response.setSuccess();
        return response;
    }
}
