package cn.dk.basic.threadtest.interruptThreadtest;

public class NoInterruptThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println("i=" + i);
        }
    }
}
