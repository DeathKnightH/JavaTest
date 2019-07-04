package cn.dk.basic.threadtest.threadsafetest;

public class ALogin extends Thread {
    @Override
    public void run() {
        LoginServlet.doPost("a","aaaaaa");
    }
}
