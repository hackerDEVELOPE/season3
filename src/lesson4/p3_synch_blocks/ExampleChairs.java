package lesson4.p3_synch_blocks;

public class ExampleChairs {
    public static void main(String[] args) throws Exception {
        Object chair1 = new Object();
        Object chair2 = new Object();

        Thread human1 = new Thread(() -> {
            System.out.println("hum1 get to chair1");
            synchronized (chair1) {
                System.out.println("hum1 sit on chair1");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("hum1 left chair1");
            }
        });
        human1.start();

        Thread human2 = new Thread(() -> {
            System.out.println("hum2 get to chair1");
            synchronized (chair1) {
                System.out.println("hum2 sit on chair1");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("hum2 left chair1");
            }
        });
        human2.start();

        Thread human3 = new Thread(() -> {
            System.out.println("hum3 get to chair1");
            synchronized (chair1) {
                System.out.println("hum3 sit on chair1");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("hum3 left chair1");
            }
        });
        human3.start();
    }
}
