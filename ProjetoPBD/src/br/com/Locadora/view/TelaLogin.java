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

import java.awt.Color;
import java.awt.Toolkit;

public class TelaLogin extends JFrame{

	private static final long serialVersionUID = -7148671693491049508L;

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
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 20));
		passwordField.setBounds(219, 169, 148, 29);
		
		buttonEntrar = new JButton();
		buttonEntrar.setIcon(new ImageIcon("imagens/button.jpg"));
		buttonEntrar.setBounds(143, 221, 258, 38);
		
		contentPane.add(FieldUser);
		contentPane.add(passwordField);
		contentPane.add(buttonEntrar);
		contentPane.add(labelBackground);
		
		setVisible(true);
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
}
