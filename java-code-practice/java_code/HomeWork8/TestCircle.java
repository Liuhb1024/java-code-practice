package HomeWork8;

/**
 * @author 刘浩彬
 * @date 2023/6/3
 */

// 测试类
public class TestCircle {
    public static void main(String[] args) {
        // 创建两个 Circle 对象
        Circle circle1 = new Circle(2.0);
        Circle circle2 = new Circle(3.0);

        // 判断其颜色是否相等
        if (circle1.getColor().equals(circle2.getColor())) {
            System.out.println("颜色相同");
        } else {
            System.out.println("颜色不同");
        }

        // 利用 equals 方法判断其半径是否相等
        if (circle1.equals(circle2)) {
            System.out.println("半径相等");
        } else {
            System.out.println("半径不等");
        }

        // 利用 toString方法方法输出半径信息
        System.out.println(circle1.toString());
        System.out.println(circle2.toString());
        }
}