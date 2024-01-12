package lesson4.p3_synch_blocks;

public class ExampleSB1 {
    public static void main(String[] args) {
        ExampleSB1 e1 = new ExampleSB1();
        ExampleSB1 e2 = new ExampleSB1();

        new Thread(() -> e1.method1()).start(); // e1 является монитором, методы будут выполняться по очереди
        new Thread(() -> e1.method2()).start(); // если заменить в этой строке на е2, выполнятся вместе, так как они оба сами себе мониторы
    }

    public synchronized void method1(){
        System.out.println("m1");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("m2");
    }
    public synchronized  void method2(){
        System.out.println("m1");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("m2");
    }
}
