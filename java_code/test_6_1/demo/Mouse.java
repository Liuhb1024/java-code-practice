package test_6_1.demo;

/**
 * @author 刘浩彬
 * @date 2023/6/1
 */
public class Mouse implements IUSB {

    @Override
    public void openDevice() {
        System.out.println("打开鼠标");
    }

    @Override
    public void closeDevice() {
        System.out.println("关闭鼠标");
    }

    public void click(){
        System.out.println("鼠标点击");
    }
}
