package com.sinarmas.phonebook;

import com.sinarmas.phonebook.service.Service;
import com.sinarmas.phonebook.service.ServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Config implements WebMvcConfigurer {
    @Bean
    public Service service(){return new ServiceImpl();
    };
}
