package com.zbhaha.mp.dto;

import com.zbhaha.mp.common.BaseRequest;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetUsersReq extends BaseRequest{
    private static final long serialVersionUID = -5699856161057860002L;
    private String uid;
    private String name;
    private String pageIndex;
    private String pageSize;
}
