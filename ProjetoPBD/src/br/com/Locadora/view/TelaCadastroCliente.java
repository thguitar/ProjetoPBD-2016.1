package br.com.Locadora.view;


import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import java.awt.SystemColor;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;

import javax.swing.JButton;

import br.com.Locadora.controller.ClienteController;
import br.com.Locadora.controller.Validations;
import br.com.Locadora.model.FixedLengthJTextField;
import br.com.Locadora.model.OnlyNumberField;
import br.com.Locadora.model.PessoaFisica;
import br.com.Locadora.model.PessoaJuridica;

import com.toedter.calendar.JDateChooser;

public class TelaCadastroCliente extends JInternalFrame {

	private static final long serialVersionUID = 4083438630101664605L;

	private JPanel contentPane;
	private JPanel panelTitulo;
	private JPanel panelRodape;
	private JPanel panelEndereco;
	private JPanel panelDadosPrincipais;
	private JLabel labelCodigo;
	private JLabel labelTitulos;
	private JLabel labelNome;
	private JLabel labelEstado;
	private JLabel labelEndereco;
	private JLabel labelCidade;
	private JLabel labelBairro;
	private	JLabel labelRua;
	private JLabel labelNumero;
	private JLabel labelCPF;
	private JLabel labelCNPJ;
	private JLabel labelHabilitacao;
	private JLabel labelDataNascimento;
	private JLabel labelVencHabilitacao;
	private JLabel labelSexo;
	private JLabel labelInscEstadual;
	private JLabel labelDadosPrincipais;
	private JLabel labelPessoa;
	private JTextField fieldCodigo;
	private JTextField fieldNome;
	private JTextField fieldCidade;
	private JTextField fieldBairro;
	private JTextField fieldRua;
	private JTextField fieldNumero;
	private JTextField fieldHabilitacao;
	private JTextField fieldInscEstadual;
	private JFormattedTextField fieldCPF;
	private JFormattedTextField fieldCNPJ;
	private JButton buttonSalvar;
	private JButton buttonCancelar;
	private JButton buttonExcluir;
	private JButton buttonLocalizar;
	private JButton buttonNovo;
	private JRadioButton radiobuttonPFisica;
	private JRadioButton radiobuttonPJurdica;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxSexo;
	private ButtonGroup grupo;
	private JDateChooser dateChooserNascimento;
	private JDateChooser dateChooserCNH;

	private ClienteController clienteController;
	
