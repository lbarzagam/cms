package com.lore.demo.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "")
public class HelloWorld {

  @RequestMapping(value = "")
  public ResponseEntity<?> sayHello() throws Exception {

    String action = "Defontana Service";

    String ticket = "21458598-8f3f-11ec-85ac-923bb234793e";
    String txId = String.format("%s-%s", ticket, UUID.randomUUID());
    Logger.getLogger(txId).info(action);

    ArrayList<String> response = new ArrayList<>(3);
    response.add("Hello");
    response.add("World");
    response.add("Say Hello");
    Map res = new HashMap<>();
    res.put("response", response);
    res.put("count", response.size());


    ResponseEntity<?> r = new ResponseEntity<>( res, HttpStatus.OK);
    Logger.getLogger(txId).info(action);
    return r;
  }

}
