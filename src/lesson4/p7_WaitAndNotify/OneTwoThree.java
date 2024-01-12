package lesson4.p7_WaitAndNotify;

public class OneTwoThree {
    static Object mon = new Object();
    static volatile int currentNum = 1;
    static final int NUM = 5;

    public static void main(String[] args) {
        new Thread(()-> {
            try{
                for (int i = 0; i < NUM; i++) {
                    synchronized (mon){
                        while (currentNum!=1){
                            mon.wait();
                        }
                        System.out.printf("A");
                        currentNum = 2;
                        mon.notifyAll();
                    }
                }
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }).start();


        new Thread(()-> {
            try{
                for (int i = 0; i < NUM; i++) {
                    synchronized (mon){
                        while (currentNum!=2){
                            mon.wait();
                        }
                        System.out.printf("B");
                        currentNum = 3;
                        mon.notifyAll();
                    }
                }
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }).start();


        new Thread(()-> {
            try{
                for (int i = 0; i < NUM; i++) {
                    synchronized (mon){
                        while (currentNum!=3){
                            mon.wait();
                        }
                        System.out.printf("C ");
                        currentNum = 1;
                        mon.notifyAll();
                    }
                }
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }).start();
    }
}
