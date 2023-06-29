package com.yk.service.impl;

import com.yk.model.form.redis.AddGeoF;
import com.yk.model.form.redis.DistGeoF;
import com.yk.model.vo.redis.DistanceGeoListV;
import com.yk.service.RedisService;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ykx
 * @Date: 2023/06/29/15:58
 * @Description:
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public String setGeo(AddGeoF addGeoF) {
        Point point = new Point(addGeoF.getLongitude().doubleValue(),addGeoF.getLatitude().doubleValue());
        Long add = redisTemplate.opsForGeo().add(addGeoF.getKeyName(), point, addGeoF.getLocation());
        assert add != null;
        return add.toString();
    }

    @Override
    public String getAll() {
        List<Point> position = redisTemplate.opsForGeo().position("杭州市", "盈丰街道新安一组");
        return null;
    }

    @Override
    public List<DistanceGeoListV> getDist(DistGeoF distGeoF) {
        Circle circle =
                new Circle(
                        new Point(distGeoF.getLongitude().doubleValue(), distGeoF.getLatitude().doubleValue()),
                        new Distance(distGeoF.getRadius().doubleValue(), Metrics.NEUTRAL)
                );
        RedisGeoCommands.GeoRadiusCommandArgs args = RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs().includeCoordinates().includeDistance();
        GeoResults<RedisGeoCommands.GeoLocation<String>> radius = redisTemplate.opsForGeo().radius(distGeoF.getKeyName(), circle,args);
        ArrayList<DistanceGeoListV> vs = new ArrayList<>();
        assert radius != null;
        for (GeoResult<RedisGeoCommands.GeoLocation<String>> geoLocationGeoResult : radius) {
            DistanceGeoListV listV = new DistanceGeoListV();
            RedisGeoCommands.GeoLocation<String> content = geoLocationGeoResult.getContent();
            Point point = content.getPoint();
            listV.setLatitude(BigDecimal.valueOf(point.getY()));
            listV.setLongitude(BigDecimal.valueOf(point.getX()));
            listV.setLocation(content.getName());
            listV.setRadius((int) geoLocationGeoResult.getDistance().getValue() + geoLocationGeoResult.getDistance().getUnit());
            vs.add(listV);
        }
        return vs;
    }
}
