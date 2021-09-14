package com.mimehoo.hrm.company.config;

import com.mimehoo.hrm.common.utils.IdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IdWorkerBean {

    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }
}
