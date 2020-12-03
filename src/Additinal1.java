import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Additinal1")

public class Additinal1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Additinal1() {
		super ();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse resp)
	throws ServletException,IOException {
		int num1 = 20;
		int num2 = 10;
		int add = num1 + num2;
		PrintWriter out = resp.getWriter();
		out.println("<html><head><title>Additon</title></head>");
		out.println("<body>");
		out.println(num1 + "+" + num2 + "=" + add);
		out.println("</body>");
		out.println("</html>");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException,IOException {
		}
	
	
}
