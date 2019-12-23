package cn.dk.concurrency.lock.reentrantlock.normal;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    public static void main(String[] args) {
        ServiceDemo serviceDemo = new ServiceDemo();
        Thread demoThread1 = new Thread(new DemoThread(serviceDemo));
        Thread demoThread2 = new Thread(new DemoThread(serviceDemo));
        Thread demoThread3 = new Thread(new DemoThread(serviceDemo));
        Thread demoThread4 = new Thread(new DemoThread(serviceDemo));
        Thread demoThread5 = new Thread(new DemoThread(serviceDemo));
        demoThread1.start();
        demoThread2.start();
        demoThread3.start();
        demoThread4.start();
        demoThread5.start();
    }
}
