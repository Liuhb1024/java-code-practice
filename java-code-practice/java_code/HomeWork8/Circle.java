package HomeWork8;

/**
 * @author 刘浩彬
 * @date 2023/6/3
 */

// 子类 Circle，代表圆形
class Circle extends GeometricObject {
    // 初始化对象的 color 属性为 "white"，weight 属性为 1.0，radius 属性为 1.0
    private String color = "white";
    private double weight = 1.0;
    private double radius = 1.0;

    // 初始化对象的 color 属性为 "white"，weight 属性为 1.0，radius 根据参数构造器确定
    public Circle(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    // 利用equals方法判断其半径是否相等
    public boolean equals(Circle circle) {
        return this.radius == circle.radius;
    }

    // 利用toString(方法输出其半径）
    @Override
    public String toString() {
        return "Circle{radius=" + radius + "}";
    }
}