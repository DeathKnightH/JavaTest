package cn.dk.basic.threadtest;

public class MyRunnableTest implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                int time = (int)(Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("MyRunnable doing!!! running=" + Thread.currentThread().getName());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
