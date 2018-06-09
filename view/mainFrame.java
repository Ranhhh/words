package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.dancibenModel;
import model.wordModel;

public class mainFrame extends JFrame {

	private JPanel contentPane;
	private JPopupMenu popupMenu;
	private String danciben;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrame frame = new mainFrame();
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
	public mainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 450);
		setTitle("我就爱背单词");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		getContentPane().setLayout(null);
		// panel.setLayout(new BorderLayout());
		this.setSize(637, 400);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("开始学习");
		btnNewButton.setBounds(19, 10, 104, 63);
		getContentPane().add(btnNewButton);
		btnNewButton.setFont(new Font("黑体", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (danciben != null) {
					cardFrame cardFrame = new cardFrame(danciben);
				}
			}
		});

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(19, 83, 97, 222);
		getContentPane().add(scrollPane_1);

		JList list = new JList(new dancibenModel());
		scrollPane_1.setViewportView(list);

		JButton btnNewButton_1 = new JButton("添加单词本");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createDanciben createdanciben = new createDanciben(list);
			}
		});
		getContentPane().add(btnNewButton_1);
		btnNewButton_1.setBounds(19, 315, 104, 35);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(147, 10, 443, 340);
		getContentPane().add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new GridLayout(0, 4, 0, 0));

		JLabel lblNewLabel_review = new JLabel("今日学习");
		lblNewLabel_review.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_review.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_review);

		JLabel lblNewLabel_new = new JLabel("复习任务");
		lblNewLabel_new.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_new.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_new);

		JLabel lblNewLabel_past = new JLabel("过往单词");
		lblNewLabel_past.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_past.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_past);

		JLabel lblNewLabel_easy = new JLabel("不再出现");
		lblNewLabel_easy.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_easy.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_easy);

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));

		JScrollPane scrollPane_reviews = new JScrollPane();
		panel_3.add(scrollPane_reviews);

		JList list_reviews = new JList();
		scrollPane_reviews.setViewportView(list_reviews);

		JScrollPane scrollPane_new = new JScrollPane();
		panel_3.add(scrollPane_new);

		JList list_new = new JList();
		scrollPane_new.setViewportView(list_new);

		JScrollPane scrollPane_past = new JScrollPane();
		panel_3.add(scrollPane_past);

		JList list_past = new JList();
		scrollPane_past.setViewportView(list_past);

		JScrollPane scrollPane_easy = new JScrollPane();
		panel_3.add(scrollPane_easy);

		JList list_easy = new JList();
		scrollPane_easy.setViewportView(list_easy);

		list.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// maybeShowPopup(e);
				Object selected = list.getModel().getElementAt(list.getSelectedIndex());
				danciben = (String) selected;
				System.out.println(danciben);
				list_reviews.setModel(new wordModel(danciben, 1));
				list_new.setModel(new wordModel(danciben, 2));
				list_past.setModel(new wordModel(danciben, 3));
				list_easy.setModel(new wordModel(danciben, 4));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				list.setSelectedIndex(list.locationToIndex(e.getPoint())); // 获取鼠标点击的项
				maybeShowPopup(e);

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				maybeShowPopup(e);
			}

			// 弹出菜单
			private void maybeShowPopup(MouseEvent e) {
				if (e.isPopupTrigger() && list.getSelectedIndex() != -1) {

					// 获取选择项的值
					Object selected = list.getModel().getElementAt(list.getSelectedIndex());
					danciben = (String) selected;
					popupMenu.show(e.getComponent(), e.getX(), e.getY());
				}
			}

		});

		popupMenu = new JPopupMenu();
		JMenuItem ifoItem = new JMenuItem("详细信息");
		JMenuItem delItem = new JMenuItem("删除");
		popupMenu.add(ifoItem); // 添加菜单项Open
		popupMenu.add(delItem);

		ActionListener actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == ifoItem) {
					wordFrame wFrame = new wordFrame(danciben);
					wFrame.setVisible(true);
				}
				if (e.getSource() == delItem) {
					new delword(list,danciben, "", 1);
				}
			}
		};
		ifoItem.addActionListener(actionListener);
		delItem.addActionListener(actionListener);

	}
}
