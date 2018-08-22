package com.zbhaha.mp.dto;

import com.zbhaha.mp.common.BaseRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserReq extends BaseRequest {
    private static final long serialVersionUID = -6620917879357251635L;
    private String uid;
    private String addr;
    private String name;
    private String telephone;
}
