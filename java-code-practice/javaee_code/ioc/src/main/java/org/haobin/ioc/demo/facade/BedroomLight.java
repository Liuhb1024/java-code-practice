package org.haobin.ioc.demo.facade;

/**
 * @author 刘浩彬
 * @date 2024/2/26
 */
public class BedroomLight implements Light{
    @Override
    public void on() {
        System.out.println("打开卧室灯");
    }

    @Override
    public void off() {
        System.out.println("关闭卧室灯");
    }
}
