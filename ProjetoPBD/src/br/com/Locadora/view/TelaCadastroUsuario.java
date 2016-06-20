package br.com.Locadora.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.SystemColor;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.Locadora.controller.UsuarioController;
import br.com.Locadora.model.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class TelaCadastroUsuario extends JFrame {

	private static final long serialVersionUID = -7442135931771402780L;

	private JPanel contentPane;
	private JPanel panelTitulo;
	private JPanel panelCentro;
	private JPanel panelRodape;
	private JLabel labelTitulo;
	private JLabel labelCodigo;
	private JLabel labelEmail;
	private JLabel labelSenha;
	private JLabel labelEmpresa;
	private JLabel labelLogin;
	private JLabel labelNome;
	private JTextField fieldCodigo;
	private JTextField fieldNome;
	private JTextField fieldEmail;
	private JTextField fieldLogin;
	private JPasswordField passFieldSenha;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxEmpresa;
	private JCheckBox chckbxAdmin;
	private JButton buttonCadastrar;
	private JButton buttonCancelar;

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


	@SuppressWarnings("rawtypes")
	public TelaCadastroUsuario() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelTitulo = new JPanel();
		panelTitulo.setBounds(0, 0, 507, 57);
		panelTitulo.setBackground(SystemColor.inactiveCaption);
		contentPane.add(panelTitulo);

		labelTitulo = new JLabel("Cadastro de Usu\u00E1rios");
		labelTitulo.setForeground(new Color(0, 0, 102));
		labelTitulo.setFont(new Font("SansSerif", Font.BOLD, 32));
		panelTitulo.add(labelTitulo);

		panelCentro = new JPanel();
		panelCentro.setBounds(33, 69, 441, 190);
		panelCentro.setBackground(SystemColor.inactiveCaption);
		contentPane.add(panelCentro);
		panelCentro.setLayout(null);

		labelEmail = new JLabel("E-mail:");
		labelEmail.setBounds(67, 82, 38, 16);
		panelCentro.add(labelEmail);
		labelEmail.setFont(new Font("SansSerif", Font.BOLD, 12));

		labelSenha = new JLabel("Senha:");
		labelSenha.setBounds(258, 58, 39, 16);
		panelCentro.add(labelSenha);
		labelSenha.setFont(new Font("SansSerif", Font.BOLD, 12));

		labelEmpresa = new JLabel("Empresa:");
		labelEmpresa.setBounds(51, 106, 54, 16);
		panelCentro.add(labelEmpresa);
		labelEmpresa.setFont(new Font("SansSerif", Font.BOLD, 12));

		comboBoxEmpresa = new JComboBox();
		comboBoxEmpresa.setBounds(109, 104, 138, 20);
		panelCentro.add(comboBoxEmpresa);

		fieldLogin = new JTextField();
		fieldLogin.setBounds(109, 56, 114, 20);
		panelCentro.add(fieldLogin);
		fieldLogin.setColumns(10);

		labelLogin = new JLabel("Nome (Login):");
		labelLogin.setBounds(27, 58, 78, 16);
		panelCentro.add(labelLogin);

		labelNome = new JLabel("Nome Completo:");
		labelNome.setBounds(12, 34, 93, 16);
		panelCentro.add(labelNome);
		labelNome.setFont(new Font("SansSerif", Font.BOLD, 12));

		fieldNome = new JTextField();
		fieldNome.setBounds(109, 32, 306, 20);
		panelCentro.add(fieldNome);
		fieldNome.setColumns(10);

		fieldEmail = new JTextField();
		fieldEmail.setBounds(109, 80, 250, 20);
		panelCentro.add(fieldEmail);
		fieldEmail.setColumns(10);

		passFieldSenha = new JPasswordField();
		passFieldSenha.setBounds(301, 56, 114, 20);
		panelCentro.add(passFieldSenha);

		chckbxAdmin = new JCheckBox("Administrador");
		chckbxAdmin.setBounds(304, 102, 112, 24);
		panelCentro.add(chckbxAdmin);

		labelCodigo = new JLabel("C\u00F3digo:");
		labelCodigo.setBounds(63, 10, 42, 16);
		panelCentro.add(labelCodigo);

		fieldCodigo = new JTextField();
		fieldCodigo.setEditable(false);
		fieldCodigo.setBounds(109, 8, 45, 20);
		panelCentro.add(fieldCodigo);
		fieldCodigo.setColumns(10);

		panelRodape = new JPanel();
		panelRodape.setBackground(SystemColor.inactiveCaption);
		panelRodape.setBounds(0, 292, 507, 17);
		contentPane.add(panelRodape);


		buttonCadastrar = new JButton("Cadastrar");
		buttonCadastrar.setForeground(new Color(0, 102, 0));
		buttonCadastrar.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonCadastrar.setBackground(new Color(204, 255, 255));
		buttonCadastrar.setBounds(93, 269, 105, 23);
		contentPane.add(buttonCadastrar);
		buttonCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validarFields()) {
					Usuario u = new Usuario();
					u.setNome(fieldNome.getText());
					u.setSenha(fieldLogin.getText());
					u.setEmail(fieldEmail.getText());
					u.setAdmin(chckbxAdmin.isSelected());
					new UsuarioController().salvar(u);
				}
			}	
		});

		buttonCancelar = new JButton("Cancelar");
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		buttonCancelar.setForeground(Color.RED);
		buttonCancelar.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonCancelar.setBackground(new Color(255, 204, 255));
		buttonCancelar.setBounds(275, 269, 105, 23);
		contentPane.add(buttonCancelar);
	}

	@SuppressWarnings("deprecation")
	private boolean validarFields(){
		if (fieldNome.getText().isEmpty()||fieldEmail.getText().isEmpty()||fieldLogin.getText().isEmpty()||passFieldSenha.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Campos Obrigatórios", null, JOptionPane.WARNING_MESSAGE);
			return false;
		}

		return true;
	}
}
