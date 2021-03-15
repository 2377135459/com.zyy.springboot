package com.springboot.demo.billing.impl;

import com.springboot.demo.billing.billingInterface.IBilling;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class IBillingImpl implements IBilling {
    @Override
    public String fristMonthBilling(int year, double money, double proportion) {
        String returns = "";
        if (year > 0) {
            double everyMonth = money / (year * 12);
            returns = "首月因收" + everyMonth + "元";
            Date now = new Date();
            double sum = getDate(now);
            double day = getDay(now);
            double result = (everyMonth / day) * sum;
            System.out.println(result);
        } else {
            returns = "计费年份不能为小于1";
        }
        return returns;
    }

    @Override
    public String everyMonthBilling(double money, double proportion) {
        return null;
    }

    /**
     * 获取本月剩余天数占比
     */
    private double getDate(Date now) {
        int MaxDate = getMaxDate(now);
        int taday = now.getDate();
        double sum = MaxDate - taday + 1;
        double cs = sum / MaxDate;
        DecimalFormat df = new DecimalFormat("######0.00");
        String vc = df.format(cs);
        Double dd = Double.parseDouble(vc);
        return dd;
    }

    /**
     * 获取本月剩余天数
     */
    private double getDay(Date now) {
        int MaxDate = getMaxDate(now);
        int taday = now.getDate();
        double sum = MaxDate - taday + 1;
        return sum;
    }

    /**
     * 获取最大天数
     */
    private int getMaxDate(Date now) {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar a = Calendar.getInstance();
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int MaxDate = a.get(Calendar.DATE);
        return MaxDate;
    }
}
