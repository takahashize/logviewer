package com.example.logviewer;

import com.example.logviewer.user.CompanyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final CompanyUserService companyUserService;

    @Autowired
    public WebSecurityConfig(CompanyUserService companyUserService) {
        this.companyUserService = companyUserService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers("/login").permitAll()
                .mvcMatchers("/log").hasRole("USER")
                .and()
                .formLogin()
                .and()
                .logout();
    }

//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(companyUserService);
//    }
}
