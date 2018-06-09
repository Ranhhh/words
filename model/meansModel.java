package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.DBUtil;

public class meansModel {
	private String means="";
	public String getMeans() {
		if(means=="")
			means="这个真没有";
		return means;
	}


	Connection ct = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public String sql = "";

	public meansModel(String danciben, String word) {
		try {
			DBUtil db = new DBUtil();
			ct = db.getConn();
			sql="select means from "+danciben+" where word=?";	
			ps = ct.prepareStatement(sql);
			ps.setString(1, word);
			rs = ps.executeQuery();
			while (rs.next()) {
				means= rs.getString(1);
				System.out.println(means);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.close();

	}
	
	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (ct != null)
				ct.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
