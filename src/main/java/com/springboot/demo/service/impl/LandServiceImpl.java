package com.springboot.demo.service.impl;

import com.springboot.demo.bean.UserLand;
import com.springboot.demo.mapper.LandMapper;
import com.springboot.demo.service.LandService;
import com.springboot.demo.util.MD5.MD5Util;
import com.springboot.demo.util.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 * 无法清除redis缓存
 * 导致登陆多密码
 */
@Deprecated
@Service("LandServiceImpl")
public class LandServiceImpl implements LandService {
    private static final Logger logger = LoggerFactory.getLogger(LandServiceImpl.class);
    @Autowired
    private LandMapper landMapper;
    @Autowired
    private RedisService redisService;

    @Override
    public boolean selectLand(UserLand user) {
        boolean island = false;
        if (user.getLandPassword() == null || user.getLandPassword() == "") {
            logger.error("密码不能为空");
        }
        if (user.getLandName() == null || user.getLandName() == "") {
            logger.error("账号不能为空");
        }
        String USERNAME = user.getLandName();
        String PASSWORD = user.getLandName() + user.getLandPassword();
        String password = MD5Util.getMd5(user.getLandPassword());
        if (redisService.get(USERNAME) != null && redisService.get(PASSWORD) != null) {
            if (redisService.get(USERNAME).equals(user.getLandName()) && redisService.get(PASSWORD).equals(password)) {
                island = true;
            }
        } else {
            user.setLandPassword(password);
            UserLand userLand = landMapper.selectByUsername(user);
            if (userLand != null && userLand.getLandPassword().equals(user.getLandPassword())) {
                redisService.set(USERNAME, userLand.getLandName());
                redisService.expire(USERNAME, 1);
                redisService.set(PASSWORD, userLand.getLandPassword());
                redisService.expire(PASSWORD, 1);
                redisService.set(userLand.getLandId().toString(), userLand.getLandId().toString());
                island = true;
            }
        }
        return island;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateLandPasword(UserLand userLand) {
        boolean b = false;
        if (userLand.getLandPassword() == null || userLand.getLandPassword() == "") {
            logger.error("修改密码不能为空,密码错误!");
            return b;
        }
        UserLand user = new UserLand();
        user.setLandPassword(MD5Util.getMd5(userLand.getLandPassword()));
        user.setLandId(userLand.getLandId());
        landMapper.updateByPrimaryKeySelective(user);
        //删除缓存
        System.out.println(redisService.get(userLand.getLandName()));
        System.out.println(redisService.get(userLand.getLandName()) + "*");
        System.out.println(userLand.getLandId().toString());
        redisService.remove(userLand.getLandName());
        redisService.remove(user.getLandName() + "*");
        redisService.remove(userLand.getLandId().toString());
        b = true;
        return b;
    }
}
