package cn.cloudfy.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import zipkin.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer // 启动zipkin
public class ZipkinApplication {
	public static void main(String[] args) {
        SpringApplication.run(ZipkinApplication.class, args);
    }
}