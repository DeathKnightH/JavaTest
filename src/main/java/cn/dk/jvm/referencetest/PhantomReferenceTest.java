package cn.dk.jvm.referencetest;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * 虚引用测试用类-Xms20m -Xmx20m -XX:+PrintGCDetails
 */
public class PhantomReferenceTest {
    public static void main(String[] args) {
        ReferenceQueue referenceQueue = new ReferenceQueue();
        PhantomReference<byte[]> bytesPhantom = new PhantomReference<>(new byte[10000 * 1024], referenceQueue);

    }
}
