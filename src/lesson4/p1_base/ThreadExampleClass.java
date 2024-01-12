package lesson4.p1_base;
// класс, являющийся подклассом класса Thread
public class ThreadExampleClass extends Thread{
    public static void main(String[] args) {
//        ThreadExampleClass t1 = new ThreadExampleClass();
//        t1.run();
//
        Thread t2 = new Thread(new RunnableExampleClass());
        t2.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
