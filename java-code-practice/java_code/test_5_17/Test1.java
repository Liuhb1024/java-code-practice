package test_5_17;

class Person{
    private String name;
    private int age;

    private static String classRoom = "109";
    //实例代码块
    {
        System.out.println("实例代码块。");
        this.age = 19;
        this.name = "蔡徐坤";

    }

    //静态代码块
    static {
        classRoom = "109";
        System.out.println("静态代码块！");
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

    public static String getClassRoom() {
        return classRoom;
    }

    public static void setClassRoom(String classRoom) {
        Person.classRoom = classRoom;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Test1 {
    public static void main(String[] args) {
        //代码块
        {
            int x = 10;
            System.out.println(x);
        }
        //用不了 System.out.println(x);

        Person person = new Person();
        Person person1 = new Person();

    }


}


