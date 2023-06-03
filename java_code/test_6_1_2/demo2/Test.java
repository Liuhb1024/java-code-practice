package test_6_1_2.demo2;

/**
 * @author 刘浩彬
 * @date 2023/6/1
 */

interface A{
    void testA();
}

interface B{
    void testB();
}

interface C{
    void testC();
}

//需求： 有一个接口 具备B和C接口的功能 extends此时意为拓展
interface D extends B,C{
//    void testA();
//    void testB();
    //D这个接口具备了B,C的功能
    void testD();
}

public class Test implements D{

    @Override
    public void testB() {

    }

    @Override
    public void testC() {

    }

    @Override
    public void testD() {

    }
}
