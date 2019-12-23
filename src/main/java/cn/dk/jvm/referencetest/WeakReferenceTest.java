package cn.dk.jvm.referencetest;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * 弱引用测试用类-Xms20m -Xmx20m -XX:+PrintGCDetails
 */
public class WeakReferenceTest {
    public static void main(String[] args) {
        ReferenceQueue referenceQueue = new ReferenceQueue();
        WeakReference<byte[]> bytesWeak = new WeakReference<>(new byte[10000 * 1024], referenceQueue);
        WeakReference<byte[]> bytesWeakOutOfMemory = new WeakReference<>(new byte[10000 * 1024], referenceQueue);
        // 由于申请第二个弱内存时已超过内存大小限制，所以先申请的弱引用被回收，第一个输出为null
        System.out.println("bytesWeak old:" + bytesWeak.get());
        // 观察控制台，如果第二个弱引用内存申请完成后垃圾回收一直没有执行，那么第二个输出为对应的引用地址
        System.out.println("bytesWeak new:" + bytesWeakOutOfMemory.get());
        // 观察控制台输出，在执行FullGC后，第二个弱引用还是被回收了
        System.gc();
        System.out.println("bytesWeak new after gc:" + bytesWeakOutOfMemory.get());

        // 回收队列中已回收的软引用和 bytesWeakOutOfMemory 一致，说明在软引用被回收后，软引用对象本身是不会被回收的，实际上bytesSoft本身是一个强引用
        System.out.println(bytesWeakOutOfMemory == referenceQueue.poll());
    }
}
