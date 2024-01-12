package lesson4.p5_deadlock;

public class ExampleDeadlock1 {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        DeadThreadOne DTO = new DeadThreadOne();
        DeadThreadTwo DTT = new DeadThreadTwo();
        DTO.start();
        DTT.start();
    }

    private static class DeadThreadOne extends Thread{
        public void run(){
            synchronized (lock1) {
                System.out.println("DTO is holding lock1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("DTO is waiting for lock2");
                synchronized (lock2){
                    System.out.println("DTO is holding lock1 and lock2");
                }
            }
        }
    }
    private static class DeadThreadTwo extends Thread{
        public void run(){
            synchronized (lock2) {
                System.out.println("DTT is holding lock2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("DTT is waiting for lock1");
                synchronized (lock1){
                    System.out.println("DTT is holding lock1 and lock2");
                }
            }
        }
    }
}

