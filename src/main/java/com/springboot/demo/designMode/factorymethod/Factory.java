package com.springboot.demo.designMode.factorymethod;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: The9.com</p>
 *
 * @author Jerry Shen
 * @version 0.5
 */
public class Factory implements IFactory {
    @Override
    public Window CreateWindow(String type) {
        if (type.equals("Big")) {
            return new WindowBig();
        } else if (type.equals("Small")) {
            return new WindowSmall();
        } else {
            return new WindowBig();
        }
    }

    public static void main(String[] args) {
        IFactory myFactory = new Factory();
        Window myBigWindow = myFactory.CreateWindow("Big");
        myBigWindow.func();

        Window mySmallWindow = myFactory.CreateWindow("Small");
        mySmallWindow.func();
    }
}
