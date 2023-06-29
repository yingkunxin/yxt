package com.yk.model.form.redis;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ykx
 * @Date: 2023/06/29/16:29
 * @Description:
 */
@Data
public class AddGeoF {

    @ApiModelProperty("纬度")
    private BigDecimal latitude;

    @ApiModelProperty("经度")
    private BigDecimal longitude;

    @ApiModelProperty("键名")
    private String keyName;

    @ApiModelProperty("地点")
    private String location;
}
