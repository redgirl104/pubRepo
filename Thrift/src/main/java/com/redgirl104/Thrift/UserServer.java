package com.redgirl104.Thrift;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.TProcessor;

import com.redgirl104.Thrift.userserver.UserService;

public class UserServer {
    public static void StartsimpleServer(UserService.Processor<UserServiceImpl> processor) {
        try {
        	int nSocket = 9090;
            TServerTransport serverTransport = new TServerSocket(nSocket);
            TServer server = new TSimpleServer(
                    new TServer.Args(serverTransport).processor(processor));
            System.out.println("Starting the simple server...[" + nSocket+"]");
            server.serve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        StartsimpleServer(new UserService.Processor<>(new UserServiceImpl()));
    }
}
