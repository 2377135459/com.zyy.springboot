package com.springboot.demo.designMode.Bridge;

/**
 * The ConcreteImplementor
 */
public class TextImpMac implements TextImp {
    //无参构造器
    public TextImpMac() {
    }

    @Override
    public void DrawTextImp() {
        System.out.println("Max系统的终端");
    }
}