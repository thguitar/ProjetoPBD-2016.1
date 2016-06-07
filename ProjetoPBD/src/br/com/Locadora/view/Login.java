package br.com.Locadora.view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Login extends JFrame {

	private static final long serialVersionUID = -7148671693491049508L;
	
	private JPanel contentPane;
	private JLabel labelPassword;
	private JLabel labelUser;
	private JPasswordField passwordField;
	private JTextField FieldUser;
	private JButton buttonEntrar;
	
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		labelPassword = new JLabel();
		labelPassword.setIcon(new ImageIcon("imagens/password.png"));
		labelPassword.setBounds(45, 80, 69, 42);
		contentPane.add(labelPassword);
		
		labelUser = new JLabel();
		labelUser.setIcon(new ImageIcon("imagens/user.png"));
		labelUser.setBounds(62, 31, 46, 48);
		contentPane.add(labelUser);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setBounds(123, 88, 119, 27);
		contentPane.add(passwordField);
		
		FieldUser = new JTextField();
		FieldUser.setBounds(123, 52, 119, 27);
		contentPane.add(FieldUser);
		FieldUser.setColumns(10);
		
		buttonEntrar = new JButton("Entrar");
		buttonEntrar.setBounds(94, 133, 89, 23);
		contentPane.add(buttonEntrar);
		
	}

	public JLabel getLabelPassword() {
		return labelPassword;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public JTextField getFieldUser() {
		return FieldUser;
	}
}
