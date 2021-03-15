package com.springboot.demo.util.SMS;

import com.alibaba.fastjson.JSONObject;
import com.zhenzi.sms.ZhenziSmsClient;
import org.springframework.beans.factory.annotation.Value;

import java.util.Random;

/**
 * 发送短信验证码
 * 欠费状态
 */
//@PropertySource("classpath:application.properties")

public class SendSms {
    @Value("${apiUrl}")
    private String apiUrl;
    private String appId = "100862";
    private String appSecret = "62358d10-bc0e-4152-a52c-578a8debc9b9";

    public String sendSmsByNummber(String nummber) {
        String result = null;
        if (nummber != null) {
            try {
                JSONObject json = null;
                String code = String.valueOf(new Random().nextInt(999999));
                ZhenziSmsClient client = new ZhenziSmsClient(apiUrl, appId, appSecret);
                result = client.send(nummber, "你当前的手机验证码为:" + code + "，请不要告诉他人");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}