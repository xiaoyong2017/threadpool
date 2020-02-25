package com.atguigu.threadpool;

import com.atguigu.callable.MyCallable;

import java.util.concurrent.*;

public class ThreadPoolTest {

    public static void main(String[] args) throws Exception {
        //ExecutorService executorService = Executors.newFixedThreadPool(5);
        //ExecutorService executorService = Executors.newSingleThreadExecutor();
        //ExecutorService executorService = Executors.newCachedThreadPool();

        //RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();//拒绝服务抛出异常
        //RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();//退回调用者，mian线程调用就退回给main线程
        //RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardOldestPolicy();//丢弃队列中最旧的
        RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardPolicy();//直接丢弃
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(2,
                5,
                5,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                handler);
        try {
            for (int i = 0; i < 10; i++) {
                // System.out.println("第" + i + "号顾客提交计算");
                Future<Integer> future = executorService.submit(new MyCallable(1, 100));
                // System.out.println("第" + i + "号顾客获取结果" + future.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }


    }
}
