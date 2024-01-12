package lesson1.hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
//        testSwap();
//        System.out.println(GenArrayList(new String[]{"sdsdsd", "232323", "pisa"}));
        Box<Apple> box = new Box<>(new ArrayList<>());
        Box<Orange> box2 = new Box<>(new ArrayList<>());
        Box<Orange> box3 = new Box<>(new ArrayList<>());

        box2.addFruit(new Orange(), new Orange(), new Orange(), new Orange());
        box3.addFruit(new Orange(), new Orange(), new Orange(), new Orange());

        box.addFruit(new Apple());
        box.addFruit(new Apple(), new Apple(), new Apple(), new Apple(), new Apple());

        System.out.println("Apples = " + box.getWeight());
        System.out.println("Oranges = " + box2.getWeight());

        System.out.println(box.compare(box2));

        box2.contentMove(box3);
        System.out.println(box2.getWeight());
        System.out.println(box3.getWeight());

        box3.contentMove(box3);



    }

    public static <T> ArrayList<T> GenArrayList(T[] arr) {
        return new ArrayList<>(Arrays.asList(arr));

    }

    public static void testSwap() {
        Integer[] arr = {1, 2, 3, 4, 5};
        Integer[] arr2 = swapArr(arr, 0, 1);
        for (Integer integer : arr2) {
            System.out.println(integer);
        }
    }

    public static <T> T[] swapArr(T[] arr, int x, int y) {
        T temp = arr[x];
        arr[x] =  arr[y];
        arr[y] = temp;
        return arr;
    }

}
