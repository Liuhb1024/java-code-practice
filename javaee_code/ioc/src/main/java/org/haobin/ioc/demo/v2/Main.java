package org.haobin.ioc.demo.v2;

/**
 * @author 刘浩彬
 * @date 2024/2/17
 */
public class Main {
    public static void main(String[] args) {
        Tire tire = new Tire(17);
        Bottom bottom = new Bottom(tire);
        Framework framework = new Framework(bottom);
        Car car = new Car(framework);
        car.run();
    }
}
