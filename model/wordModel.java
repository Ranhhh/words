package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.AbstractListModel;

import bean.Word;
import utils.DBUtil;

public class wordModel extends AbstractListModel {
	private Word firstWord;	
	public Word getFirstWord() {
		return firstWord;
	}

	Vector words = new Vector<>();

	Connection ct = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public String sql = "";

	public wordModel(String danciben, Word newword) {//向danciben中添加 Word
		Date date = new Date();

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss"); // 这里填写的是想要进行转换的时间格式
		String str1 = "2000-01-01 00:00:00"; // date
		try {
			date = format.parse(str1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Timestamp timeStamep = new Timestamp(date.getTime());

		String str2 = "9999-01-01 00:00:00"; // nextdate
		try {
			date = format.parse(str2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Timestamp timeStamep2 = new Timestamp(date.getTime());
		if (sql.equals("")) {
			sql = "insert into " + danciben + " values(?,?,?,?,?,?,?)";
		}
		try {
			DBUtil db = new DBUtil();
			ct = db.getConn();
			ps = ct.prepareStatement(sql);
			ps.setString(1, newword.getWord());
			ps.setString(2, newword.getMeans());
			ps.setInt(3, 0);
			ps.setInt(4, 0);
			ps.setTimestamp(5, timeStamep);
			ps.setTimestamp(6, timeStamep2);
			ps.setInt(7, 0);
			int num = ps.executeUpdate();
			if (num > 0) {
				System.out.println("插入成功");
			} else {
				System.out.println("插入失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.close();

	}

	public wordModel(String danciben, String word, String means,int flag) { //修改 Word
		try {
			DBUtil db = new DBUtil();
			ct = db.getConn();
			sql = "update " + danciben + " set means=?,flag=? where word=?";
			ps = ct.prepareStatement(sql);
			ps.setString(1, means);
			ps.setInt(2, flag);
			ps.setString(3, word);

			int num = ps.executeUpdate();
			if (num > 0) {
				System.out.println("修改成功");
			} else {
				System.out.println("修改失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.close();
	}
	
	public wordModel(String danciben, String word, int core,Timestamp date,Timestamp nextdate) { //修改 card word
		try {
			DBUtil db = new DBUtil();
			ct = db.getConn();
			sql = "update " + danciben + " set core=? ,time=time+1 , date=?, nextdate=? where word=?";
			ps = ct.prepareStatement(sql);
			ps.setInt(1, core);
			ps.setTimestamp(2, date);
			ps.setTimestamp(3, nextdate);
			ps.setString(4, word);
			int num = ps.executeUpdate();
			if (num > 0) {
				System.out.println("修改成功");
			} else {
				System.out.println("修改失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.close();
	}

	public wordModel(String dancibenNames, int flag) {//查询danciben中四种单词
		if (sql.equals("")) {
			if (flag == 0) // 所有单词
				sql = "select word from " + dancibenNames;
			else if (flag == 1) { // 今日学习
				sql = "select word from " + dancibenNames + " where to_days(date) = to_days(now())";
				System.out.println(sql);
			} else if (flag == 2) { // 复习任务
				sql = "select word from " + dancibenNames + " where to_days(nextdate) <= to_days(now())";
			} else if (flag == 3) { // 过往单词
				sql = "select word from " + dancibenNames + " where time>1";
			} else if (flag == 4) {
				sql = "select word from " + dancibenNames + " where flag=1";// 此处的flag=1是表示不再出现
			}
		}
		try {
			DBUtil db = new DBUtil();
			ct = db.getConn();
			ps = ct.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				String s = rs.getString(1);
				words.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.close();

	}
	
	public wordModel(String dancibenNames, String word) {//删除danciben表中 单词word记录
		try {
			sql = "delete from " + dancibenNames + " where word=?";// 
			
			DBUtil db = new DBUtil();
			ct = db.getConn();
			ps = ct.prepareStatement(sql);
			ps.setString(1, word);
			System.out.println(sql);
			int num=ps.executeUpdate();
			if(num>0) {
				System.out.println("删除成功");
			}else {
				System.out.println("删除失败");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.close();

	}

	public wordModel(String danciben) {
		firstWord=new Word();
		try {
			DBUtil db = new DBUtil();
			ct = db.getConn();
			sql="select * from "+danciben+" where nextdate<CURTIME() or time=0 ORDER BY nextdate ASC limit 0,1";	
			ps = ct.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				firstWord.setWord(rs.getString(1));
				firstWord.setMeans(rs.getString(2));
				firstWord.setTime(rs.getInt(3));
				firstWord.setCore(rs.getInt(4));
				firstWord.setDate(rs.getTimestamp(5));
				firstWord.setNextdate(rs.getTimestamp(6));
				firstWord.setFlag(rs.getInt(7));
								
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

	@Override
	public Object getElementAt(int arg0) {
		// TODO Auto-generated method stub
		return this.words.get(arg0);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return this.words.size();
	}

}
