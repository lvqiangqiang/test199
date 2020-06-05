package com.kkgs.test.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @Auther: lvqiang
 * @Date: 2020/05/19/16:05
 * @Description:
 */
public class CallableDemo implements Callable {

    public static void main(String[] args) {
        CallableDemo callableDemo = new CallableDemo();
        FutureTask futureTask = new FutureTask<>(callableDemo);
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " 循环变量i的值： " + i);
            if (i == 20){
                new Thread(futureTask,"有返回值的线程").start();
            }
        }
        try {
            System.out.println("子线程的返回值："+futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Object call() throws Exception {
        int i;
        for (i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        return i;
    }
}
