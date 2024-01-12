package lesson7;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) throws Exception {
//        Class c1 = Cat.class;
//        Class c2 = new Cat().getClass();
//        Class c3 = Class.forName("lesson7.Cat");

//        Constructor<Cat> constructor = c1.getConstructor(String.class, int.class, String.class);
//        Cat cat = constructor.newInstance("Dark", 2, "black");

//        cat.info();

//        System.out.println(int.class);
//        System.out.println(int[].class);
//        System.out.println(int[][].class);

//        Method[] methods = c1.getMethods();
//        for (Method method : methods) {
//            System.out.println(method);
//        }
//        Method[] methods = c1.getDeclaredMethods();
//        for (Method method : methods) {
//            System.out.println(method);
//        }

//        Method mInfo = c1.getMethod("info");
//        mInfo.invoke(cat);

//        Method mMeow = c1.getDeclaredMethod("meow");
//        mMeow.setAccessible(true);
//        mMeow.invoke(cat);

//        int mod = mInfo.getModifiers();
//        System.out.println(mod);
//
//        System.out.println(Modifier.isPublic(mod));
//        System.out.println(Modifier.isSynchronized(mod));

//        Field[] fields = c1.getDeclaredFields();
//        for (Field field : fields) {
//            System.out.println(field);
//        }
//
//        Field field = c1.getDeclaredField("name");
//        field.setAccessible(true);
//        System.out.println(field.get(cat));
//
//        field.set(cat, "purple");
//        cat.info();

        Class mt = MyTest.class;
        Method[] methods = mt.getDeclaredMethods();
        for (Method m : methods) {
           if(m.isAnnotationPresent(Anno.class)){
               System.out.println(m.getAnnotation(Anno.class).description());
               m.invoke(null);
           }
        }




    }
}
