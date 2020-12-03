import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

	@WebServlet("/input")
	public class input extends HttpServlet {
	    private static final long serialVersionUID = 1L;
	    
	    String[] sb;
	 
	    public input() {
	        super();

	    }

	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	         request.setCharacterEncoding("UTF-8");
	         String id = request.getParameter("user_id");
	         String pw = request.getParameter("user_pw");
	         
	         String[] sb = request.getParameterValues("subject");
	         
	         response.setContentType("text/html; charset=UTF-8");
             PrintWriter out = response.getWriter();
	         out.println("아이디  : "+id + "<br>");
	         out.println("비밀번호  : "+pw + "<br>");
	         for(int i = 0; i < sb.length; i++) {
	        	 out.println(sb[i]+",");
	         }
	    }

	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	    }

	}
	
