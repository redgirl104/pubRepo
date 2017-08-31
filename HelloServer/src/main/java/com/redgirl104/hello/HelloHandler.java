package com.redgirl104.hello;

import org.apache.thrift.TException;
import com.redgirl104.hello.HelloServer;
import hello.HelloService;


public class HelloHandler implements HelloService.Iface {
  @Override
  public String greeting(String name, int age) throws TException {
      return "[Server Msg] Hello " + name +". You are " + age + " years old";
  }
}