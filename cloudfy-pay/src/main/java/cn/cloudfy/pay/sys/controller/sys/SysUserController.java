package cn.cloudfy.pay.sys.controller.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.cloudfy.common.annotation.TraceLog;
import cn.cloudfy.common.pojo.Page;
import cn.cloudfy.common.pojo.Result;
import cn.cloudfy.pay.sys.pojo.SysUser;
import cn.cloudfy.pay.sys.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("pay")
@Slf4j
@Api(description = "用户管理")
public class SysUserController {
	
	@Autowired
	private SysUserService sysUserService;
	
	/**
     * 分页查询用户
     *
     * @param page
     * @return
     */
    @GetMapping("selectSysUserByPage")
    @ApiOperation(value = "查询用户接口", notes = "分页查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "name", value = "用户名称", dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "startTime", value = "开始时间", dataType = "Date"),
            @ApiImplicitParam(paramType = "query", name = "endTime", value = "结束时间", dataType = "Date"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "要查看的页码，默认是1", dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页查询数量，默认是10", dataType = "int")
    })
    public ResponseEntity<Result> selectSysUserByPage(Page page, SysUser sysUser) {
        try {
            Result<?> result = this.sysUserService.selectSysUserByPage(page, sysUser);
            if (result != null) {
                return ResponseEntity.ok(result);
            }
        } catch (Exception e) {
            log.error("分页查询用户信息错误！{}", e.getMessage(), e);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Result.msg("分页查询用户信息错误！"));
    }
    
    /**
     * 添加用户
     *
     * @return
     */
    @PostMapping("saveSysUser")
    @ApiOperation(value = "添加用户接口", notes = "保存用户")
    @ApiImplicitParams({
    	    @ApiImplicitParam(paramType = "query", name = "id", value = "ID", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "name", value = "用户名称", dataType = "String"),
    	    @ApiImplicitParam(paramType = "query", name = "age", value = "年龄", dataType = "Integer"),
    	    @ApiImplicitParam(paramType = "query", name = "address", value = "地址", dataType = "String")
    })
    @TraceLog(content = "添加系统用户", paramIndexs = {0})
    public ResponseEntity<Result> saveSysUser(SysUser sysUser) {
        try {
            this.sysUserService.saveSysUser(sysUser);
            return ResponseEntity.status(HttpStatus.OK).body(Result.msg("成功"));
        } catch (Exception e) {
            log.error("添加用户信息错误！{}", e.getMessage(), e);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Result.msg("添加用户信息错误！"));
    }

}
