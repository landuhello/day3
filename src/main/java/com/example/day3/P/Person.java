package com.example.day3.P;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class Person {
     //单例
    public Person() {
    }
    private static final Person PERSON = new Person();

    public static Person getPERSON() {
        return PERSON;
    }
    public static String getstr(String str){
        try {
            URL url = new URL(str);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(5000);
            int responseCode = connection.getResponseCode();
            if (responseCode==HttpURLConnection.HTTP_OK){
                InputStream inputStream = connection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuffer buffer = new StringBuffer();
                String temp="";
                while ((temp=bufferedReader.readLine())!=null){
                    buffer.append(temp);
                }
                String s = buffer.toString();
                connection.disconnect();
                bufferedReader.close();
                return s;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
