package com.thread;

import com.alibaba.fastjson.JSONObject;
import com.autogen.common.base.result.Result;
import com.goods.dao.BrandEntity;
import com.goods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;


@Service
public class RemoteService {
    @Autowired
    private RestTemplate restTemplate;

    public String getProductList() {
        Object[] ret = restTemplate.getForObject("http://127.0.0.1:8083/product/list", Object[].class);
        System.out.println(JSONObject.toJSONString(ret) + "=========");
        return JSONObject.toJSONString(ret);

    }

    public String getBrandList() {
        String s = "http://127.0.0.1:8881/brand";

        Map<String, List<BrandEntity>> brands = restTemplate.getForObject(s, Map.class);

        System.out.println(JSONObject.toJSONString(brands) + "=========");
        return JSONObject.toJSONString(brands);

    }


    public static void main(String args[]) {
        RestTemplate rest = new RestTemplate();
        String s = "http://127.0.0.1:9010/book-product/product/list";
        s = "http://127.0.0.1:9010/shop/brand";

        Map<String, List<BrandEntity>> brands = rest.getForObject(s, Map.class);
        System.out.println(JSONObject.toJSONString(brands) + "=========");
    }


//    http://127.0.0.1:9010/shop/brand
}
