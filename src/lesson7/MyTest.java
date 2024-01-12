package lesson7;

public class MyTest {


    @Anno (description = "test1", time = 5)
    public static void test1() {
        System.out.println("test1");
    }

    @Anno
    public static void test2() {
        System.out.println("test2");
    }

    @Anno (description = "test3")
    public static void test3() {
        System.out.println("test3");
    }


}
