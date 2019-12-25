package cn.dk.basic.threadtest;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class ThreadTest {

    /**
     *
     */
    @Test
    public void testRandom() {
    }

    /**
     * 测试不加锁的情况下对类的域进行修改，多运行几次，count减少的顺序不一致，每个线程减少的count不连续，甚至会出现重复或者count错误的情况。
     */
    @Test
    public void testNonSynchronized() {
        CountThreadNonSyn test = new CountThreadNonSyn();
        Thread a = new Thread(test,"A");
        Thread b = new Thread(test,"B");
        Thread c = new Thread(test,"C");
        Thread d = new Thread(test,"D");
        Thread e = new Thread(test,"E");

        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }

    /**
     * 测试加锁情况下对类的域进行修改，对 run() 方法加 synchronized 关键字。
     * 多次运行，尽管线程执行的顺序可能不同，但是每个线程内的 count 是连续的，并且总体的 count 顺序是连续且每条减 1 的
     */
    @Test
    public void testSynchronized(){
        CountThreadSyn test = new CountThreadSyn();
        Thread a = new Thread(test,"A");
        Thread b = new Thread(test,"B");
        Thread c = new Thread(test,"C");
        Thread d = new Thread(test,"D");
        Thread e = new Thread(test,"E");

        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }

    /**
     * 测试线程占用的内存资源
     */
    @Test
    public void threadMemoryTest(){
        for (int i = 0; i < 100; i++) {
            Thread temp = new Thread(()-> {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            temp.start();
        }
    }
}