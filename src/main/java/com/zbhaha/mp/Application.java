package com.zbhaha.mp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@EnableTransactionManagement
@SpringBootApplication
@ComponentScan(basePackages = {
        "com.zbhaha.mp.config",
        "com.zbhaha.mp.controller",
        "com.zbhaha.mp.interceptor",
        "com.zbhaha.mp.service"})
public class Application {

    protected final static Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
        LOGGER.info("Application is started!");
    }
}
