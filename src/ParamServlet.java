import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ParamSerlvet")

public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메소드 호출");
	}

	
	public ParamServlet() {
		super();
	}

	   protected void doGet(HttpServletRequest request, HttpServletResponse response)
		         throws ServletException, IOException {
		      request.setCharacterEncoding("utf-8");
		      response.setContentType("text/html;charset=utf-8");
		      String id = request.getParameter("id");
		      int age = Integer.parseInt(request.getParameter("age"));
		      PrintWriter out = response.getWriter();
		      
		      out.print("<html>");
		      out.print("<body>");
		      out.println("당신이 입력한 정보 입니다.<br>");
		      out.println("아이디 :");
		      out.println(id);
		      out.println("<br> 나이 : ");
		      out.println(age);
		      out.println("<br><a href='javascript:history.go(-1)'>다시</a>");
		      out.print("</body>");
		      out.print("</html>");
		      out.close();
		   }
		   protected void doPost(HttpServletRequest request, HttpServletResponse response)
		         throws ServletException, IOException {
		      
		   }
		   
			public void destroy() {
				System.out.println("destroy 메소드 호출");
			}
	}


