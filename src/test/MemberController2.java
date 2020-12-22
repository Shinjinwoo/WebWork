package test;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/*")
public class MemberController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDAO2 memberDAO;

	public void init() throws ServletException {
		memberDAO = new MemberDAO2();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = null;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// URL에 요청을 가져옴
		String action = request.getPathInfo();
		System.out.println("action:" + action);
		if (action == null || action.equals("/listMembers.do")) {
			List<MemberVO> membersList = memberDAO.listMembers();
			request.setAttribute("membersList", membersList);
			
			nextPage = "/1222/listMembers.jsp";
			//listMember.jsp로 포워딩
			
		} else if (action.equals("/addMember.do")) {
			//action 값이 /addMember.do면 전송된 정보를 가져와서 테이블에 추가
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			MemberVO memberVO = new MemberVO(id, pwd, name, email);
			memberDAO.addMember(memberVO);
			//회원 등록 후 다시 회원 목록을 추가한다.
			request.setAttribute("msg", "addMember");
			nextPage = "/member/listMembers.do";

		} else if (action.equals("/memberForm.do")) {
			//action 값이 /memberForm.do면 회원 가입 창을 화면에 출력
			nextPage = "/1222/memberForm.jsp";
			
		} else if (action.equals("/modMemberForm.do")) {
			// 액션값이 modMemberForm.do 이면 실행하는 조건문이다.
			// 회원정보 수정을 담당하는 조건문
			String id = request.getParameter("id");
			// 파라매터로 아이디를 받아서
			MemberVO memInfo = memberDAO.findMember(id);
			// 아이디를 파라매터로 DAO에서 특정 아이디만 조회하는 메소드로 넘어감
			// memInfo에 저장
			request.setAttribute("memInfo", memInfo);
			// 셋 에트리뷰트를 통해 id를 기반을 특정 회원에 대한 정보를
			// modMemberForm.jsp에 전송후 이동
			nextPage = "/1222/modMemberForm.jsp";
			
		} else if (action.equals("/modMember.do")){
			// modMember.do로 액션값이 넘어옴 
			// modMembersForm.jsp에서 수정을 완료한 정보를 파라매터로 변수로 받아옴
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			MemberVO memberVO = new MemberVO(id,pwd,name,email);
			//맴버 VO에 수정된 회원정보를 다시 게터 세터로 이용해 저장함.
			memberDAO.modMember(memberVO);
			//meberDAO 클래스에 modMember 메소드를 호출해서 VO를 저장함
			request.setAttribute("msg", "modified");
			// msg를 modified로 셋 에트리 뷰트
			// listMembers.do로 초기화면인 memberForm.jsp로 넘어감
			nextPage="/member/listMembers.do";
					
		} else if (action.equals("/delMember.do")) {
			// delMember.do 액션값을 가지면 
			String id = request.getParameter("id");
			// 아이디를 파라매터로 가져와서 
			memberDAO.delMember(id);
			// 멤버 DAO에 delMember 메소드를 통해 회원정볼르 삭제한다.
			request.setAttribute("msg", "deleted");
			// 그 후 속성의 이름을 msg로 값을 deleted로 메시지 전송
			nextPage="/member/listMembers.do";
			// 초기 페이지로
			
		}
		
		else {
			List<MemberVO> membersList = memberDAO.listMembers();
			request.setAttribute("membersList", membersList);
			nextPage = "/1222/listMembers.jsp";
		}
		//nextPage에 지정한 요청명으로 서블릿에 요청한다.
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	}
}