package cn.dk.basic.io;

import io.netty.buffer.ByteBuf;

import java.nio.ByteBuffer;

public class BufferTest {
    public static void main(String[] args) {
        jdkBufferTest();
    }

    public static void jdkBufferTest(){
        ByteBuffer byteBuffer = ByteBuffer.allocate(20);
        System.out.println(byteBuffer.toString());
        byteBuffer.put((byte) 'D');
        byteBuffer.put((byte) 'K');
        System.out.println(byteBuffer.toString());
        byteBuffer.flip();
        while (byteBuffer.hasRemaining()) {
            System.out.println(byteBuffer.get());
        }

        byteBuffer.put(0, (byte) 'H');
        System.out.println(byteBuffer.toString());
        while (byteBuffer.hasRemaining()) {
            System.out.println(byteBuffer.get());
        }
    }

    public static void nettyBufferTest(){

    }
}
