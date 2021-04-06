package com.edwin.dubbo.demo.provider;


import com.edwin.dubbo.demo.DemoService;

public class DemoServiceImpl implements DemoService {
    public String sayHello(String name) {
        return "hello " + name;
    }
}