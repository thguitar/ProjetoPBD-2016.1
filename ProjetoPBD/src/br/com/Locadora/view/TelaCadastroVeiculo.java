package br.com.Locadora.view;


import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import br.com.Locadora.controller.CategoriaController;
import br.com.Locadora.controller.VeiculoController;
import br.com.Locadora.model.Acessorios;
import br.com.Locadora.model.Categoria;
import br.com.Locadora.model.FixedLengthJTextField;
import br.com.Locadora.model.OnlyNumberField;
import br.com.Locadora.model.Veiculo;

import com.toedter.calendar.JYearChooser;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.JCheckBox;

public class TelaCadastroVeiculo extends JInternalFrame {


	private static final long serialVersionUID = 3675788004973562001L;

	private JPanel contentPane;
	private JPanel panelRodape;
	private JPanel panelTitulo;
	private JPanel panelInformacoesPrincipais;
	private JPanel panelAcessorios;
	private JLabel labelDadosPrincipais;
	private JLabel labelTitulo;
	private JLabel labelChassi;
	private JLabel labelCapacidade;
	private JLabel labelAnoModelo;
	private JLabel labelAnoFabricacao;
	private JLabel labelPlaca;
	private JLabel labelCor;
	private JLabel labelNumPortas;
	private JLabel labelNumMotor;
	private JLabel labelCombustivel;
	private JLabel labelQuilometragem;
	private JLabel labelTorqueMotor;
	private JLabel labelCategoria;
	private JLabel labelTipoCambio;
	private JLabel labelAcessorios;
	private JLabel labelDistnciaEntreEixos;
	private JLabel labelDesempenho;
	private JLabel labelOutros;
	private JLabel labelVolAbastecimento;
	private JLabel labelAirbag;
	private JLabel labelCapacidadeDeCarga;
	private JLabel labelTipo;
	private JTextField fieldChassi;
	private JTextField fieldCor;
	private JTextField fieldNumMotor;
	private JTextField fieldKms;
	private JFormattedTextField formattedTextFieldPlaca;
	private JFormattedTextField formattedTextFieldTorque;
	private JFormattedTextField fieldDistanciEixos;
	private JFormattedTextField fieldVolumeAbastecimento;
	private JFormattedTextField fieldDesempenho;
	private JFormattedTextField fieldCapacidadeCarga;
	private JCheckBox chckbxArcondicionado;
	private JCheckBox chckbxRadio;
	private JCheckBox chckbxDVD;
	private JCheckBox chckbxDirecaoHidraulica;
	private JCheckBox chckbxMP3;
	private JCheckBox chckbxCameraRe;
	private JCheckBox chckbxComputadorDeBordo;
	private JCheckBox chckbxRodasLigaLeve;
	private JCheckBox chckbxCintosRetrateis;
	private JCheckBox chckbxControlePoluicao;
	private JCheckBox chckbxAcionamentoHemb;
	private JButton buttonSalvar;
	private JButton buttonCancelar;
	private JButton buttonExcluir;
	private JButton buttonLocalizar;
	private JButton buttonNovo;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoTipoCambio;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxNumPortas;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxCategoria;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxPassageiros;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxCombustivel;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxAirBag;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxTipo;
	private JYearChooser yearChooserModelo;
	private JYearChooser yearChooserFabricacao;

	private boolean saveupdate;
	
	private VeiculoController veiculoController;
	private CategoriaController categoriaController;

	private Veiculo veiculoUpdate;
	
	private List<Categoria> categorias;
	private JLabel labelCodigo;
	private JTextField fieldCodigo;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TelaCadastroVeiculo() {
		setClosable(true);
		setTitle("Cadastro de Ve\u00EDculos                                                                                                                                                                                     ");
		setResizable(false);
		setSize(730, 530);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		veiculoController = new VeiculoController();
		
		panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(204, 204, 255));
		panelTitulo.setBounds(0, 0, 720, 66);
		contentPane.add(panelTitulo);
		panelTitulo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		labelTitulo = new JLabel("Cadastro de Ve\u00EDculos");
		labelTitulo.setForeground(new Color(0, 0, 102));
		labelTitulo.setFont(new Font("SansSerif", Font.BOLD, 32));
		panelTitulo.add(labelTitulo);

		panelRodape = new JPanel();
		panelRodape.setBackground(new Color(204, 204, 255));
		panelRodape.setBounds(0, 479, 720, 18);
		contentPane.add(panelRodape);

		panelInformacoesPrincipais = new JPanel();
		panelInformacoesPrincipais.setBackground(new Color(204, 204, 204));
		panelInformacoesPrincipais.setBounds(12, 117, 696, 151);
		contentPane.add(panelInformacoesPrincipais);
		panelInformacoesPrincipais.setLayout(null);

		labelChassi = new JLabel("N\u00BA do Chassi:");
		labelChassi.setBounds(10, 47, 74, 16);
		panelInformacoesPrincipais.add(labelChassi);
		labelChassi.setFont(new Font("SansSerif", Font.BOLD, 12));

		labelCapacidade = new JLabel("Capacidade de Passageiros:");
		labelCapacidade.setBounds(423, 121, 162, 16);
		panelInformacoesPrincipais.add(labelCapacidade);
		labelCapacidade.setFont(new Font("SansSerif", Font.BOLD, 12));

		labelAnoModelo = new JLabel("Ano do Modelo:");
		labelAnoModelo.setBounds(163, 73, 86, 16);
		panelInformacoesPrincipais.add(labelAnoModelo);
		labelAnoModelo.setFont(new Font("SansSerif", Font.BOLD, 12));

