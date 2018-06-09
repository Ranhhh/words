package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.AbstractListModel;

import com.mysql.jdbc.Statement;

import utils.DBUtil;

public class dancibenModel extends AbstractListModel{
//	Vector<Vector<String>> Names=new Vector<Vector<String>>();
	Vector dancibenNames = new Vector<>();

	Connection ct = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	java.sql.Statement stmt=null;
	public String sql = "";
	public dancibenModel() {
		System.out.println("新的单词表list");
		if(sql.equals("")) {
			sql="show tables";
		}		
		try {
			DBUtil db=new DBUtil();
			ct=db.getConn();			
			ps=ct.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				String s=rs.getString(1);
				System.out.println(s);
				dancibenNames.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.close();
	}
	
	public dancibenModel(String danciben,int f) {
		if(f==0) {//创建表
			sql="create table "+danciben+" (word varchar(255) NOT  NULL,means text,time int(11) NOT NULL," + 
					" core int(11) NOT NULL," + 
					" date datetime," + 
					" nextdate datetime," + 
					" flag int," + 
					" PRIMARY KEY (word)" + 
					" );";
		}
		else if(f==1) {//删除表
			sql="DROP TABLE "+danciben;
		}
		System.out.println(sql);
		try {
			DBUtil db=new DBUtil();
			ct=db.getConn();
			stmt = ct.createStatement();
			stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.close();
	}
	
	public void close() {
		try {
			if(rs!=null)
			rs.close();
			if(ps!=null)
				ps.close();
			if(ct!=null)
				ct.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

	@Override
	public Object getElementAt(int arg0) {
		// TODO Auto-generated method stub
		return this.dancibenNames.get(arg0);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return this.dancibenNames.size();
	}
	
}
