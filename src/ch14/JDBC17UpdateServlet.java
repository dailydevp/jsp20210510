package ch14;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch14.bean.Customer;
import ch14.bean.Employee;

/**
 * Servlet implementation class JDBC17UpdateServlet
 */
@WebServlet("/JDBC17UpdateServlet")
public class JDBC17UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JDBC17UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Employee employee = getEmployee(Integer.parseInt(id));
		
		request.setAttribute("employee", employee);
		
		String path = "/ch14/jdbc17.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	private Employee getEmployee(int id) {
		
		Employee employee = null;
		
		String sql = "SELECT EmployeeID,"
				+ "          LastName,"
				+ "          FirstName, "
				+ "          Notes "
				+ "   FROM Employees "
				+ "   WHERE EmployeeID = ?";
				
//				"SELECT EmployeeID,  LastName, FirstName, Notes "
//					+ "FROM Employees "
//					+ "WHERE EmployeeID = ?";
		
		String url = "jdbc:mysql://52.79.57.117/test";
		String user = "root";
		String password = "wnddkdwjdqhcjfl1";
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, user, password);
			
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				employee = new Employee();
				employee.setId(id);
				employee.setLastName(rs.getString(2));
				employee.setFirstName(rs.getString(3));
				employee.setNotes(rs.getString(4));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmt != null) {
				try {
						stmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(con != null) {
				try {
					con.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return employee;
							
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		//request 파라미터 수집
		String id = request.getParameter("id");
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		String notes = request.getParameter("notes");
		
		//employee 객체 만들기
		Employee employee = new Employee();
		employee.setId(Integer.parseInt(id));
		employee.setLastName(lastName);
		employee.setFirstName(firstName);
		employee.setNotes(notes);
		
		updateEmployee(employee);
		
		doGet(request, response);
	}

	private void updateEmployee(Employee employee) {
		
		String sql = " UPDATE Employees "
				+ "    SET LastName = ?, "
				+ "        FirstName = ?,"
				+ "        Notes = ? "
				+ "    WHERE EmployeeID = ? ";
				
//				"UPDATE Employees "
//				+ "SET LastName = ?, "
//				+ "		FirstName = ?, "
//				+ "		Notes = ? "
//		+ "WHERE EmployeeID = ?";

		String url = "jdbc:mysql://52.79.57.117/test";
		String user = "root";
		String password = "wnddkdwjdqhcjfl1";
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, user, password);
			
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, employee.getLastName());
			stmt.setString(2, employee.getFirstName());
			stmt.setString(3, employee.getNotes());
			stmt.setInt(4, employee.getId());
			
			int cnt = stmt.executeUpdate();
			
			if (cnt == 1) {
				System.out.println("수정 성공");
			}else {
				System.out.println("수정 실패");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(stmt != null) {
				try {
						stmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(con != null) {
				try {
					con.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
