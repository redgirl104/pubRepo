package hello;

import org.apache.thrift.TException;

public class HelloHandler implements HelloService.Iface {
	@Override
	public String greeting(String name, int age) throws TException {
		return "Hello??? " + name + ". You are " + age + " years old";
	}

}
