package cn.dk.basic.threadtest.sleeptest;

import org.junit.Test;

import static org.junit.Assert.*;

public class SleepThreadTest {
    @Test
    public void sleepThreadTest(){
        SleepThread sleepThread = new SleepThread();
        System.out.println("begin=" + System.currentTimeMillis());
        sleepThread.start();
        System.out.println("end=" + System.currentTimeMillis());
        System.out.println("begin=" + System.currentTimeMillis());
        sleepThread.run();
        System.out.println("end=" + System.currentTimeMillis());
    }
}