package br.com.Locadora.view;


import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.SystemColor;

import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.Locadora.controller.EmpresaController;
import br.com.Locadora.model.Empresa;
import br.com.Locadora.model.FixedLengthJTextField;

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
	private JTextField fieldCidade;
	private JTextField fieldNumero;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxEstado;
	private JCheckBox chckbxFilial;
	private JButton buttonSalvar;
	private JButton buttonCancelar;
	private JButton buttonExcluir;
	private JButton buttonLocalizar;
	private JButton buttonNovo;

	private boolean saveupdate;
	
	private EmpresaController empresaController;
	
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

		empresaController = new EmpresaController();
		
		panelTitulo = new JPanel();
		panelTitulo.setBounds(0, 0, 507, 57);
		panelTitulo.setBackground(SystemColor.inactiveCaption);
		contentPane.add(panelTitulo);

		labelTitulo = new JLabel("Cadastro de Empresas");
		labelTitulo.setForeground(new Color(0, 0, 102));
		labelTitulo.setFont(new Font("SansSerif", Font.BOLD, 32));
		panelTitulo.add(labelTitulo);

		panelCentro = new JPanel();
		panelCentro.setBounds(33, 104, 441, 165);
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
		comboBoxEstado.setModel(new DefaultComboBoxModel(new String[] {"ACRE", "ALAGOAS", "AMAP\u00C1", "AMAZONAS", "BAHIA", "CEAR\u00C1", "DISTRITO FEDERAL", "ESP\u00CDRITO SANTO", "GOI\u00C1S", "MARANH\u00C3O", "MATO GROSSO", "MATO GROSSO DO SUL", "MINAS GERAIS", "PAR\u00C1 ", "PARA\u00CDBA", "PARAN\u00C1", "PERNAMBUCO", "PIAU\u00CD", "RIO DE JANEIRO", "RIO GRANDE DO NORTE", "RIO GRANDE DO SUL", "ROND\u00D4NIA", "RORAIMA", "SANTA CATARINA", "S\u00C3O PAULO", "SERGIPE", "TOCANTINS"}));
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
		fieldNumero.setDocument(new FixedLengthJTextField(5));
		fieldNumero.setBounds(270, 85, 51, 20);
		panelCentro.add(fieldNumero);
		fieldNumero.setColumns(10);

		panelRodape = new JPanel();
		panelRodape.setBackground(SystemColor.inactiveCaption);
		panelRodape.setBounds(0, 292, 507, 17);
		contentPane.add(panelRodape);

		buttonNovo = new JButton();
		buttonNovo.setToolTipText("Novo");
		buttonNovo.setIcon(new ImageIcon("imagens/additionButton.png"));
		buttonNovo.setForeground(Color.BLACK);
		buttonNovo.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonNovo.setBackground(SystemColor.inactiveCaption);
		buttonNovo.setBounds(101, 69, 50, 26);
		contentPane.add(buttonNovo);
		
		buttonSalvar = new JButton();
		buttonSalvar.setToolTipText("Gravar");
		buttonSalvar.setIcon(new ImageIcon("imagens/saveButton.png"));
		buttonSalvar.setForeground(Color.BLACK);
		buttonSalvar.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonSalvar.setEnabled(false);
		buttonSalvar.setBackground(SystemColor.inactiveCaption);
		buttonSalvar.setBounds(163, 69, 50, 26);
		contentPane.add(buttonSalvar);
		
		buttonExcluir = new JButton();
		buttonExcluir.setToolTipText("Excluir");
		buttonExcluir.setIcon(new ImageIcon("imagens/deleteButton.png"));
		buttonExcluir.setForeground(Color.BLACK);
		buttonExcluir.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonExcluir.setEnabled(false);
		buttonExcluir.setBackground(SystemColor.inactiveCaption);
		buttonExcluir.setBounds(225, 69, 50, 26);
		contentPane.add(buttonExcluir);
		
		buttonCancelar = new JButton();
		buttonCancelar.setToolTipText("Desfazer");
		buttonCancelar.setIcon(new ImageIcon("imagens/undoButton.png"));
		buttonCancelar.setForeground(Color.BLACK);
		buttonCancelar.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonCancelar.setBackground(SystemColor.inactiveCaption);
		buttonCancelar.setBounds(287, 69, 50, 26);
		contentPane.add(buttonCancelar);
		
		buttonLocalizar = new JButton();
		buttonLocalizar.setToolTipText("Localizar");
		buttonLocalizar.setIcon(new ImageIcon("imagens/searchButton.png"));
		buttonLocalizar.setForeground(Color.BLACK);
		buttonLocalizar.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonLocalizar.setBackground(SystemColor.inactiveCaption);
		buttonLocalizar.setBounds(349, 69, 50, 26);
		contentPane.add(buttonLocalizar);
		
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
		
		buttonSalvar.addActionListener(new ActionListener() {
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
					
					if(saveupdate){ 
						empresaController.insert(emp);
					} else{ 
						emp.setId(Integer.parseInt(fieldCodigo.getText()));
						empresaController.update(emp);
					}
					
					cleanFields();
					disableFields();
					buttonNovo.setEnabled(true);
					buttonExcluir.setEnabled(false);
					buttonSalvar.setEnabled(false);
					buttonLocalizar.setEnabled(true);
				}
			}	
		});
		
		buttonExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (JOptionPane.showConfirmDialog(null, "Deseja Realmente Excluir ?", "Excluir Empresa", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==0) {
					empresaController.delete(Integer.parseInt(fieldCodigo.getText()));
					cleanFields();
					disableFields();
					buttonNovo.setEnabled(true);
					buttonExcluir.setEnabled(false);
					buttonSalvar.setEnabled(false);
				}

			}
		});

		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cleanFields();
				disableFields();
				buttonSalvar.setEnabled(false);
				buttonNovo.setEnabled(true);
				buttonExcluir.setEnabled(false);
				buttonLocalizar.setEnabled(true);
			}
		});

		buttonLocalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ConsultaEmpresa(TelaCadastroEmpresa.this).setVisible(true);
			}
		});
		
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
		fieldCodigo.setText(null);
		fieldNome.setText(null);
		fieldBairro.setText(null);
		fieldRua.setText(null);
		chckbxFilial.setSelected(false);
		fieldCidade.setText(null);
		fieldNumero.setText(null);
		comboBoxEstado.setSelectedIndex(0);
	}
	
	public void enableFields(){
		fieldNome.setEditable(true);
		fieldBairro.setEditable(true);
		fieldRua.setEditable(true);
		chckbxFilial.setEnabled(true);
		fieldCidade.setEditable(true);
		fieldNumero.setEditable(true);
		comboBoxEstado.setEnabled(true);
	}
	
	public void disableFields(){
		fieldNome.setEditable(false);
		fieldBairro.setEditable(false);
		fieldRua.setEditable(false);
		chckbxFilial.setEnabled(false);
		fieldCidade.setEditable(false);
		fieldNumero.setEditable(false);
		comboBoxEstado.setEnabled(false);
	}
	
	public void setFields(int id){
		Empresa emp = empresaController.consultaId(id);
		fieldCodigo.setText(String.valueOf(emp.getId()));
		fieldNome.setText(emp.getNome());
		fieldBairro.setText(emp.getEndBairro());
		fieldRua.setText(emp.getEndRua());
		chckbxFilial.setSelected(emp.isFilial());
		fieldCidade.setText(emp.getEndCidade());
		fieldNumero.setText(emp.getEndNumero());
		comboBoxEstado.setSelectedItem(emp.getEndEstado());
		buttonExcluir.setEnabled(true);
		buttonSalvar.setEnabled(true);
		buttonNovo.setEnabled(false);
		saveupdate = false;
		enableFields();
	}
	
	public void setPosicao() {
		Dimension d = this.getDesktopPane().getSize();
		this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
	}
}
