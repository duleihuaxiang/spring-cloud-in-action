package com.agan.book.config.resolver;

import jodd.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * specification
 * 请求媒介解析器
 * 目前包含 X-SGW-REQUEST-ID : 用来记录一条真实Request的全局请求ID
 *
 * @author Sudao @ Tim Zhang
 * @email : zhanglong@kuaicto.com or solidsnake2007@gmail.com
 * @date: 2017/11/16
 * @time: 下午5:53
 * =========================================
 * <p>
 * Contributors :
 * Tim Zhang - 2017/11/16 下午5:53
 */
public class RequestMediaResolver implements Serializable {
    /******* Fields Area *******/

    public final static String SGW_REQUEST_ID = "X-SGW-REQUEST-ID";


    /******* Construction Area *******/

    /**
     * 获得网关分配的 request Id
     *
     * @param request HttpServletRequest {@link HttpServletRequest}
     * @return rid
     */
    public static String getGatewayRequestId(HttpServletRequest request) throws Exception {
        String rid = request.getHeader(SGW_REQUEST_ID);
        if (StringUtil.isEmpty(rid)) {
            throw new Exception();
        }
        return rid;
    }

    /******* GetSet Area ******/

    /******* Method Area *******/


}
