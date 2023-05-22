package test_5_22.oop;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘浩彬
 * @date 2023/5/22
 */



class B {
    public B() {
        // do nothing
        func(); // 会调用子类的func
    }
    public void func() {
        System.out.println("B.func()");
    }
}
class D extends B {
    private int num = 1;
    D(){
        super();
    }
    @Override
    // 0
    public void func() {
        System.out.println("D.func() " + num);
    }
}

public class Test2 {
    public static void main(String[] args) {
        D d = new D();
        // List<String> list = new ArrayList<>();发生了向上转型
    }
}
