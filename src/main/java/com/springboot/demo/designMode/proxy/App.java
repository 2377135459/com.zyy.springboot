package com.springboot.demo.designMode.proxy;

import com.springboot.demo.designMode.proxy.proxyfactory.ProxyFactory;
import com.springboot.demo.designMode.proxy.statics.IUserDao;
import com.springboot.demo.designMode.proxy.statics.UserDao;
import com.springboot.demo.designMode.proxy.statics.UserDaoProxy;

/**
 * 测试类
 */
public class App {
    public static void main(String[] args) {
        /**
         * 静态代理
         * */
        //目标对象
        UserDao target = new UserDao();

        //代理对象,把目标对象传给代理对象,建立代理关系
        UserDaoProxy proxy = new UserDaoProxy(target);
        proxy.save();//执行的是代理的方法
        /**
         * 动态代理
         * */
        // 目标对象
        IUserDao targets = new UserDao();
        // 【原始的类型 class cn.itcast.b_dynamic.UserDao】
        System.out.println(targets.getClass());
        // 给目标对象，创建代理对象
        IUserDao proxys = (IUserDao) new ProxyFactory(target).getProxyInstance();
        // class $Proxy0   内存中动态生成的代理对象
        System.out.println(proxys.getClass());
        // 执行方法   【代理对象】
        proxys.save();

    }
}
