package cn.dk.basic.threadtest.currentthreadtest;

public class Run {
    public static void main(String[] args) {
        CountOperate test = new CountOperate();
        test.setName("OriginThread");
        Thread thread = new Thread(test,"AThread");
        System.out.println("AThread before start ,isAlive=" + thread.isAlive());
        thread.start();
        System.out.println("AThread after start ,isAlive=" + thread.isAlive());
    }
}
