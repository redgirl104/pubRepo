//HelloServer.java
package com.redgirl104.hello;
import hello.HelloService;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TServerSocket;

public class HelloServer{
	
	public static void main(String[] args) throws Exception{
		if(args.length <1){
		System.out.println("Usage java HelloServer <port>");
		System.exit(0);
	}
	int port = Integer.parseInt(args[0]);
        final TServerSocket socket = new TServerSocket(port);

        final HelloService.Processor processor = new HelloService.Processor(new HelloHandler());

        final TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(socket).processor(processor));

        System.out.println("=============started port:"+port);

        server.serve();



}

}

