package cn.dk.basic.threadtest;

public class CountThreadNonSyn implements Runnable{
    private int count = 5;
    @Override
    public void run() {
        this.count--;
        System.out.println("由线程："+ Thread.currentThread().getName() + "计算，count=" + this.count);
    }
}
