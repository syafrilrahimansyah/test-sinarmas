package com.sinarmas.phonebook;

import com.sinarmas.phonebook.persistence.DaoService;
import com.sinarmas.phonebook.persistence.DaoServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class DaoConfig implements WebMvcConfigurer {
    @Bean
    public DaoService daoService(){return  new DaoServiceImpl();
    };
}
