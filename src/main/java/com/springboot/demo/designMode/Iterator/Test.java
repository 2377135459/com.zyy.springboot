package com.springboot.demo.designMode.Iterator;

/**
 *
 */

import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        String fileName = "D:\\IEDA_project\\springbootproject\\src\\main\\java\\com\\springboot\\demo\\designMode\\Iterator\\data.txt";
        DataVector dataVector = new DataVector(fileName);
        Iterator iVector = dataVector.CreateIterator();
        for (iVector.First(); !iVector.IsDone(); iVector.Next()) {
            iVector.CurrentItem();
        }
    }
}
