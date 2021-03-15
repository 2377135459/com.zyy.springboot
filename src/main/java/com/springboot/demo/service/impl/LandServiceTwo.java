package com.springboot.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.demo.bean.UserLand;
import com.springboot.demo.mapper.LandMapper;
import com.springboot.demo.service.LandService;
import com.springboot.demo.util.MD5.MD5Util;
import com.springboot.demo.util.count.Constant;
import com.springboot.demo.util.redis.RedisNumber;
import com.springboot.demo.util.redis.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("LandServiceTwo")
public class LandServiceTwo implements LandService {
    private static final Logger logger = LoggerFactory.getLogger(LandServiceTwo.class);
    @Autowired
    private LandMapper landMapper;
    @Autowired
    private RedisService redisService;

    @Override
    public boolean selectLand(UserLand user) {
        logger.info("登陆信息传入参数：" + JSON.toJSONString(user));
        boolean island = false;
        if (user.getLandPassword() == null || user.getLandPassword() == "") {
            logger.error("密码不能为空");
        }
        if (user.getLandName() == null || user.getLandName() == "") {
            logger.error("账号不能为空");
        }
        String password = MD5Util.getMd5(user.getLandPassword());
        user.setLandPassword(password);
        if (redisService.get(user.getLandName()) != null) {
            String redisinfo = redisService.get(user.getLandName());
            JSONObject jsonObject = JSONObject.parseObject(redisinfo);
            String pass = (String) jsonObject.get(Constant.LandUserConstant.PASSWORD);
            if (user.getLandPassword().equals(pass)) {
                logger.info("登陆成功：redis中的数据" + user);
                island = true;
            }
        } else {
            UserLand userLand = landMapper.selectByUsername(user);
            if (userLand != null) {
                Map<String, Object> map = RedisNumber.setConditionMap(userLand);
                map.put(Constant.LandUserConstant.ID, userLand.getLandId().toString());
                String s = JSON.toJSONString(map);
                redisService.set(user.getLandName(), s);
                logger.info("登陆成功：mysql中的数据" + user);
                island = true;
            }
        }
        return island;
    }

    @Override
    public boolean updateLandPasword(UserLand userLand) {
        boolean b = false;
        if (userLand.getLandPassword() == null || userLand.getLandPassword() == "") {
            logger.error("修改密码不能为空,密码错误!");
            return b;
        }
        String redisinfo = redisService.get(userLand.getLandName());
        JSONObject jsonObject = JSONObject.parseObject(redisinfo);
        Long id = Long.valueOf((String) jsonObject.get(Constant.LandUserConstant.ID));
        UserLand user = new UserLand();
        user.setLandPassword(MD5Util.getMd5(userLand.getLandPassword()));
        user.setLandId(id);
        landMapper.updateByPrimaryKeySelective(user);
        redisService.remove(userLand.getLandName());
        b = true;
        logger.error("修改密码成功!" + userLand);
        return b;
    }
}
