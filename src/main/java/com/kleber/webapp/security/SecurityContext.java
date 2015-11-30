package com.kleber.webapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

@Configuration
@EnableWebSecurity
@ComponentScan
public class SecurityContext extends WebSecurityConfigurerAdapter {
  @Autowired
  private UserDetailsService userDetailsService;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private PermissionEvaluator permissionEvaluator;

  @Autowired
  private AuthenticationManagerBuilder auth;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .csrf()
        .disable()
      .authorizeRequests()
        .antMatchers("/**").permitAll()
        .anyRequest().authenticated()
        .and()
      .formLogin()
        .loginPage("/signin")
        .loginProcessingUrl("/login").permitAll()
        .usernameParameter("login")
        .passwordParameter("senha")
        .and()
      .rememberMe()
        .key("remember-me")
        .and()
      .logout()
        .logoutUrl("/logout");
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    DefaultWebSecurityExpressionHandler handler = new DefaultWebSecurityExpressionHandler();
    handler.setPermissionEvaluator(permissionEvaluator);

    web
      .expressionHandler(handler);
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth
      .userDetailsService(userDetailsService)
      .passwordEncoder(passwordEncoder);
  }

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return auth.getOrBuild();
  }
}

