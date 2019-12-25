package cn.dk.basic.threadtest;

public class ThreadTest {
    public static void main(String[] args){
        testRandom();
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
}
