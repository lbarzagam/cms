package com.lore.demo.Config;

import com.lore.demo.Filters.MyNewFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFilterConfig {

  @Bean
  public FilterRegistrationBean<MyNewFilter> registrationBean()
  {
    FilterRegistrationBean<MyNewFilter> registrationBean = new FilterRegistrationBean<>();

    registrationBean.setFilter(new MyNewFilter());
    registrationBean.addUrlPatterns("/customer/*");
    return registrationBean;
  }
}
