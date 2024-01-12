package lesson5.HW;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class MainClass {
    public static final int CARS_COUNT = 4;

    private static CyclicBarrier cyclicBarrier;
    private static CountDownLatch countDownLatchReady;
    private static CountDownLatch countDownLatchFinish;
    private static Semaphore semaphore;
    private static ArrayBlockingQueue<String> abqWinner;


    public static void main(String[] args) {

        cyclicBarrier = new CyclicBarrier(CARS_COUNT);
        countDownLatchReady = new CountDownLatch(CARS_COUNT);
        countDownLatchFinish = new CountDownLatch(CARS_COUNT);
        semaphore = new Semaphore(CARS_COUNT/2);
        abqWinner = new ArrayBlockingQueue<>(1);

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> ПОДГОТОВКА!!!");
        Race race = new Race (new Road(40), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), cyclicBarrier, countDownLatchReady, countDownLatchFinish, semaphore, abqWinner);
        }

        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

        try {
            countDownLatchReady.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            System.out.println(abqWinner.take() + " IS WINNNER!!!!!!");
            countDownLatchFinish.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка завершилась!!!");


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("the end");
        }


    }
}
