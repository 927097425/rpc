package com.example.tlias.configure;

import com.example.tlias.Inteceptor.LogincheckInteceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class webconfigure implements WebMvcConfigurer {
    @Autowired
    LogincheckInteceptor logincheckInteceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logincheckInteceptor).addPathPatterns("/**").excludePathPatterns("/login");
    }
}
