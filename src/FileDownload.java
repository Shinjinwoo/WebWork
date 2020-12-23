import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*@WebServlet("/download.do")*/
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FileDownload() {
		super();
	}

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

		String file_repo = "D:\\file_repo";
		// 파일 경로 받음
		String fileName = (String) request.getParameter("fileName");
		// 파일 네임을 불러와서 넣음
		System.out.println("fileName=" + fileName);
		// 파일명을 콘솔창에 띄움
		OutputStream out = response.getOutputStream();
		// 바이트단위를 출력하기위한 객체를 생성해줌
		String downFile = file_repo + "\\" + fileName;
		// 다운로드 파일 경로 넣어줌
		File f = new File(downFile);
		// 다운로드 받는 파일 객체
		response.setHeader("Cache-Control", "no-cache");
		// Cache-Control 헤더의 값을 no-cache로 지정함
		response.addHeader("Content-disposition", "attachment; fileName=" + fileName);
		// Content-disposition 헤더의 값을 attachment; fileName=" + fileName 로 지정함
		FileInputStream in = new FileInputStream(f);
		// 파일을 읽어내는 객체 생성
		byte[] buffer = new byte[1024 * 8];
		// 바이트 크기 설정
		while (true) {
			int count = in.read(buffer);
			// 파일을 읽어내줌
			if (count == -1) {
				break;
			}
			out.write(buffer, 0, count);
			// 안에내용 출력
		}
		in.close();
		out.close();
	}
}
