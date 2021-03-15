package com.springboot.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.springboot.demo.service.impl.UserBaseInfoServiceImpl;
import com.springboot.demo.util.OutBack;
import com.springboot.demo.util.count.Constant;
import com.springboot.demo.util.redis.RedisService;
import com.springboot.demo.util.session.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/success")
public class SuccessController {
    @Autowired
    private UserBaseInfoServiceImpl userBaseInfoService;
    @Autowired
    private RedisService redisService;

    @RequestMapping("/successland")
    public ModelAndView successLand(HttpServletRequest request) {
        String attribute = (String) SessionUtil.getSessionAttribute(Constant.LandUserConstant.USERNAME);
        String redis = redisService.get(attribute);
        JSON json = JSONObject.parseObject(redis);
        String landid = (String) ((JSONObject) json).get(Constant.LandUserConstant.ID);
        Long longs = Long.valueOf(landid).longValue();
        Object object = userBaseInfoService.selectBaseInfo(longs);
        System.out.println("登陆信息打印" + object);
        ModelAndView modelAndView = new ModelAndView();
        JSON result = OutBack.objectToJson(true, object);
        modelAndView.setViewName("flex");
        modelAndView.addObject("key", result);
        return modelAndView;
    }
}
