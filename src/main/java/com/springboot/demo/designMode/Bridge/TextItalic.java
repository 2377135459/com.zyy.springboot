package com.springboot.demo.designMode.Bridge;

/**
 * The RefinedAbstraction
 */
public class TextItalic extends Text {
    private TextImp imp;

    public TextItalic(String type) {
        imp = GetTextImp(type);
    }

    @Override
    public void DrawText(String text) {
        System.out.println(text);
        System.out.println("可以视频聊天");
        imp.DrawTextImp();
    }
}
