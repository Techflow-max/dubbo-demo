package com.edwin.dubbo.demo.provider;

import com.edwin.dubbo.demo.DemoService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;

import java.util.concurrent.CountDownLatch;


public class Provider {

    private static final String zookeeperHost = System.getProperty("zookeeper.address", "127.0.0.1");
    private static final String zookeeperPort = System.getProperty("zookeeper.port", "2181");

    public static void main(String[] args) throws Exception {
        ServiceConfig<DemoService> service = new ServiceConfig<>();
        service.setApplication(new ApplicationConfig("first-dubbo-provider"));
        service.setRegistry(new RegistryConfig(
                "zookeeper://" + zookeeperHost + ":" + zookeeperPort));
        service.setInterface(DemoService.class);
        service.setRef(new DemoServiceImpl());
        service.export();

        System.out.println("dubbo service started");
        new CountDownLatch(1).await();
    }
}

