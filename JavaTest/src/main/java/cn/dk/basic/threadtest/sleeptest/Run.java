package cn.dk.basic.threadtest.sleeptest;

public class Run {
    public static void main(String[] args){
        SleepThread sleepThread = new SleepThread();
        System.out.println("begin=" + System.currentTimeMillis());
        sleepThread.start();
        //sleepThread.run();
        System.out.println("end=" + System.currentTimeMillis());

    }
}
