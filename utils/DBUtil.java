package utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;


public class DBUtil {
	
	Connection ct=null;
	String url="jdbc:mysql://localhost:3306/words";
	String username="root";
	String passwd="1234";
	String driver="com.mysql.jdbc.Driver";
	
	
	public Connection getConn() {//获取数据库连接
		try {
			//1.加载驱动
			Class.forName(driver);
			//2.获取连接
			ct=DriverManager.getConnection(url, username, passwd);		
			System.out.println("success");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("fail");
		}			
		return ct;
	}
	
	
	public void close() {//关闭数据库
			try {
				if(ct!=null)
					ct.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	@Test
	void TestDB() {
		getConn();
	}
}
