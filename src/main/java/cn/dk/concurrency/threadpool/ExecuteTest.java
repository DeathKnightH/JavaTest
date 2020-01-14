package cn.dk.concurrency.threadpool;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 测试ThreadPoolExecutor 的任务执行方式
 */
public class ExecuteTest {
    /**
     * 测试 execute 和 Runnable
     */
    public static void executeTest() {
        // 核心线程 4，最大线程8，工作队列 100
        ThreadPoolExecutor executor = CreatingPools.threadPoolExecutor();
        // 可以看到控制台输出，由于核心线程为4，工作队列为100，而任务数超出核心线程数量但是没有填满工作队列
        // 因此同时执行任务的线程只有4个，只有当核心线程中的一个或多个线程执行完毕了才会从工作队列取新的任务继续执行
        for (int i = 0; i < 10; i++) {
            TestRunnableTask testThread = new TestRunnableTask(String.valueOf(i));
            executor.execute(testThread);
        }
        executor.shutdown();
        // 等待线程池停用
        while (!executor.isTerminated()) {

        }
        System.out.println("Finish all the threads");
    }

    /**
     * 测试 submit 和 Callable
     */
    public static void submitTest() {
        // 核心线程 4，最大线程8，工作队列 100
        ThreadPoolExecutor executor = CreatingPools.threadPoolExecutor();
        List<Future<String>> futureList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TestCallableTask testThread = new TestCallableTask(String.valueOf(i));
            // 将 future 结果依次加入 list 中
            futureList.add(executor.submit(testThread));
        }
        for (Future<String> future : futureList) {
            try {
                // 调用 future.get() 时，当前线程会阻塞，因此可以看到控制台输出时是按照task顺序输出的
                // 但是由于执行任务的线程不是顺序的，所以可以看到输出的线程name不是顺序的
                System.out.println(new Date() + ": " + future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
        System.out.println("Finish all the threads");
    }


    public static void main(String[] args) {
        //executeTest();
        submitTest();
    }
}
