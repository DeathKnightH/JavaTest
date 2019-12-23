package cn.dk.concurrency.lock.reentrantlock.normal;

public class DemoThread implements Runnable {
    private ServiceDemo serviceDemo;

    public DemoThread(ServiceDemo serviceDemo) {
        this.serviceDemo = serviceDemo;
    }

    @Override
    public void run() {
        this.serviceDemo.testMethod();
    }
}