package org.haobin.ioc.demo.v2;

/**
 * @author 刘浩彬
 * @date 2024/2/17
 */
public class Bottom {
    private Tire tire;

    public Bottom(Tire tire) {
        this.tire = tire;
        System.out.println("bottom init...");
    }
}
