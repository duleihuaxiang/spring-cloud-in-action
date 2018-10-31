package com.thread;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

@Service
public class MultiResult {

    @Autowired
    RemoteService remoteService;

    public static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public List getList() throws ExecutionException, InterruptedException {

        Callable<JSONObject> brandlist = new Callable<JSONObject>() {
            @Override
            public JSONObject call() throws Exception {

                String brand = remoteService.getBrandList();
                JSONObject brandInfo = JSONObject.parseObject(brand);
                return brandInfo;
            }
        };

        Callable<JSONArray> productlist = new Callable<JSONArray>() {
            @Override
            public JSONArray call() throws Exception {

                String product = remoteService.getProductList();
                JSONArray productInfo = JSONObject.parseArray(product);
                return productInfo;
            }
        };

        FutureTask<JSONObject> brandTask = new FutureTask<JSONObject>(brandlist);
        FutureTask<JSONArray> productTask = new FutureTask<JSONArray>(productlist);


        executorService.submit(brandTask);
        executorService.submit(productlist);

//        new Thread(brandTask).start();
//        new Thread(productTask).start();

        List list = new ArrayList();
        list.add(brandTask.get());

        list.add(productTask.get());


        return list;
    }


}