		labelAnoFabricacao = new JLabel("Ano de Farica\u00E7\u00E3o:");
		labelAnoFabricacao.setBounds(323, 73, 101, 16);
		panelInformacoesPrincipais.add(labelAnoFabricacao);
		labelAnoFabricacao.setFont(new Font("SansSerif", Font.BOLD, 12));

		labelPlaca = new JLabel("Placa:");
		labelPlaca.setBounds(49, 72, 35, 16);
		panelInformacoesPrincipais.add(labelPlaca);
		labelPlaca.setFont(new Font("SansSerif", Font.BOLD, 12));

		labelCor = new JLabel("Cor:");
		labelCor.setBounds(59, 97, 23, 16);
		panelInformacoesPrincipais.add(labelCor);
		labelCor.setFont(new Font("SansSerif", Font.BOLD, 12));

		fieldChassi = new JTextField();
		fieldChassi.setDocument(new FixedLengthJTextField(15));
		fieldChassi.setEditable(false);
		fieldChassi.setBounds(89, 45, 120, 20);
		panelInformacoesPrincipais.add(fieldChassi);

		fieldCor = new JTextField();
		fieldCor.setBounds(89, 95, 120, 20);
		fieldCor.setEditable(false);
		panelInformacoesPrincipais.add(fieldCor);
		fieldCor.setColumns(10);

		fieldNumMotor = new JTextField();
		fieldNumMotor.setDocument(new OnlyNumberField(15));
		fieldNumMotor.setEditable(false);
		fieldNumMotor.setBounds(300, 45, 120, 20);
		panelInformacoesPrincipais.add(fieldNumMotor);

		formattedTextFieldPlaca = new JFormattedTextField(Mascara("UUU-####"));
		formattedTextFieldPlaca.setBounds(89, 70, 62, 20);
		formattedTextFieldPlaca.setEditable(false);
		panelInformacoesPrincipais.add(formattedTextFieldPlaca);
		formattedTextFieldPlaca.setColumns(10);

		labelNumPortas = new JLabel("N\u00BA de portas:");
		labelNumPortas.setBounds(513, 97, 72, 16);
		panelInformacoesPrincipais.add(labelNumPortas);
		labelNumPortas.setFont(new Font("SansSerif", Font.BOLD, 12));

		labelNumMotor = new JLabel("N\u00BA do Motor:");
		labelNumMotor.setBounds(227, 47, 68, 16);
		panelInformacoesPrincipais.add(labelNumMotor);
		labelNumMotor.setFont(new Font("SansSerif", Font.BOLD, 12));

		labelCombustivel = new JLabel("Combust\u00EDvel:");
		labelCombustivel.setBounds(227, 97, 73, 16);
		panelInformacoesPrincipais.add(labelCombustivel);
		labelCombustivel.setFont(new Font("SansSerif", Font.BOLD, 12));

		labelQuilometragem = new JLabel("Quilometragem:");
		labelQuilometragem.setBounds(494, 72, 91, 16);
		panelInformacoesPrincipais.add(labelQuilometragem);
		labelQuilometragem.setFont(new Font("SansSerif", Font.BOLD, 12));

		comboBoxNumPortas = new JComboBox();
		comboBoxNumPortas.setBounds(590, 95, 73, 20);
		comboBoxNumPortas.setEnabled(false);
		panelInformacoesPrincipais.add(comboBoxNumPortas);
		comboBoxNumPortas.setModel(new DefaultComboBoxModel(new String[] {"1 Porta", "2 Portas", "3 Portas", "4 Portas"}));

		fieldKms = new JTextField();
		fieldKms.setDocument(new OnlyNumberField(10));
		fieldKms.setEditable(false);
		fieldKms.setBounds(590, 70, 92, 20);
		panelInformacoesPrincipais.add(fieldKms);

		labelTorqueMotor = new JLabel("Torque do Motor:");
		labelTorqueMotor.setBounds(489, 47, 96, 16);
		panelInformacoesPrincipais.add(labelTorqueMotor);
		labelTorqueMotor.setFont(new Font("SansSerif", Font.BOLD, 12));

		formattedTextFieldTorque = new JFormattedTextField(Mascara("#.#"));
		formattedTextFieldTorque.setBounds(590, 45, 23, 20);
		formattedTextFieldTorque.setEditable(false);
		panelInformacoesPrincipais.add(formattedTextFieldTorque);
		formattedTextFieldTorque.setColumns(10);

		labelCategoria = new JLabel("Categoria:");
		labelCategoria.setBounds(26, 121, 58, 16);
		panelInformacoesPrincipais.add(labelCategoria);
		labelCategoria.setFont(new Font("SansSerif", Font.BOLD, 12));

		comboBoxCategoria = new JComboBox();
		comboBoxCategoria.setBounds(89, 119, 120, 20);
		comboBoxCategoria.setEnabled(false);
		panelInformacoesPrincipais.add(comboBoxCategoria);
		categoriaController = new CategoriaController();
		categorias = categoriaController.ListALL();
		for (int i = 0; i < categorias.size(); i++) {
			comboBoxCategoria.addItem(categorias.get(i).getDescricao());
		}

		comboBoxPassageiros = new JComboBox();
		comboBoxPassageiros.setBounds(590, 119, 63, 20);
		comboBoxPassageiros.setEnabled(false);
		for (int i = 1; i<=50; i++ ){
			comboBoxPassageiros.addItem(i);
		}
		panelInformacoesPrincipais.add(comboBoxPassageiros);

		yearChooserModelo = new JYearChooser();
		yearChooserModelo.setBounds(254, 71, 48, 20);
		yearChooserModelo.setEnabled(false);
		panelInformacoesPrincipais.add(yearChooserModelo);
		yearChooserModelo.getSpinner().setLocation(0, 103);
		yearChooserModelo.getSpinner().setSize(48, 20);

