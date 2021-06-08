package sample2.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {
	private static String url;
	private static String user;
	private static String password;
	
	static {
		url = "jdbc:mysql://52.79.57.117/test2";
		user ="root";
		password="wnddkdwjdqhcjfl1";
	}
	
	public static Connection getConnection() {
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			return con;			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
//	하나 이상 여러개 가질수 잇다. : 는 향상된 for 문.
	public static void close(AutoCloseable...objs) {
		for (AutoCloseable o : objs) {
			if (o != null) {
				try {
					o.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void rollback(Connection con) {
	
		if (con != null) {
			try {
				con.rollback();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}		
	}
	
}
