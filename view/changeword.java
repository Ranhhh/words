package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bean.Word;
import model.meansModel;
import model.wordModel;

import javax.swing.JCheckBox;

public class changeword extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JCheckBox chckbxNewCheckBox;

	public changeword(JTextArea jta, String danciben, String word) {

		this.setSize(400, 400);
		this.setContentPane(contentPanel);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("单词：");
		lblNewLabel.setBounds(38, 36, 54, 15);
		contentPanel.add(lblNewLabel);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(38, 61, 145, 21);
		textField.setText(word);
		contentPanel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("单词解释：");
		lblNewLabel_1.setBounds(38, 105, 93, 15);
		contentPanel.add(lblNewLabel_1);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(38, 130, 305, 165);
		textArea.setText(new meansModel(danciben, word).getMeans());
		contentPanel.add(textArea);

		chckbxNewCheckBox = new JCheckBox("不再出现");
		chckbxNewCheckBox.setBounds(240, 60, 103, 23);
		contentPanel.add(chckbxNewCheckBox);
		this.setVisible(true);

		JButton btnNewButton = new JButton("修改");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String word = textField.getText();
				String means = textArea.getText();
				boolean x = chckbxNewCheckBox.isSelected();
				int flag = x == true ? 1 : 0;
				new wordModel(danciben, word,means,flag);
				jta.setText(means);
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

	}

	public void close() {
		this.dispose();
	}
}
