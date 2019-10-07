package cn.cloudfy.pay;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import cn.cloudfy.pay.feign.ChartFeignClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 启动类
 */
@SpringCloudApplication
@EnableFeignClients // 启动feign
//2 @EnableFeignClients(clients = ChartFeignClient.class) //声明具体接口作为feign client调用
@EnableHystrixDashboard // 启用Hystrix Dashboard功能
@MapperScan(basePackages = {"cn.cloudfy.pay.*.dao"})
@ComponentScan(basePackages = {"cn.cloudfy"})
public class PayApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PayApplication.class, args);
	}

}
