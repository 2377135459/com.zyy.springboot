package com.springboot.demo.designMode.Bridge;

/**
 * A test client
 */
public class Test {
    public Test() {
    }

    public static void main(String[] args) {
        //向下转型选择功能，入参选择终端
        Text myText = new TextBold("Mac");

        myText.DrawText("=== A test String ===");

        myText = new TextBold("Linux");
        myText.DrawText("=== A test String ===");

        System.out.println("------------------------------------------");

        myText = new TextItalic("Mac");
        myText.DrawText("=== A test String ===");

        myText = new TextItalic("Linux");
        myText.DrawText("=== A test String ===");
    }
}
