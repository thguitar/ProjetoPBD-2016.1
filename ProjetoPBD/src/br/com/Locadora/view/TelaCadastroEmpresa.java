package br.com.Locadora.view;


import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.SystemColor;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.Locadora.controller.EmpresaController;
import br.com.Locadora.model.Empresa;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JCheckBox;

public class TelaCadastroEmpresa extends JInternalFrame {


	private static final long serialVersionUID = 3691713444891118750L;

	private JPanel contentPane;
	private JPanel panelTitulo;
	private JPanel panelCentro;
	private JPanel panelRodape;
	private JLabel labelTitulo;
	private JLabel labelCodigo;
	private JLabel labelBairro;
	private JLabel labelCidade;
	private JLabel labelEmpresa;
	private JLabel labelRua;
	private JLabel labelNumero;
	private JLabel labelNome;
	private JTextField fieldCodigo;
	private JTextField fieldNome;
	private JTextField fieldBairro;
	private JTextField fieldRua;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxEstado;
	private JCheckBox chckbxFilial;
	private JButton buttonCadastrar;
	private JButton buttonCancelar;

	private JTextField fieldCidade;
	private JTextField fieldNumero;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TelaCadastroEmpresa() {
		setTitle("Cadastro de Empresas                                                                                                          ");
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

		labelTitulo = new JLabel("Cadastro de Empresas");
		labelTitulo.setForeground(new Color(0, 0, 102));
		labelTitulo.setFont(new Font("SansSerif", Font.BOLD, 32));
		panelTitulo.add(labelTitulo);

		panelCentro = new JPanel();
		panelCentro.setBounds(33, 69, 441, 190);
		panelCentro.setBackground(SystemColor.inactiveCaption);
		contentPane.add(panelCentro);
		panelCentro.setLayout(null);

		labelBairro = new JLabel("Bairro :");
		labelBairro.setBounds(13, 87, 41, 16);
		panelCentro.add(labelBairro);
		labelBairro.setFont(new Font("SansSerif", Font.BOLD, 12));

		labelCidade = new JLabel("Cidade :");
		labelCidade.setBounds(221, 111, 45, 16);
		panelCentro.add(labelCidade);
		labelCidade.setFont(new Font("SansSerif", Font.BOLD, 12));

		labelEmpresa = new JLabel("Estado :");
		labelEmpresa.setBounds(9, 111, 45, 16);
		panelCentro.add(labelEmpresa);
		labelEmpresa.setFont(new Font("SansSerif", Font.BOLD, 12));

		comboBoxEstado = new JComboBox();
		comboBoxEstado.setModel(new DefaultComboBoxModel(new String[] {"ACRE (AC)", "ALAGOAS (AL)", "AMAP\u00C1 (AP)", "AMAZONAS (AM)", "BAHIA (BA)", "CEAR\u00C1 (CE)", "DISTRITO FEDERAL (DF)", "ESP\u00CDRITO SANTO (ES)", "GOI\u00C1S (GO)", "MARANH\u00C3O (MA)", "MATO GROSSO (MT)", "MATO GROSSO DO SUL (MS)", "MINAS GERAIS (MG)", "PAR\u00C1(PA) ", "PARA\u00CDBA (PB)", "PARAN\u00C1 (PR)", "PERNAMBUCO (PE)", "PIAU\u00CD (PI)", "RIO DE JANEIRO (RJ)", "RIO GRANDE DO NORTE (RN)", "RIO GRANDE DO SUL (RS)", "ROND\u00D4NIA (RO)", "RORAIMA (RR)", "SANTA CATARINA (SC)", "S\u00C3O PAULO (SP)", "SERGIPE (SE)", "TOCANTINS (TO)"}));
		comboBoxEstado.setBounds(58, 109, 147, 20);
		panelCentro.add(comboBoxEstado);

		fieldRua = new JTextField();
		fieldRua.setBounds(58, 61, 306, 20);
		panelCentro.add(fieldRua);
		fieldRua.setColumns(10);

		labelRua = new JLabel("Rua :");
		labelRua.setBounds(26, 63, 28, 16);
		panelCentro.add(labelRua);

		labelNome = new JLabel("Nome :");
		labelNome.setBounds(15, 39, 39, 16);
		panelCentro.add(labelNome);
		labelNome.setFont(new Font("SansSerif", Font.BOLD, 12));

		fieldNome = new JTextField();
		fieldNome.setBounds(58, 37, 306, 20);
		panelCentro.add(fieldNome);
		fieldNome.setColumns(10);

		fieldBairro = new JTextField();
		fieldBairro.setBounds(58, 85, 147, 20);
		panelCentro.add(fieldBairro);
		fieldBairro.setColumns(10);

		chckbxFilial = new JCheckBox("Filial");
		chckbxFilial.setBounds(314, 5, 50, 24);
		panelCentro.add(chckbxFilial);

		labelCodigo = new JLabel("C\u00F3digo:");
		labelCodigo.setBounds(12, 15, 42, 16);
		panelCentro.add(labelCodigo);

		fieldCodigo = new JTextField();
		fieldCodigo.setEditable(false);
		fieldCodigo.setBounds(58, 13, 45, 20);
		panelCentro.add(fieldCodigo);
		fieldCodigo.setColumns(10);
		
		fieldCidade = new JTextField();
		fieldCidade.setBounds(270, 109, 161, 20);
		panelCentro.add(fieldCidade);
		fieldCidade.setColumns(10);
		
		labelNumero = new JLabel("N\u00FAmero :");
		labelNumero.setBounds(215, 87, 51, 16);
		panelCentro.add(labelNumero);
		
		fieldNumero = new JTextField();
		fieldNumero.setBounds(270, 85, 51, 20);
		panelCentro.add(fieldNumero);
		fieldNumero.setColumns(10);

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
					Empresa emp = new Empresa();
					emp.setNome(fieldNome.getText());
					emp.setEndBairro(fieldBairro.getText());
					emp.setEndRua(fieldRua.getText());
					emp.setFilial(chckbxFilial.isSelected());
					emp.setEndCidade(fieldCidade.getText());
					emp.setEndNumero(fieldNumero.getText());
					emp.setEndEstado((String) comboBoxEstado.getSelectedItem());
					new EmpresaController().salvar(emp);
					cleanFields();
				}
			}	
		});

		buttonCancelar = new JButton("Cancelar");
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cleanFields();
			}
		});
		buttonCancelar.setForeground(Color.RED);
		buttonCancelar.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonCancelar.setBackground(new Color(255, 204, 255));
		buttonCancelar.setBounds(275, 269, 105, 23);
		contentPane.add(buttonCancelar);
		
		setVisible(true);
	}

	private boolean validarFields(){
		if (fieldNome.getText().isEmpty()||fieldBairro.getText().isEmpty()||fieldRua.getText().isEmpty()||fieldCidade.getText().isEmpty()||fieldNumero.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Campos Obrigatórios", null, JOptionPane.WARNING_MESSAGE);
			return false;
		}

		return true;
	}
	
	public void cleanFields(){
		fieldNome.setText("");
		fieldBairro.setText("");
		fieldRua.setText("");
		chckbxFilial.setSelected(false);
		fieldCidade.setText("");
		fieldNumero.setText("");
		comboBoxEstado.setSelectedIndex(0);
	}
}
