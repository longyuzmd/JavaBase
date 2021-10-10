package com.atguigu.file;

import java.io.File;

public class FileMethod {

    /**
     * File常用方法：
     *  文件的基本属性获取
     *  getName()
     *  getLength()
     *
     *
     * 文件的判断方法
     *  isFile()
     *  isDirectory()
     *  exist()
     *  canRead()
     *  canWrite()
     *  isHide()
     *
     * 文件的获取方法
     *  list()
     *  listFiles()
     *
     * 文件的创建方法
     *  createNewFile()
     *  mkdir()
     *  mkdirs()
     *
     */
    public static void main(String[] args) {
        File file = new File("hello.txt");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getName());
        System.out.println(file.length());
        System.out.println(file.getPath());
        System.out.println(file.getParent());
    }
}
