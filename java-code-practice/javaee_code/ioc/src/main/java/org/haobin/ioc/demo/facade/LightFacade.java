package org.haobin.ioc.demo.facade;

/**
 * @author 刘浩彬
 * @date 2024/2/26
 */
public class LightFacade {
    LivingRoomLight livingRoomLight = new LivingRoomLight();
    BedroomLight bedroomLight = new BedroomLight();
    HallLight hallLight = new HallLight();
    // 打开所有灯
    void on(){
        livingRoomLight.on();
        bedroomLight.on();
        hallLight.on();
    }

    // 关闭所有灯
    void off(){
        livingRoomLight.off();
        bedroomLight.off();
        hallLight.off();
    }
}
