package com.zbhaha.mp.dto;

import com.zbhaha.mp.common.BaseResponse;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetUserRes extends BaseResponse{
    private static final long serialVersionUID = -1539210314127721122L;
    private String addr;
    private String name;
    private String telephone;
}
