package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class loginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginFrame frame = new loginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public loginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		getContentPane().setLayout(null);
		this.setSize(600, 400);
		contentPane.setLayout(null);
		JLabel label = new JLabel("一句名人名言一句名人名言，大概这么长");
		label.setFont(new Font("华文行楷", Font.PLAIN, 18));
		label.setBounds(104, 55, 383, 21);
		getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("——名人哈哈");
		lblNewLabel.setFont(new Font("华文行楷", Font.PLAIN, 18));
		lblNewLabel.setBounds(432, 88, 134, 29);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("我就爱背单词");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(213, 98, 167, 84);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("用户名");
		lblNewLabel_2.setBounds(184, 213, 45, 15);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("登陆密码");
		lblNewLabel_3.setBounds(175, 268, 54, 15);
		getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(239, 210, 153, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(239, 265, 153, 21);
		getContentPane().add(passwordField);
		
		btnNewButton = new JButton("登录");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name=textField.getText();
				String passwd=String.valueOf(passwordField.getPassword());
				System.out.println(name+passwd);
				if(name.equals("root") && passwd.equals("1234")) {
				closeFrme();
				mainFrame frame = new mainFrame();
				frame.setVisible(true);
				}
			}
		});

		btnNewButton.setBounds(466, 316, 73, 23);
		getContentPane().add(btnNewButton);
		
		
	}
	public void closeFrme() {
		this.dispose();
	}

}
