package com.it.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.it.services.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	    @Autowired
	    private CustomUserDetailsService userDetailsService;
	    
	    @Bean
	    public AuthenticationManager authenticationManager(HttpSecurity http, PasswordEncoder encoder) throws Exception {
	        
	    	return http.getSharedObject(AuthenticationManagerBuilder.class)
	                   .userDetailsService(userDetailsService)
	                   .passwordEncoder(encoder)
	                   .and()
	                   .build();
	    }
	    
	    
        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                                       http.csrf().disable()
                                           .authorizeHttpRequests()
                                           .requestMatchers("/tlogin","/ssignup","/tsignup","/slogin").permitAll()
                                           .anyRequest().authenticated()
                                           .and()
                                           .sessionManagement()
                                           .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

                    return http.build();
       }

   
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance(); // only for dev/testing
    }


}
