package test_5_24.typoraNoteTest;

/**
 * @author 刘浩彬
 * @date 2023/5/24
 */
//public class TestAnimal {
//
//        public static void main2(String[] args) {
//            Cat cat = new Cat("元宝",2);
//            Dog dog = new Dog("小七", 1);
//// 向上转型
//            Animal animal = cat;
//                    animal.eat();
//            animal = dog;
//            animal.eat();
//            if(animal instanceof Cat){
//                cat = (Cat)animal;
//                cat.mew();
//            }
//            if(animal instanceof Dog){
//                dog = (Dog)animal;
//                dog.bark();
//            }
//        }
//
//
//    public static void main1(String[] args) {
//        Cat cat = new Cat("元宝",2);
//        Dog dog = new Dog("小七", 1);
//// 向上转型
//        Animal animal = cat;
//        animal.eat();
//        animal = dog;
//        animal.eat();
//// 编译失败，编译时编译器将animal当成Animal对象处理
//// 而Animal类中没有bark方法，因此编译失败
//// animal.bark();
//// 向上转型
//// 程序可以通过编程，但运行时抛出异常---因为：animal实际指向的是狗
//// 现在要强制还原为猫，无法正常还原，运行时抛出：ClassCastException
//        cat = (Cat)animal;
//        cat.mew();
//// animal本来指向的就是狗，因此将animal还原为狗也是安全的
//        dog = (Dog)animal;
//        dog.bark();
//    }
//}
