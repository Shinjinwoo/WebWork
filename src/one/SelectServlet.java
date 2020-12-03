package one;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메소드 호출");
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	         throws ServletException, IOException {
	      
		String job = request.getParameter("job");
        String interests[] = request.getParameterValues("interest");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        String data = "";
        data += "<html><body>";
        data += "당신이 선택한 직업 : <b>";
        data += job;
        data += "</b><hr>당신이 선택한 관심 분야 : <b>";
        if(interests == null) {
            data += "선택한 항목이 없습니다";
        }else {
            for(String interest : interests) {
                data += interest + " ";
            }
        }
        data += "</b><br><a href='javascript:history.go(-1)'>다시입력</a>";
        data += "</body></html>";
        out.print(data);
	      
	      
	      
	   }
	   protected void doPost(HttpServletRequest request, HttpServletResponse response)
	         throws ServletException, IOException {
	      
	   }
	   
		public void destroy() {
			System.out.println("destroy 메소드 호출");
		}
}
