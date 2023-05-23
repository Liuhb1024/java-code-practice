package test_5_23.oop.demo3;

/**
 * @author 刘浩彬
 * @date 2023/5/23
 */

// 笔记本类：使用USB设备
public class Computer {
    public void powerOn(){
        System.out.println("打开笔记本电脑");
    }
    public void powerOff(){
        System.out.println("关闭笔记本电脑");
    }


    public void useDevice(IUSB usb){
        usb.openDevice();
        if(usb instanceof Mouse){
            //强转
            Mouse mouse = (Mouse)usb;
            mouse.click();
        }else if(usb instanceof KeyBoard){
            KeyBoard keyBoard = (KeyBoard)usb;
            keyBoard.inPut();
        }
        usb.closeDevice();
    }

    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.powerOn();

        computer.useDevice(new Mouse());
        computer.useDevice(new KeyBoard());

        computer.powerOff();
    }
}
