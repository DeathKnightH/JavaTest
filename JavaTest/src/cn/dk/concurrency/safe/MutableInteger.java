package cn.dk.concurrency.safe;

import net.jcip.annotations.GuardedBy;

/**
 * 可变整数类
 */
public class MutableInteger {
    @GuardedBy("this")
    private int value;

    public synchronized int get(){
        return this.value;
    }

    public synchronized void set(int value) {
        this.value = value;
    }
}
