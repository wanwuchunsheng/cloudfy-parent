package cn.cloudfy.chart;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import tk.mybatis.spring.annotation.MapperScan;

@SpringCloudApplication
@EnableFeignClients // 启动feign
@EnableHystrixDashboard // 启用Hystrix Dashboard功能
@MapperScan(basePackages = {"cn.cloudfy.chart.dao"})
@ComponentScan(basePackages = {"cn.cloudfy"})
public class ChartApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ChartApplication.class, args);
	}

}
