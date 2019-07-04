package cn.dk.concurrency.safe;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * 可变整数类
 */
@ThreadSafe
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
