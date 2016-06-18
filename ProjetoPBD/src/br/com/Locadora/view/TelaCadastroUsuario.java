package br.com.Locadora.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextField;

public class TelaCadastroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroUsuario frame = new TelaCadastroUsuario();
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
	public TelaCadastroUsuario() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 507, 57);
		panel.setBackground(SystemColor.inactiveCaption);
		contentPane.add(panel);
		
		JLabel lblCadastroDeUsurios = new JLabel("Cadastro de Usu\u00E1rios");
		lblCadastroDeUsurios.setForeground(new Color(0, 0, 102));
		lblCadastroDeUsurios.setFont(new Font("SansSerif", Font.BOLD, 32));
		panel.add(lblCadastroDeUsurios);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(5, 308, 497, 1);
		panel_1.setBackground(SystemColor.inactiveCaption);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("Cadastro de Usu\u00E1rios");
		label.setBounds(83, 5, 331, 42);
		label.setForeground(new Color(0, 0, 102));
		label.setFont(new Font("SansSerif", Font.BOLD, 32));
		panel_1.add(label);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.inactiveCaption);
		panel_2.setBounds(0, 292, 507, 17);
		contentPane.add(panel_2);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNome.setBounds(10, 68, 47, 16);
		contentPane.add(lblNome);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblEmail.setBounds(10, 112, 47, 16);
		contentPane.add(lblEmail);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblSenha.setBounds(10, 156, 47, 16);
		contentPane.add(lblSenha);
		
		JLabel lblEmpresa = new JLabel("Empresa:");
		lblEmpresa.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblEmpresa.setBounds(272, 68, 63, 16);
		contentPane.add(lblEmpresa);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(345, 68, 134, 20);
		contentPane.add(comboBox);
		
		JRadioButton rdbtnAdministrador = new JRadioButton("Administrador");
		rdbtnAdministrador.setFont(new Font("SansSerif", Font.BOLD, 12));
		rdbtnAdministrador.setBounds(273, 109, 109, 23);
		contentPane.add(rdbtnAdministrador);
		
		JButton button = new JButton("Cadastrar");
		button.setForeground(new Color(0, 102, 0));
		button.setFont(new Font("SansSerif", Font.BOLD, 13));
		button.setBackground(new Color(204, 255, 255));
		button.setBounds(130, 217, 105, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Cancelar");
		button_1.setForeground(Color.RED);
		button_1.setFont(new Font("SansSerif", Font.BOLD, 13));
		button_1.setBackground(new Color(255, 204, 255));
		button_1.setBounds(277, 218, 105, 23);
		contentPane.add(button_1);
		
		textField = new JTextField();
		textField.setBounds(67, 67, 200, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(67, 111, 200, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(67, 155, 105, 20);
		contentPane.add(textField_2);
	}
}
