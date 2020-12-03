import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/input2")
//매핑을 위해 필요한 작업이다.
//클래스명과 통일하는게 다른 매핑과 꼬이지 않아서 유리하다.

public class input2 extends HttpServlet {
	//HttpServlet 클래스를 상속받음.
	public void init() throws ServletException {
		System.out.println("init 메서드 호출");
		//서블릿 클래스의 init 메서드는 서블릿의 초기화 작업이 수행될 때 자동으로 호출되는 메서드
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse resp)
	    throws ServletException, IOException {
		// GET : URL값으로 정보가 전송된다.
		// html내 form 태그의 method속성이 get일 경우 호출된다.
		// 웹브라우저의 주소창 URL을 이용하여 servlet을 요청한 경우에도 호출된다.
		// doGet 메소드는 매개변수로 HttpServletRequset와 HttpServletResponse를 받는다.
		// 웹 브라우저에서 요청하면 doGet() 메소드가 호출되고 Requset 객체와 Response 객체를 호출해서
		// 인자로 전달한다.
		// doGet 메소드 호출시 response.setContentType을 통해 응답방식을 결정한다.
		request.setCharacterEncoding("utf-8");
		//한글 인코딩을 위해 선언하는 메서드이다.
		Enumeration enu=request.getParameterNames();
		// 전송된 데이터가 많아 일일이 name의 값을 기억하기 힘들때 이용한다.
		// getParameter() 메서드는 파라매터의 타입등을 알아야해서 불편
	
		while(enu.hasMoreElements()) {
			String name=(String)enu.nextElement();
//			hasMoreElements() 메서드는 Enumeration 의 메서드로 
//			현재 커서가 가리키는 다음 위치에도 요소가 있으면 true를 반환한다.
//			nextElement()는 커서를 다음 요소를 가리키도록 변경하고 
//			해당 위치의 요소를 반환한다.

			String []values=request.getParameterValues(name);
			for (String value : values) {
				System.out.println("name" + name + ", value=" +value);
//				html으로 전송되어온 name 속성들만 Enumeration 타입으로 받아온 후,
//				각 name을 하나씩 가져와 전송된 값을 출력한다.
			}
		}
	}
	public void destroy() {
		System.out.println("destroy 메소드 호출 ");
		//destroy 메서드는 서블릿의 마무리 작업이 수행될 때 자동으로 호출되는 메서드 이다
	}

}
