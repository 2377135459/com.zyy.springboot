package com.springboot.demo.designMode.docorator;

public class Adamp {
    public static void main(String[] args) {
        Source source = new Source();
        source.method();
        Sourceable sourceable = new Decareter(source);
        sourceable.method();
    }
}
