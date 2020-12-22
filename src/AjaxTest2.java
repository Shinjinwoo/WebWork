import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AjaxTest2")
public class AjaxTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AjaxTest2() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 request.setCharacterEncoding("utf-8");
 response.setContentType("text/html; charset=utf-8");
 String result = "";
 PrintWriter writer = response.getWriter();
 result="<main><book>"+
 "<title><![CDATA[자바 프로그래밍]]></title>"+
 "<writer><![CDATA[저 | 박샘이]]></writer>"+
 
 "<image><![CDATA[file:///D:/file_repo/1.jpg]]>"+
 
 "</image>"+"</book>"+ "<book>"+"<title><![CDATA[모두의 파이썬]]></title>"+
 "<writer><![CDATA[길벗 저 |주니샘]]></writer>"+
 
 "<image><![CDATA[file:///D:/file_repo/2.jpg]]>"+
 "</image>"+"</book></main>";

 System.out.println(result);
 writer.print(result);
 }
}
