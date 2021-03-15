package com.springboot.demo.service;

import com.springboot.demo.bean.UserBaseInfo;


public interface UserBaseInfoService {
    Object selectBaseInfo(Long landId);

    boolean updateBaseInfo(UserBaseInfo userBaseInfo);
}
