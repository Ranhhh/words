package view;

import javax.swing.JPanel;
import javax.swing.JTextField;

import model.wordModel;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.Date;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;

public class cardBack2 extends JPanel implements ActionListener{
	private JTextField textField;
	private CardLayout cardLayout;
	private JPanel contentpanel;
	private cardFrame cardframe;
	/**
	 * Create the panel.
	 */
	public cardBack2(cardFrame cardframe) {
		this.cardframe=cardframe;
		setLayout(null);
		this.setSize(600, 400);
		this.cardLayout=cardframe.getCardLayout();
		this.contentpanel=cardframe.getContentPane();
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(234, 23, 119, 40);
		add(textField);
		textField.setColumns(10);
		textField.setText(cardframe.getFirstWord().getWord());
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(104, 87, 387, 205);
		add(textArea);
		textArea.setText(cardframe.getFirstWord().getMeans());
		
		JButton btnNewButton = new JButton("我不会！");
		btnNewButton.setBounds(55, 314, 92, 40);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("我见过");
		btnNewButton_1.setBounds(183, 314, 92, 40);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("差不多");
		btnNewButton_2.setBounds(312, 314, 92, 40);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("我记得");
		btnNewButton_3.setBounds(440, 314, 92, 40);
		add(btnNewButton_3);
		
		btnNewButton.addActionListener(this);
		btnNewButton_1.addActionListener(this);
		btnNewButton_2.addActionListener(this);
		btnNewButton_3.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int x=0;//此次得分
		switch (e.getSource().toString()){
			case "btnNewButton":  x=-10;break;
			case "btnNewButton_1": x=-1;break;
			case "btnNewButton_2": x=0;break;
			case "btnNewButton_3": x=1;break;
		}
		int core=cardframe.getFirstWord().getCore()+x;
		if(core<0)
			core=0;
		long addtime = 0;
		switch(core) {
		case 0:addtime=60*1;   break;//1min
		case 1:addtime=60*10;   break;//10min
		case 2:addtime=60*30;   break;//30min
		case 3:addtime=60*60;   break;//1h
		case 4:addtime=60*60*24;   break;//1day
		case 5:addtime=60*60*24*3;   break;//3day
		case 6:addtime=60*60*24*7;   break;//7day
		case 7:addtime=60*60*24*15;   break;//15day
		case 8:addtime=60*60*24*30;   break;//1month
		case 9:addtime=60*60*24*30*2;   break;//2month
		case 10:addtime=60*60*24*30*4;   break;//4month
		default:addtime=60*60*24*30*5;
		}
		Date date0=new Date();
		Timestamp date = new Timestamp(date0.getTime());
		Timestamp nextdate=new Timestamp(1000*(date0.getTime()/1000+addtime));
       
		new wordModel(cardframe.getDanciben(),cardframe.getFirstWord().getWord(),core,date,nextdate);
		
	//	cardframe.getCardLayout().show(cardframe.getContentPane(), "card");	
		cardFrame newcardframe=new cardFrame(cardframe.getDanciben());
		cardframe.dispose();
		
	}

}
