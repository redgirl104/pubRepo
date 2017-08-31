package hello;

import hello.HelloService;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

public class HelloClient {

	// 서버 IP
	private String host;
	// 서버 PORT
	private int port;
	// 서버로 보낼 이름
	private String name;
	// 서버로 보낼 나이
	private int age;

	public String getHost() {
		return this.host;
	}

	public int getPort() {
		return this.port;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

	public void setHost(String ServerIP) {
		this.host = ServerIP;
	}

	public void setPort(int ServerPORT) {
		this.port = ServerPORT;
	}

	public void setAge(int ServerAge) {
		this.age = ServerAge;
	}

	public void setName(String ServerName) {
		this.name = ServerName;
	}

	public String Run(String IP, String PORT) throws Exception {
		String result = null;

		try {

			int timeout = 10 * 1000;

			// TSocket
//			final TTransport transport = new TSocket(IP, Integer.parseInt(PORT));
//			// socket.setTimeout(timeout);
//			final TProtocol protocol = new TBinaryProtocol(transport);
//			final HelloService.Client client = new HelloService.Client(protocol);

			// Non Blocking Mode - TFramedTransport wrapping
			 final TTransport transport = new TFramedTransport(new TSocket(IP, Integer.parseInt(PORT)));
			 final TProtocol protocol = new TBinaryProtocol(transport);
			 final HelloService.Client client = new HelloService.Client(protocol);

			transport.open();

			for (int i = 0; i <= 1000; i++) {
				result = client.greeting(getName(), getAge());
			}
			transport.close();

		} catch (TException te) {
		}

		return result;
	}
}