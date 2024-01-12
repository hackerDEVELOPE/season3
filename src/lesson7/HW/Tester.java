package lesson7.HW;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;

public class Tester {
    private static Method[] allMethods;
    private static List<Method> beforeSuite = new ArrayList<>(1);
    private static List<Method> afterSuite = new ArrayList<>(1);
    private static List<Method> testMethods = new ArrayList<>(1);
    //   static Method[] afterSuite;
//    static Method[] testMethods;

    public static void start(Class testClass) {
        allMethods = testClass.getDeclaredMethods();
        prepareBeforeAndAfterSuite(testClass);
        prepareTests(testClass);
        executeAll();


    }

    private static void prepareBeforeAndAfterSuite(Class c) {
        for (Method method : allMethods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                beforeSuite.add(method);
            }
        }
        if (beforeSuite.size() > 1) throw new RuntimeException("Can't be > 1 @BeforeSuite methods");

        for (Method method : allMethods) {
            if (method.isAnnotationPresent(AfterSuite.class)) {
                afterSuite.add(method);
            }
        }
        if (afterSuite.size() > 1) throw new RuntimeException("Can't be > 1 @AfterSuite methods");
    }

//    private static void prepareTests(Class c) {
//        for (int i = 10; i > 0; i--) {
//            for (Method method : allMethods) {
//                if (method.isAnnotationPresent(Test.class)) {
//                    if (method.getAnnotation(Test.class).priority() == i) {
//                        testMethods.add(method);
//                    }
//                }
//            }
//        }
//    }

    public static void prepareTests(Class c) {
        for (Method method : allMethods) {
            if (method.isAnnotationPresent(Test.class)) {
                testMethods.add(method);
            }
        }

        testMethods.sort(Comparator.comparingInt(new ToIntFunction<Method>() {
            @Override
            public int applyAsInt(Method i) {
                return i.getAnnotation(Test.class).priority();
            }
        }).reversed());
    }


    private static void executeAll() {
        try {
            for (Method method : beforeSuite) {
                method.invoke(null);
            }
            for (Method method : testMethods) {
                method.invoke(null);
            }
            for (Method method : afterSuite) {
                method.invoke(null);
            }
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }


        System.out.println();
    }
}
