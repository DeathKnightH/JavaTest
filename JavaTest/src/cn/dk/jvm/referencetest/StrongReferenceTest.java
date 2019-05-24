package cn.dk.jvm.referencetest;

/**
 * 强引用测试用类-Xms20m -Xmx20m -XX:+PrintGCDetails
 *
 */
public class StrongReferenceTest {
    public static void main(String[] args) {
        // 在以上jvm配置条件下，第一句是正常执行的，因为申请的内存没有超过虚拟机的堆大小
        byte[] bytes = new byte[10000 * 1024];
        // 如果在以上语句的基础下再执行以下的语句会抛出java.lang.OutOfMemoryError: Java heap space，强引用就算内存不足也不会被回收，而是会抛出Error
        //byte[] byteOutOfMemory = new byte[10000 * 1024];
    }
}
