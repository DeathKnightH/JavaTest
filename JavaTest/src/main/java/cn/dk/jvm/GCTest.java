package cn.dk.jvm;

/**
 * 测试jvm垃圾回收的机制
 * 在运行main函数时添加虚拟机参数 -XX:PrintGCDetails
 */
public class GCTest {
    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[4000 * 1024];
        allocation2 = new byte[500 * 1024];
        allocation3 = new byte[500 * 1024];
    }
}
