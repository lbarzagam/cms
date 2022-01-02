package com.lore.demo.Api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HelloWorld {

  @RequestMapping(value = "")
  public String HelloWorld() {
    return "Hello World!!! " + new Date();
  }


}
