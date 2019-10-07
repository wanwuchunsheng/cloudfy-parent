package cn.cloudfy.chart.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.cloudfy.chart.pojo.SysUser;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("chart")
@Slf4j
@Api(description = "购物车管理")
public class ChartController {
	
	@GetMapping("queryChartById/{id}")
	public List<SysUser> queryChartById(@PathVariable("id") Integer id){
		log.info("______@_____{}",id);
		List<SysUser> list= new ArrayList<SysUser>();
		SysUser s=new SysUser();
		s.setId(1);
		s.setName("zhangsan");
		s.setAddress("上海闵行");
		s.setAge(44);
		list.add(s);
		SysUser s2=new SysUser();
		s2.setId(2);
		s2.setName("rose");
		s2.setAddress("湖北武汉");
		s2.setAge(22);
		list.add(s2);
		try {
			//Thread.sleep(10000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

}
