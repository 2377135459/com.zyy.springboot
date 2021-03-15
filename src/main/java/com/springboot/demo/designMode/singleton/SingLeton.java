package com.springboot.demo.designMode.singleton;

public class SingLeton {
    public static void main(String[] args) {
        person p = person.getInstance();
        person p1 = person.getInstance();
        System.out.println("懒汉式单例" + (p == p1));
        //
        persons p2 = persons.getInstance();
        persons p3 = persons.getInstance();
        System.out.println("饿汉式单例" + (p2 == p3));
    }
}

class person {
    private static person p;//所要向外界提供的一份实例

    private person() {
    }

    ;//构造器私有化

    public static person getInstance() {
        /*getInstance方法在主函数开始时调用，返回一个实例化对象，此对象是static的，
        在内存中保留着它的引用，即内存中有一块区域专门用来存放静态方法和变量，
        可以直接使用，调用多次返回同一个对象。所以person p对象必须是静态的才能放进这个方法。*/
        if (p == null) {//第一次调用时如果对象没有创建，则创建唯一的一份实例
            p = new person();
        }
        return p;
    }

}

class persons {
    private static persons p;//所要向外界提供的一份实例

    private persons() {
    }

    ;//构造器私有化

    public static persons getInstance() {
        /*getInstance方法在主函数开始时调用，返回一个实例化对象，此对象是static的，
        在内存中保留着它的引用，即内存中有一块区域专门用来存放静态方法和变量，
        可以直接使用，调用多次返回同一个对象。所以person p对象必须是静态的才能放进这个方法。*/

        if (p == null) {//第一次调用时如果对象没有创建，则创建唯一的一份实例
            synchronized (persons.class) {
                if (p == null) {
                    p = new persons();
                }
            }
        }
        return p;
    }
}


