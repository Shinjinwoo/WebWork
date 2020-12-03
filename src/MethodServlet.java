import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MethodServlet")
public class MethodServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public MethodServlet() {
        super();

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.print("<html><body><h1>");
        out.print("Get방식으로 됨");
        out.print("</h1></body></html>");
        out.close();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.print("<html><body><h1>");
        out.print("Post방식으로 됨");
        out.print("</h1></body></html>");
        out.close();
    }

}
