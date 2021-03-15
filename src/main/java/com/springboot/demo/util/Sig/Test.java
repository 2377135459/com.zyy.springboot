package com.springboot.demo.util.Sig;

import com.alibaba.fastjson.JSON;
import com.springboot.demo.util.MD5.MD5Util;
import com.springboot.demo.util.properties.PropertyUtil;

/**
 * Demo class
 *
 * @author keriezhang
 * @date 2016/10/31
 */
public class Test {
    public static void main(String args) {
        //加密和解密过程中的密匙制作基本就是遵循这种原则
        //配置文件中获取密匙
        String keys = PropertyUtil.getVal("sub_key");
        String sub = "cracked" + keys + "znzt";
        String subKey = MD5Util.getMd5(sub).substring(0, 24);
        System.out.println("密匙：" + subKey);
        //测试字符串
        person p = new person();
        p.setTradeId("100000063359");
        p.setCodeValue("59");
        String test = JSON.toJSONString(p);
        System.out.println("原字符串：" + test);
        //加密字符串+密匙制作
        String s = SignatureUtil.md5DigestEncryption(test, subKey);
        System.out.println("加密字符串：" + s);
        //解密字符串+密匙解密
        String body = SignatureUtil.md5DigestDecryption(s, subKey);
        System.out.println("解密字符串：" + body);
        /**
         * 加签验签测试
         * */
        String T = SignatureUtil.generateSignature(p, "88888888");
        System.out.println("加签字符串" + T);
    }
}

class person {
    @Signature
    String tradeId;
    @Signature
    String codeValue;

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

    @Override
    public String toString() {
        return "person{" + "tradeId='" + tradeId + '\'' + ", codeValue='" + codeValue + '\'' + '}';
    }
}
