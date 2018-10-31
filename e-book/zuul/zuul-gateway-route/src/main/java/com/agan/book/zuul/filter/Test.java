package com.agan.book.zuul.filter;

import com.alibaba.fastjson.JSONObject;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test {
    public static void main(String []args) throws ExecutionException, InterruptedException {
        Callable<Object> callable1 =  new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                System.out.println("====111====");
                return null;
            }
        };

        Callable<Object> callable2 =  new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                System.out.println("====2222====");
                return null;
            }
        };


        FutureTask<Object> futureTask = new FutureTask<Object>(callable1);

        FutureTask<Object> futureTask2 = new FutureTask<Object>(callable2);

        new Thread(futureTask).start();
        new Thread(futureTask2).start();


        //JSONObject jsonObject =  new JSONObject();
        //jsonObject.putAll(futureTask.get());

    }
}
