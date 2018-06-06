package cn.dk.basic.threadtest;

public class ThreadTest {
    public static void main(String[] args){
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

    public static void test1() {
        Thread myThread = new MyThreadTest();
        myThread.start();

        Thread myRunnale = new Thread(new MyRunnableTest());
        myRunnale.start();
        String currentThreadName = Thread.currentThread().getName();
        System.out.println(currentThreadName);
        for (int i = 0; i<10; i++){
            new Thread(String.valueOf(i)){
                public void run(){
                    System.out.println("Thread:" + getName() + "running~");
                }
            }.start();
        }
    }

    public static void testRandom() {
        MyRunnableTest test = new MyRunnableTest();
        Thread thread = new Thread(test);
        thread.start();
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(i*100);
                System.out.println("main=" + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void testNonSynchronized() {
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
}
