package cn.dk.concurrency.volatileTest;

import net.jcip.annotations.NotThreadSafe;

import java.util.concurrent.LinkedBlockingDeque;

@NotThreadSafe
public class VolatileTest {
    private int count;
    private void add10k(){
        for (int i = 0; i < 10000; i++) {
            count += 1;
        }
    }

    public static void main(String[] args){
        VolatileTest test = new VolatileTest();
        Thread thread1 = new Thread(()->{
            test.add10k();
        },"thread1");

        Thread thread2 = new Thread(()->{
            test.add10k();
        },"thread2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(test.count);
    }
}
