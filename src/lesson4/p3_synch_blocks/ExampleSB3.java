package lesson4.p3_synch_blocks;

public class ExampleSB3 {
    public static void main(String[] args) {
        ExampleSB3 e = new ExampleSB3();
        System.out.println("start");

        new Thread(()-> {
            try {
                method();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }).start();
        new Thread(()-> {
            try {
                e.method2();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }).start();
    }

    public synchronized static void method() throws InterruptedException { // synch по классуц
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            Thread.sleep(300);
        }
    }

    public synchronized void method2() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            Thread.sleep(400);
        }
    }

}
