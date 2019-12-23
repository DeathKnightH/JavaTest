package cn.dk.concurrency.lock.reentrantlock.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ServiceDemo {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();


}
