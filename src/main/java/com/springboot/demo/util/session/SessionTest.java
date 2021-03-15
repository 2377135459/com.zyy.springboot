package com.springboot.demo.util.session;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class SessionTest {
    public static void getSessionTest(String name) {
        Map<String, String> map = new HashMap();
        SessionUtil.setRequestAttribute(name, name);
        map.put("request", String.valueOf(SessionUtil.getRequest()));
        map.put("url", SessionUtil.getRealRootPath());
        map.put("ip", SessionUtil.getIp());
        map.put("username", name);
        map.put("session", String.valueOf(SessionUtil.getSession()));
        String json = JSON.toJSONString(map);
        System.out.println("session信息打印------------" + json);
    }
}
