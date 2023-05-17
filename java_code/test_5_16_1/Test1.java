package test_5_16_1;

/*
面向对象的三大特征：
  封装 继承 多态
 */

class Person{
    private String name;//此时这个属性只能在当前类当中使用
    private int age;
    private String sex;

    public Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Person(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    /*

    这个部分实际上有快捷键 alt + insert --> Getter and Setter
                      ---> constructor 构造方法
    //获取name的值
    public String getName() {
        return this.name;
    }

    //修改name的值
    public void setName(String name){
        this.name = name;
    }

     */

}


public class Test1 {
    public static void main(String[] args) {
        Person person = new Person();
        //person.name = 18;因为name被private了，所以没办法读取
        //解决方法：
        person.setName("sdsds");
        System.out.println(person.getName());
    }
}
