package lesson4.part2;

import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
//        ExecutorService service = Executors.newFixedThreadPool(4);
//        ExecutorService service = Executors.newSingleThreadExecutor();
//        ExecutorService service = Executors.newCachedThreadPool();
//        for (int i = 0; i < 10; i++) {
//            final int w = i;
//            service.execute(() -> {
//                System.out.println(w+"start");
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                System.out.println(w+"end");
//            });
//
//        }
//        service.shutdown();

//        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

//        service.schedule(()-> System.out.println(1), 5, TimeUnit.SECONDS);
//        service.scheduleAtFixedRate(()-> System.out.println(1), 3, 2, TimeUnit.SECONDS);
//        service.scheduleWithFixedDelay(()-> System.out.println(1), 3, 2, TimeUnit.SECONDS);
//        service.shutdown();

//        Thread t = new Thread(()->{
//            boolean flag = true;
//
//            while (!Thread.currentThread().isInterrupted() && flag){
//                System.out.println(1);
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    System.out.println("InterruptedException");
//                    break;
//                    Thread.currentThread().interrupt();
//                    flag = false;
//                }
//            }
//        });
//        t.start();
//
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        t.interrupt();


//        ExecutorService service = Executors.newFixedThreadPool(4);

//        service.shutdown();
//        try {
//            service.awaitTermination(10, TimeUnit.SECONDS);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

//        for (int i = 0; i < 10; i++) {
//            final int w = i;
//            service.execute(() -> {
//                System.out.println(w+"start");
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                System.out.println(w+"end");
//            });
//
//        }
//
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        List<Runnable> tasks = service.shutdownNow();
//
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        System.out.println("tasks count"+tasks.size());
//
//        new Thread(tasks .get(0)).start();
//        new Thread(tasks.get(1)).start();


        ExecutorService service = Executors.newFixedThreadPool(4);
//        Future future = service.submit(()-> {
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println(1);
//        });

//        Future<String> future = service.submit(new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                return "java";
//            }
//        });
//
//
//
//        try {
//            Thread.sleep(1500);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(future.isDone());
//
//        try {
//            System.out.println(future.get());
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }
//
//
//        System.out.println("end");

        System.out.println(Runtime.getRuntime().availableProcessors());

    }
}
