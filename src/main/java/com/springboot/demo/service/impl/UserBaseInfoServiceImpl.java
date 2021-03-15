package com.springboot.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.demo.bean.UserBaseInfo;
import com.springboot.demo.mapper.UserBaseInfoMapper;
import com.springboot.demo.service.UserBaseInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBaseInfoServiceImpl implements UserBaseInfoService {
    @Autowired
    private UserBaseInfoMapper userBaseInfoMapper;
    private static final Logger logger = LoggerFactory.getLogger(UserBaseInfoServiceImpl.class);

    @Override
    public Object selectBaseInfo(Long landId) {
        logger.info("用户资料详情" + landId);
        PageHelper.startPage(1, 2);
        List<UserBaseInfo> list = userBaseInfoMapper.selectByPrimaryKey(landId);
        PageInfo<UserBaseInfo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public boolean updateBaseInfo(UserBaseInfo userBaseInfo) {
        return false;
    }
}