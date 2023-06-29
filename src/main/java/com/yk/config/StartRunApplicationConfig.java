package com.yk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class StartRunApplicationConfig implements ApplicationRunner {

    @Autowired
    private ApplicationContext applicationContext;

    private static final String banner = "____    __    ____  ___   ____    ____  __    __  .__   __.\n" +
            "_____.___.____  __.\n" +
            "\\__  |   |    |/ _|\n" +
            "  /   |   |      <  \n" +
            " \\____   |    |  \\ \n" +
            "  / ______|____|__ \\\n" +
            " \\/              \\/";


    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(banner);

    }
}
