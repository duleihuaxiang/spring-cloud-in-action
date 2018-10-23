package com.agan.book.config.utils;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class AddressUtils {



    /**
     * 从url获取结果
     * @param path
     * @param params
     * @param encoding
     * @return
     */
    public static String getRs(String path, String params, String encoding){

        URL url = null;

        HttpURLConnection connection = null;

        try {

            url = new URL(path);
            connection = (HttpURLConnection)url.openConnection();// 新建连接实例
            connection.setConnectTimeout(2000);// 设置连接超时时间，单位毫�?
            connection.setReadTimeout(2000);// 设置读取数据超时时间，单位毫�?
            connection.setDoInput(true);// 是否打开输出�? true|false
            connection.setDoOutput(true);// 是否打开输入流true|false
            connection.setRequestMethod("POST");// 提交方法POST|GET
            connection.setUseCaches(false);// 是否缓存true|false
            connection.connect();// 打开连接端口
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            out.writeBytes(params);
            out.flush();
            out.close();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),encoding));
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = reader.readLine())!= null) {
                buffer.append(line);
            }
            reader.close();
            return buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            connection.disconnect();// 关闭连接
        }
        return null;
    }


}
