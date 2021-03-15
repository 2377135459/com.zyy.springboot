package com.springboot.demo.designMode.ChainofResponsibility;

/**
 * A client to test
 */

import java.io.*;

public class Test {
    public static void main(String[] args) {
        //五个实现类的new,以后可以放在工厂里面
        Manager aManager = new Manager();
        ProjectManager aPM = new ProjectManager();
        Programmer aProgrammer = new Programmer();
        QA aQA = new QA();
        Others others = new Others();

        //责任链开始
        aManager.addChain(aPM);
        aPM.addChain(aProgrammer);
        aProgrammer.addChain(aQA);
        aQA.addChain(others);

        aManager.sendToChain("Get Project");
        aManager.sendToChain("Design");
        aManager.sendToChain("Coding");
        aManager.sendToChain("Test");
        aManager.sendToChain("Kill La Deng !");
    }
}
