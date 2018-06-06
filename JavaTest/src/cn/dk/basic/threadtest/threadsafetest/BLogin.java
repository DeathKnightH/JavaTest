package cn.dk.basic.threadtest.threadsafetest;

public class BLogin extends Thread {
    @Override
    public void run(){
        LoginServlet.doPost("b", "bbbbbb");
    }
}
