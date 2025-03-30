package com.abhi.jobportal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.abhi.jobportal.service.MyUserDetailsService;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private MyUserDetailsService userDetailsService;
	
	
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		return provider;
	}
	
	
	
	
	@Bean
	public SecurityFilterChain defaulSecurityFilterChain(HttpSecurity http) throws Exception {
		
		http
		.csrf(customizer -> customizer.disable())
		.authorizeHttpRequests(auth -> auth
				.requestMatchers("/register","/","/home","/jobs","/jobs/apply","/add").permitAll()
				.anyRequest().authenticated())
		
		 .formLogin(login -> login
		            .defaultSuccessUrl("http://localhost:3000/", true))
		.httpBasic(Customizer.withDefaults());
		
		
		return http.build();
		
	}
	
	
	 @Bean
	 public PasswordEncoder passwordEncoder() {
		 return new BCryptPasswordEncoder();
    }
	
}
