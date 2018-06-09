package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.dancibenModel;
import model.wordModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;
import java.awt.Font;

public class delword extends JDialog {


	public delword(JList list,String danciben, String word,int f) {
		setBounds(100, 100, 322, 188);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("È·ÈÏÉ¾³ýÂð£¿");
		lblNewLabel.setFont(new Font("ËÎÌå", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(73, 14, 147, 68);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("ÊÇ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(f==0) {//É¾³ýµ¥´Ê
					new wordModel(danciben, word);
					list.setModel(new wordModel(danciben,0));
				}
				else if(f==1) {//É¾³ý±í
					new dancibenModel(danciben, 1);
					list.setModel(new dancibenModel());
				}
				close();
			}
		});
		btnNewButton.setBounds(63, 93, 65, 30);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("·ñ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnNewButton_1.setBounds(172, 93, 65, 30);
		getContentPane().add(btnNewButton_1);
		setVisible(true);
	}
	public void close() {
		this.dispose();
	}
}
