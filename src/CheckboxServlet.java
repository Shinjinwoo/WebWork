import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CheckboxServlet")
//매핑을 위해 필요한 작업이다.
//클래스명과 통일하는게 다른 매핑과 꼬이지 않아서 유리하다.

public class CheckboxServlet extends HttpServlet {
	//HttpServlet 클래스를 상속받음.
	private static final long serialVersionUID = 1L;
	// serialVersionUID를 지정하지 않으면 컴파일러가 계산한 값을 부여한다.
	// 그렇게 되면 컴파일러에 따라 할당되는 값이 다를 수도 있다는 뜻.
	// 컴파일러는 Serializable Class 혹은 Outer Class를 참고하여 만들기에
	// 만약 클래스에 변경이 잇다면 serialVersionUID도 변경이 있을수 있다.
       
    public CheckboxServlet() {
        super();     
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET : URL값으로 정보가 전송된다.
		// html내 form 태그의 method속성이 get일 경우 호출된다.
		// 웹브라우저의 주소창 URL을 이용하여 servlet을 요청한 경우에도 호출된다.
		// doGet 메소드는 매개변수로 HttpServletRequset와
	    // HttpServletResponse를 받는다.
		// 웹 브라우저에서 요청하면 doGet() 메소드가 호출되고
	    // Requset 객체와 Response 객체를 호출해서
		// 인자로 전달한다.
		// doGet 메소드 호출시 response.setContentType을 통해 응답방식을 결정한다.

		response.setContentType("text/html;charset=UTF-8");
		//한글 인코딩을 위해 선언하는 메서드이다.
		PrintWriter out = response.getWriter();
		//응답 스트림에 텍스트를 기록하기 위해서 호출한다.
		out.print("<html><body>");
		String items[] = request.getParameterValues("item");
		// getParameterValues 메소드를 통해 item에 있는  벨류들을 items 배열에
		// 하나씩 저장한다.
		if (items == null) {
		// items 배열에 저장된 value들이 없으면 실행되는 조건문이다.
		out.print("선택한 항목이 없습니다.");
		} else {
	    // items 배열에 저장된 value들이 널값이 아닐 경우 실행 
		out.println("당신이 선택한 항목입니다.<hr>");
		for (String item : items) {
		// 확장된 FOR문이다. items의 인덱스들을 이용한다.
		out.print(item + " ");
		}
		}
		out.println("<br><a href='javascript:history.go(-1)'>다시</a>");
		// histroy.go()
		//이전 또는 이후 페이지의 이동이 가능합니다. 사용방법은 전달할 인자에 숫자를 넣어 
		//이동하게 된다. 1 또는 -1 등을 사용하여 이전 또는 이후로 이동할 수 있다.

		out.print("</body></html>");
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
	


