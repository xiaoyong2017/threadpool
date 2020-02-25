package com.atguigu.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> futureTask = new FutureTask<>(new MyCallable(20, 50));
        new Thread(futureTask, "t1").start();
        //System.out.println(futureTask.get());//线程还未运算完成尝试获取结果会阻塞程序
        //  System.out.println(Thread.currentThread().getName() + "=====================");

        FutureTask<Integer> futureTask2 = new FutureTask<>(new MyCallable(51, 100));
        new Thread(futureTask2, "t2").start();
        int sum = 0;
        for (int i = 1; i < 20; i++) {
            sum += i;
        }

        while (!futureTask.isDone() || !futureTask2.isDone()) {
            Thread.yield();
        }
        int res = futureTask.get() + futureTask2.get() + sum;
        System.out.println(Thread.currentThread().getName() + "res：" + res);
        System.out.println(Runtime.getRuntime().availableProcessors());

    }
}
