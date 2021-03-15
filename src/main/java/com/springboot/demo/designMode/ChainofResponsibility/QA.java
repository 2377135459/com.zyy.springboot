package com.springboot.demo.designMode.ChainofResponsibility;

/**
 * A member of the chain
 * The resposibility of QA is test
 */

import java.io.*;

public class QA implements Chain {
    private Chain nextChain = null;
    private String responsibility = "Test";

    public QA() {
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
        if (mesg.equals(responsibility)) {
            System.out.println("A QA  -->  Test");
        } else {
            if (nextChain != null) {
                nextChain.sendToChain(mesg);
            }
        }
    }

}
