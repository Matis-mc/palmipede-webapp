package com.polytech.palmipedewebapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;


/*
@Configuration
@EnableWebSecurity
public class BasicWebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password(passwordEncoder.encode("1234"))
                .roles("USER")
                .and()
                .withUser("technicien").password(passwordEncoder.encode("1234"))
                .roles("USER","TECHNICIEN")
                .and()
                .withUser("admin").password(passwordEncoder.encode("1234"))
                .roles("USER","TECHNICIEN","ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/user").permitAll()
                .antMatchers( "/palmipede", "/ponte").access("hasRole('USER')")
                .antMatchers("/palmipede/espece", "/infra").access("hasRole('TECHNICIEN')")
                .anyRequest().authenticated()
                .and()
                .httpBasic();

    }


    /**
     @Bean
     public PasswordEncoder passwordEncoder() {
     return new BCryptPasswordEncoder();
     }
     **/

//}