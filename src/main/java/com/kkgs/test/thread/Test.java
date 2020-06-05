package com.kkgs.test.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: lvqiang
 * @Date: 2020/05/19/15:39
 * @Description:
 */
public class Test {
    @org.junit.Test
    public void create1Test() {

        CreateThread1 createThread1 = new CreateThread1();
//        createThread1.start();
//        createThread1.interrupt();
        createThread1.setDaemon(true);
        createThread1.run();
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }

    }


    @org.junit.Test
    public void create2Test() throws InterruptedException {
        Thread thread = new Thread(String.valueOf(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {

                return 2;
            }
        }));
        thread.start();

        Thread.sleep(5000);
    }

    static int i = 0;

    ThreadLocal threadLocal = new ThreadLocal();

    @org.junit.Test
    public void addTest() {
        int h=0;
        threadLocal.set(h);


        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        Map<Object, Object> objectObjectHashMap = new HashMap<>();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int j = 0; j < 10; j++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Object o = threadLocal.get();
                    Integer integer = (Integer) o;
                    integer++;
                    threadLocal.set(integer);

                }
            }).start();
        }
        System.out.println(threadLocal.get());
    }


    public synchronized void add(){
        i++;
    }
}
