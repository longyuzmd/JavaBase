package com.atguigu.file;

import java.io.File;

public class FileConstruct {

    public static void main(String[] args) {

        // 创建文件的三种方式
        File file1 = new File("hello.txt");
        System.out.println(file1);

        File file2 = new File("d:" + File.separator + "io", "hello.txt");
        System.out.println(file2);

        File file3 = new File("d:" + File.separator + "io");
        File file4 = new File(file3,"hi.txt");
        System.out.println(file4);
    }
}
