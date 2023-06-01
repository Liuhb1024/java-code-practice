package test_6_1_1.demo3;

import java.util.Objects;

/**
 * @author 刘浩彬
 * @date 2023/6/1
 */

class Person{
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';

        /*
//        return "Person{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';
         return "haobin";
         */

    }
    // 若没有toString 输出test_6_1_1.demo3.Person@14ae5a5
    // 若有toString   输出Person{name='zhangsan', age=10}


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
public class Test {
    public static void main(String[] args) {
        Person person1 = new Person("zhangsan",10);
        System.out.println(person1);
        Person person2 = new Person("zhangsan",10);
        System.out.println(person2);

        System.out.println("----------------------------------");

        System.out.println(person1 == person2);
        //false - 地址不一样

        System.out.println(person1.equals(person2));
        //false - 其实比的和上面的类似 Object
        //重写 equals 就会变成true

        Person person3 = person1;
        System.out.println(person1.equals(person3));

    }
}
