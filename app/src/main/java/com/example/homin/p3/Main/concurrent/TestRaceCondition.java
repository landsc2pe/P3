package com.example.homin.p3.Main.concurrent;

/**
 * Created by jjkim on 2016. 7. 16..
 */
public class TestRaceCondition {
    volatile int count = 0;

    void run() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100000; i++) {
                    count++;
                }
                System.out.println(Thread.currentThread().getName() + " done.");
            }
        }, "thread1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100000; i++) {
                    count++;
                }

                System.out.println(Thread.currentThread().getName() + " done.");
            }
        }, "thread2");

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100000; i++) {
                    count++;
                }

                System.out.println(Thread.currentThread().getName() + " done.");
            }
        }, "thread3");

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("count : " + count);
    }

    public static void test() {
        System.out.println("available cores # : " +
                Runtime.getRuntime().availableProcessors());
        TestRaceCondition testRaceCondition = new TestRaceCondition();
        testRaceCondition.run();
    }

    void increment() {
        synchronized (TestRaceCondition.class) {
            count++;
        }
    }
}
