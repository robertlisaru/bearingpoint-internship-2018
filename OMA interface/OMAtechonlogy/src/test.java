import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class test {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		
		frame.setBounds(100, 100, 1022, 721);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1016, 686);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Laurentiu\\Desktop\\Logo.png"));
		label.setBounds(342, 90, 300, 300);
		panel.add(label);
		
		textField = new JTextField();
		textField.setBounds(595, 398, 211, 45);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblUsername.setBounds(230, 393, 171, 45);
		panel.add(lblUsername);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(595, 471, 211, 45);
		panel.add(passwordField);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(230, 471, 171, 38);
		panel.add(lblPassword);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(654, 567, 154, 58);
		panel.add(btnNewButton);
		
		JButton btnDismiss = new JButton("Exit");
		btnDismiss.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDismiss.setBounds(230, 567, 132, 58);
		panel.add(btnDismiss);
		
	}
}
