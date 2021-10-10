package com.atguigu.file;


import org.junit.Test;

import java.io.File;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 写入是从文件的开始位置进行覆盖（文件已存在）
 *
 */
public class RandomAccessFileTest {

    @Test
    public void test() throws IOException {
        // 可以是输入流也可以是输出流，需要指定读写权限mode
        RandomAccessFile rai = new RandomAccessFile("hello.txt", "r");
        RandomAccessFile rao = new RandomAccessFile("hi.txt", "rw");

        // 进行数据的读写操作
        byte[] bytes = new byte[1024];
        int len;
        while ((len = rai.read(bytes)) != -1){
            rao.write(bytes,0,len);
        }

        // 关闭流操作
        rai.close();
        rao.close();
    }

    /**
     * 文件覆盖
     */
    @Test
    public void test01() throws IOException {
        // 可以是输入流也可以是输出流，需要指定读写权限mode
        RandomAccessFile rao = new RandomAccessFile("hi.txt", "rw");

        // 进行数据的读写操作
        rao.write("xyz".getBytes());

        // 关闭流操作
        rao.close();
    }

    /**
     * 实现内容的插入功能
     */
    @Test
    public void test02() throws IOException {
        // 可以是输入流也可以是输出流，需要指定读写权限mode
        RandomAccessFile rao = new RandomAccessFile("hi.txt", "rw");

        // 将指针移动到指定位置
        rao.seek(5);

        // 保存后面内容到StringBuilder中
        StringBuilder builder = new StringBuilder((int) new File("hi.txt").length());
        byte[] bytes = new byte[1024];
        int len;
        while ((len = rao.read(bytes)) != -1){
            builder.append(new String(bytes,0,len));
        }

        // 将指针移动会5的位置
        rao.seek(5);
        rao.write("abc".getBytes());

        // 将builder内容再写入
        rao.write(builder.toString().getBytes());
        rao.close();
    }
}
