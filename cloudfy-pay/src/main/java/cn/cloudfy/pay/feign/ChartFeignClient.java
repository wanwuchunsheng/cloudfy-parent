package cn.cloudfy.pay.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cn.cloudfy.pay.hystrix.ChartHystrixClientFactory;
import cn.cloudfy.pay.sys.pojo.SysUser;

/**
 * 通过用户ID查询商品
 * 
 * */
@FeignClient(value = "cloudfy-chart", fallbackFactory = ChartHystrixClientFactory.class)
public interface ChartFeignClient {

	@GetMapping("/chart/queryChartById/{id}")
	public List<SysUser> queryChartById(@PathVariable("id") Integer id);
    
}
