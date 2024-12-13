package org.haobin.ioc.demo.v1;

/**
 * @author 刘浩彬
 * @date 2024/2/17
 */
public class Framework {
    private Bottom bottom;

    public Framework(int size) {
        bottom = new Bottom(size);
        System.out.println("framework init.....");
    }
}
