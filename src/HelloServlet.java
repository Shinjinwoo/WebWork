import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse resp)
		// 클라이언트에게 응답할 페이지 정보를 셋팅한다.
		throws ServletException,IOException {
		
		resp.setContentType("text/html");
		// [Ctrl] + Shift + 오(알파벳) ] : 자동 import
		
		PrintWriter out=resp.getWriter();
		out.print("<html><body><h1>"); 
		out.print("Hello Servlet"); 
		out.print("</h1></body></html>"); 
		out.close();
		
	}
}
