package cn.dk.basic.threadtest;

public class ThreadTest {
    public static void main(String[] args){
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
}
