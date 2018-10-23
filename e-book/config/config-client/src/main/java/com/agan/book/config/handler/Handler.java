package com.agan.book.config.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * api-framework
 * Created with IntelliJ IDEA.
 * User: GiftRegistry @ Tim Zhang
 * Date: 2017/5/16
 * Time: 下午7:55
 * To change this template use File | Settings | File Templates.
 */
public abstract class Handler {
    /******* Fields Area *******/
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected Handler prev;
    protected Handler next;

    protected EnumUrlPatternType patternType = EnumUrlPatternType.CONTAIN;
    /**
     * 筛选常量
     */
    protected List<String> patternConsts = Collections.singletonList("/*");


    /******* Construction Area *******/


    public Handler() {
    }

    /**
     * 根据筛选正则确定是否进入Handler
     * 命中算进入
     */
    public Handler(String... patternConsts) {
        this.patternConsts = Arrays.asList(patternConsts);
    }


    public Handler(EnumUrlPatternType patternType, String... patternConsts) {
        this.patternType = patternType;
        this.patternConsts = Arrays.asList(patternConsts);
    }
    /******* GetSet Area ******/

    /******* Method Area *******/

    /**
     * invoke handle
     * When you need invoke next handler, Please enter 'super.next.handler(,,)'
     *
     * @param url      url
     * @param request  request
     * @param response response
     * @throws Exception
     */
    public abstract void handle(String url, HttpServletRequest request, HttpServletResponse response) throws Exception;

    public Handler except(String... patternType) {
        this.patternType = EnumUrlPatternType.EXCEPT;
        this.patternConsts = Arrays.asList(patternType);
        return this;
    }

    public Handler contain(String... patternType) {
        this.patternType = EnumUrlPatternType.CONTAIN;
        this.patternConsts = Arrays.asList(patternType);
        return this;
    }

}
