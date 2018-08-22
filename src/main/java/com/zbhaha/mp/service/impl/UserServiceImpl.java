package com.zbhaha.mp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zbhaha.mp.dto.*;
import com.zbhaha.mp.entity.User;
import com.zbhaha.mp.mapper.UserMapper;
import com.zbhaha.mp.service.IUserService;
import com.zbhaha.mp.utils.CheckUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public GetUsersRes listBy(GetUsersReq request) {
        String pageIndex = request.getPageIndex();
        String pageSize = request.getPageSize();
        CheckUtils.checkNotNull(pageIndex, "pageIndex");
        CheckUtils.checkNotNull(pageSize, "pageSize");

        //构造查询条件
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        if (!StringUtils.isEmpty(request.getUid())) {
            wrapper.eq(User.UID, request.getUid());
        }
        wrapper.orderByDesc(User.UID);

        //分页查询
        Page<User> pageParam = new Page<User>(Long.parseLong(pageIndex), Long.parseLong(pageSize));
        IPage<User> pageData = userMapper.selectPage(pageParam, wrapper);

        //处理返回结果
        GetUsersRes response = new GetUsersRes();
        response.setList(pageData.getRecords());
        response.setTotalPages(pageData.getPages());
        response.setTotalRecords(pageData.getTotal());
        response.setSuccess();
        return response;
    }

    @Override
    public GetUserRes getBy(GetUserReq request) {
        GetUserRes response = new GetUserRes();
        CheckUtils.checkNotNull(request.getUid(), "用户id");
        User user = userMapper.selectById(request.getUid());
        BeanUtils.copyProperties(user, response);
        response.setSuccess();
        return response;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserRes insert(UserReq request) {
        CheckUtils.checkNotNull(request.getTelephone(), "手机号");
        CheckUtils.checkNotNull(request.getAddr(), "地址");
        CheckUtils.checkNotNull(request.getName(), "姓名");

        User user = new User();
        BeanUtils.copyProperties(request, user);
        userMapper.insert(user);

        UserRes response = new UserRes();
        response.setSuccess();
        return response;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserRes update(UserReq request) {
        CheckUtils.checkNotNull(request.getUid(), "用户id");
        CheckUtils.checkNotNull(request.getTelephone(), "手机号");
        CheckUtils.checkNotNull(request.getAddr(), "地址");
        CheckUtils.checkNotNull(request.getName(), "姓名");

        User user = new User();
        BeanUtils.copyProperties(request, user);
        userMapper.updateById(user);

        UserRes response = new UserRes();
        response.setSuccess();
        return response;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserRes delete(UserReq request) {
        CheckUtils.checkNotNull(request.getUid(), "用户id");

        userMapper.deleteById(request.getUid());

        UserRes response = new UserRes();
        response.setSuccess();
        return response;
    }
}