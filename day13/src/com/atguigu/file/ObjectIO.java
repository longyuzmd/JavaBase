package com.atguigu.file;

import org.junit.Test;

import java.io.*;

/**
 * 对象流：
 * ObjectInputStream
 * 序列化：将内存对象存储到磁盘中
 *
 *
 * ObjectOutputStream
 * 反序列化：将磁盘中对象还原成内存中的对象
 */
public class ObjectIO {

    @Test
    public void test() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.txt"));

        oos.writeObject(new String("我爱我的祖国！"));

        oos.close();
    }

    @Test
    public void test01() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.txt"));

        String s =(String) ois.readObject();

        System.out.println(s);
        ois.close();
    }


    @Test
    public void testPersonIn() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("per.txt"));

        oos.writeObject(new Person("左明登",26));

        oos.close();
    }

    @Test
    public void testPersonOut() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("per.txt"));

        Person s =(Person) ois.readObject();

        System.out.println(s);
        ois.close();
    }
}
