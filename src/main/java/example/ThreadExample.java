package example;

public class ThreadExample {

    public static void main(String[] args) {

        Thread th1 = new Thread(()-> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        });

        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 1000; i++) {
                    System.out.println(Thread.currentThread().getName() + " " + i);
                }
            }
        });

        th1.setPriority(1);
        th2.setPriority(10);
        th1.setName("th1");
        th2.setName("th2");
        th1.start();
        th2.start();
    }
}



