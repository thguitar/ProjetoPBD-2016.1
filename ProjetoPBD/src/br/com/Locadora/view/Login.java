package br.com.Locadora.view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Login extends JFrame {

	private static final long serialVersionUID = -492498719433282366L;
	
	private JPanel contentPane;
	private JLabel labelUser;
	private JLabel labelSenha;
	private JTextField fieldUser;
	private JPasswordField fieldSenha;
	private JButton buttonEntrar;
	
	public Login() {
		
		setTitle("Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 356, 214);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		labelUser = new JLabel("Usuário:");
		labelUser.setFont(new Font("Dialog", Font.BOLD, 18));
		labelUser.setBounds(83, 74, 94, 15);
		contentPane.add(labelUser);
		
		labelSenha = new JLabel("Senha:");
		labelSenha.setFont(new Font("Dialog", Font.BOLD, 18));
		labelSenha.setBounds(83, 124, 70, 15);
		contentPane.add(labelSenha);
		
		fieldUser = new JTextField();
		fieldUser.setFont(new Font("Dialog", Font.PLAIN, 18));
		fieldUser.setBounds(175, 73, 94, 19);
		contentPane.add(fieldUser);
		fieldUser.setColumns(10);
		
		fieldSenha = new JPasswordField();
		fieldSenha.setFont(new Font("Dialog", Font.PLAIN, 18));
		fieldSenha.setBounds(175, 123, 94, 19);
		contentPane.add(fieldSenha);
		
		buttonEntrar = new JButton("Entrar");
		buttonEntrar.setBounds(120, 166, 117, 25);
		contentPane.add(buttonEntrar);
	}

	
	public JPanel getContentPane() {
		return contentPane;
	}

	public JLabel getLabelUser() {
		return labelUser;
	}

	public JLabel getLabelSenha() {
		return labelSenha;
	}

	public JTextField getFieldUser() {
		return fieldUser;
	}

	public JPasswordField getFieldSenha() {
		return fieldSenha;
	}

	public JButton getButtonEntrar() {
		return buttonEntrar;
	}
	
}
