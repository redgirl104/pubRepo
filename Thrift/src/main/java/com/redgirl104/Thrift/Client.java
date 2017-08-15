package com.redgirl104.Thrift;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import com.redgirl104.Thrift.userserver.UserService;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try {
            TTransport transport;
            transport = new TSocket("192.168.0.8", 9090);
            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            UserService.Client client = new UserService.Client(protocol);
            System.out.println("user info:" + client.find());
            transport.close();
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException x) {
            x.printStackTrace();
        }
	}

}
