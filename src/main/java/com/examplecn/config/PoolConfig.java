package com.examplecn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableAsync
public class PoolConfig {

    @Bean(name = "taskExecutor")
    public ThreadPoolExecutor threadPoolExecutor() {

        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque(1);

        return new ThreadPoolExecutor(1, 1, 6000, TimeUnit.MICROSECONDS, linkedBlockingDeque);
    }
}
