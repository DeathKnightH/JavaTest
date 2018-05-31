package cn.dk.basic.threadtest;

public class MyRunnableTest implements Runnable {
    @Override
    public void run() {
        System.out.println("MyRunnable doing!!!");
    }
}
