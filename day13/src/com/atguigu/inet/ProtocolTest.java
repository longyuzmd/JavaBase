package com.atguigu.inet;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 通讯协议：
 *  数据传输协议：
 *  TCP
 *      三次握手 保证连接的可靠性，
 *      是否都在线，客户端和服务端
 *      可以进行大数据传输，
 *      传输完毕要释放连接资源
 *  UDP
 *      不需要建立连接的 数据报（<= 64K） 不可靠的，
 *      不管接收方是否准备，就发送，
 *      发送完毕也不需要释放资源
 *      开销小，速度快
 *      游戏开发应该是采用UDP 我们经常说的丢包率  视频 直播
 */
public class ProtocolTest {

    /**
     * 客户端
     * 1、文件的角度
     */
    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        ByteArrayOutputStream bos = null;
        InputStream is = null;
        try {
            // 获取服务端Socket连接
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet, 8080);

            os = socket.getOutputStream();

            // 简单的输出
//        os.write("你好！".getBytes());

            // 复杂点，输出一个图片文件 or 文本文件
            FileInputStream fis = new FileInputStream("hello.txt");
            byte[] bytes = new byte[10];
            int len;
            while((len = fis.read(bytes)) != -1){
                os.write(bytes,0,len);
            }

            // 提示服务端图片传输完成
            socket.shutdownOutput();

            // 获取服务端的反馈
            bos = new ByteArrayOutputStream();
            is = socket.getInputStream();
            byte[] bs = new byte[5];
            int lenB;
            while ((lenB = is.read(bs)) != -1){
                bos.write(bs,0,lenB);
            }
            System.out.println(bos.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            // 关闭流信息
            if(os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 服务端
     */
    @Test
    public void server(){

        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream is = null;
        FileOutputStream fos = null;
        OutputStream os = null;
        try {
            serverSocket = new ServerSocket(8080);

            accept = serverSocket.accept();

            is = accept.getInputStream();

            // 文件传输，需要接受文件的流
            fos = new FileOutputStream("socketHello.txt");

            byte[] bytes = new byte[10];
            int len;
            while((len = is.read(bytes)) != -1){
                fos.write(bytes,0,len);
            }

            // 成功需要反馈
            os = accept.getOutputStream();
            os.write("发送成功！".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            // 关闭流信息
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (accept != null) {
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
