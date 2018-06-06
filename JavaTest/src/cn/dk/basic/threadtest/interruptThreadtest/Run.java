package cn.dk.basic.threadtest.interruptThreadtest;

public class Run {
    public static void main(String[] args){

    }

    public static void noInterrupt() {
        NoInterruptThread thread = new NoInterruptThread();
        thread.start();
        thread.interrupt();
        System.out.println("thread.interrupt()");
    }
}
