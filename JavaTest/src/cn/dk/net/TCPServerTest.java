package cn.dk.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class TCPServerTest {
    public static void main(String[] args){
        try(ServerSocket serverSocket = new ServerSocket(50001)){
            ExecutorService executorService = Executors.newFixedThreadPool(16);
            while (true) {
                    Socket socket = serverSocket.accept();
                    Thread thread = new Thread(new CalculateMessageLength(socket));
                    Future d = executorService.submit(thread);
                    try{
                        d.get();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }catch (ExecutionException e){
                        e.printStackTrace();
                    }
            }
        }catch (IOException e){
            System.out.println("创建socket失败，IO异常");
        }
    }
}
