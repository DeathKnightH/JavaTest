package cn.dk.concurrency.unsafe;

public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread{
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args){
        new ReaderThread().start();
        number = 30;
        ready = false;
        new ReaderThread().start();
        number = 42;
        ready = true;
    }
}
