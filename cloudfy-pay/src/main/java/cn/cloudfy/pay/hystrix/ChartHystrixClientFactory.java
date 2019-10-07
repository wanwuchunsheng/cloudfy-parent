package cn.cloudfy.pay.hystrix;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.cloudfy.pay.feign.ChartFeignClient;
import cn.cloudfy.pay.sys.pojo.SysUser;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * 购物Hystrix
 */
@Slf4j
@Component
public class ChartHystrixClientFactory implements FallbackFactory<ChartFeignClient> {
	
	@Override
	public ChartFeignClient create(Throwable throwable) {
		return new ChartFeignClient() {
			
			@Override
			public List<SysUser> queryChartById(Integer id) {
				log.error("通过ID查询购物车异常：{}", throwable.getMessage());
				return null;
			}
			
		};
	}

}
