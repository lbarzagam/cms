package com.lore.demo.Filters;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class MyNewFilter implements Filter {

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
    throws IOException, ServletException {

    System.out.println("My new Filter Configuration");
    filterChain.doFilter(servletRequest, servletResponse);
  }
}
