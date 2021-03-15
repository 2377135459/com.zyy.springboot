package com.springboot.demo.controller;

import com.alibaba.fastjson.JSON;
import com.springboot.demo.annotation.HAStatusCheck;
import com.springboot.demo.bean.UserLand;
import com.springboot.demo.service.LandService;
import com.springboot.demo.service.impl.UserBaseInfoServiceImpl;
import com.springboot.demo.util.OutBack;
import com.springboot.demo.util.SMS.Phonenumber;
import com.springboot.demo.util.count.Constant;
import com.springboot.demo.util.session.SessionTest;
import com.springboot.demo.util.session.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class LandController {
    @Autowired
    private Map<String, LandService> landService;

    @RequestMapping("/hello")
    @HAStatusCheck()
    public JSON userinfo(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request, HttpServletResponse response) {
        UserLand user = new UserLand();
        user.setLandName(username);
        user.setLandPassword(password);
        boolean ruturn = landService.get(Constant.ServiceImpl.serviceImplName).selectLand(user);
        //session获取
        SessionTest.getSessionTest(username);
        SessionUtil.setSessionAttribute(Constant.LandUserConstant.USERNAME, username);
        return OutBack.objectToJson(ruturn, new Phonenumber().phone(username));
    }

    @RequestMapping("/updatepassword")
    public JSON userupdate() {
        UserLand userLand = new UserLand();
        userLand.setLandName("18602030217");
        userLand.setLandPassword("zyy05162110");
        boolean ruturn = landService.get(Constant.ServiceImpl.serviceImplName).updateLandPasword(userLand);//zyy05162110
        return OutBack.objectToJson(ruturn);
    }
}
