package com.springboot.demo.designMode.Adapter;

/**
 * 类适配器
 * 什么都没有，又要继承又要实现
 */
public class TextShapeClass extends Text implements Shape {
    public TextShapeClass() {
    }

    @Override
    public void Draw() {
        System.out.println("Draw的实现类，实现Shape接口");
    }

    @Override
    public void Border() {

        System.out.println("Set the border of the shap ! 实现Shape接口");
    }

    public static void main(String[] args) {
        TextShapeClass myTextShapeClass = new TextShapeClass();
        myTextShapeClass.Draw();
        myTextShapeClass.Border();
        myTextShapeClass.SetContent("A test text !");
        System.out.println("The content in Text Shape is :" + myTextShapeClass.GetContent());
    }
}
