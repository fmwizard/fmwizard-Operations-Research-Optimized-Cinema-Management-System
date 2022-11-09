package com.example.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.net.http.WebSocket;
import java.util.Scanner;

@SpringBootApplication
public class CommonApplication {

    public static void main(String[] args) throws UnknownHostException {
        SpringApplication.run(CommonApplication.class, args);
    }

}
