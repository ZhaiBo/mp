package com.zbhaha.mp.dto;

import com.zbhaha.mp.common.BaseResponse;
import com.zbhaha.mp.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class GetUsersRes extends BaseResponse{
    private static final long serialVersionUID = -1539210314127721122L;
    private List<User> list;
    private Long totalPages;
    private Long totalRecords;
}
