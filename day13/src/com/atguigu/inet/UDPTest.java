package com.atguigu.inet;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * UDP 形式的网络编程
 *
 */
public class UDPTest {

    @Test
    public void send() throws IOException {
        // 发送端
        DatagramSocket socket = new DatagramSocket();

        String s = new String("你好！");
        byte[] data = s.getBytes();
        InetAddress inet = InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(data, 0, data.length, inet, 8080);

        socket.send(packet);
    }

    @Test
    public void receiver() throws IOException {
        // 接收端
        DatagramSocket socket = new DatagramSocket(8080);

        byte[] buffer = new byte[100];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);

        socket.receive(packet);

        System.out.println(new String(packet.getData(),0,packet.getLength()));
    }
}
