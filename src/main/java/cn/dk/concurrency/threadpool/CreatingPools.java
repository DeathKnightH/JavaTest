package cn.dk.concurrency.threadpool;

import java.util.concurrent.*;

/**
 * 展示不同方式创建线程池的实例
 */
public class CreatingPools {
    /**
     * 直接使用 ThreadPoolExecutor 类的构造函数创建线程池
     */
    public static ThreadPoolExecutor threadPoolExecutor() {
        // 核心线程数
        int coreThreadNumber = 4;
        // 最大线程数
        int maxThreadNumber = 8;
        // 存活时间
        long keepAliveTime = 2L;
        // 存活时间单位
        TimeUnit util = TimeUnit.SECONDS;
        // 工作队列，用于存储尚未执行的任务
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(100);
        // 使用以上参数以及 默认的 ThreadFactory 和 AbortPolicy 构造一个线程池实例
        ThreadPoolExecutor executor = new ThreadPoolExecutor(coreThreadNumber, maxThreadNumber, keepAliveTime, util,
                workQueue, Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        return executor;
    }

    /**
     * 使用 Executors 工具类的静态方法创建线程池，
     * 实际上静态方法仍然调用的是 ThreadPoolExecutor 和 ScheduledThreadPoolExecutor 的构造函数，只是传入了很多缺省的参数
     */
    public static void executors() {
        // FixedThreadPool，核心线程数和最大线程数均为传入参数 5，工作队列无界(实际最大size为Integer.MAX_VALUE)
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        // SingleThreadExecutor，核心线程数和最大线程数均为 1，工作队列无界(实际最大size为Integer.MAX_VALUE)
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        // cachedThreadPool，核心线程数为 0，最大线程数为 Integer.MAX_VALUE
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        // ScheduledExecutor，核心线程数为传入参数 5，最大线程数为 Integer.MAX_VALUE
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

    }

    public static void main(String[] args) {

    }
}
