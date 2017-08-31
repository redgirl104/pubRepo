package com.redgirl104.hello;

import hello.HelloService;

import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;

public class HelloServer {
	public void startServer(int port) throws Exception {

		// TThreadPoolServer
//		final TNonblockingServerSocket socket = new TNonblockingServerSocket(port);
//		final HelloService.Processor processor = new HelloService.Processor(new HelloHandler());
//		final TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(socket).processor(processor));

		// TNonblockingServer
//		final TNonblockingServerTransport serverTransport = new TNonblockingServerSocket(port);
//		final HelloService.Processor processor = new HelloService.Processor(new HelloHandler());
//		final TServer server = new TNonblockingServer(
//				new TNonblockingServer.Args(serverTransport).processor(processor));

		// THsHaServer
		final TNonblockingServerSocket socket = new TNonblockingServerSocket(port);
		final HelloService.Processor processor = new HelloService.Processor(new HelloHandler());
		final TServer server = new THsHaServer(
				new THsHaServer.Args(socket).processorFactory(new TProcessorFactory(processor)).maxWorkerThreads(2000));

		System.out.println("=========== HelloServer started(port:" + port + ")");
		server.serve();
	}

	public static void main(String[] args) throws Exception {
		if (args.length < 1) {
			System.out.println("Usage java HelloServer <port>");
			System.exit(0);
		}

		int port = Integer.parseInt(args[0]);

		(new HelloServer()).startServer(port);

	}
}
