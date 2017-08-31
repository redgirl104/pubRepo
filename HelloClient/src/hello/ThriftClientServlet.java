package hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * Servlet implementation class ThriftClientServlet
 */
@WebServlet("/ThriftClient")
public class ThriftClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThriftClientServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String serverIp = request.getParameter("serverIP");
		String serverPort = request.getParameter("serverPort");
		String name = request.getParameter("name");
		String age = request.getParameter("age");

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		try {
			int timeout = 10 * 1000;

//			final TTransport transport = new TSocket(serverIp, Integer.parseInt(serverPort));
//			final TProtocol protocol = new TBinaryProtocol(transport);
//			final HelloService.Client client = new HelloService.Client(protocol);

			// Non Blocking Mode - TFramedTransport wrapping
			final TTransport transport = new TFramedTransport(new TSocket(serverIp, Integer.parseInt(serverPort)));
			final TProtocol protocol = new TBinaryProtocol(transport);
			final HelloService.Client client = new HelloService.Client(protocol);

			transport.open();

			out.println("<html>");
			out.println("<head>");
			out.println("</head>");
			out.println("<body>");
			for (int i = 0; i <= 1000; i++) {
				String result = client.greeting(name, Integer.parseInt(age));

				out.println(i + " --> " + result + "<br>");
			}
			out.println("</body>");
			out.println("</html>");
			out.close();

			transport.close();
		} catch (TException te) {
		}
	}
}
