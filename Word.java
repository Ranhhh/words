package bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Word {
	private String word;
	private String means;
	private int time;//ѧϰ����
	private int core;//�÷�
	private Date date;//�ϴ�ѧϰʱ��
	private Date nextdate;//�´�ѧϰʱ��
	private int flag;//���ٳ���
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getMeans() {
		return means;
	}
	public void setMeans(String means) {
		this.means = means;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getCore() {
		return core;
	}
	public void setCore(int core) {
		this.core = core;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getNextdate() {
		return nextdate;
	}
	public void setNextdate(Date nextdate) {
		this.nextdate = nextdate;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public Word() {
		this.word=null;
		this.means=null;
		this.time=0;
		this.core=0;
		this.date=null;
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");    // ������д������Ҫ����ת����ʱ���ʽ
		String str = "9999-01-01 00:00:00";         // ʱ���ַ���
		try{
		this.nextdate = format.parse(str);
		}catch(Exception e){
		e.printStackTrace();
		}
		
		this.flag=0;
	}
	public Word(String word,String means){
		this.word=word;
		this.means=means;
		this.time=0;
		this.core=0;
		this.date=null;
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");    // ������д������Ҫ����ת����ʱ���ʽ
		String str = "9999-01-01 00:00:00";         // ʱ���ַ���
		try{
		this.nextdate = format.parse(str);
		}catch(Exception e){
		e.printStackTrace();
		}
		
		this.flag=0;
	}
}
