import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login3")
public class login3 extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메소드 호출");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		System.out.println("아이디: "+id);
		System.out.println("비밀번호: "+pw);
		
		if (id !=null && (id.length() != 0)) {
			out.print("<html>");
			out.print("<body>");
			out.print(id + " 님 로그인 하셨습니다.");
			out.print("</body>");
			out.print("</html>");
		} else {
			
			// id가 널값일때 수행되는 문장이다.
			// 아이디를 입력하라는 문장이 뜨고
			// 지정한 주소의 페이지로 이동한다.
			
			out.print("<html>");
			out.print("<body>");
			out.print("아이디를 입력하세요 ");
			out.print("<br>");
			out.print("<a href ='http://localhost:8080/WeekHomeWork/login3.html'>");
			out.print("</body>");
			out.print("</html>");
		}

	}

	public void destroy() {
		System.out.println("destroy 메소드 호출");
	}
}