package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*@WebServlet("/board/listArticle.do")*/
public class BoardController extends HttpServlet {
	private static String ARTICLE_IMAGE_REPO = "C:\\board\\article_image";
	
	private static final long serialVersionUID = 1L;
	BoardService boardService;
	ArticleVO articleVO;

	public void init(ServletConfig config) throws ServletException {
		boardService = new BoardService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		//포워딩할 객체 nextPage 생성
		String nextPage = "";
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		// 클라리언트가 request를 보낼 때의 URL 관련된 부가적인 경로 정보를 리턴한다. 부가적인 경로 정보는 서블릿 경로
		// 요청명을 가져옴 고로 /board/listArticle.do를 가져오면서 else if문으로 접속이 가능하게 한다.
		// /board/*을 하면 부가적인 경로를 가져오지 못한다. (조건문에서 따로 처리를 해주지 않앗기 때문 )
		// * 는 null 이 아니므로 어노테이션 명을 @WebServlet("/board/listArticle.do")
		// 처리해야만 조건문으로 들어가진다는 의미이다 만약 *을  조건문에서 캐치하려면 'action.equals("/*")' 방식으로 써줘야 한다
		// 그러나 이 방식으로 처리한다면 다른 MVC 기능을 구현할때 액션값이 다른값이 들어와도 
		// 조회기능만 돌아가므로 else문으로 처리를 해주는게 옳바른 방법으로 사료된다.
		
		String action = request.getPathInfo();
		System.out.println("action:" + action);
		
		try {
			List<ArticleVO> articlesList = new ArrayList<ArticleVO>();
			if (action == null) {
				articlesList = boardService.listArticles();
				request.setAttribute("articlesList", articlesList);
				nextPage = "/1222/listArticles.jsp";
				
			} else if (action.equals("/listArticles.do")) {
				articlesList = boardService.listArticles();
				request.setAttribute("articlesList", articlesList);
				nextPage = "/1222/listArticles.jsp";
				
			} 
			
			
			
			
			
			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
			dispatch.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
