package com.kleber.webapp;

import java.util.Set;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.spring3.SpringTemplateEngine;
import org.thymeleaf.extras.springsecurity3.dialect.SpringSecurityDialect;

@Configuration
public class Thymeleaf {

  @Bean
  public SpringTemplateEngine templateEngine() {
    SpringTemplateEngine engine  =  new SpringTemplateEngine();

    final Set<IDialect> dialects = new HashSet<IDialect>();
    dialects.add( new SpringSecurityDialect() );
    engine.setDialects( dialects );

    return engine;
  }

}
