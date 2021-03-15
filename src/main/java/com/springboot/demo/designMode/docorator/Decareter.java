package com.springboot.demo.designMode.docorator;

public class Decareter implements Sourceable {
    private Source source;

    public Decareter(Source source) {
        this.source = source;
    }

    @Override
    public void method() {
        System.out.println("打开冰箱门");
        source.method();
        System.out.println("关闭冰箱门");
    }
}
