package com.zbhaha.mp.service;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zbhaha.mp.dto.*;
import com.zbhaha.mp.entity.User;

public interface IUserService extends IService<User> {

    GetUsersRes listBy(GetUsersReq request);

    GetUserRes getBy(String uid);

    UserRes insert(UserReq request);

    UserRes update(UserReq request);

    UserRes delete(UserReq request);
}