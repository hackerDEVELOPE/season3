package lesson4.p3_synch_blocks;

public class ExampleSB2 {
    private Object lock1 = new Object();

    public static void main(String[] args) {
        ExampleSB2 e2=new ExampleSB2();
        new Thread(()-> e2.method1()).start();
        new Thread(()-> e2.method1()).start();
        new Thread(()-> e2.method1()).start();
    }

    public void method1() {
        try {
            System.out.println("NonSynch-Begin " + Thread.currentThread().getName());
            for (int i = 0; i < 3; i++) {
                System.out.println('.');
                Thread.sleep(200);
            }
            System.out.println("NonSynch-End " + Thread.currentThread().getName());
            synchronized (lock1) {
                System.out.println("Synch-Begin " + Thread.currentThread().getName());
                for (int i = 0; i < 5; i++) {
                    System.out.println('.');
                    Thread.sleep(200);
                }
                System.out.println("Synch-End " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
