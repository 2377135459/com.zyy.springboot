package com.springboot.demo.designMode.ChainofResponsibility;

/**
 * The end of the chain
 * The resposibility of Others is handle exeception
 */

import java.io.*;

public class Others implements Chain {
    private Chain nextChain = null;
    private String responsibility = "";

    public Others() {
    }

    @Override
    public void addChain(Chain c) {
        nextChain = c;
    }

    @Override
    public Chain getChain() {
        return nextChain;
    }

    @Override
    public void sendToChain(String mesg) {
        System.out.println("No one can handle -->  " + mesg);
    }

}