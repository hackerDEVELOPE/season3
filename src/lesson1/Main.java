package lesson1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
//        double x = sumOfList(numbers);
        int x = getFirstElement(numbers);
        System.out.println(x);

//        Collections.copy();
    }

    public static <T> T getFirstElement(List<T> list){
        return list.get(0);
    }

    public static double sumOfList( List<? extends Number> nums){
        double sum = 0.0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i).doubleValue();
        }
        return sum;
    }


    private static void exBoxWithNumbers(){
        BoxWithNumbers<Float> boxFloat = new BoxWithNumbers<>(1f, 2f, 4f, 6f);
        BoxWithNumbers<Float> boxFloat2 = new BoxWithNumbers<>(1f, 2f, 4f, 6f);
        System.out.println(boxFloat.avg());
        System.out.println(boxFloat2.avg());
        System.out.println(boxFloat.sameAvg(boxFloat2));

        BoxWithNumbers<Integer> boxInteger = new BoxWithNumbers<>(5, 2, 5, 67);
        System.out.println(boxInteger.avg());
        System.out.println(boxFloat.sameAvg(boxInteger));
    }
    private static void exBoxGen() {
        BoxGen<Integer> box1 = new BoxGen<>(10);
        BoxGen<Integer> box2 = new BoxGen<>(120);

        box1.setObj(64);

        int sum = box1.getObj() + box2.getObj();
        System.out.println("sum = " + sum);

        BoxGen<String> boxStr = new BoxGen<>("kaif");

        System.out.println(box1.getClass());
        System.out.println(boxStr.getClass());
    }

    private static void exSimpleBox() {
        SimpleBox box1 = new SimpleBox(10);
        SimpleBox box2 = new SimpleBox(20);

        //////////////////
        box1.setObj("java");
        /////////////////
        if (box1.getObj() instanceof Integer && box2.getObj() instanceof Integer) {
            int sum = (Integer) box1.getObj() + (Integer) box2.getObj();
            System.out.println("sum = " + sum);
        }
    }
    public void doubleBouble(){
        double a = 0.0;
        double b = 0.7;
        for (int i = 0; i < 70; i++) {
            a += 0.01;
        }
        System.out.println(a == b);
        System.out.println(a);
        System.out.println(Math.abs(a-b) < 0.000001);
    }
}
