package test_5_23.oop.demo3;

/**
 * @author 刘浩彬
 * @date 2023/5/23
 */
//快捷键 alt + enter
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
