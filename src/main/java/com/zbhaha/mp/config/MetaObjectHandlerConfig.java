package com.zbhaha.mp.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

@Component
public class MetaObjectHandlerConfig implements MetaObjectHandler {

  @Override
  public void insertFill(MetaObject metaObject) {
    //插入方法实体填充
  }

  @Override
  public void updateFill(MetaObject metaObject) {
    //更新方法实体填充
  }
}
