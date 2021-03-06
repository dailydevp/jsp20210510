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
 * Servlet implementation class JDBC16UpdateServlet
 */
@WebServlet("/JDBC16UpdateServlet")
public class JDBC16UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JDBC16UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		Customer customer = getCustomer(id);
		
		System.out.println(customer);
		
		request.setAttribute("customer", customer);
		
		String path = "/ch14/jdbc16.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	private Customer getCustomer(int id) {
		
	Customer customer = null; //리턴할 객체
		
	String sql = "SELECT CustomerID, CustomerName, ContactName, Address, City, PostalCode, Country "
				+ " FROM Customers "
				+ " WHERE CustomerID = ?";
	
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
		stmt.setInt(1, id);
		
	
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			customer = new Customer();
			customer.setId(id);
			customer.setName(rs.getString(2));
			customer.setContactName(rs.getString(3));
			customer.setAddress(rs.getString(4));
			customer.setCity(rs.getString(5));
			customer.setPostalCode(rs.getString(6));
			customer.setCountry(rs.getString(7));
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


	return customer;
}





	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//request 파라미터 수집,
		//customer 객체 완성. input attribute same
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String contactName = request.getParameter("contactName");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String postalCode = request.getParameter("postalCode");
		String country = request.getParameter("country");
		
		Customer customer = new Customer();
		customer.setId(Integer.parseInt(id));
		customer.setName(name);
		customer.setContactName(contactName);
		customer.setAddress(address);
		customer.setCity(city);
		customer.setPostalCode(postalCode);
		customer.setCountry(country);
		
		updateCustomer(customer);
		
		doGet(request, response);
	}

	private void updateCustomer(Customer customer) {
		
		String sql =
//				" UPDATE Customers "
//				+ "    SET CustomerName = ?, "
//				+ "        ContactName = ?,"
//				+ "        Address = ?, "
//				+ "        City = ?, "
//				+ "        PostalCode = ?, "
//				+ "        Country = ? "
//				+ "    WHERE CustomerID = ? ";
				
				
				"UPDATE Customers "
					+ "		SET CustomerName = ?, "
					+ "	  		ContactName = ?, "
					+ "		   	Address = ?, "
					+ "			City = ?, "
					+ "			PostalCode = ?, "
					+ "			Country = ? "
					+ "		WHERE Customer ID = ? ";
		
		String url = "jdbc:mysql://52.79.57.117/test";
		String user = "root";
		String password = "wnddkdwjdqhcjfl1";
		
		Connection con = null;
		PreparedStatement stmt = null;
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url,user,password);
			
			//preparedstatement 생성
			stmt = con.prepareStatement(sql);
			
			// ? (parameter)에 값 할당
			stmt.setString(1, customer.getName());
			stmt.setString(2, customer.getContactName());
			stmt.setString(3, customer.getAddress());
			stmt.setString(4, customer.getCity());
			stmt.setString(5, customer.getPostalCode());
			stmt.setString(6, customer.getCountry());
			stmt.setInt(7, customer.getId());
		
			
			int cnt = stmt.executeUpdate();
			
			if(cnt == 1) {
				System.out.println("수정 성공");
			} else {
				System.out.println("수정 실패");
			}
			
			
		}catch (Exception e){
			e.printStackTrace();
		} finally {
			if (stmt !=null) {
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

	}
	
}
