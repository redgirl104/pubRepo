//HelloHandler.java
package com.redgirl104.hello;

import com.redgirl104.hello.HelloServer;
import java.text.SimpleDateFormat;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.thrift.TException;
import hello.HelloService;

public class HelloHandler implements HelloService.Iface{
	@Override
	public String greeting(String name, int age) throws TException{
		
	    String greetingPrefix = "Hello";
	    synchronized(HelloServer.configurations) {
	      if(HelloServer.configurations.containsKey(HelloServer.CONF_GREETING_KEY)) {
	        greetingPrefix = HelloServer.configurations.get(HelloServer.CONF_GREETING_KEY);
	      }
	    }
	    return greetingPrefix + " " + name + ". You are " + age + " years old";
	  }
	}
	

