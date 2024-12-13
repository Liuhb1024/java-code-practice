package org.haobin.ioc.demo.facade;

/**
 * @author 刘浩彬
 * @date 2024/2/26
 */
public class LivingRoomLight implements Light{
    @Override
    public void on() {
        System.out.println("打开客厅的灯");
    }

    @Override
    public void off() {
        System.out.println("关闭客厅的灯");
    }
}
