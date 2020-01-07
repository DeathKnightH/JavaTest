package cn.dk.basic.threadtest;

public class CountThreadSyn implements Runnable {
    private int count = 15;
    @Override
    synchronized public void run() {
        for (int i = 0; i < 3; i++) {
            this.count--;
            System.out.println("由线程："+ Thread.currentThread().getName() + "计算，count=" + this.count);
        }

    }
}
