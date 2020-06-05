package com.kkgs.test.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @Auther: lvqiang
 * @Date: 2020/05/20/11:50
 * @Description: 让某些线程全部执行完毕才执行目标线程任务
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws Exception{
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("子线程"+Thread.currentThread().getName()+"执行中...");
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("子线程"+Thread.currentThread().getName()+"完毕...");
                countDownLatch.countDown();
            }
        }).start();

        new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("子线程"+Thread.currentThread().getName()+"执行中...");
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("子线程"+Thread.currentThread().getName()+"完毕...");
                countDownLatch.countDown();
            }
        }).start();
        countDownLatch.await();
        System.out.println("等待两个子线程执行完毕...");
        System.out.println("两个子线程执行完毕...");
        System.out.println("执行主线程中...");

    }

}
