package ch14;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch14.bean.Customer;

/**
 * Servlet implementation class JDBC14InsertServlet
 */
@WebServlet("/JDBC14InsertServlet")
public class JDBC14InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JDBC14InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String path="/ch14/jdbc14form.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String contactName = request.getParameter("contactName");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String postalCode = request.getParameter("postalCode");
		String country = request.getParameter("country");
//		jdbc 메소드에넘기기..!
		
//		executerJDBC(name, contactName,address, city, postalCode, country);
//		customer  객체 만들어서 적어넣기!
		Customer customer = new Customer();
		customer.setName(name);
		customer.setContactName(contactName);
		customer.setAddress(address);
		customer.setCity(city);
		customer.setPostalCode(postalCode);
		customer.setCountry(country);
		
//		executeJDBC(name,contactName, address, city, postalCode, country);
		executeJDBC(customer);
		
		doGet(request, response);
	}
	
		private void executeJDBC(Customer customer) {
				
				List<Customer> list = new ArrayList<>();
			
			String sql = "INSERT INTO Customers " + 
							"(CustomerName, ContactName, Address, City, PostalCode, Country) " + 
							"VALUES " + 
							"(?, ?, ?, ?, ?, ?)";
//			column의 갯수와 일치해서 ?도 6개 입력/
//			preparedstatement도 Connection으로부터 만들어줌.
//							"('"+customer.getName()+"', '"
//							+ ""+customer.getContactName()"', 'NY', 'NYC', '000', 'US' )";
			
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
				stmt.setString(1, customer.getName());
				stmt.setString(2, customer.getContactName());
				stmt.setString(3, customer.getAddress());
				stmt.setString(4, customer.getCity());
				stmt.setString(5, customer.getPostalCode());
				stmt.setString(6, customer.getCountry());
//				
//				insert method 사용할 땐, executeUpdate 메소드써야함. java8 api 참조
//				데이터를 insert, update, delete 는 요 메소드 쓰세요. 인티저 리턴. 인서트잘되면 1, 안되면 0 리턴.
//				데이터 조작언어.
				
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
//			return list;
		}


}
