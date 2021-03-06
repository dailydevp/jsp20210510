package ch14;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch14.bean.Customer;
import ch14.bean.Employee;

/**
 * Servlet implementation class Exam1
 */
@WebServlet("/Exam1")
public class Exam1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exam1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/ch14/exam1form.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	/**
	
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response, int birthDate) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String LastName = request.getParameter("lastName");
		String FirstName = request.getParameter("firstName");
		String BirthDate = request.getParameter("birthdate");
		String Photo = request.getParameter("photo");
		String Notes = request.getParameter("notes");
		
		Employee employee = new Employee();
		employee.setLastName(LastName);
		employee.setFirstName(FirstName);
//		employee.setBirthDate(birthDate);
		employee.setPhoto(Photo);
		employee.setNotes(Notes);
		
		executeJDBC(employee);
		
		doGet(request, response);
	}
		private void executeJDBC(Employee employee) {
			
			List<Employee> list = new ArrayList<>();
		
		String sql = "INSERT INTO Employees " + 
						"(LastName, FirstName, BirthDate, Photo, Notes) " + 
						"VALUES " + 
						"(?, ?, ?, ?)";
		String url = "jdbc:mysql://52.79.57.117/test";
		String user = "root";
		String password = "wnddkdwjdqhcjfl1";
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url,user,password);
			
			//preparedstatement ??????
			stmt = con.prepareStatement(sql);
			
			// ? (parameter)??? ??? ??????
			stmt.setString(1, employee.getLastName());
			stmt.setString(2, employee.getFirstName());
//			stmt.setInt(3, employee.getBirthDate());
			stmt.setString(4, employee.getPhoto());
			stmt.setString(5, employee.getNotes());
		
			
	//		
	//		insert method ????????? ???, executeUpdate ??????????????????. java8 api ??????
	//		???????????? insert, update, delete ??? ??? ????????? ?????????. ????????? ??????. ?????????????????? 1, ????????? 0 ??????.
	//		????????? ????????????.
			
			//select??? ?????? ??????????????????????????? ????????????. while ~~~
			int cnt = stmt.executeUpdate();
			
			if(cnt == 1) {
				System.out.println("?????? ??????");
			} else {
				System.out.println("?????? ??????");
			}
			
			
		}catch (Exception e){
			e.printStackTrace();
		} finally {
			if (rs !=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(con != null) {
				try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
		//return type void ?????? ????????? ????????????.
	//	return list;
	}
	

}


