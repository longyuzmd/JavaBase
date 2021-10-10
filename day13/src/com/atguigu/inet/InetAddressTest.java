package com.atguigu.inet;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress类
 */
public class InetAddressTest {

    public static void main(String[] args) throws UnknownHostException {

        InetAddress inet = InetAddress.getByName("www.baidu.com");
        System.out.println(inet);
        System.out.println(inet.getHostName());
        System.out.println(inet.getHostAddress());
        System.out.println("========================");

        InetAddress localNet = InetAddress.getByName("127.0.0.1");
        System.out.println(localNet);

        InetAddress inet1 = InetAddress.getByName("192.168.10.109");
        System.out.println(inet1);

        InetAddress inet2 = InetAddress.getLocalHost();
        System.out.println(inet2);
    }
}
