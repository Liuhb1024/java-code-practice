package org.haobin.ioc.demo.facade;

/**
 * @author 刘浩彬
 * @date 2024/2/26
 */
public class FacadeDemo {
    public static void main(String[] args) {
        // 打开所有屋子的灯
        LightFacade lightFacade = new LightFacade();
        lightFacade.on();
        lightFacade.off();
    }
}
