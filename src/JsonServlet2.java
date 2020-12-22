

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet("/json2")
public class JsonServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();

		JSONObject totalObject = new JSONObject();
		JSONArray membersArray = new JSONArray();
		JSONObject memberInfo = new JSONObject();
		
		// Json 오브젝트인 total과 memberInfo를 생성
		// Json 배열인 memberArray를 생성

		memberInfo.put("name", "박지성");
		memberInfo.put("age", "25");
		memberInfo.put("gender", "남자");
		memberInfo.put("nickname", "날쌘돌이");
        
		//memberInfo 오브젝트에  데이터 삽입
		
		membersArray.add(memberInfo);
		
		//Json 배열인 memberArray에 오브젝트를 삽입.

		memberInfo = new JSONObject();
		memberInfo.put("name", "김연아");
		memberInfo.put("age", "21");
		memberInfo.put("gender", "여자");
		memberInfo.put("nickname", "칼치");
		//memberInfo 오브젝트에 json 형식으로 데이터 삽입
		membersArray.add(memberInfo);
		//Json 배열인 memberArray에 오브젝트를 삽입.

		totalObject.put("members", membersArray);
		// 전체 오브젝트를 의미하는 jsonObject인 totalObject에 멤버스라는 이름으로
		// memberArray를 값으로 삽입
		
		String jsonInfo = totalObject.toJSONString();
		//만들어둔 JSON 객체를 문자열 데이터로 변경할때는 toJSONString() 메서드를 사용
		
		System.out.print(jsonInfo);
		//콘솔창에 jsoninfo를 출력
		writer.print(jsonInfo);
		//브라우저에 jsonInfo 출력
	}

}
