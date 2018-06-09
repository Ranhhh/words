package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.meansModel;
import model.wordModel;

import java.awt.CardLayout;

public class wordFrame extends JFrame {

	public JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextArea textArea;

	/**
	 * Create the frame.
	 */
	public wordFrame(String danciben) {
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 640, 450);
		setTitle("详细信息");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		getContentPane().setLayout(null);
		this.setSize(610, 400);

		textField = new JTextField();
		textField.setBounds(9, 47, 79, 23);
		getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnQ = new JButton("查询");
		btnQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String word = textField.getText();
				System.out.println(word);
				textArea.setText(new meansModel(danciben, word).getMeans());
			}
		});
		btnQ.setBounds(89, 47, 79, 25);
		getContentPane().add(btnQ);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(9, 71, 159, 280);
		getContentPane().add(scrollPane);

		JList list = new JList();
		list.setModel(new wordModel(danciben, 0));
		scrollPane.setViewportView(list);

		JButton btnNewButton = new JButton("添加单词");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addword add = new addword(list, danciben);
			}
		});
		btnNewButton.setBounds(200, 315, 86, 34);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("修改单词");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String word = textField.getText();
				changeword changeword = new changeword(textArea, danciben, word);
				textArea.setText(new meansModel(danciben, word).getMeans());
			}

		});
		btnNewButton_1.setBounds(296, 315, 98, 34);
		getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("删除单词");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String word = textField.getText();
				new delword(list, danciben, word, 0);				
			}
		});
		btnNewButton_2.setBounds(404, 315, 87, 34);
		getContentPane().add(btnNewButton_2);

		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(200, 47, 368, 258);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		getContentPane().add(textArea);

		textField_1 = new JTextField(danciben);
		textField_1.setEditable(false);
		textField_1.setBounds(10, 10, 78, 23);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JButton btnNewButton_3 = new JButton("返回");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_3.setBounds(501, 328, 73, 23);
		getContentPane().add(btnNewButton_3);

		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				// you code
				dispose();
			}
		});

		list.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// maybeShowPopup(e);
				Object selected = list.getModel().getElementAt(list.getSelectedIndex());
				String word = (String) selected;
				System.out.println(word);
				textArea.setText(new meansModel(danciben, word).getMeans());
				textField.setText(word);
			}
		});

	}

}
