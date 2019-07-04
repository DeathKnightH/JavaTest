package cn.dk.net.socket;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class TCPClientTest {
    public static void main(String[] args){
        SocketAddress socketAddress = new InetSocketAddress("127.0.0.1",50001);
        try(Socket socket = new Socket()){
            socket.connect(socketAddress,10000);
            OutputStream outStream = socket.getOutputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String message = bufferedReader.readLine();
            outStream.write(message.getBytes("UTF-8"));
            socket.shutdownOutput();

            InputStream inStream = socket.getInputStream();
            byte[] resultByte = new byte[1024];
            int length;
            StringBuilder stringBuilder = new StringBuilder();
            while ((length = inStream.read(resultByte)) != -1){
                stringBuilder.append(new String(resultByte, 0, length, "UTF-8"));
            }
            System.out.println(stringBuilder.toString());
            inStream.close();
            outStream.close();

        }catch (IOException e){
            e.printStackTrace();
            System.out.println("connect异常，IO异常");
        }
    }
}
