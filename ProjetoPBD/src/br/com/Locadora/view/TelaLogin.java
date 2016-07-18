package br.com.Locadora.view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import br.com.Locadora.model.FixedLengthJTextField;

import java.awt.Color;
import java.awt.Toolkit;

public class TelaLogin extends JFrame{

	private static final long serialVersionUID = -7148671693491049508L;
	public static final int ERROR_CONNECT_DB = 1;
	public static final int LOGIN_INVALID = 2;
	public static final int FIELDS_EMPTY = 3;
	
	private JPanel contentPane;
	private JLabel labelBackground;
	private JPasswordField passwordField;
	private JTextField FieldUser;
	private JButton buttonEntrar;

	
	public TelaLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagens/iconlogin.png"));
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(534, 318);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		labelBackground = new JLabel();
		labelBackground.setIcon(new ImageIcon("imagens/login.png"));
		labelBackground.setBounds(0, 0, 528, 290);

		FieldUser = new JTextField();
		FieldUser.setForeground(Color.DARK_GRAY);
		FieldUser.setBackground(Color.WHITE);
		FieldUser.setFont(new Font("Tahoma", Font.BOLD, 20));
		FieldUser.setToolTipText("Usu\u00E1rio");
		FieldUser.setBounds(219, 88, 148, 29);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Senha");
		passwordField.setDocument(new FixedLengthJTextField(6));
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 20));
		passwordField.setBounds(219, 169, 148, 29);
		
		buttonEntrar = new JButton();
		buttonEntrar.setIcon(new ImageIcon("imagens/button.jpg"));
		buttonEntrar.setBounds(143, 221, 258, 38);
		
		contentPane.add(FieldUser);
		contentPane.add(passwordField);
		contentPane.add(buttonEntrar);
		contentPane.add(labelBackground);
		
		//setVisible(true);
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public JTextField getFieldUser() {
		return FieldUser;
	}

	public JButton getButtonEntrar() {
		return buttonEntrar;
	}
	
	public void showMensseger(int typeMenssage){
		switch (typeMenssage) {
		case ERROR_CONNECT_DB:{JOptionPane.showMessageDialog(null, "Erro ao Connectar o Banco de Dados.\n        O Sistema será Finalizado\n","Erro de Conexão",JOptionPane.ERROR_MESSAGE);} break;
		case LOGIN_INVALID:{JOptionPane.showMessageDialog(null, "Login Inv\u00E1lido",null ,JOptionPane.WARNING_MESSAGE);}break;
		case FIELDS_EMPTY:{JOptionPane.showMessageDialog(null,"Campos Obrigat\u00F3rios",null,JOptionPane.INFORMATION_MESSAGE);} break;
		}
	}
}
