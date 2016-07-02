package br.com.Locadora.view;


import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.SystemColor;

import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.Locadora.controller.UsuarioController;
import br.com.Locadora.model.Empresa;
import br.com.Locadora.model.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;

public class TelaCadastroUsuario extends JInternalFrame {

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
	private JButton buttonSalvar;
	private JButton buttonCancelar;
	private JButton buttonExcluir;

	private UsuarioController controller;
	private JButton buttonLocalizar;
	private JButton buttonNovo;

	private boolean saveupdate;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TelaCadastroUsuario() {
		setTitle("Cadastro de Usu\u00E1rios                                                                                                            ");
		setClosable(true);
		setResizable(false);
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
		panelCentro.setBounds(31, 94, 441, 190);
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

		controller = new UsuarioController();
		List<Empresa> empresas = controller.consultaEmpresas();

		comboBoxEmpresa = new JComboBox();
		for(int i=0; i <empresas.size(); i++) {
			comboBoxEmpresa.addItem(empresas.get(i).getId()+" - "+empresas.get(i).getNome());
		}
		comboBoxEmpresa.setBounds(109, 104, 167, 20);
		comboBoxEmpresa.setEnabled(false);
		panelCentro.add(comboBoxEmpresa);

		fieldLogin = new JTextField();
		fieldLogin.setBounds(109, 56, 114, 20);
		fieldLogin.setEditable(false);
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
		fieldNome.setEditable(false);
		fieldNome.setBounds(109, 32, 306, 20);
		panelCentro.add(fieldNome);
		fieldNome.setColumns(10);

		fieldEmail = new JTextField();
		fieldEmail.setBounds(109, 80, 250, 20);
		fieldEmail.setEditable(false);
		panelCentro.add(fieldEmail);
		fieldEmail.setColumns(10);

		passFieldSenha = new JPasswordField();
		passFieldSenha.setEditable(false);
		passFieldSenha.setBounds(301, 56, 114, 20);
		panelCentro.add(passFieldSenha);

		chckbxAdmin = new JCheckBox("Administrador");
		chckbxAdmin.setEnabled(false);
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

		buttonSalvar = new JButton();
		buttonSalvar.setEnabled(false);
		buttonSalvar.setToolTipText("Gravar");
		buttonSalvar.setBounds(152, 62, 50, 26);
		contentPane.add(buttonSalvar);
		buttonSalvar.setIcon(new ImageIcon("imagens/saveButton.png"));
		buttonSalvar.setForeground(Color.BLACK);
		buttonSalvar.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonSalvar.setBackground(SystemColor.inactiveCaption);

		buttonExcluir = new JButton();
		buttonExcluir.setToolTipText("Excluir");
		buttonExcluir.setEnabled(false);
		buttonExcluir.setIcon(new ImageIcon("imagens/deleteButton.png"));
		buttonExcluir.setForeground(Color.BLACK);
		buttonExcluir.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonExcluir.setBackground(SystemColor.inactiveCaption);
		buttonExcluir.setBounds(214, 62, 50, 26);
		contentPane.add(buttonExcluir);

		buttonCancelar = new JButton();
		buttonCancelar.setToolTipText("Desfazer");
		buttonCancelar.setIcon(new ImageIcon("imagens/undoButton.png"));
		buttonCancelar.setForeground(Color.BLACK);
		buttonCancelar.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonCancelar.setBackground(SystemColor.inactiveCaption);
		buttonCancelar.setBounds(276, 62, 50, 26);
		contentPane.add(buttonCancelar);

		buttonLocalizar = new JButton();
		buttonLocalizar.setIcon(new ImageIcon("imagens/searchButton.png"));
		buttonLocalizar.setToolTipText("Localizar");
		buttonLocalizar.setForeground(Color.BLACK);
		buttonLocalizar.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonLocalizar.setBackground(SystemColor.inactiveCaption);
		buttonLocalizar.setBounds(338, 62, 50, 26);
		contentPane.add(buttonLocalizar);

		buttonNovo = new JButton();
		buttonNovo.setIcon(new ImageIcon("imagens/additionButton.png"));
		buttonNovo.setToolTipText("Novo");
		buttonNovo.setForeground(Color.BLACK);
		buttonNovo.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonNovo.setBackground(SystemColor.inactiveCaption);
		buttonNovo.setBounds(90, 62, 50, 26);
		contentPane.add(buttonNovo);

		buttonSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validarFields()) {
					Usuario u = new Usuario();
					u.setId(Integer.parseInt(fieldCodigo.getText()));
					u.setNome(fieldNome.getText());
					u.setLogin(fieldLogin.getText());
					u.setEmail(fieldEmail.getText());
					u.setAdmin(chckbxAdmin.isSelected());
					u.setSenha(new String(passFieldSenha.getPassword()));
					u.setEmpresa(Integer.parseInt(String.valueOf(comboBoxEmpresa.getSelectedItem()).substring(0, 1)));
					
					if(saveupdate){ 
						controller.insert(u); 
					}else {
						controller.update(u);
					}
					
					cleanFields();
					buttonNovo.setEnabled(true);
					buttonSalvar.setEnabled(false);
					buttonLocalizar.setEnabled(true);
					buttonExcluir.setEnabled(false);
				}
			}	
		});

		buttonExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (JOptionPane.showConfirmDialog(null, "Deseja Realmente Excluir ?", "Excluir Usuário", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==0) {
					Usuario u = new Usuario();
					u.setId(Integer.parseInt(fieldCodigo.getText()));
					u.setNome(fieldNome.getText());
					u.setLogin(fieldLogin.getText());
					u.setEmail(fieldEmail.getText());
					u.setAdmin(chckbxAdmin.isSelected());
					u.setSenha(new String(passFieldSenha.getPassword()));
					u.setEmpresa(Integer.parseInt(String.valueOf(comboBoxEmpresa.getSelectedIndex()).substring(0, 1)));
					controller.delete(u);
					cleanFields();
					buttonNovo.setEnabled(true);
					buttonExcluir.setEnabled(false);
					buttonSalvar.setEnabled(false);
				}

			}
		});

		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cleanFields();
				buttonSalvar.setEnabled(false);
				buttonNovo.setEnabled(true);
				buttonExcluir.setEnabled(false);
				buttonLocalizar.setEnabled(true);
			}
		});

		buttonLocalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ConsultaUsuario(getTela()).setVisible(true);
			}
		});

		buttonNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cleanFields();
				buttonSalvar.setEnabled(true);
				buttonExcluir.setEnabled(false);
				buttonLocalizar.setEnabled(false);
				buttonNovo.setEnabled(false);
				enableFields();
				saveupdate = true;
			}
		});

	}

	@SuppressWarnings("deprecation")
	private boolean validarFields(){
		if (fieldNome.getText().isEmpty()||fieldEmail.getText().isEmpty()||fieldLogin.getText().isEmpty()||passFieldSenha.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Campos Obrigatórios", null, JOptionPane.WARNING_MESSAGE);
			return false;
		}

		return true;
	}

	private void cleanFields(){
		fieldCodigo.setText(null);
		fieldNome.setText(null);
		fieldEmail.setText(null);
		fieldLogin.setText(null);
		passFieldSenha.setText(null);
		comboBoxEmpresa.setSelectedIndex(0);
		chckbxAdmin.setSelected(false);
		disableFields();
	}

	public void enableFields(){
		fieldNome.setEditable(true);
		fieldEmail.setEditable(true);
		fieldLogin.setEditable(true);
		passFieldSenha.setEditable(true);
		comboBoxEmpresa.setEnabled(true);
		chckbxAdmin.setEnabled(true);
	}

	public void disableFields(){
		fieldNome.setEditable(false);
		fieldEmail.setEditable(false);
		fieldLogin.setEditable(false);
		passFieldSenha.setEditable(false);
		comboBoxEmpresa.setEnabled(false);
		chckbxAdmin.setEnabled(false);
	}

	public TelaCadastroUsuario getTela(){
		return this;
	}

	public void setFields(int codigo) {
		Usuario u = controller.consultaId(codigo);
		fieldCodigo.setText(String.valueOf(u.getId()));
		fieldNome.setText(u.getNome());
		fieldLogin.setText(u.getLogin());
		fieldEmail.setText(u.getEmail());
		passFieldSenha.setText(u.getSenha());
		chckbxAdmin.setSelected(u.isAdmin());
		comboBoxEmpresa.setSelectedItem(u.getEmpresa()+" - "+controller.consultaEmpresa(u.getEmpresa()).getNome());
		buttonExcluir.setEnabled(true);
		buttonSalvar.setEnabled(true);
		buttonNovo.setEnabled(false);
		enableFields();
		saveupdate = false;
	}
	
	public void setPosicao() {
	    Dimension d = this.getDesktopPane().getSize();
	    this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); }
	}
