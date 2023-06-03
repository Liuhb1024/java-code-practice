package test_6_2.demo4;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 刘浩彬
 * @date 2023/6/2
 */

/*
class Student implements Comparable<Student>{
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

 */

class Student{
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /*@Override
    public int compareTo(Student o) {
        //return this.age - o.age;  <--- 简约写法
        if(this.age > o.age){
            return 1;
        }else if(this.age < o.age){
            return -1;
        }else
            return 0;
    }

     */

    public int compareTo(Student o){
        return this.age - o.age;
    }
}

//比较器
//优点 ： 对类的侵入性 不强
class AgeComparator implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        return o1.age - o2.age;
    }
}

class NameComparator implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        //return o1.name - o2.name; ---> 引用类型报错
        return o1.name.compareTo(o2.name);
    }
}

public class Test {

    public static void main(String[] args) {
        Student student1 = new Student("zhangsan",10);
        Student student2 = new Student("lisi",15);

        AgeComparator ageComparator = new AgeComparator();
        System.out.println(ageComparator.compare(student1,student2));

        NameComparator nameComparator = new NameComparator();
        System.out.println(nameComparator.compare(student1, student2));
    }


    public static void bubbleSort(Comparable[] comparable){

        for (int i = 0; i < comparable.length-1; i++) {
            for (int j = 0; j < comparable.length - 1 - i; j++) {
                if(comparable[j].compareTo(comparable[j + 1]) > 0){
                    Comparable tmp = comparable[j];
                    comparable[j] = comparable[j + 1];
                    comparable [j + 1] = tmp;
                }
            }
        }

    }

    /*public static void main1(String[] args) {
        Student student1 = new Student("zhangsan",10);
        Student student2 = new Student("lisi",15);
        //比较大小
        // System.out.println(student1 > student2); -- 报错！
        // 引用类型不能这样比较
        //解决方法 -> 加个接口  -->  implements Comparable<Student> --> 重写一个compare to
        System.out.println(student1.compareTo(student2));//stydent1 与 student2 这个对象比较


        //数组
        Student[] students = new Student[3];
        students[0] = new Student("zhangsan",10);
        students[1] = new Student("lisi",2);
        students[2] = new Student("wangwu",18);

        Arrays.sort(students);

        System.out.println(Arrays.toString(students));
        //输出：
        //[Student{name='lisi', age=2}, Student{name='zhangsan', age=10}, Student{name='wangwu', age=18}

        bubbleSort(students);
        System.out.println(Arrays.toString(students));
    }

     */
}
