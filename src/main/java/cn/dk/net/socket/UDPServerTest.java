package cn.dk.net.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;

public class UDPServerTest {
    public static void main(String[] args){
            try(DatagramSocket datagramSocket = new DatagramSocket(50002)){
                while (true){
                    byte[] buffer = new byte[128];
                    DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
                    datagramSocket.receive(datagramPacket);
                    byte[] data = datagramPacket.getData();
                    String message = new String(data,0,data.length, StandardCharsets.UTF_8);
                    System.out.println(message + "长度："+ message.length());
                    byte[] responseData = message.getBytes(StandardCharsets.UTF_8);
                    DatagramPacket responsePacket = new DatagramPacket(responseData,responseData.length,datagramPacket.getAddress(), datagramPacket.getPort());
                    datagramSocket.send(responsePacket);
                }
            }catch (IOException e){
                e.printStackTrace();
            }

    }
}
