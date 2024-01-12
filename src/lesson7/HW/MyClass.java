package lesson7.HW;

public class MyClass {




    @Test
    public static void test(){
        System.out.println("test default priority");
    }
    @Test (priority = 7)
    public static void test2(){
        System.out.println("test 7 priority");
    }
    @Test (priority = 2)
    public static void test3(){
        System.out.println("test 2 priority");
    }
    @Test (priority = 9)
    public static void test4(){
        System.out.println("test 9 priority");
    }
    @Test (priority = 1)
    public static void test5(){
        System.out.println("test 1 priority");
    }
    @BeforeSuite
    public static void abc() {
        System.out.println("before SUITE");
    }

    @AfterSuite
    public static void abc2() {
        System.out.println("after SUITE");
    }

}
