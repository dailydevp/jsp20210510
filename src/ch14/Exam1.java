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
			
			//preparedstatement 생성
			stmt = con.prepareStatement(sql);
			
			// ? (parameter)에 값 할당
			stmt.setString(1, employee.getLastName());
			stmt.setString(2, employee.getFirstName());
//			stmt.setInt(3, employee.getBirthDate());
			stmt.setString(4, employee.getPhoto());
			stmt.setString(5, employee.getNotes());
		
			
	//		
	//		insert method 사용할 땐, executeUpdate 메소드써야함. java8 api 참조
	//		데이터를 insert, update, delete 는 요 메소드 쓰세요. 인티저 리턴. 인서트잘되면 1, 안되면 0 리턴.
	//		데이터 조작언어.
			
			//select로 답을 얻어오는게아니라서 필요없음. while ~~~
			int cnt = stmt.executeUpdate();
			
			if(cnt == 1) {
				System.out.println("입력 성공");
			} else {
				System.out.println("입력 실패");
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
		//return type void 니까 이것도 필요없음.
	//	return list;
	}
	

}


