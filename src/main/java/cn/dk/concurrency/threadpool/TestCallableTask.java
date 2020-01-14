package cn.dk.concurrency.threadpool;

import java.util.concurrent.Callable;

/**
 * 测试 callable 接口的线程类
 */
public class TestCallableTask implements Callable<String> {
    private final String taskName;

    public TestCallableTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        return Thread.currentThread().getName() + " called task: " + taskName;
    }
}
