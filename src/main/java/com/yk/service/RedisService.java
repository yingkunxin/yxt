package com.yk.service;

import com.yk.model.form.redis.AddGeoF;
import com.yk.model.form.redis.DistGeoF;
import com.yk.model.vo.redis.DistanceGeoListV;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ykx
 * @Date: 2023/06/29/15:57
 * @Description:
 */
public interface RedisService {
    String setGeo(AddGeoF addGeoF);

    String getAll();

    List<DistanceGeoListV> getDist(DistGeoF distGeoF);
}
