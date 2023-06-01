package test_6_1.demo;

/**
 * @author 刘浩彬
 * @date 2023/6/1
 */

/*
IDEA 快捷键 alt+enter
 */
public class KeyBoard implements IUSB{
    @Override
    public void openDevice() {
        System.out.println("打开键盘");
    }

    @Override
    public void closeDevice() {
        System.out.println("关闭键盘");
    }

    public void inPut(){
        System.out.println("键盘输入");
    }
}
