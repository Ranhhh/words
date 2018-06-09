package view;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class card extends JPanel {
	private JTextField textField;
	private CardLayout cardLayout;
	private JPanel contentpanel;
	private String word;

	public String getWord() {
		return word;
	}

	/**
	 * Create the panel.
	 */
	public card(cardFrame cardframe) {
		setLayout(null);
		this.setSize(600, 400);
		this.cardLayout = cardframe.getCardLayout();
		this.contentpanel = cardframe.getContentPane();
		textField = new JTextField();
		textField.setFont(new Font("ËÎÌå", Font.PLAIN, 18));
		textField.setEditable(false);
		textField.setBounds(223, 114, 147, 42);
		add(textField);
		textField.setColumns(10);
		word=cardframe.getFirstWord().getWord();
		textField.setText(word);
		

		JButton btnNewButton = new JButton("·­Ò³");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cardframe.getFirstWord().getTime() == 0)
					cardLayout.show(contentpanel, "cardBack1");
				else
					cardLayout.show(contentpanel, "cardBack2");
			}
		});
		btnNewButton.setBounds(252, 319, 93, 23);
		add(btnNewButton);

	}

}
