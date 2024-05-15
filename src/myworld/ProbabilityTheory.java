package myworld;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class ProbabilityTheory {

    static volatile int count1;
    static volatile int count2;
    static AtomicInteger aInt1 = new AtomicInteger();
    static AtomicInteger aInt2 = new AtomicInteger();
    static Random random = new Random();
    public static void main(String[] args) {
        System.out.println(calculateProbability(100000));
    }



    public static float calculateProbability(int n) {
        int rand = 0;
        for (int i = 0; i < n; i++) {
            rand = random.nextInt(10);
            if (rand > 0) aInt1.getAndIncrement();
            else aInt2.getAndIncrement();
        }
        System.out.println(aInt2.get()+" "+ aInt1.get());

        return ((float) aInt1.get() / (float) aInt2.get()) - 8f;
    }
}
