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
	
	
	public Connection getConn() {//��ȡ���ݿ�����
		try {
			//1.��������
			Class.forName(driver);
			//2.��ȡ����
			ct=DriverManager.getConnection(url, username, passwd);		
			System.out.println("success");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("fail");
		}			
		return ct;
	}
	
	
	public void close() {//�ر����ݿ�
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
