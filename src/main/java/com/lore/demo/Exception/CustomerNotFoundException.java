package com.lore.demo.Exception;

public class CustomerNotFoundException  extends RuntimeException
{
  public CustomerNotFoundException(String message)
  {
    super(message);
  }
}
