package com.springboot.demo.designMode.Bridge;

/**
 * The ConcreteImplementor
 */
public class TextImpLinux implements TextImp {
    //省略掉无参构造器
    @Override
    public void DrawTextImp() {
        System.out.println("Linux系统的终端");
    }
}
