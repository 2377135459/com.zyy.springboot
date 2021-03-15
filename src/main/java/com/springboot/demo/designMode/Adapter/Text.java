package com.springboot.demo.designMode.Adapter;

/**
 * 适配器
 */
public class Text {
    //对象
    private String content;

    public Text() {

    }

    public void SetContent(String str) {
        content = str;
    }

    public String GetContent() {
        return content;
    }
}
