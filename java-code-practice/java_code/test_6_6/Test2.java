package test_6_6;

import java.awt.*;

/**
 * @author 刘浩彬
 * @date 2023/6/6
 */

class Person implements Cloneable{
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class Test2 {

    //递归  栈溢出、堆溢出
    public static void test(){
        test();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        /*
        Person person = new Person();
        Person person1 = (Person) person.clone();
         */
        test();
    }



}
