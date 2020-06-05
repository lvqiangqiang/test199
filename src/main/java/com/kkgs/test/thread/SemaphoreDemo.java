package com.kkgs.test.thread;

import com.sun.corba.se.spi.orbutil.threadpool.Work;

import java.util.concurrent.Semaphore;

/**
 * @Auther: lvqiang
 * @Date: 2020/05/20/14:46
 * @Description: 假设有八个员工， 五台机器，一台机器只允许一个员工同时使用，只有使用完毕其他员工方可使用。
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 8; i++) {
            new Worker(i,semaphore).start();
        }
    }



    static class Worker extends Thread {
        private Integer workerNum;
        private Semaphore machinNum;

        public Worker(Integer workerNum, Semaphore machinNum) {
            this.workerNum = workerNum;
            this.machinNum = machinNum;
        }

        @Override
        public void run() {
            try {
                machinNum.acquire();
                System.out.println("工人"+this.workerNum+"正在使用机器");
                Thread.sleep(2000);
                machinNum.release();
                System.out.println("工人"+this.workerNum+"使用机器完毕，释放.....");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
