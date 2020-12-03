import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ccc")

public class ThirdServlet extends HttpServlet {
	private static final long seriaVersionUID = 1L;
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("ThirdServlet init 메소드 호출");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse resp)
		throws ServletException,IOException {
		System.out.println("ThirdServlet doGet 메소드 호출");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException,IOException {
			System.out.println("ThirdServlet doGet 메소드 호출");
		}
}
	

// 애너테이션을 이용한 서블릿 매핑시는 반드시 extends HttpServlet 상속 받아야 한다.
// web.xml에 여러 서블릿 매핑 설정시 복잡해짐
// 따라서 서블릿 클래스에 직접 애너테이션으로 서블릿명을 설정하면 가독성이 좋아짐
//@WebServlet을 이용해서 서블릿 매핑을 구현함