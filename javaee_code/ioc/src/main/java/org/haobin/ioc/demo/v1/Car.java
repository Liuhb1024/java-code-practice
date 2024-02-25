package org.haobin.ioc.demo.v1;

/**
 * @author 刘浩彬
 * @date 2024/2/17
 */
public class Car {
    private Framework framework;
    public Car(int size){
        framework = new Framework(size);
        System.out.println("cat init........");
    }
    public void run() {
        System.out.println("car run.........");
    }

}
