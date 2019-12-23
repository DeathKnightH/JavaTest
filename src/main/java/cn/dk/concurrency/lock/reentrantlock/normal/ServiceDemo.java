package cn.dk.concurrency.lock.reentrantlock.normal;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ServiceDemo {
    private Lock lock = new ReentrantLock();

    public void testMethod() {
        lock.lock();
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(1000);
                System.out.println("ThreadName=" + Thread.currentThread().getName() + " " + (i + 1));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
