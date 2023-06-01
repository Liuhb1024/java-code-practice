package test_6_1.demo;

/**
 * @author 刘浩彬
 * @date 2023/6/1
 */

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
            ((Mouse) usb).click();
            /*
            Mouse mouse = (Mouse) usb;
            mouse.click;
             */
        }else if(usb instanceof KeyBoard){
            ((KeyBoard) usb).inPut();
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
