package view;

import javax.swing.JPanel;
import javax.swing.JTextField;

import model.wordModel;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;

public class cardBack1 extends JPanel implements ActionListener {
	private JTextField textField;
	private CardLayout cardLayout;
	private JPanel contentpanel;
	private JButton btnNewButton, btnNewButton_1, btnNewButton_2;
	private cardFrame cardframe;
	
	/**
	 * Create the panel.
	 */
	public cardBack1(cardFrame cardframe) {
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
		textArea.setText(cardframe.getFirstWord().getMeans());
		add(textArea);
		
		btnNewButton = new JButton("我不会！");
		btnNewButton.setBounds(81, 314, 92, 40);
		add(btnNewButton);
		
		btnNewButton_1 = new JButton("还行吧");
		btnNewButton_1.setBounds(250, 314, 92, 40);
		add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("我会！");
		btnNewButton_2.setBounds(414, 314, 92, 40);
		add(btnNewButton_2);
		btnNewButton.addActionListener(this);
		btnNewButton_1.addActionListener(this);
		btnNewButton_2.addActionListener(this);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int x=0;//此次得分
		switch (e.getSource().toString()){
			case "btnNewButton":  x=0;break;
			case "btnNewButton_1": x=0;break;
			case "btnNewButton_2": x=1;break;
		}
		int core=cardframe.getFirstWord().getCore()+x;
		long addtime = 0;
		switch(core) {
		case 0:addtime=60*1;   break;//1min
		case 1:addtime=60*10;   break;//10min
		
		}
		Date date0=new Date();
		Timestamp date = new Timestamp(date0.getTime());
		Timestamp nextdate=new Timestamp(1000*(date0.getTime()/1000+addtime));
       
		new wordModel(cardframe.getDanciben(),cardframe.getFirstWord().getWord(),core,date,nextdate);
		
		//cardframe.getCardLayout().show(cardframe.getContentPane(), "card");
		cardFrame newcardframe=new cardFrame(cardframe.getDanciben());
		cardframe.dispose();
		
	}

}
