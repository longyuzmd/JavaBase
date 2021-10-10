package com.atguigu.file;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * io流的分类
 *  按照流的流向分为： 输入流 input 输出流 output
 *  流的处理数据单元： byte（8bit） 字节流  char(16bit) 字符流
 *  流的角色方式： 直接怼再目标文件上的 节点流 处理流的流 处理流
 *
 *  流的四个抽象基类：
 *                  字节流         字符流
 *      输入流    inputStream      Reader
 *      输出流    outputStream     Writer
 */
public class IOType {

    /**
     * 读取文件hello.txt 打印到控制台
     */
    @Test
    public void test() {
        // 创建文件对象
        File file = new File("hello.txt");

        FileReader fr = null;
        try {
            // 创建文件输入流
            fr = new FileReader(file);

            // 文件的数据读取
            int data;
            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            // 关闭流，避免内存泄露问题
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
