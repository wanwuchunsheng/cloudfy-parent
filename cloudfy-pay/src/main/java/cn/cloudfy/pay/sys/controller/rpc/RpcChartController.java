package cn.cloudfy.pay.sys.controller.rpc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;

import cn.cloudfy.pay.feign.ChartFeignClient;
import cn.cloudfy.pay.sys.pojo.SysUser;
import lombok.extern.slf4j.Slf4j;

/**
 * @Date: 2018/11/23 11:14
 * @Description: 购物车查询
 */
@RestController
@RequestMapping("rpc")
@Slf4j
public class RpcChartController {

	@Autowired
    private ChartFeignClient chartFeignClient;
	
	/**
     * 根据id查询商品
     * @param name
     * @return
     */
    @GetMapping("/queryChartById/{id}")
    public List<SysUser> queryChartById(@PathVariable("id") Integer id) {
    	List<SysUser> list=this.chartFeignClient.queryChartById(id);
    	log.info("返回结果{}",JSONArray.toJSONString(list));
    	return list;
    }
}
