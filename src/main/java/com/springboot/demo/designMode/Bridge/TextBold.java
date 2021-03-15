package com.springboot.demo.designMode.Bridge;

/**
 * The RefinedAbstraction
 */

import java.io.*;

public class TextBold extends Text {
    private TextImp imp;

    public TextBold(String type) {
        imp = GetTextImp(type);
    }

    @Override
    public void DrawText(String text) {
        System.out.println(text);
        System.out.println("可以语音聊天");
        imp.DrawTextImp();
    }
}
