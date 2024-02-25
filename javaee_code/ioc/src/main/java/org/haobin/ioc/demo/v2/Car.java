package org.haobin.ioc.demo.v2;

/**
 * @author 刘浩彬
 * @date 2024/2/17
 */
public class Car {
    private Framework framework;

    public Car(Framework framework) {
        this.framework = framework;
        System.out.println("car init.......");
    }

    public void run() {
        System.out.println("car run........");
    }
}
