package lesson5;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

import static java.util.concurrent.ForkJoinTask.invokeAll;

public class Main {
    public static void main(String[] args) {


//        ThreadFactory factory = new ThreadFactory() {
//            @Override
//            public Thread newThread(Runnable r) {
//                Thread t = new Thread(r);
//                t.setDaemon(true);
//                t.setName("gigaThread");
//                return t;
//            }
//        };

//        service.execute(()->{
//            System.out.println(Thread.currentThread().getName());
//        });

        List<Callable<String>> tasks = new ArrayList<>(Arrays.asList(
                new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        System.out.println(1);
                        Thread.sleep(500);
                        System.out.println(11);
                        return "java1";
                    }
                },
                new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        System.out.println(2);
                        Thread.sleep(1500);
                        System.out.println(22);
                        return "java2";
                    }
                },
                new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        System.out.println(3);
                        Thread.sleep(3000);
                        System.out.println(33);
                        return "java3";
                    }
                }
        ));

        ExecutorService service = Executors.newFixedThreadPool(4);
//        try {
//           List<Future<String>> result = service.invokeAll(tasks);
//
//            for (int i = 0; i < result.size(); i++) {
//                System.out.println(result.get(i).get());
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

//        try {
//            String result = service.invokeAny(tasks);
//            System.out.println(result);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }
//        service.shutdown();

//        FutureTask<String> ft = new FutureTask<>(() -> "java bimbo");
//        new Thread(ft).start();
//        try {
//            System.out.println(ft.get());
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }


//        List<String> list = new ArrayList<>();
//        List<String> list1 = new LinkedList<>();
//        List<String> list2 = new Vector<>();
//        List<String> list3 = new CopyOnWriteArrayList<>();
//        List<String> list4 = Collections.synchronizedList(list1);

//        CopyOnWriteArraySet

//        Map<String, Integer> map1 = new LinkedHashMap<>();
//        Map<String, Integer> map2 = new TreeMap<>();
//        Map<String, Integer> map3 = new HashMap<>();
//        Map<String, Integer> map4 = new Hashtable<>();
//        Map<String, Integer> map5 = new ConcurrentHashMap<>();
//        Map<String, Integer> map6 = Collections.synchronizedMap(map3);

//        ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<>(4);
//
//        Thread baker = new Thread(() -> {
//            while (true) {
//                try {
//                    Thread.sleep(2000);
//                    System.out.println("Bread was ready");
//                    abq.put("Bread");
//                    System.out.println("Bread was added to the shelve");
//                    System.out.println(abq);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        Thread buyers = new Thread(() -> {
//            while (true) {
//                try {
//                    Thread.sleep(3000);
//                    System.out.println("Buyer came to the shelve");
//                    abq.take();
//                    System.out.println("Bread was taken");
//                    System.out.println(abq);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        baker.start();
//        buyers.start();

//        Semaphore semaphore = new Semaphore(4);
//        ExecutorService service1 = Executors.newFixedThreadPool(10);
//
//        for (int i = 0; i < 10; i++) {
//            final int w = i;
//            service1.execute(()->{
//                try {
//                    System.out.println(w+" ready");
//                    semaphore.acquire();
//                    System.out.println(w+" start");
//                    Thread.sleep(2000);
//                    System.out.println(w+" end");
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                } finally {
//                    semaphore.release();
//                }
//            });
//        }
//        service1.shutdown();


//        CountDownLatch cdl = new CountDownLatch(5);
//        for (int i = 0; i < 5; i++) {
//            final int w = i;
//            new Thread(() -> {
//                try {
//                    System.out.println(w + " start");
//                    Thread.sleep(2000 + w * 1000);
//                    System.out.println(w + " end");
//                    cdl.countDown();
//                    //
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }).start();
//        }
//
//        try {
//            cdl.await();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        System.out.println("end");

//        CyclicBarrier cb = new CyclicBarrier(3);
//
//        for (int i = 0; i < 3; i++) {
//            final int w = i;
//            new Thread(() -> {
//                try {
//                    System.out.println(w + " begin");
//                    Thread.sleep(2000 + w * 2000);
//                    System.out.println(w + " ready");
//                    cb.await();
//                    System.out.println(w + " start");
//
//                    cb.await();
//
//                    System.out.println(w + " begin2");
//                    Thread.sleep(2000 + w * 2000);
//                    System.out.println(w + " ready");
//                    cb.await();
//                    System.out.println(w + " start");
//                } catch (Exception e) {
//                    throw new RuntimeException(e);
//                }
//            }).start();
//        }


//        final Object mon = new Object();
//        new Thread(()->{
//            synchronized (mon){
//
//            }
//        }).start();
//
//        new Thread(()->{
//            synchronized (mon){
//
//            }
//        }).start();

//        Lock lock = new ReentrantLock();
//
//        new Thread(()->{
//            System.out.println(1);
//            lock.lock();
//            System.out.println(11);
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            lock.unlock();
//            System.out.println(111);
//        }).start();
//
//        new Thread(()->{
//            System.out.println(2);
//            lock.lock();
//            System.out.println(22);
//
//            lock.unlock();
//            System.out.println(222);
//        }).start();


//        Lock lock = new ReentrantLock();
//
//        new Thread(() -> {
//            try {
//                System.out.println(1);
//                if (lock.tryLock(3, TimeUnit.SECONDS)) {
//                    System.out.println(11);
//
//                    Thread.sleep(2000);
//
//                    lock.unlock();
//                }
//                ;
//                System.out.println(111);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }).start();
//
//        new Thread(() -> {
//            try {
//                System.out.println(2);
//                if (lock.tryLock(3, TimeUnit.SECONDS)) {
//                    System.out.println(22);
//                    lock.unlock();
//                }
//                System.out.println(222);
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        }).start();
//
//
//        ReadWriteLock rwl = new ReentrantReadWriteLock();
//        rwl.readLock().lock();
//        rwl.readLock().unlock();
//        rwl.writeLock().lock();
//        rwl.writeLock().unlock();

        AtomicInteger atomicInteger = new AtomicInteger(10);
//        atomicInteger.get();
//        atomicInteger.decrementAndGet();
//        atomicInteger.getAndDecrement();
//        System.out.println(atomicInteger.addAndGet(5));
//        atomicInteger.updateAndGet(operand -> operand = operand*operand);
//        atomicInteger.accumulateAndGet(2, (a, b) -> a-b);
        atomicInteger.compareAndSet(10, 20);
        System.out.println(atomicInteger.get());
    }
}