		yearChooserFabricacao = new JYearChooser();
		yearChooserFabricacao.setBounds(429, 71, 48, 20);
		yearChooserFabricacao.setEnabled(false);
		panelInformacoesPrincipais.add(yearChooserFabricacao);

		comboBoxCombustivel = new JComboBox();
		comboBoxCombustivel.setBounds(307, 95, 113, 20);
		comboBoxCombustivel.setEnabled(false);
		panelInformacoesPrincipais.add(comboBoxCombustivel);
		comboBoxCombustivel.setModel(new DefaultComboBoxModel(new String[] {"Biodiesel", "Diesel", "Etanol", "Flex", "Gasolina", "G\u00E1s Natural", "Hidrog\u00EAnio"}));

		labelDadosPrincipais = new JLabel("Dados Principais");
		labelDadosPrincipais.setForeground(new Color(0, 0, 102));
		labelDadosPrincipais.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelDadosPrincipais.setBounds(10, 0, 96, 16);
		panelInformacoesPrincipais.add(labelDadosPrincipais);
		
		labelTipo = new JLabel("Tipo:");
		labelTipo.setBounds(227, 121, 27, 16);
		panelInformacoesPrincipais.add(labelTipo);
		
		comboBoxTipo = new JComboBox();
		comboBoxTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch (comboBoxTipo.getSelectedIndex()) {
				case 0:{enableFieldsPequeno(); disableFieldsPickup(); disableFieldsPickupCarga(); cleanFieldsPickup();} break;
				case 1:{enableFieldsPickup(); disableFieldsPickupCarga(); cleanFieldsCarga();} break;
				case 2:{enableFieldsPickupCarga(); disableFieldsPequeno(); disableFieldsPickup(); cleanFieldsPickup();} break;
				default: break;
				}
			}
		});
		comboBoxTipo.setEnabled(false);
		comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"Autom\u00F3vel", "Caminhotene", "Caminhotene de Carga"}));
		comboBoxTipo.setBounds(279, 119, 141, 20);
		panelInformacoesPrincipais.add(comboBoxTipo);
		
		labelCodigo = new JLabel("C\u00F3digo:");
		labelCodigo.setBounds(42, 22, 42, 16);
		panelInformacoesPrincipais.add(labelCodigo);
		
		fieldCodigo = new JTextField();
		fieldCodigo.setEditable(false);
		fieldCodigo.setBounds(89, 20, 48, 20);
		panelInformacoesPrincipais.add(fieldCodigo);
		fieldCodigo.setColumns(10);

		buttonNovo = new JButton();
		buttonNovo.setToolTipText("Novo");
		buttonNovo.setIcon(new ImageIcon("imagens/additionButton.png"));
		buttonNovo.setForeground(Color.BLACK);
		buttonNovo.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonNovo.setBackground(SystemColor.inactiveCaption);
		buttonNovo.setBounds(193, 78, 50, 26);
		contentPane.add(buttonNovo);

		buttonSalvar = new JButton();
		buttonSalvar.setToolTipText("Gravar");
		buttonSalvar.setIcon(new ImageIcon("imagens/saveButton.png"));
		buttonSalvar.setForeground(Color.BLACK);
		buttonSalvar.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonSalvar.setEnabled(false);
		buttonSalvar.setBackground(SystemColor.inactiveCaption);
		buttonSalvar.setBounds(255, 78, 50, 26);
		contentPane.add(buttonSalvar);

		buttonExcluir = new JButton();
		buttonExcluir.setToolTipText("Excluir");
		buttonExcluir.setIcon(new ImageIcon("imagens/deleteButton.png"));
		buttonExcluir.setForeground(Color.BLACK);
		buttonExcluir.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonExcluir.setEnabled(false);
		buttonExcluir.setBackground(SystemColor.inactiveCaption);
		buttonExcluir.setBounds(317, 78, 50, 26);
		contentPane.add(buttonExcluir);

		buttonCancelar = new JButton();
		buttonCancelar.setToolTipText("Desfazer");
		buttonCancelar.setIcon(new ImageIcon("imagens/undoButton.png"));
		buttonCancelar.setForeground(Color.BLACK);
		buttonCancelar.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonCancelar.setBackground(SystemColor.inactiveCaption);
		buttonCancelar.setBounds(379, 78, 50, 26);
		contentPane.add(buttonCancelar);

		buttonLocalizar = new JButton();
		buttonLocalizar.setToolTipText("Localizar");
		buttonLocalizar.setIcon(new ImageIcon("imagens/searchButton.png"));
		buttonLocalizar.setForeground(Color.BLACK);
		buttonLocalizar.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonLocalizar.setBackground(SystemColor.inactiveCaption);
		buttonLocalizar.setBounds(441, 78, 50, 26);
		contentPane.add(buttonLocalizar);
		
		panelAcessorios = new JPanel();
		panelAcessorios.setBounds(12, 280, 696, 187);
		panelAcessorios.setBackground(new Color(204, 204, 204));
		contentPane.add(panelAcessorios);
		panelAcessorios.setLayout(null);
		
		chckbxArcondicionado = new JCheckBox("Ar-Condicionado");
		chckbxArcondicionado.setEnabled(false);
		chckbxArcondicionado.setBounds(8, 29, 119, 24);
		panelAcessorios.add(chckbxArcondicionado);
		
		chckbxRadio = new JCheckBox("R\u00E1dio");
		chckbxRadio.setEnabled(false);
		chckbxRadio.setBounds(8, 57, 57, 24);
		panelAcessorios.add(chckbxRadio);
		
		chckbxDVD = new JCheckBox("DVD");
		chckbxDVD.setEnabled(false);
		chckbxDVD.setBounds(8, 85, 49, 24);
		panelAcessorios.add(chckbxDVD);
		
		chckbxDirecaoHidraulica = new JCheckBox("Dire\u00E7\u00E3o Hidraulica");
		chckbxDirecaoHidraulica.setEnabled(false);
		chckbxDirecaoHidraulica.setBounds(135, 29, 172, 24);
		panelAcessorios.add(chckbxDirecaoHidraulica);
		
		chckbxMP3 = new JCheckBox("MP3");
		chckbxMP3.setEnabled(false);
		chckbxMP3.setBounds(8, 113, 50, 24);
		panelAcessorios.add(chckbxMP3);
		
		chckbxCameraRe = new JCheckBox("C\u00E2mera de R\u00E9");
		chckbxCameraRe.setEnabled(false);
		chckbxCameraRe.setBounds(8, 141, 105, 24);
		panelAcessorios.add(chckbxCameraRe);
		
		comboBoTipoCambio = new JComboBox();
		comboBoTipoCambio.setEnabled(false);
		comboBoTipoCambio.setModel(new DefaultComboBoxModel(new String[] {"Autom\u00E1tico", "Dualogic", "Manual", "CVT"}));
		comboBoTipoCambio.setBounds(214, 59, 93, 20);
		panelAcessorios.add(comboBoTipoCambio);
		
		labelTipoCambio = new JLabel("Tipo C\u00E2mbio:");
		labelTipoCambio.setBounds(135, 61, 73, 16);
		panelAcessorios.add(labelTipoCambio);
		
		labelAcessorios = new JLabel("Acess\u00F3rios");
		labelAcessorios.setForeground(new Color(0, 0, 102));
		labelAcessorios.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelAcessorios.setBounds(10, 0, 65, 16);
		panelAcessorios.add(labelAcessorios);
		
		chckbxComputadorDeBordo = new JCheckBox("Computador de Bordo");
		chckbxComputadorDeBordo.setEnabled(false);
		chckbxComputadorDeBordo.setBounds(135, 113, 172, 24);
		panelAcessorios.add(chckbxComputadorDeBordo);
		
		chckbxRodasLigaLeve = new JCheckBox("Rodas de Liga Leve");
		chckbxRodasLigaLeve.setEnabled(false);
		chckbxRodasLigaLeve.setBounds(323, 29, 135, 24);
		panelAcessorios.add(chckbxRodasLigaLeve);
		
		chckbxCintosRetrateis = new JCheckBox("Cintos Traz. Retrateis");
		chckbxCintosRetrateis.setEnabled(false);
		chckbxCintosRetrateis.setBounds(135, 141, 172, 24);
		panelAcessorios.add(chckbxCintosRetrateis);
		
		chckbxControlePoluicao = new JCheckBox("Controle de Polu\u00ED\u00E7\u00E3o");
		chckbxControlePoluicao.setEnabled(false);
		chckbxControlePoluicao.setBounds(323, 57, 142, 24);
		panelAcessorios.add(chckbxControlePoluicao);
		
		chckbxAcionamentoHemb = new JCheckBox("Acionamento Embreagem");
		chckbxAcionamentoHemb.setEnabled(false);
		chckbxAcionamentoHemb.setBounds(323, 85, 172, 24);
		panelAcessorios.add(chckbxAcionamentoHemb);
		
		labelCapacidadeDeCarga = new JLabel("Capacidade de Carga:");
		labelCapacidadeDeCarga.setBounds(509, 89, 124, 16);
		panelAcessorios.add(labelCapacidadeDeCarga);
		
		fieldCapacidadeCarga = new JFormattedTextField();
		fieldCapacidadeCarga.setEditable(false);
		DecimalFormat dFormat3 = new DecimalFormat("##.00");
		dFormat3.setMaximumIntegerDigits(2);
		NumberFormatter Formatter3 = new NumberFormatter(dFormat3);
		Formatter3.setFormat (dFormat3);
		Formatter3.setAllowsInvalid (false);
		fieldCapacidadeCarga.setFormatterFactory(new DefaultFormatterFactory(Formatter3));
		fieldCapacidadeCarga.setText(",00");
		fieldCapacidadeCarga.setBounds(635, 87, 49, 20);
		panelAcessorios.add(fieldCapacidadeCarga);
		fieldCapacidadeCarga.setColumns(10);
		
		labelDistnciaEntreEixos = new JLabel("Dist\u00E2ncia entre Eixos:");
		labelDistnciaEntreEixos.setBounds(510, 31, 123, 16);
		panelAcessorios.add(labelDistnciaEntreEixos);

		fieldDistanciEixos = new JFormattedTextField();
		fieldDistanciEixos.setEditable(false);
		fieldDistanciEixos.setBounds(635, 29, 49, 20);
		DecimalFormat dFormat = new DecimalFormat("##.00");
		dFormat.setMaximumIntegerDigits(1);
		NumberFormatter Formatter = new NumberFormatter(dFormat);
		Formatter.setFormat (dFormat);
		Formatter.setAllowsInvalid (false);
		fieldDistanciEixos.setFormatterFactory(new DefaultFormatterFactory(Formatter));
		fieldDistanciEixos.setText(",00");
		panelAcessorios.add(fieldDistanciEixos);
		fieldDistanciEixos.setColumns(10);
		
		labelVolAbastecimento = new JLabel("Vol. de Abastecimento:");
		labelVolAbastecimento.setBounds(503, 117, 130, 16);
		panelAcessorios.add(labelVolAbastecimento);
		
		fieldVolumeAbastecimento = new JFormattedTextField();
		DecimalFormat dFormat1 = new DecimalFormat("###.00");
		dFormat1.setMaximumIntegerDigits(2);
		NumberFormatter Formatter1 = new NumberFormatter(dFormat1);
		Formatter1.setFormat (dFormat1);
		Formatter1.setAllowsInvalid (false);
		fieldVolumeAbastecimento.setFormatterFactory(new DefaultFormatterFactory(Formatter1));
		fieldVolumeAbastecimento.setText(",00");
		fieldVolumeAbastecimento.setEditable(false);
		fieldVolumeAbastecimento.setBounds(635, 115, 49, 20);
		panelAcessorios.add(fieldVolumeAbastecimento);
		fieldVolumeAbastecimento.setColumns(10);
		
		labelDesempenho = new JLabel("Desempenho:");
		labelDesempenho.setBounds(555, 61, 78, 16);
		panelAcessorios.add(labelDesempenho);
		
		fieldDesempenho = new JFormattedTextField();
		fieldDesempenho.setEditable(false);
		DecimalFormat dFormat4 = new DecimalFormat("##.00");
		dFormat4.setMaximumIntegerDigits(2);
		NumberFormatter Formatter4 = new NumberFormatter(dFormat4);
		Formatter4.setFormat (dFormat4);
		Formatter4.setAllowsInvalid (false);
		fieldDesempenho.setFormatterFactory(new DefaultFormatterFactory(Formatter4));
		fieldDesempenho.setText(",00");
		fieldDesempenho.setBounds(635, 59, 49, 20);
		panelAcessorios.add(fieldDesempenho);
		fieldDesempenho.setColumns(10);
		
		labelOutros = new JLabel("Outros");
		labelOutros.setForeground(new Color(0, 0, 102));
		labelOutros.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelOutros.setBounds(510, 0, 39, 16);
		panelAcessorios.add(labelOutros);
		
		labelAirbag = new JLabel("Air-Bag:");
		labelAirbag.setBounds(135, 88, 45, 16);
		panelAcessorios.add(labelAirbag);
		
		comboBoxAirBag = new JComboBox();
		comboBoxAirBag.setEnabled(false);
		comboBoxAirBag.setModel(new DefaultComboBoxModel(new String[] {"Simples-Dianteira", "Duplo-Dianteira", "Total"}));
		comboBoxAirBag.setBounds(184, 86, 123, 20);
		panelAcessorios.add(comboBoxAirBag);


		buttonNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cleanFields();
				buttonSalvar.setEnabled(true);
				buttonExcluir.setEnabled(false);
				buttonLocalizar.setEnabled(false);
				buttonNovo.setEnabled(false);
				enableFields();
				enableFieldsPequeno();
				saveupdate = true;
			}
		});

		buttonSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (validaFields()) {
					if (saveupdate){
						Veiculo veiculo = new Veiculo();
						veiculo.setNumeroChassi(fieldChassi.getText());
						veiculo.setNumeroMotor(fieldNumMotor.getText());
						veiculo.setAnoFabricacao(yearChooserFabricacao.getYear());
						veiculo.setAnoModelo(yearChooserModelo.getYear());
						veiculo.setCapacidadePassageiroos((int) comboBoxPassageiros.getSelectedItem());
						veiculo.setCombustivel((String) comboBoxCombustivel.getSelectedItem());
						veiculo.setCor(fieldCor.getText());
						veiculo.setNumeroPortas(Integer.parseInt(String.valueOf(comboBoxNumPortas.getSelectedItem()).substring(0, 1)));
						veiculo.setPlaca(formattedTextFieldPlaca.getText().replaceAll("[.-]", ""));
						veiculo.setTorqueDoMotor(Double.parseDouble(formattedTextFieldTorque.getText()));
						veiculo.setQuilometragem(Integer.parseInt(fieldKms.getText()));
						veiculo.setCategoria(categorias.get(comboBoxCategoria.getSelectedIndex()));
						switch (comboBoxTipo.getSelectedIndex()) {
							case 0:{veiculo.setTipo('A'); veiculo.setAcessorios(new Acessorios(chckbxArcondicionado.isSelected(), chckbxRadio.isSelected(), chckbxDVD.isSelected(), chckbxDirecaoHidraulica.isSelected(), chckbxMP3.isSelected(), chckbxCameraRe.isSelected(), (String) comboBoTipoCambio.getSelectedItem()));} break;
							case 1:{veiculo.setTipo('C'); veiculo.setAcessorios(new Acessorios(chckbxArcondicionado.isSelected(), chckbxRadio.isSelected(), chckbxDVD.isSelected(), chckbxDirecaoHidraulica.isSelected(), chckbxMP3.isSelected(), chckbxCameraRe.isSelected(), (String) comboBoTipoCambio.getSelectedItem(), (String) comboBoxAirBag.getSelectedItem(), chckbxComputadorDeBordo.isSelected(), chckbxCintosRetrateis.isSelected(), chckbxRodasLigaLeve.isSelected(), chckbxControlePoluicao.isSelected()));} break;
							case 2:{veiculo.setTipo('V'); veiculo.setAcessorios(new Acessorios(Double.parseDouble(fieldCapacidadeCarga.getText().replace(',', '.')), Double.parseDouble(fieldDistanciEixos.getText().replace(',', '.')), chckbxAcionamentoHemb.isSelected(), Double.parseDouble(fieldDesempenho.getText().replace(',', '.')), Double.parseDouble(fieldVolumeAbastecimento.getText().replace(',', '.'))));} break;
							default: break;
						}
						if(veiculoController.insert(veiculo))
							JOptionPane.showMessageDialog(null, "Veículo Cadastrado com Sucesso", "Mensagem Cadastro", JOptionPane.INFORMATION_MESSAGE);
						else
							JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Veículo", "Erro Inserção", JOptionPane.ERROR_MESSAGE);
					} else{
						veiculoUpdate.setID(Integer.parseInt(fieldCodigo.getText()));
						veiculoUpdate.setNumeroChassi(fieldChassi.getText());
						veiculoUpdate.setNumeroMotor(fieldNumMotor.getText());
						veiculoUpdate.setAnoFabricacao(yearChooserFabricacao.getYear());
						veiculoUpdate.setAnoModelo(yearChooserModelo.getYear());
						veiculoUpdate.setCapacidadePassageiroos((int) comboBoxPassageiros.getSelectedItem());
						veiculoUpdate.setCombustivel("COMBUSTIVEL");
						veiculoUpdate.setCombustivel((String) comboBoxCombustivel.getSelectedItem());
						veiculoUpdate.setCor(fieldCor.getText());
						veiculoUpdate.setNumeroPortas(Integer.parseInt(String.valueOf(comboBoxNumPortas.getSelectedItem()).substring(0, 1)));
						veiculoUpdate.setPlaca(formattedTextFieldPlaca.getText().replaceAll("[.-]", ""));
						veiculoUpdate.setTorqueDoMotor(Double.parseDouble(formattedTextFieldTorque.getText()));
						veiculoUpdate.setQuilometragem(Integer.parseInt(fieldKms.getText()));
						veiculoUpdate.setCategoria(categorias.get(comboBoxCategoria.getSelectedIndex()));
//						veiculoUpdate.getAcessorios().setID(veiculoUpdate.getAcessorios().getID());
						veiculoUpdate.getAcessorios().setArCondicionado(chckbxArcondicionado.isSelected());
						veiculoUpdate.getAcessorios().setRadio(chckbxRadio.isSelected());
						veiculoUpdate.getAcessorios().setDvd(chckbxDVD.isSelected());
						veiculoUpdate.getAcessorios().setDirecaoHidraulica(chckbxDirecaoHidraulica.isSelected());
						veiculoUpdate.getAcessorios().setMp3(chckbxMP3.isSelected());
						veiculoUpdate.getAcessorios().setCameraDeRe(chckbxCameraRe.isSelected());
						veiculoUpdate.getAcessorios().setTipoDeCambio((String) comboBoTipoCambio.getSelectedItem());
						veiculoUpdate.getAcessorios().setAirBag((String) comboBoxAirBag.getSelectedItem());
						veiculoUpdate.getAcessorios().setDirecaoAssistida(chckbxComputadorDeBordo.isSelected());
						veiculoUpdate.getAcessorios().setCintosTraseirosRetrateis(chckbxCintosRetrateis.isSelected());
						veiculoUpdate.getAcessorios().setRodasDeLigaLeve(chckbxRodasLigaLeve.isSelected());
						veiculoUpdate.getAcessorios().setControleDePoluicao(chckbxControlePoluicao.isSelected());
						veiculoUpdate.getAcessorios().setCapacidadeDeCarga(Double.parseDouble(fieldCapacidadeCarga.getText().replace(',', '.')));
						veiculoUpdate.getAcessorios().setDistanciaEntreEixos(Double.parseDouble(fieldDistanciEixos.getText().replace(',', '.')));
						veiculoUpdate.getAcessorios().setAcionamentoEmbreagem(chckbxAcionamentoHemb.isSelected());
						veiculoUpdate.getAcessorios().setDesempenhoDoVeiculo(Double.parseDouble(fieldDesempenho.getText().replace(',', '.')));
						veiculoUpdate.getAcessorios().setVolumeDeAbastecimento(Double.parseDouble(fieldVolumeAbastecimento.getText().replace(',', '.')));

						if(veiculoController.commit()){
							JOptionPane.showMessageDialog(null, "Veículo Alterado com Sucesso", "Mensagem Cadastro", JOptionPane.INFORMATION_MESSAGE);
							veiculoUpdate = null;
						}
						else
							JOptionPane.showMessageDialog(null, "Erro ao Alterar Veículo", "Erro Autalização", JOptionPane.ERROR_MESSAGE);
					}	

					cleanFields();
				}
			}

		});

		buttonExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (JOptionPane.showConfirmDialog(null, "Deseja Realmente Excluir ?", "Excluir Veículo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==0) {
				
					if(veiculoController.delete(fieldChassi.getText()))
						JOptionPane.showMessageDialog(null, "Veículo Excluído com Sucesso", "Mensagem Cadastro", JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "Erro ao Deletar Veículo", "Erro Remoção", JOptionPane.ERROR_MESSAGE);
					
					cleanFields();
					cleanFieldsPickup();
					cleanFieldsPequeno();
					cleanFieldsCarga();
					disableFieldsPickupCarga();
					disableFieldsPequeno();
					buttonNovo.setEnabled(true);
					buttonExcluir.setEnabled(false);
					buttonSalvar.setEnabled(false);
				}

			}
		});

		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cleanFields();
				cleanFieldsPickup();
				cleanFieldsPequeno();
				cleanFieldsCarga();
				disableFieldsPickupCarga();
				disableFieldsPequeno();
				buttonSalvar.setEnabled(false);
				buttonNovo.setEnabled(true);
				buttonExcluir.setEnabled(false);
				buttonLocalizar.setEnabled(true);
			}
		});

		buttonLocalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ConsultaVeiculo(TelaCadastroVeiculo.this).setVisible(true);
			}
		});

		setVisible(true);

	}


	private MaskFormatter Mascara(String mascara){
		MaskFormatter formatter;

		try {
			formatter = new MaskFormatter();
			formatter.setMask(mascara);
			return formatter;
		} catch (Exception e) {
			return null;
		}
	}

	
	private boolean validaFields() {
		if (fieldChassi.getText().isEmpty()||fieldCor.getText().isEmpty()||fieldKms.getText().isEmpty()||fieldNumMotor.getText().isEmpty()||formattedTextFieldPlaca.equals("   -    ")||
				formattedTextFieldTorque.equals(" . ")||fieldKms.getText().isEmpty()) {
			if(comboBoxTipo.getSelectedIndex()==2){ 
				if(fieldCapacidadeCarga.getText().equals(",00")||fieldVolumeAbastecimento.getText().equals(",00")||fieldDistanciEixos.getText().equals(",00")||
						fieldDesempenho.getText().equals(",00")){
					JOptionPane.showMessageDialog(null, "Campos Obrigatórios", null, JOptionPane.WARNING_MESSAGE);
					return false;
				}
			}
			JOptionPane.showMessageDialog(null, "Campos Obrigatórios", null, JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if(comboBoxTipo.getSelectedIndex()==2){ 
			if(fieldCapacidadeCarga.getText().equals(",00")||fieldVolumeAbastecimento.getText().equals(",00")||fieldDistanciEixos.getText().equals(",00")||
					fieldDesempenho.getText().equals(",00")){
				JOptionPane.showMessageDialog(null, "Campos Obrigatórios", null, JOptionPane.WARNING_MESSAGE);
				return false;
			}
		}
		return true;
	}
	
	public void cleanFields(){
		fieldCodigo.setText(null);
		fieldChassi.setText(null);
		fieldCor.setText(null);
		fieldNumMotor.setText(null);
		comboBoxCategoria.setSelectedIndex(0);
		comboBoxCombustivel.setSelectedIndex(0);
		comboBoxNumPortas.setSelectedIndex(0);
		comboBoxPassageiros.setSelectedIndex(0);
		comboBoxTipo.setSelectedIndex(0);
		formattedTextFieldPlaca.setValue(null);
		formattedTextFieldTorque.setValue(null);
		fieldKms.setText(null);
		yearChooserFabricacao.setValue(2016);
		yearChooserModelo.setValue(2016);
		cleanFieldsPequeno();
		cleanFieldsPickup();
		cleanFieldsCarga();
		disableFields();
		disableFieldsPequeno();
		disableFieldsPickup();
		disableFieldsPickupCarga();
		buttonNovo.setEnabled(true);
		buttonSalvar.setEnabled(false);
		buttonLocalizar.setEnabled(true);
		buttonExcluir.setEnabled(false);
	}

	public void disableFields(){
		fieldChassi.setEditable(false);
		fieldCor.setEditable(false);
		fieldNumMotor.setEditable(false);
		comboBoxCategoria.setEnabled(false);
		comboBoxCombustivel.setEnabled(false);
		comboBoxNumPortas.setEnabled(false);
		comboBoxPassageiros.setEnabled(false);
		comboBoxTipo.setEnabled(false);
		formattedTextFieldPlaca.setEditable(false);
		formattedTextFieldTorque.setEditable(false);
		fieldKms.setEditable(false);
		yearChooserFabricacao.setEnabled(false);
		yearChooserModelo.setEnabled(false);
	}

	public void enableFields(){
		fieldChassi.setEditable(true);
		fieldCor.setEditable(true);
		fieldNumMotor.setEditable(true);
		comboBoxCategoria.setEnabled(true);
		comboBoxCombustivel.setEnabled(true);
		comboBoxNumPortas.setEnabled(true);
		comboBoxPassageiros.setEnabled(true);
		comboBoxTipo.setEnabled(true);
		formattedTextFieldPlaca.setEditable(true);
		formattedTextFieldTorque.setEditable(true);
		fieldKms.setEditable(true);
		yearChooserFabricacao.setEnabled(true);
		yearChooserModelo.setEnabled(true);
		
	}
	
	public void enableFieldsPequeno(){
		chckbxArcondicionado.setEnabled(true);
		chckbxCameraRe.setEnabled(true);
		chckbxDirecaoHidraulica.setEnabled(true);
		chckbxDVD.setEnabled(true);
		chckbxMP3.setEnabled(true);
		chckbxRadio.setEnabled(true);
		comboBoTipoCambio.setEnabled(true);
	}
	
	public void disableFieldsPequeno(){
		chckbxArcondicionado.setEnabled(false);
		chckbxCameraRe.setEnabled(false);
		chckbxDirecaoHidraulica.setEnabled(false);
		chckbxDVD.setEnabled(false);
		chckbxMP3.setEnabled(false);
		chckbxRadio.setEnabled(false);
		comboBoTipoCambio.setEnabled(false);
	}
	
	public void cleanFieldsPequeno(){
		chckbxArcondicionado.setSelected(false);
		chckbxCameraRe.setSelected(false);
		chckbxDirecaoHidraulica.setSelected(false);
		chckbxDVD.setSelected(false);
		chckbxMP3.setSelected(false);
		chckbxRadio.setSelected(false);
		comboBoTipoCambio.setSelectedIndex(2);
	}
	
	public void enableFieldsPickup(){
		chckbxArcondicionado.setEnabled(true);
		chckbxCameraRe.setEnabled(true);
		chckbxDirecaoHidraulica.setEnabled(true);
		chckbxDVD.setEnabled(true);
		chckbxMP3.setEnabled(true);
		chckbxRadio.setEnabled(true);
		comboBoTipoCambio.setEnabled(true);
		comboBoxAirBag.setEnabled(true);
		chckbxComputadorDeBordo.setEnabled(true);
		chckbxRodasLigaLeve.setEnabled(true);
		chckbxCintosRetrateis.setEnabled(true);
		chckbxControlePoluicao.setEnabled(true);
	}
	
	public void disableFieldsPickup(){
		comboBoxAirBag.setEnabled(false);
		chckbxComputadorDeBordo.setEnabled(false);
		chckbxRodasLigaLeve.setEnabled(false);
		chckbxCintosRetrateis.setEnabled(false);
		chckbxControlePoluicao.setEnabled(false);
	}
	
	public void cleanFieldsPickup(){
		chckbxArcondicionado.setSelected(false);
		chckbxCameraRe.setSelected(false);
		chckbxDirecaoHidraulica.setSelected(false);
		chckbxDVD.setSelected(false);
		chckbxMP3.setSelected(false);
		chckbxRadio.setSelected(false);
		comboBoTipoCambio.setSelectedIndex(2);
		comboBoxAirBag.setSelectedIndex(0);
		chckbxComputadorDeBordo.setSelected(false);
		chckbxRodasLigaLeve.setSelected(false);
		chckbxCintosRetrateis.setSelected(false);
		chckbxControlePoluicao.setSelected(false);
	}
	
	public void enableFieldsPickupCarga(){
		chckbxAcionamentoHemb.setEnabled(true);
		fieldDesempenho.setEditable(true);
		fieldDistanciEixos.setEditable(true);
		fieldCapacidadeCarga.setEditable(true);
		fieldVolumeAbastecimento.setEditable(true);
	}
	
	public void disableFieldsPickupCarga(){
		chckbxAcionamentoHemb.setEnabled(false);
		fieldDesempenho.setEditable(false);
		fieldDistanciEixos.setEditable(false);
		fieldCapacidadeCarga.setEditable(false);
		fieldVolumeAbastecimento.setEditable(false);
	}
	
	public void cleanFieldsCarga(){
		chckbxAcionamentoHemb.setSelected(false);
		fieldDesempenho.setText(null);
		fieldDistanciEixos.setText(null);
		fieldCapacidadeCarga.setText(null);
		fieldVolumeAbastecimento.setText(null);

	}
	
	public void setFields(int codigo){
		veiculoUpdate = veiculoController.consultaIdUpdate(codigo);
		
		fieldCodigo.setText(String.valueOf(veiculoUpdate.getID()));
		fieldChassi.setText(veiculoUpdate.getNumeroChassi());
		fieldCor.setText(veiculoUpdate.getCor());
		fieldNumMotor.setText(veiculoUpdate.getNumeroMotor());
		comboBoxCategoria.setSelectedItem(veiculoUpdate.getCategoria().getDescricao());
		comboBoxCombustivel.setSelectedItem(veiculoUpdate.getCombustivel());
		comboBoxNumPortas.setSelectedItem(veiculoUpdate.getNumeroPortas());
		comboBoxPassageiros.setSelectedItem(veiculoUpdate.getCapacidadePassageiroos());
		formattedTextFieldPlaca.setText(veiculoUpdate.getPlaca());
		formattedTextFieldTorque.setText(String.valueOf(veiculoUpdate.getTorqueDoMotor()));
		fieldKms.setText(String.valueOf(veiculoUpdate.getQuilometragem()));
		yearChooserFabricacao.setValue(veiculoUpdate.getAnoFabricacao());
		yearChooserModelo.setValue(veiculoUpdate.getAnoModelo());
		chckbxArcondicionado.setSelected(veiculoUpdate.getAcessorios().isArCondicionado());
		chckbxCameraRe.setSelected(veiculoUpdate.getAcessorios().isCameraDeRe());
		chckbxDirecaoHidraulica.setSelected(veiculoUpdate.getAcessorios().isDirecaoHidraulica());
		chckbxDVD.setSelected(veiculoUpdate.getAcessorios().isDvd());
		chckbxMP3.setSelected(veiculoUpdate.getAcessorios().isMp3());
		chckbxRadio.setSelected(veiculoUpdate.getAcessorios().isRadio());
		comboBoTipoCambio.setSelectedItem(veiculoUpdate.getAcessorios().getTipoDeCambio());
		comboBoxAirBag.setSelectedItem(veiculoUpdate.getAcessorios().getAirBag());
		chckbxComputadorDeBordo.setSelected(veiculoUpdate.getAcessorios().isDirecaoAssistida());
		chckbxRodasLigaLeve.setSelected(veiculoUpdate.getAcessorios().isRodasDeLigaLeve());
		chckbxCintosRetrateis.setSelected(veiculoUpdate.getAcessorios().isCintosTraseirosRetrateis());
		chckbxControlePoluicao.setSelected(veiculoUpdate.getAcessorios().isControleDePoluicao());
		chckbxAcionamentoHemb.setSelected(veiculoUpdate.getAcessorios().isAcionamentoEmbreagem());
		fieldDesempenho.setText(String.valueOf(veiculoUpdate.getAcessorios().getDesempenhoDoVeiculo()));
		fieldDistanciEixos.setText(String.valueOf(veiculoUpdate.getAcessorios().getDistanciaEntreEixos()));
		fieldCapacidadeCarga.setText(String.valueOf(veiculoUpdate.getAcessorios().getCapacidadeDeCarga()));
		fieldVolumeAbastecimento.setText(String.valueOf(veiculoUpdate.getAcessorios().getVolumeDeAbastecimento()));
		
		if(veiculoUpdate.getTipo()=='A'){
			comboBoxTipo.setSelectedItem("Automóvel");
			enableFieldsPequeno();
		}
		else if(veiculoUpdate.getTipo()=='C'){
			comboBoxTipo.setSelectedItem("Caminhotene");
			enableFieldsPickup();
		}
		else{
			comboBoxTipo.setSelectedItem("Caminhotene de Carga");
			enableFieldsPickupCarga();
		}
		
		saveupdate = false;
		disableFields();
		enableFields();
		buttonExcluir.setEnabled(true);
		buttonSalvar.setEnabled(true);
		buttonNovo.setEnabled(false);
	}
	
	public void setPosicao() {
		Dimension d = this.getDesktopPane().getSize();
		this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
	}
}
