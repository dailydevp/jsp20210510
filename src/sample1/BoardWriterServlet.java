package sample1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardWriterServlet
 */
@WebServlet("/sample1/write")
public class BoardWriterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWriterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("board writer doGet..");
		
		String path = "/WEB-INF/sample1/boardForm.jsp";
		RequestDispatcher dispatcher =request.getRequestDispatcher(path);
		dispatcher.forward(request,response);
		//dispatcher 객체를 통해 forward 시킨다. 포워드하려면 위에처럼 한다 라는 관형적? type. just remember.
		//포워드는 같은 리퀘스트 객체를 씀.
		//web-inf는 외부에서 접근 불가해서 서블릿에서 접근해야함.
		
//		PrintWriter out = response.getWriter();
//		out.print("<form>"); // 이런일은 jsp가 하는것. 여기서 하지 않는당.
//		out.print("</form>"); jsp는 web0inf안에서 처리.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//db 아직 안배워서 흉내낸것...!
		request.setCharacterEncoding("utf-8");
		ServletContext application = request.getServletContext();
		List<Board> list = (List<Board>) application.getAttribute("boards");
		
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		String writer = request.getParameter("writer");
		
		Board board = new Board();
		board.setTitle(title);
		board.setBody(body);
		board.setWriter(writer);
		
		list.add(board);
		
		response.sendRedirect(request.getContextPath()+"/sample1/list");
	}

}
