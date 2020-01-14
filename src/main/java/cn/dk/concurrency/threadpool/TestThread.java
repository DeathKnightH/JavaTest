package cn.dk.concurrency.threadpool;

import java.util.Date;

/**
 * 用于测试线程池工作的自定义线程类，对当前线程进行短暂暂停，然后结束
 */
public class TestThread implements Runnable {
    private final String taskName;

    public TestThread(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + this.taskName + " Start: " + new Date());
        doSomething();
        System.out.println(Thread.currentThread().getName() + " " + this.taskName + " End: " + new Date());
    }

    private void doSomething() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
