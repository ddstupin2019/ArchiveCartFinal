package com.example.demo.enity;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.FileEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class YndecsDiscSviz {

    public static void man(String[] args) {
        File file = new File("C:\\Users\\ddstu\\AndroidStudioProjects\\demo\\src\\main\\resources\\templates\\lol\\assets\\1674063893334.jpg");
        DefaultHttpClient httpclient = new DefaultHttpClient();
        String url ="https://uploader19g.disk.yandex.net:443/upload-target/20230130T164315.321.utd.a0mtd3twjn54pasd7dep09gc5-k19g.6865570";
        HttpPut h = new HttpPut(url);
        FileEntity f = new FileEntity(file);
        h.setEntity(f);
        try {
            HttpResponse response = httpclient.execute(h);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        DefaultHttpClient httpclient = new DefaultHttpClient();
        String url = "https://cloud-api.yandex.net/v1/disk/resources/download?path=arvive/1675087728816trenirovka_zm_23_01_23.jpg";
        HttpGet httpPost = new HttpGet(url);
        httpPost.addHeader("Authorization", "Ваш токен");
        try {
            HttpResponse response = httpclient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            String responseString = EntityUtils.toString(entity, "UTF-8");
            System.out.println(responseString);
            String s = responseString.replace("\"","");
            String[] a = s.split(",");
            System.out.println(a[0].replace("{href:", ""));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void setFile(File file, String url){
        DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpPut h = new HttpPut(url);
        FileEntity f = new FileEntity(file);
        h.setEntity(f);
        try {
            HttpResponse response = httpclient.execute(h);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getUrl(String fileName) {
        DefaultHttpClient httpclient = new DefaultHttpClient();
        String url = "https://cloud-api.yandex.net/v1/disk/resources/upload?path=/arvive/" + fileName;
        HttpGet httpPost = new HttpGet(url);
        httpPost.addHeader("Authorization", "Ваш токен");

        try {
            HttpResponse response = httpclient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            String responseString = EntityUtils.toString(entity, "UTF-8");
            String s = responseString.replace("\"","");
            String[] a = s.split(",");
            return a[1].replace("href:", "");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getFileUrl(String fileName){
        DefaultHttpClient httpclient = new DefaultHttpClient();
        String url = "https://cloud-api.yandex.net/v1/disk/resources/download?path=arvive/"+fileName;
        HttpGet httpPost = new HttpGet(url);
        httpPost.addHeader("Authorization", "Ваш токен");
        try {
            HttpResponse response = httpclient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            String responseString = EntityUtils.toString(entity, "UTF-8");
            String s = responseString.replace("\"","");
            String[] a = s.split(",");
            return a[0].replace("{href:", "");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

