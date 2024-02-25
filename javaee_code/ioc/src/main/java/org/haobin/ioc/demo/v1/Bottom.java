package org.haobin.ioc.demo.v1;

/**
 * @author 刘浩彬
 * @date 2024/2/17
 */
public class Bottom {
    private Tire tire;

    public Bottom(int size) {
        tire = new Tire(size);
        System.out.println("bottom init.....");
    }
}
