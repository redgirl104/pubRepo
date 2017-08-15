package com.redgirl104.hello; 

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import hello.HelloService;


public class HelloClient {

        public static void main(String[] args) throws Exception {

                if(args.length < 1){

                        System.out.println("Usage java HelloServer <port>");

                        System.exit(0);

                }

                String host ="localhost";

                int port = Integer.parseInt(args[0]);

                int timeout = 10 * 1000;



                final TTransport transport = new TSocket(host, port);

                final TProtocol protocol = new TBinaryProtocol(transport);



                final HelloService.Client client = new HelloService.Client(protocol);



                transport.open();


                String result = client.greeting("redgirl", 17);

                System.out.println("Received [ " + result + "]");


                transport.close();

        }
}
