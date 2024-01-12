package lesson4.p2_synch_counter;

public class ExampleSynchroCounter2 {
    public static void main(String[] args) {
        SynchCounter sc = new SynchCounter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                sc.inc();
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                sc.dec();
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(sc.value());

    }
}
