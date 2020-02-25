package com.atguigu.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class MyCallable implements Callable<Integer> {

    private Integer startNum;
    private Integer endNum;

    public MyCallable(Integer startNum, Integer endNum) {
        this.startNum = startNum;
        this.endNum = endNum;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "正在开始计算");
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        int sum = 0;
        for (int i = startNum; i <= endNum; i++) {
            sum += i;
        }
        System.out.println(Thread.currentThread().getName() + "计算结束sum=" + sum);
        return sum;
    }
}
