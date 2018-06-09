package view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bean.Word;
import model.wordModel;

import javax.swing.JTextArea;



public class addword extends JDialog  {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	// 定义我需要的swing组件

	public addword(JList list, String danciben) {
	//	super(owner, title, modal);

		// 展现
		this.setSize(400, 400);
		this.setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("单词：");
		lblNewLabel.setBounds(38, 36, 54, 15);
		contentPanel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(38, 61, 145, 21);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("单词解释：");
		lblNewLabel_1.setBounds(38, 105, 93, 15);
		contentPanel.add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(38, 130, 305, 165);
		contentPanel.add(textArea);
		
		JButton btnNewButton = new JButton("添加");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String word=textField.getText();
				String means=textArea.getText();
				Word newword=new Word(word, means);
				new wordModel(danciben,newword);
				list.setModel(new wordModel(danciben, 0));
				close();
			}
		});
		btnNewButton.setBounds(48, 313, 83, 23);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnNewButton_1.setBounds(208, 313, 83, 23);
		contentPanel.add(btnNewButton_1);
		this.setVisible(true);
	}
	public void close() {
		this.dispose();
	}


}
