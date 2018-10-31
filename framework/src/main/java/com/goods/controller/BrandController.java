package com.goods.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.autogen.common.base.controller.BaseController;

import com.autogen.common.base.result.Page;
import com.autogen.common.base.result.Result;
import com.autogen.common.base.result.ResultCode;
import com.autogen.common.utils.BeanUtils;

import com.goods.service.BrandService;
import com.goods.service.BrandService.Brand;
import com.goods.vo.req.BrandReq;
import com.thread.MultiResult;
import com.thread.RemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;


@RestController
@RequestMapping("/brand")
public class BrandController extends BaseController {

    @Autowired
    private RemoteService remoteService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private MultiResult multiResult;

    @RequestMapping("/list")
    public List getList2() throws ExecutionException, InterruptedException {
        List  ret  = multiResult.getList();
        return ret;
    }

    @RequestMapping("/async")
    public Callable<String> getBrandList(){
        long t1 = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName()+"------tomcat 主线程 开始---"+t1);

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                long t1 = System.currentTimeMillis();
                System.out.println(Thread.currentThread().getName()+"------异步线程 开始---"+t1);
                String ss= remoteService.getBrandList();
                long t2 = System.currentTimeMillis();

                System.out.println(Thread.currentThread().getName()+"------异步线程 结束---"+t2);
                System.out.println(Thread.currentThread().getName()+"------异步线程 耗时---"+(t2-t1));

                return ss;
            }
        };

        long t2 = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName()+"------tomcat 主线程 结束---"+t2);

        return callable;
    }
    
    @PostMapping("")
     @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> create(@RequestBody final BrandReq brand) {
        // create
        // obj.setOperator(getSession().getUserId());
        Brand obj =  new Brand();
        BeanUtils.copyProperties(brand,obj);
        Long id = brandService.create(obj);

        return resultMap(ResultCode.OK, "brandId", id);
    }

    @PutMapping("/{id}")
     @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> update(@PathVariable("id") final Long id, @RequestBody BrandReq brand) {
        // obj.setOperator(getSession().getUserId());
        Brand obj =  new Brand();
        BeanUtils.copyProperties(brand,obj);
        obj.setBrandId(id);
        brandService.update(obj);

        return resultMap(ResultCode.OK);
    }

    @DeleteMapping("/{id}")
     @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> delete(@PathVariable("id") final Long id) {
        BrandReq obj = new BrandReq();
        // obj.setOperator(getSession().getUserId());
        // obj.setStatus(Status.DELETED);
        update(id, obj);

        return resultMap(ResultCode.OK);
    }


    @GetMapping("/{id}")
    public Brand get(@PathVariable("id") final Long id) {
        int xx = 12/0;
        Brand obj = brandService.getById(id);
        return obj;
    }

    @GetMapping("")
    public Result<Page<Brand>> find(
        @RequestParam(value = "offset", required = false) Integer offset,
        @RequestParam(value = "limit", required = false) Integer limit,
        @RequestParam(value = "page", required = false) Integer pageNum
    ) {
        BrandService.BrandQuery query = new BrandService.BrandQuery();
    	query.setOffset(offset);
    	query.setLimit(limit);
    	query.setPage(pageNum);

    	Page<Brand> page = brandService.find(query);
        return new Result<Page<Brand>>(ResultCode.OK, page);
    }

}
