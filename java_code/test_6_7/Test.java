package test_6_7;

/**
 * @author 刘浩彬
 * @date 2023/6/7
 */
public class Test {

    public static void main(String[] args) {

    }

//建议写法：
    public static void main3(String[] args) {
        try{
            System.out.println(10/0);
        }catch (ArithmeticException e){
            e.printStackTrace();
            System.out.println("捕获到了算数异常");
        }catch (NullPointerException e){
            System.out.println("捕获到空指针异常");
        }
        //父类放到最后
        catch (Exception e){
            System.out.println("捕获到异常");
        }
        System.out.println("其他业务代码");
    }

    public static void main2(String[] args) {


        //catch 一定要捕获一个异常 否则还是交给 JVM
        try{
            System.out.println(10/0);
        }catch (ArithmeticException e){
            System.out.println("捕获到了算数异常！");
        }
        System.out.println("其他业务代码");
    }

    public static void main1(String[] args) {
        //System.out.println(10/0); ---> ArithmeticException

        int a = 10;
        if(a == 10){
            //抛出一个自定义异常
            throw new ArithmeticException("a == 10");
            //throw new CloneNotSupportedException("sdsds"); -- 报错
            /**
             * 抛出一个运行时异常是不需要处理的，但是如果是一个编译时异常，就需要处理这个异常
             * 最简单的方式是通过 throws 去处理
             * throws CloneNotSupportedException 一般放在方法声明的地方
             */
        }
    }
}
