package lesson5.HW;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;

    private CountDownLatch countDownLatchReady;
    private CountDownLatch countDownLatchFinish;
    private CyclicBarrier cyclicBarrier;
    private Semaphore semaphore;
    private ArrayBlockingQueue<String> abqWinner;

    public String getName() {
        return name;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public Car(Race race, int speed, CyclicBarrier cyclicBarrier, CountDownLatch countDownLatchReady, CountDownLatch countDownLatchFinish, Semaphore semaphore, ArrayBlockingQueue<String> abqWinner) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник №"+ CARS_COUNT;

        this.cyclicBarrier = cyclicBarrier;
        this.countDownLatchReady = countDownLatchReady;
        this.countDownLatchFinish = countDownLatchFinish;
        this.semaphore = semaphore;
        this.abqWinner = abqWinner;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name +" готовится");
            Thread.sleep(500 + (int)(Math.random()*800));
            System.out.println(this.name+ " готов");

            countDownLatchReady.countDown();
            cyclicBarrier.await();

            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }

            countDownLatchFinish.countDown();

            abqWinner.add(this.name);

        } catch (Exception e) {

        }

    }
}
