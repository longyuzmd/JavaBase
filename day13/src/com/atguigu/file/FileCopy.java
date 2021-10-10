package com.atguigu.file;

import org.junit.Test;

import java.io.*;

public class FileCopy {

    /**
     * 处理文件的字符流
     */
    @Test
    public void test(){
        // 1、创建两个文件对象，节点
        File sourceFile = new File("hello.txt");
        File copyFile = new File("copyHello.txt");

        FileReader fr = null;
        FileWriter fw = null;
        try {
            // 2、创建输入和输出流，站在程序的角度去看
            fr = new FileReader(sourceFile);
            fw = new FileWriter(copyFile);

            // 3、文件数据的读写操作 字符形式去读写
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                fw.write(cbuf, 0, len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            // 4、关闭流操作
            if(fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 处理非文本文件的字节流copy
     */
    @Test
    public void test2(){
        // 1、创建两个图片文件，字节流处理
        File sourceFile = new File("1.png");
        File copyFile = new File("2.png");

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // 2、处理字节的流，字节流
            fis = new FileInputStream(sourceFile);
            fos = new FileOutputStream(copyFile);

            // 3、读写数据
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fis.read(bytes)) != -1){
                fos.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4、关闭流
            try {
                if(fis != null)
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fos != null)
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 非文本文件的copy方法
     * @param sourcePath
     * @param destPath
     */
    public void copy(String sourcePath,String destPath){
        // 1、创建两个非文本文件，字节流处理
        File sourceFile = new File(sourcePath);
        File copyFile = new File(destPath);
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            // 2、处理字节的流，字节流
            fis = new FileInputStream(sourceFile);
            fos = new FileOutputStream(copyFile);

            // 3、读写数据
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fis.read(bytes)) != -1){
                fos.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4、关闭流
            try {
                if(fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 处理流：
     *  缓冲流：字节流 和 字符流
     *  BufferedInputStream
     *  BufferedOutputStream
     *  BufferedReader
     *  BufferedWrite
     */
    @Test
    public void test03(){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(new File("")));
            bos = new BufferedOutputStream(new FileOutputStream(new File("")));

            byte[] bytes = new byte[1024];
            int len;
            while ((len = bis.read(bytes)) != -1){
                bos.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if(bis != null)
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bos != null)
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test04(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(new File("")));
            bw = new BufferedWriter(new FileWriter(new File("")));

            char[] cbuf = new char[1024];
            int len;
            while ((len = br.read(cbuf)) != -1){
                bw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if(br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bw != null)
                    bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
