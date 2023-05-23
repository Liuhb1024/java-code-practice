package test_5_23.oop.demo3;

/**
 * @author 刘浩彬
 * @date 2023/5/23
 */
// USB接口
public interface IUSB {
    void openDevice(); //打开服务
    void closeDevice();//关闭服务
}