package com.yk.model.vo.redis;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ykx
 * @Date: 2023/06/29/17:10
 * @Description:
 */
@Data
public class DistanceGeoListV {

    @ApiModelProperty("纬度")
    private BigDecimal latitude;

    @ApiModelProperty("经度")
    private BigDecimal longitude;

    @ApiModelProperty("距离")
    private String radius;

    @ApiModelProperty("地点")
    private String location;
}