	private boolean saveupdate;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TelaCadastroCliente() {
		setTitle("Cadastro de Clientes                                                                                                                                                                   ");
		setClosable(true);
		setBounds(100, 100, 672, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		clienteController = new ClienteController();
		
		panelTitulo = new JPanel();
		panelTitulo.setBackground(SystemColor.inactiveCaption);
		panelTitulo.setBounds(0, 0, 662, 71);
		contentPane.add(panelTitulo);

		labelTitulos = new JLabel("Cadastro de Clientes");
		labelTitulos.setFont(new Font("SansSerif", Font.BOLD, 32));
		labelTitulos.setForeground(new Color(0, 0, 102));
		panelTitulo.add(labelTitulos);

		panelRodape = new JPanel();
		panelRodape.setBackground(SystemColor.inactiveCaption);
		panelRodape.setBounds(0, 410, 662, 16);
		contentPane.add(panelRodape);

		radiobuttonPFisica = new JRadioButton("F\u00EDsica", true);
		radiobuttonPFisica.setFont(new Font("SansSerif", Font.BOLD, 12));
		radiobuttonPFisica.setEnabled(false);
		radiobuttonPFisica.setBounds(10, 89, 58, 24);
		contentPane.add(radiobuttonPFisica);

		radiobuttonPJurdica = new JRadioButton("Jur\u00EDdica");
		radiobuttonPJurdica.setFont(new Font("SansSerif", Font.BOLD, 12));
		radiobuttonPJurdica.setEnabled(false);
		radiobuttonPJurdica.setBounds(77, 89, 71, 24);
		contentPane.add(radiobuttonPJurdica);

		grupo = new ButtonGroup();		
		grupo.add(radiobuttonPFisica);
		grupo.add(radiobuttonPJurdica);

		panelDadosPrincipais = new JPanel();
		panelDadosPrincipais.setBackground(new Color(204, 204, 204));
		panelDadosPrincipais.setBounds(10, 118, 640, 165);
		panelDadosPrincipais.setVisible(true);

		panelEndereco = new JPanel();
		panelEndereco.setBounds(10, 288, 640, 116);
		contentPane.add(panelEndereco);
		panelEndereco.setBackground(new Color(204, 204, 204));
		panelEndereco.setLayout(null);

		labelEstado = new JLabel("Estado:");
		labelEstado.setBounds(4, 73, 42, 16);
		labelEstado.setFont(new Font("SansSerif", Font.BOLD, 12));
		panelEndereco.add(labelEstado);

		labelEndereco = new JLabel("Endere\u00E7o");
		labelEndereco.setBounds(4, 0, 54, 16);
		labelEndereco.setForeground(new Color(0, 0, 102));
		labelEndereco.setFont(new Font("SansSerif", Font.BOLD, 12));
		panelEndereco.add(labelEndereco);

		comboBox = new JComboBox();
		comboBox.setEnabled(false);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"ACRE", "ALAGOAS", "AMAP\u00C1", "AMAZONAS", "BAHIA", "CEAR\u00C1", "DISTRITO FEDERAL", "ESP\u00CDRITO SANTO", "GOI\u00C1S", "MARANH\u00C3O", "MATO GROSSO", "MATO GROSSO DO SUL", "MINAS GERAIS", "PAR\u00C1", "PARA\u00CDBA", "PARAN\u00C1", "PERNAMBUCO", "PIAU\u00CD", "RIO DE JANEIRO", "RIO GRANDE DO NORTE", "RIO GRANDE DO SUL", "ROND\u00D4NIA", "RORAIMA", "SANTA CATARINA", "S\u00C3O PAULO", "SERGIPE", "TOCANTINS"}));
		comboBox.setBounds(49, 71, 189, 20);
		panelEndereco.add(comboBox);

		labelCidade = new JLabel("Cidade:");
		labelCidade.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelCidade.setBounds(262, 49, 42, 16);
		panelEndereco.add(labelCidade);

		fieldCidade = new JTextField();
		fieldCidade.setEditable(false);
		fieldCidade.setBounds(307, 47, 180, 20);
		panelEndereco.add(fieldCidade);
		fieldCidade.setColumns(10);

		labelBairro = new JLabel("Bairro:");
		labelBairro.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelBairro.setBounds(8, 49, 38, 16);
		panelEndereco.add(labelBairro);

		fieldBairro = new JTextField();
		fieldBairro.setEditable(false);
		fieldBairro.setBounds(49, 47, 202, 20);
		panelEndereco.add(fieldBairro);
		fieldBairro.setColumns(10);

		fieldRua = new JTextField();
		fieldRua.setEditable(false);
		fieldRua.setColumns(10);
		fieldRua.setBounds(49, 23, 345, 20);
		panelEndereco.add(fieldRua);

		labelRua = new JLabel("Rua:");
		labelRua.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelRua.setBounds(21, 25, 25, 16);
		panelEndereco.add(labelRua);

		fieldNumero = new JTextField();
		fieldNumero.setEditable(false);
		fieldNumero.setDocument(new FixedLengthJTextField(5));
		fieldNumero.setColumns(10);
		fieldNumero.setBounds(307, 71, 71, 20);
		panelEndereco.add(fieldNumero);

		labelNumero = new JLabel("N\u00FAmero:");
		labelNumero.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelNumero.setBounds(256, 73, 48, 16);
		panelEndereco.add(labelNumero);
		contentPane.add(panelDadosPrincipais);
		panelDadosPrincipais.setLayout(null);

		labelCPF = new JLabel("CPF:");
		labelCPF.setBounds(25, 70, 25, 20);
		labelCPF.setFont(new Font("SansSerif", Font.BOLD, 12));
		panelDadosPrincipais.add(labelCPF);

		fieldCPF = new JFormattedTextField(Mascara("###.###.###-##"));
		fieldCPF.setEditable(false);
		fieldCPF.setBounds(53, 70, 95, 20);
		panelDadosPrincipais.add(fieldCPF);
		fieldCPF.setColumns(10);

		fieldHabilitacao = new JTextField();
		fieldHabilitacao.setDocument(new OnlyNumberField(11));
		fieldHabilitacao.setEditable(false);
		fieldHabilitacao.setColumns(10);
		fieldHabilitacao.setBounds(254, 98, 85, 20);
		panelDadosPrincipais.add(fieldHabilitacao);

		labelHabilitacao = new JLabel("N\u00FAmero da CNH:");
		labelHabilitacao.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelHabilitacao.setBounds(158, 98, 92, 20);
		panelDadosPrincipais.add(labelHabilitacao);

		labelDataNascimento = new JLabel("Data de Nascimento:");
		labelDataNascimento.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelDataNascimento.setBounds(18, 127, 122, 16);
		panelDadosPrincipais.add(labelDataNascimento);

		labelVencHabilitacao = new JLabel("Vencimento da CNH:");
		labelVencHabilitacao.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelVencHabilitacao.setBounds(347, 100, 122, 16);
		panelDadosPrincipais.add(labelVencHabilitacao);

		labelSexo = new JLabel("Sexo:");
		labelSexo.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelSexo.setBounds(18, 98, 32, 20);
		panelDadosPrincipais.add(labelSexo);

		comboBoxSexo = new JComboBox();
		comboBoxSexo.setEnabled(false);
		comboBoxSexo.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino"}));
		comboBoxSexo.setBounds(53, 98, 95, 20);
		panelDadosPrincipais.add(comboBoxSexo);

		labelInscEstadual = new JLabel("Insc. Estadual:");
		labelInscEstadual.setBounds(324, 70, 82, 20);
		panelDadosPrincipais.add(labelInscEstadual);
		labelInscEstadual.setFont(new Font("SansSerif", Font.BOLD, 12));

		labelCNPJ = new JLabel("CNPJ:");
		labelCNPJ.setBounds(158, 70, 34, 20);
		panelDadosPrincipais.add(labelCNPJ);
		labelCNPJ.setFont(new Font("SansSerif", Font.BOLD, 12));

		fieldCNPJ = new JFormattedTextField(Mascara("##.###.###/####-##"));
		fieldCNPJ.setEditable(false);
		fieldCNPJ.setBounds(194, 70, 117, 20);
		panelDadosPrincipais.add(fieldCNPJ);
		fieldCNPJ.setColumns(10);

		fieldInscEstadual = new JTextField();
		fieldInscEstadual.setText("ISENTO");
		fieldInscEstadual.setDocument(new FixedLengthJTextField(20));
		fieldInscEstadual.setEditable(false);
		fieldInscEstadual.setBounds(408, 70, 125, 20);
		panelDadosPrincipais.add(fieldInscEstadual);
		fieldInscEstadual.setColumns(10);

		labelNome = new JLabel("Nome:");
		labelNome.setBounds(14, 45, 36, 20);
		panelDadosPrincipais.add(labelNome);
		labelNome.setFont(new Font("SansSerif", Font.BOLD, 12));

		fieldNome = new JTextField();
		fieldNome.setEditable(false);
		fieldNome.setBounds(53, 45, 345, 20);
		panelDadosPrincipais.add(fieldNome);
		fieldNome.setColumns(10);

		labelDadosPrincipais = new JLabel("Dados Principais");
		labelDadosPrincipais.setForeground(new Color(0, 0, 102));
		labelDadosPrincipais.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelDadosPrincipais.setBounds(4, 0, 96, 16);
		panelDadosPrincipais.add(labelDadosPrincipais);

		dateChooserNascimento = new JDateChooser();
		dateChooserNascimento.setEnabled(false);
		dateChooserNascimento.setDate(new Date());
		dateChooserNascimento.setBounds(140, 125, 92, 20);
		panelDadosPrincipais.add(dateChooserNascimento);

		dateChooserCNH = new JDateChooser();
		dateChooserCNH.setEnabled(false);
		dateChooserCNH.setDate(new Date());
		dateChooserCNH.setBounds(467, 98, 92, 20);
		panelDadosPrincipais.add(dateChooserCNH);
		
		labelCodigo = new JLabel("C\u00F3digo:");
		labelCodigo.setBounds(8, 21, 42, 16);
		panelDadosPrincipais.add(labelCodigo);
		
		fieldCodigo = new JTextField();
		fieldCodigo.setEditable(false);
		fieldCodigo.setBounds(53, 19, 47, 20);
		panelDadosPrincipais.add(fieldCodigo);
		fieldCodigo.setColumns(10);

		buttonNovo = new JButton();
		buttonNovo.setIcon(new ImageIcon("imagens/additionButton.png"));
		buttonNovo.setToolTipText("Novo");
		buttonNovo.setForeground(Color.BLACK);
		buttonNovo.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonNovo.setBackground(SystemColor.inactiveCaption);
		buttonNovo.setBounds(182, 81, 50, 26);
		contentPane.add(buttonNovo);

		buttonSalvar = new JButton();
		buttonSalvar.setToolTipText("Gravar");
		buttonSalvar.setIcon(new ImageIcon("imagens/saveButton.png"));
		buttonSalvar.setForeground(Color.BLACK);
		buttonSalvar.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonSalvar.setEnabled(false);
		buttonSalvar.setBackground(SystemColor.inactiveCaption);
		buttonSalvar.setBounds(244, 81, 50, 26);
		contentPane.add(buttonSalvar);
		
		buttonExcluir = new JButton();
		buttonExcluir.setToolTipText("Excluir");
		buttonExcluir.setIcon(new ImageIcon("imagens/deleteButton.png"));
		buttonExcluir.setForeground(Color.BLACK);
		buttonExcluir.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonExcluir.setEnabled(false);
		buttonExcluir.setBackground(SystemColor.inactiveCaption);
		buttonExcluir.setBounds(306, 81, 50, 26);
		contentPane.add(buttonExcluir);
		
		buttonCancelar = new JButton();
		buttonCancelar.setToolTipText("Desfazer");
		buttonCancelar.setIcon(new ImageIcon("imagens/undoButton.png"));
		buttonCancelar.setForeground(Color.BLACK);
		buttonCancelar.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonCancelar.setBackground(SystemColor.inactiveCaption);
		buttonCancelar.setBounds(368, 81, 50, 26);
		contentPane.add(buttonCancelar);
		
		buttonLocalizar = new JButton();
		buttonLocalizar.setToolTipText("Localizar");
		buttonLocalizar.setIcon(new ImageIcon("imagens/searchButton.png"));
		buttonLocalizar.setForeground(Color.BLACK);
		buttonLocalizar.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonLocalizar.setBackground(SystemColor.inactiveCaption);
		buttonLocalizar.setBounds(430, 81, 50, 26);
		contentPane.add(buttonLocalizar);

		labelPessoa = new JLabel("Pessoa");
		labelPessoa.setForeground(new Color(0, 0, 102));
		labelPessoa.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelPessoa.setBounds(14, 74, 43, 16);
		contentPane.add(labelPessoa);
		
		radiobuttonPFisica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (radiobuttonPFisica.isSelected()){
					enableFieldsPF();
				}
			}
		});

		radiobuttonPJurdica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radiobuttonPJurdica.isSelected()){
					enableFieldsPJ();
				}
			}
		});
		
		buttonNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cleanFields();
				buttonSalvar.setEnabled(true);
				buttonExcluir.setEnabled(false);
				buttonLocalizar.setEnabled(false);
				buttonNovo.setEnabled(false);
				radiobuttonPFisica.setEnabled(true);
				radiobuttonPJurdica.setEnabled(true);
				if (radiobuttonPFisica.isSelected()) {
					enableFieldsPF();
				}else {
					enableFieldsPJ();
				}
				enableFieldsEnd();
				saveupdate = true;
			}
		});
		
		buttonSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (validaFields()) {
					if(radiobuttonPFisica.isSelected()){
						String s = (String) comboBoxSexo.getSelectedItem();
						char sexo = s.charAt(0);
						PessoaFisica pf = new PessoaFisica();
						pf.setNome(fieldNome.getText());
						pf.setCpf(fieldCPF.getText().replaceAll("[.-]", ""));
						pf.setNumeroHabilitacao(fieldHabilitacao.getText());
						pf.setBairro(fieldBairro.getText());
						pf.setRua(fieldRua.getText());
						pf.setnumeroEndereco(fieldNumero.getText());
						pf.setCidade(fieldCidade.getText());
						pf.setEstado((String) comboBox.getSelectedItem());
						pf.setSexo(sexo);
						pf.setDataNascimento(dateChooserNascimento.getDate());
						pf.setDataVencimentoHailitacao(dateChooserCNH.getDate());
						
						if(saveupdate){ 
							clienteController.insert(pf);
						} else{ 
							pf.setId(Integer.parseInt(fieldCodigo.getText()));
							clienteController.updatePF(pf);
						}
						
					}else {
						PessoaJuridica pj = new PessoaJuridica();
						pj.setNome(fieldNome.getText());
						pj.setCnpj(fieldCNPJ.getText().replaceAll("\\D", ""));
						pj.setInscricaoEstadual(fieldInscEstadual.getText());
						pj.setBairro(fieldBairro.getText());
						pj.setnumeroEndereco((fieldNumero.getText()));
						pj.setRua(fieldRua.getText());
						pj.setCidade(fieldCidade.getText());
						pj.setEstado((String) comboBox.getSelectedItem());

						if(saveupdate){ 
							clienteController.insert(pj);
						} else{ 
							pj.setId(Integer.parseInt(fieldCodigo.getText()));
							clienteController.updatePJ(pj);
						}
					}
					
					cleanFields();
					disableFields();
					buttonNovo.setEnabled(true);
					buttonSalvar.setEnabled(false);
					buttonLocalizar.setEnabled(true);
					buttonExcluir.setEnabled(false);
					radiobuttonPFisica.setEnabled(false);
					radiobuttonPJurdica.setEnabled(false);

				}
			}
		});
		
		buttonExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (JOptionPane.showConfirmDialog(null, "Deseja Realmente Excluir ?", "Excluir Usuário", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==0) {
					if(radiobuttonPFisica.isSelected()){
						clienteController.deletePF(Integer.parseInt(fieldCodigo.getText()));
						
					}else {
						clienteController.deletePJ(Integer.parseInt(fieldCodigo.getText()));
					}				
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
				radiobuttonPFisica.setSelected(true);
				radiobuttonPFisica.setEnabled(false);
				radiobuttonPJurdica.setEnabled(false);
				buttonSalvar.setEnabled(false);
				buttonNovo.setEnabled(true);
				buttonExcluir.setEnabled(false);
				buttonLocalizar.setEnabled(true);
			}
		});

		buttonLocalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ConsultaCliente(TelaCadastroCliente.this).setVisible(true);
			}
		});
	}

	private MaskFormatter Mascara(String mascara){

		@SuppressWarnings("unused")
		MaskFormatter maskFormatter;

		try {
			return maskFormatter = new MaskFormatter(mascara);
		} catch (Exception e) {
			return null;
		}
	}

	public boolean validaFields(){
		if (radiobuttonPFisica.isSelected()) {
			if(fieldNome.getText().isEmpty()||fieldCPF.getText().equals("   .   .   -  ")||fieldInscEstadual.getText().isEmpty()||
					fieldHabilitacao.getText().isEmpty()||fieldRua.getText().isEmpty()||fieldBairro.getText().isEmpty()||
					fieldCidade.getText().isEmpty()||fieldNumero.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "Existem Campos Vazios",null , JOptionPane.WARNING_MESSAGE);
				return false;
			}else if(!Validations.isValidCPF(fieldCPF.getText().replaceAll("[.-]", ""))){
				JOptionPane.showMessageDialog(null, "CPF Inválido","Aviso de Inconsistência" , JOptionPane.WARNING_MESSAGE);
				return false; 
			}

			return true;
		}else {
			if(fieldNome.getText().isEmpty()||fieldCNPJ.getText().equals("  .   .   /    -  ")||fieldInscEstadual.getText().isEmpty()||
					fieldRua.getText().isEmpty()||fieldBairro.getText().isEmpty()||
					fieldCidade.getText().isEmpty()||fieldNumero.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "Existem Campos Vazios",null , JOptionPane.WARNING_MESSAGE);
				return false;
			}else if(!Validations.isValidCNPJ(fieldCNPJ.getText().replaceAll("\\D", ""))){
				JOptionPane.showMessageDialog(null, "CNPJ Inválido","Aviso de Inconsistência" , JOptionPane.WARNING_MESSAGE);
				return false; 
			}

			return true;
		}
	}
	
	public void cleanFields(){
		fieldCodigo.setText(null);
		fieldCPF.setValue(null);
		fieldHabilitacao.setText(null);
		comboBoxSexo.setSelectedIndex(0);
		fieldCNPJ.setValue(null);
		fieldInscEstadual.setText(null);
		fieldBairro.setText(null);
		fieldCidade.setText(null);
		fieldNome.setText(null);
		fieldNumero.setText(null);
		fieldRua.setText(null);
		comboBox.setSelectedIndex(0);
	}
	
	public void disableFields(){
		fieldCPF.setEditable(false);
		fieldHabilitacao.setEditable(false);
		comboBoxSexo.setEnabled(false);
		fieldCNPJ.setEditable(false);
		fieldInscEstadual.setEditable(false);
		fieldBairro.setEditable(false);
		fieldCidade.setEditable(false);
		fieldNome.setEditable(false);
		fieldNumero.setEditable(false);
		fieldRua.setEditable(false);
		comboBox.setEnabled(false);
		dateChooserCNH.setEnabled(false);
		dateChooserNascimento.setEnabled(false);
	}
	
	public void enableFieldsPF(){
		fieldNome.setEditable(true);
		fieldCPF.setEditable(true);
		fieldHabilitacao.setEditable(true);
		comboBoxSexo.setEnabled(true);
		fieldCNPJ.setEditable(false);
		fieldInscEstadual.setEditable(false);
		fieldInscEstadual.setText("ISENTO");
		dateChooserCNH.setEnabled(true);
		dateChooserNascimento.setEnabled(true);
	}
	
	public void disableFieldsPF(){
		fieldCPF.setEditable(false);
		fieldHabilitacao.setEditable(false);
		comboBoxSexo.setEnabled(false);
		dateChooserCNH.setEnabled(false);
		dateChooserNascimento.setEnabled(false);
	}
	
	public void enableFieldsPJ(){
		fieldNome.setEditable(true);
		fieldCPF.setEditable(false);
		fieldHabilitacao.setEditable(false);
		comboBoxSexo.setEnabled(false);
		fieldCNPJ.setEditable(true);
		fieldInscEstadual.setEditable(true);
		dateChooserCNH.setEnabled(false);
		dateChooserNascimento.setEnabled(false);
	}
	
	public void disableFieldsPJ(){
		fieldCNPJ.setEditable(false);
		fieldInscEstadual.setEditable(false);
	}
	
	public void enableFieldsEnd(){
		fieldBairro.setEditable(true);
		fieldCidade.setEditable(true);
		fieldNumero.setEditable(true);
		fieldRua.setEditable(true);
		comboBox.setEnabled(true);
	}
	
	public void setFieldsPF(int id){
		PessoaFisica pf  = clienteController.consultaPFId(id);
		fieldCodigo.setText(String.valueOf(pf.getId()));
		fieldCPF.setText(pf.getCpf());
		fieldInscEstadual.setText("ISENTO");
		fieldHabilitacao.setText(pf.getNumeroHabilitacao());
		comboBoxSexo.setSelectedItem(pf.getSexoCompleto());
		fieldBairro.setText(pf.getBairro());
		fieldCidade.setText(pf.getCidade());
		fieldNome.setText(pf.getNome());
		fieldNumero.setText(pf.getnumeroEndereco());
		fieldRua.setText(pf.getRua());
		comboBox.setSelectedItem(pf.getEstado());
		dateChooserCNH.setDate(pf.getDataVencimentoHailitacao());
		dateChooserNascimento.setDate(pf.getDataNascimento());
		radiobuttonPFisica.setSelected(true);
		saveupdate = false;
		disableFieldsPJ();
		enableFieldsPF();
		enableFieldsEnd();
		buttonExcluir.setEnabled(true);
		buttonSalvar.setEnabled(true);
		buttonNovo.setEnabled(false);
	}
	
	public void setFieldsPJ(int id){
		PessoaJuridica pj = clienteController.consultaPJId(id);
		fieldCodigo.setText(String.valueOf(pj.getId()));
		fieldCNPJ.setText(pj.getCnpj());
		fieldInscEstadual.setText(pj.getInscricaoEstadual());
		fieldBairro.setText(pj.getBairro());
		fieldCidade.setText(pj.getCidade());
		fieldNome.setText(pj.getNome());
		fieldNumero.setText(pj.getnumeroEndereco());
		fieldRua.setText(pj.getRua());
		comboBox.setSelectedItem(pj.getEstado());
		radiobuttonPJurdica.setSelected(true);
		saveupdate = false;
		disableFieldsPF();
		enableFieldsPJ();
		enableFieldsEnd();
		buttonExcluir.setEnabled(true);
		buttonSalvar.setEnabled(true);
		buttonNovo.setEnabled(false);
	}
	
	public TelaCadastroCliente getTela(){
		return this;
	}
	
	public void setPosicao() {
		Dimension d = this.getDesktopPane().getSize();
		this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
	}
}

