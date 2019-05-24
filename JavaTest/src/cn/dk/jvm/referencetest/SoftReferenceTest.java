package cn.dk.jvm.referencetest;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 * 软引用测试用类-Xms20m -Xmx20m -XX:+PrintGCDetails
 */
public class SoftReferenceTest {
    public static void main(String[] args) {
        ReferenceQueue referenceQueue = new ReferenceQueue();
        SoftReference<byte[]> bytesSoft = new SoftReference<>(new byte[10000 * 1024], referenceQueue);
        SoftReference<byte[]> bytesSoftOutOfMemory = new SoftReference<>(new byte[10000 * 1024], referenceQueue);

        // 由于申请第二个软引用内存时已超过内存大小限制，所以先申请的软引用被回收，第一个输出为null
        System.out.println("bytesSoft old:" + bytesSoft.get());
        // 第二个软引用内存申请完成后内存空间一直都是足够的，不需要回收，所以第二个输出为对应的引用地址
        System.out.println("bytesSoft new:" + bytesSoftOutOfMemory.get());
        // 观察控制台输出，在执行FullGC后，第二个软引用还是没有被回收
        System.gc();
        System.out.println("bytesSoft new after gc:" + bytesSoftOutOfMemory.get());

        // 回收队列中已回收的软引用和bytesSoft一致，说明在软引用被回收后，软引用对象本身是不会被回收的，实际上bytesSoft本身是一个强引用
        System.out.println(bytesSoft == referenceQueue.poll());
    }
}
