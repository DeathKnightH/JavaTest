package cn.dk.net;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class CalculateMessageLength implements Runnable{
    private Socket socket;
    public CalculateMessageLength(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (OutputStream outputStream = this.socket.getOutputStream()) {
            try(InputStream inputStream = this.socket.getInputStream()){
                byte[] bufferByte = new byte[1024];
                int length;
                StringBuilder stringBuilder = new StringBuilder();
                while((length = inputStream.read(bufferByte)) != -1){
                    stringBuilder.append(new String(bufferByte,0,length, StandardCharsets.UTF_8));
                }
                System.out.println(stringBuilder.toString() + "长度：" + stringBuilder.length());
                outputStream.write(String.valueOf(stringBuilder.length()).getBytes(StandardCharsets.UTF_8));
                this.socket.shutdownOutput();
            }catch (IOException e){
                e.printStackTrace();
            }
        }catch (IOException e){
            System.out.println(Thread.currentThread().getId()+":socket获取outputString异常");
        }
        try {
            this.socket.close();
        } catch (IOException e) {
            System.out.println(Thread.currentThread().getId()+":socket关闭异常");
        }
    }
}
