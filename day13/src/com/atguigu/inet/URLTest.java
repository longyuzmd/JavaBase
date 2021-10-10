package com.atguigu.inet;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLTest {
    
    public void test() throws IOException {
        URL url = new URL("");

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        urlConnection.connect();

        InputStream is = urlConnection.getInputStream();  // 获取输入流

        // 写入到指定文件
    }
}
