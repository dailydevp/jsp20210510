package ch14.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ch14.bean.Customer;

public class CustomersDAO {
	public Customer getCustomer(int id) {
		
		Customer customer = null;
		
		String sql = "SELECT CustomerID,"
				+ "				CustomerName,"
				+ "				ContactName, "
				+ "				Address, "
				+ "				City, "
				+ "				PostalCode,"
				+ "				Country"
				+ "		FROM Customers "
				+ "		WHERE CustomerID = ?";
		
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
			
			if (rs.next()) {
				customer = new Customer();
				customer.setId(id);
				customer.setName(rs.getString(2));
				customer.setContactName(rs.getString(3));
				customer.setAddress(rs.getString(4));
				customer.setCity(rs.getString(5));
				customer.setPostalCode(rs.getString(6));
				customer.setCountry(rs.getString(7));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException e) {
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
		return customer;
	}

	public void updateCustomer(Customer customer) {
		
		String sql = " UPDATE Customers "
				+ "		SET CustomerName = ?, "
				+ "			ContactName = ?, "
				+ "			Address = ?,"
				+ "			City = ?,"
				+ "			PostalCode = ?,"
				+ "			Country = ? "
				+ "		WHERE CustomerID = ? ";
		
		String url = "jdbc:mysql://52.79.57.117/test";
		String user = "root";
		String password = "wnddkdwjdqhcjfl1";
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, user, password);
			
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, customer.getName());
			stmt.setString(2, customer.getContactName());
			stmt.setString(3, customer.getAddress());
			stmt.setString(4, customer.getCity());
			stmt.setString(5, customer.getPostalCode());
			stmt.setString(6, customer.getCountry());
			stmt.setInt(7, customer.getId());
			
			int cnt = stmt.executeUpdate();
			
			if (cnt == 1) {
				System.out.println("수정 성공");
			} else {
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
	
	public void deleteCustomer(int id) {
		String sql = "DELETE FROM Customers WHERE CustomerID = ?";
		
		String url = "jdbc:mysql://52.79.57.117/test";
		String user = "root";
		String password = "wnddkdwjdqhcjfl1";
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, user, password);
			
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			int cnt = stmt.executeUpdate();
			
			if (cnt == 1) {
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제 실패");
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
