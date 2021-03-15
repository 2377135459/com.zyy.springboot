package com.springboot.demo.util.SMS;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 验证手机号是否正确
 */
public class Phonenumber {
    public boolean phone(String number) {
        boolean b = false;
        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,1,5-9]))\\d{8}$";
        if (number.length() != 11) {
            return b;
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(number);
            boolean isMatch = m.matches();
            if (isMatch) {
                b = true;
            } else {
                b = false;
            }
        }
        return b;
    }
}
