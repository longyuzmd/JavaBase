package com.atguigu.file;

import org.junit.Test;

import java.io.*;

/**
 * 转化流：
 * InputStreamReader 字节流转化成字符流
 *
 * OutputStreamWriter 字符流转化成字节流 入参尽然是字节流
 */
public class ChangeIO {

    @Test
    public void test() throws Exception {

        File source = new File("");
        File dest = new File("");

        FileInputStream fis = new FileInputStream(source);
        FileOutputStream fos = new FileOutputStream(dest);

        // 转化流
        InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
        OutputStreamWriter osw = new OutputStreamWriter(fos, "gbk");

        // 数据的读写操作
        char[] cbuf = new char[10];
        int len;
        while ((len = isr.read(cbuf)) != -1){
            osw.write(cbuf,0,len);
        }

        isr.close();
        osw.close();
    }
}
