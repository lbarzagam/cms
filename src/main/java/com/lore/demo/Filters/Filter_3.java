package com.lore.demo.Filters;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
@Order(value = 1)
public class Filter_3 implements Filter {

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
    throws IOException, ServletException {

    System.out.println("This is my 3 er Filter");
    filterChain.doFilter(servletRequest, servletResponse);
  }
}
