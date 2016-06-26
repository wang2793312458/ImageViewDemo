package com.feicui.imageview;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by AAAAA on 2016/6/26.
 */
public class HttpUtils {
    private final static String URL_PATH="http://pic2.sc.chinaz.com/files/pic/pic9/201605/apic20874.jpg";//访问图片的路径
    public HttpUtils(){}
    /**
     * 从网络中获取图片信息，以流的形式返回
     * @return
     */
    public static InputStream getImageViewInputStream(){
        InputStream inputStream=null;
        try {
            URL url=new URL(URL_PATH);
            if (url!=null){
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setConnectTimeout(3000);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoInput(true);
                int resonpseCode=httpURLConnection.getResponseCode();
                if (resonpseCode==200){
                    inputStream=httpURLConnection.getInputStream();
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputStream;
    }
//    /**
//     * 从网络中获取图片西悉尼，以字节数组的形式放回
//     * @return
//     */
//    public static byte[] getImageViewArray(){
//        byte[]data=null;
//        InputStream inputStream=null;
//        //不需要关闭的输出流，直接写入内存中。
//        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
//        try {
//            URL url=new URL(URL_PATH);
//            if ()
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//    }
}
