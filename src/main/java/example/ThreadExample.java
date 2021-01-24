package example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExample {

    public static void main(String[] args) {


        /*
        ExecutorService - better method of creating Threads in bigger application.
        We can choose number of used Threads to execute task(s).
        We call this threads as threads 'Pool'
         */
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(ThreadExample::incrementTo1000);
        executorService.submit(ThreadExample::incrementTo1000);
        executorService.submit(ThreadExample::incrementTo1000);
        executorService.shutdown();


        /* Standard method of creating Threads. Useful only for small tasks. Not well
        to multithreading applications
         */
        Thread th1 = new Thread(ThreadExample::incrementTo1000);
        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                incrementTo1000();
            }
        });

//        th1.setPriority(1);
//        th2.setPriority(10);
//        th1.setName("th1");
//        th2.setName("th2");
//        th1.start();
//        th2.start();
    }

    private static void incrementTo1000() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}



