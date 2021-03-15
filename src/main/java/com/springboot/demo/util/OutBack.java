package com.springboot.demo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.springboot.demo.util.count.Constant;

public class OutBack {
    public static JSON objectToJson(Object obj) {
        JSONObject json = new JSONObject();
        if (obj != null) {
            json = JSONObject.parseObject(obj.toString());
        }
        return json;
    }

    public static JSON objectToJson(boolean obj) {
        JSONObject json = new JSONObject();
        if (obj) {
            json.put("RETURNBACK", Constant.Result.SUCCESS_BACK);
            json.put("RETURNBACKCODE", Constant.ResultCode.SUCCESS_CODE);
        } else {
            json.put("RETURNBACK", Constant.Result.DEFORT_BACK);
            json.put("RETURNBACKCODE", Constant.ResultCode.DEFORT_CODE);
        }
        json.put("RESULT", obj);
        return json;
    }

    public static JSON objectToJson(boolean istrue, Object obj) {
        JSONObject json = new JSONObject();
        if (istrue) {
            json.put("RETURNBACK", Constant.Result.SUCCESS_BACK);
            json.put("RETURNBACKCODE", Constant.ResultCode.SUCCESS_CODE);
        } else {
            json.put("RETURNBACK", Constant.Result.DEFORT_BACK);
            json.put("RETURNBACKCODE", Constant.ResultCode.DEFORT_CODE);
        }
        json.put("RESULT", obj);
        return json;
    }

    public static JSON objectToJson(boolean obj, boolean number) {
        JSONObject json = new JSONObject();
        if (obj) {
            json.put("RETURNBACK", Constant.Result.SUCCESS_BACK);
            json.put("RETURNBACKCODE", Constant.ResultCode.SUCCESS_CODE);
        } else {
            if (number) {
                json.put("RETURNBACK", Constant.Result.DEFORT_BACK);
                json.put("RETURNBACKCODE", Constant.ResultCode.DEFORT_CODE);
            } else {
                json.put("RETURNBACK", Constant.Result.NUMBER_BACK);
                json.put("RETURNBACKCODE", Constant.ResultCode.DEFORT_CODE);
            }

        }
        json.put("RESULT", obj);
        return json;
    }
}