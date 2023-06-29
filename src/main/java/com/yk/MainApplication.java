package com.yk;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ykx
 * @Date: 2023/06/29/15:53
 * @Description:
 */
@Slf4j
@EnableAsync
@EnableScheduling
@MapperScan(basePackages = { "com.yk.mapper"})
@SpringBootApplication(scanBasePackages = "com.yk")
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}
