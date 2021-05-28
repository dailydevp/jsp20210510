package ch14;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JDBC02Servlet
 */
@WebServlet("/JDBC02Servlet")
public class JDBC02Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JDBC02Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		executeJDBC();
		response.getWriter().print("<h1>jdbc02</h1>");
	}
		
		private void executeJDBC() {

			String sql = "SELECT CustomerName, City FROM Customers WHERE CustomerID=1";
			
			String url="jdbc:mysql://52.79.57.117/test";
			String user="root";
			String password="wnddkdwjdqhcjfl1";
			
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			try {		
				//클래스 로딩
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//연결
				con = DriverManager.getConnection(url,user, password);
				
				//statement 생성
				stmt = con.createStatement();
				
				//query 실행, result(resultset) return
				rs = stmt.executeQuery(sql);
				
				//result 탐색
				if (rs.next()) {
					String name = rs.getString(1);
					String city = rs.getString(2);
					System.out.println(name);
					System.out.println(city);
				}
			
			}catch (Exception e) {
				e.printStackTrace();
			} finally {
				//연결닫기
			if(rs != null) {
				try {
					rs.close();				
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(stmt !=null) {
				try {
					stmt.close();				
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(con != null) {
				try {
					con.close();				
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
