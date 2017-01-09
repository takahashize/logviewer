package com.example.logviewer;

import com.example.logviewer.user.ResetPasswordInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(passwordResetInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/reset");
    }

    @Bean
    public ResetPasswordInterceptor passwordResetInterceptor() {
        ResetPasswordInterceptor interceptor = new ResetPasswordInterceptor();
        interceptor.setResetPath("/reset");
        return interceptor;
    }
}
