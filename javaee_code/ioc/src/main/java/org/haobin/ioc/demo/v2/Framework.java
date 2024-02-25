package org.haobin.ioc.demo.v2;

/**
 * @author 刘浩彬
 * @date 2024/2/17
 */
public class Framework {
    private Bottom bottom;

    public Framework(Bottom bottom) {
        this.bottom = bottom;
        System.out.println("framework init...");
    }
}
