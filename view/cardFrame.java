package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.Word;
import model.wordModel;

import java.awt.CardLayout;

public class cardFrame extends JFrame {

	private JPanel contentPane;
	private card card;
	private cardBack1 cardBack1;
	private cardBack2 cardBack2;
	private CardLayout cardLayout;
	private String danciben;

	public String getDanciben() {
		return danciben;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public CardLayout getCardLayout() {
		return cardLayout;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cardFrame frame = new cardFrame("words");
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
	public cardFrame(String danciben) {
		this.danciben = danciben;
		System.out.println(danciben);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 640, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		cardLayout = new CardLayout(0, 0);
		contentPane.setLayout(cardLayout);
		card = new card(this);
		cardBack1 = new cardBack1(this);
		cardBack2 = new cardBack2(this);
		contentPane.add(card, "card");
		contentPane.add(cardBack1, "cardBack1");
		contentPane.add(cardBack2, "cardBack2");
		if (card.getWord() != null)
			setVisible(true);
		else
			JOptionPane.showMessageDialog(this, "学完了哈哈哈", "提示", JOptionPane.INFORMATION_MESSAGE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				// you code
				dispose();
			}
		});

	}

	public Word getFirstWord() {
		Word word = new wordModel(danciben).getFirstWord();
		return word;
	}

}
