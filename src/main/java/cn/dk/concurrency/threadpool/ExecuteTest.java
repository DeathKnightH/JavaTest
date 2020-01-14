package cn.dk.concurrency.threadpool;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 测试ThreadPoolExecutor 的 execute 方法实现
 */
public class ExecuteTest {
    public static void executeTest() {
        // 核心线程 4，最大线程8，工作队列 100
        ThreadPoolExecutor executor = CreatingPools.threadPoolExecutor();
        // 可以看到控制台输出，由于核心线程为4，工作队列为100，而任务数超出核心线程数量但是没有填满工作队列
        // 因此同时执行任务的线程只有4个，只有当核心线程中的一个或多个线程执行完毕了才会从工作队列取新的任务继续执行
        for (int i = 0; i < 10; i++) {
            TestThread testThread = new TestThread(String.valueOf(i));
            executor.execute(testThread);
        }
        executor.shutdown();
        // 等待线程池停用
        while (!executor.isTerminated()) {

        }
        System.out.println("Finish all the threads");
    }

    public static void main(String[] args) {
        executeTest();
    }
}
