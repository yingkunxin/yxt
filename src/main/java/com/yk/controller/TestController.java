package com.yk.controller;

import com.yk.mapper.TestMapper;
import com.yk.model.form.redis.AddGeoF;
import com.yk.model.form.redis.DistGeoF;
import com.yk.model.vo.common.ApiResult;
import com.yk.model.vo.redis.DistanceGeoListV;
import com.yk.service.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ykx
 * @Date: 2023/06/29/16:04
 * @Description:
 */
@RestController
@Api(tags = "测试模块")
@RequestMapping("/test")
public class TestController {

    @Resource
    private TestMapper testMapper;

    @Resource
    private RedisService redisService;

    @PostMapping("/test1")
    @ApiOperation("geo")
    public String test(@RequestBody AddGeoF addGeoF){
        return redisService.setGeo(addGeoF);
    }

    @ApiOperation("getAll")
    @GetMapping("/test3")
    public String getAll(){
        return redisService.getAll();
    }

    @ApiOperation("getDist")
    @GetMapping("/getDist")
    public ApiResult<List<DistanceGeoListV>> getDist(@ModelAttribute DistGeoF distGeoF){
        return ApiResult.buildSuccess(redisService.getDist(distGeoF));
    }

    @ApiOperation("testSql")
    @GetMapping("/testSql")
    public ApiResult<?> testSql() {
        testMapper.testSql("tets' or '1' = '1");
        return ApiResult.buildSuccess();
    }
}
