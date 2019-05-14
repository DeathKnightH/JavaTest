package cn.dk.concurrency.util;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch闭锁效果实验类
 */
public class CountDownLatchTest {
    /**
     * 多线程计时方法
     * 使用两个CountDownLatch闭锁实现同时启动所有线程，计算所有线程执行完所花费的时间
     * @param nThreads 线程个数
     * @param task 任务
     * @return 执行时间
     * @throws InterruptedException
     */
    public long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread temp = new Thread() {
                @Override
                public void run() {
                    try {
                        // startGate闭锁
                        startGate.await();
                        try {
                            task.run();
                        }finally {
                            // endGate闭锁计数器-1
                            endGate.countDown();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            temp.start();
        }

        long start = System.nanoTime();
        // startGate闭锁计数器-1，由于本身只有1，所以相当于计时开始的同时打开startGate闭锁
        startGate.countDown();
        // endGate闭锁等待计数器归零打开闭锁
        endGate.await();
        long end = System.nanoTime();
        return end - start;
    }
}
