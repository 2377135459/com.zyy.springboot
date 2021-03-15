package com.springboot.demo.designMode.Bridge;

/**
 * The Abstract of Text
 */
public abstract class Text {
    public abstract void DrawText(String text);

    //相当于桥，链接终端的构造器
    protected TextImp GetTextImp(String type) {
        if (type.equals("Mac")) {
            return new TextImpMac();
        } else if (type.equals("Linux")) {
            return new TextImpLinux();
        } else {
            return new TextImpMac();
        }
    }
}
