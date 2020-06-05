package com.kkgs.test.thread;

/**
 * @Auther: lvqiang
 * @Date: 2020/05/19/15:38
 * @Description:
 */
public class CreateThread1 extends Thread {
    @Override
    public void run() {

        try {
            Thread.sleep(5000L);
            System.out.println("1111111111");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
