package com.yk.mapper;

import com.yk.model.entity.Test;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;

public interface TestMapper extends Mapper<Test> {
    List<String> testSql(@Param("name") String name);
}