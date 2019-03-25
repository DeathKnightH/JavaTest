package cn.dk.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class UDPClientTest {
    public static void main(String[] args){
        try ( DatagramSocket datagramSocket = new DatagramSocket()){
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String message = bufferedReader.readLine();
            byte[] messageByte = message.getBytes(StandardCharsets.UTF_8);
            InetAddress serverAddress = InetAddress.getByName("127.0.0.1");
            DatagramPacket datagramPacket = new DatagramPacket(messageByte,messageByte.length,serverAddress,50002);
            datagramSocket.send(datagramPacket);

            byte[] responseBytes = new byte[1024];
            DatagramPacket response = new DatagramPacket(responseBytes,responseBytes.length);
            datagramSocket.receive(response);
            String length = new String(response.getData(), 0, response.getLength(), StandardCharsets.UTF_8);
            System.out.println(length);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
