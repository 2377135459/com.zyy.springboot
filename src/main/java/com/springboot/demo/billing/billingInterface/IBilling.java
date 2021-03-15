package com.springboot.demo.billing.billingInterface;

/**
 * @Author zhangyy
 * @Description //TODO 计费测试
 * @Date 14:56 2020/12/23
 **/
public interface IBilling {
    /**
     * @Description //TODO 首月按天末月补齐/成本按比例
     * @Date 14:56 2020/12/23
     **/
    String fristMonthBilling(int year, double money, double proportion);

    /**
     * @Description //TODO 合同月租/成本按比例
     * @Date 14:56 2020/12/23
     **/
    String everyMonthBilling(double money, double proportion);
}
