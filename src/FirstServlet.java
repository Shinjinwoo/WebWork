import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

 
public class FirstServlet extends HttpServlet {
	public void init() throws ServletException {
		System.out.println("init 메소드 호출");
	}
	protected void doGet(HttpServletRequest req,
	HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet 메소드 호출");
	}
	public void destroy() {
		System.out.println("destroy 메소드 호출 ");
		
	}
}


