package test_6_2.demo4;

import java.awt.*;

/**
 * @author 刘浩彬
 * @date 2023/6/2
 */

class Money implements Cloneable{
    public double money = 19.9;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Person implements Cloneable{
    public int age;
    public Money m;

    public Person(int age) {
        this.age = age;
        this.m = new Money();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //return super.clone();
        Person tmp = (Person) super.clone();
        tmp.m = (Money) this.m.clone();
        return tmp;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }
}

public class Test2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person1 = new Person(10);
        Person person2 = (Person) person1.clone();
        System.out.println(person1.m.money);
        System.out.println(person2.m.money);
        System.out.println("=========================");
        person2.m.money = 99.99;
        System.out.println(person1.m.money);
        System.out.println(person2.m.money);
        /*
        浅拷贝
        输出：
        19.9
        19.9
        =========================
        99.99
        99.99
         */

        /*
        重写这个之后
        @Override
        protected Object clone() throws CloneNotSupportedException {
        //return super.clone();
        Person tmp = (Person) super.clone();
        tmp.m = (Money) this.m.clone();
        return tmp;
        }
        输出结果：
        19.9
        19.9
        =========================
        19.9
        99.99
        达到深拷贝
         */
    }
}


