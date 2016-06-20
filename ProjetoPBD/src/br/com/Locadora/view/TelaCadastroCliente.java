package br.com.Locadora.view;

import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import java.awt.SystemColor;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

import com.toedter.calendar.JDateChooser;

public class TelaCadastroCliente extends JInternalFrame {

	private static final long serialVersionUID = 4083438630101664605L;

	private JPanel contentPane;
	private JPanel panelTitulo;
	private JPanel panelRodape;
	private JPanel panelEndereco;
	private JPanel panelDadosPrincipais;
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
	private JTextField fieldNome;
	private JTextField fieldCidade;
	private JTextField fieldBairro;
	private JTextField fieldRua;
	private JTextField fieldNumero;
	private JFormattedTextField fieldCPF;
	private JFormattedTextField fieldHabilitacao;
	private JFormattedTextField fieldCNPJ;
	private JFormattedTextField fieldInscEstadual;
	private JButton buttonCadastrar;
	private JButton buttonCancelar;
	private JRadioButton radiobuttonPFisica;
	private JRadioButton radiobuttonPJurdica;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxSexo;
	private ButtonGroup grupo;
	private JDateChooser dateChooserNascimento;
    private JDateChooser dateChooserCNH;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCliente frame = new TelaCadastroCliente();
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
	@SuppressWarnings("rawtypes")
	public TelaCadastroCliente() {
		setTitle("Cadastro de Clientes");
		setClosable(true);
		setBounds(100, 100, 672, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelTitulo = new JPanel();
		panelTitulo.setBackground(SystemColor.inactiveCaption);
		panelTitulo.setBounds(0, 0, 656, 71);
		contentPane.add(panelTitulo);
		
		labelTitulos = new JLabel("Cadastro de Clientes");
		labelTitulos.setFont(new Font("SansSerif", Font.BOLD, 32));
		labelTitulos.setForeground(new Color(0, 0, 102));
		panelTitulo.add(labelTitulos);
		
		panelRodape = new JPanel();
		panelRodape.setBackground(SystemColor.inactiveCaption);
		panelRodape.setBounds(0, 410, 656, 16);
		contentPane.add(panelRodape);
		
		radiobuttonPFisica = new JRadioButton("F\u00EDsica", true);
		radiobuttonPFisica.setFont(new Font("SansSerif", Font.BOLD, 12));
		radiobuttonPFisica.setBounds(10, 89, 58, 24);
		contentPane.add(radiobuttonPFisica);
		
		radiobuttonPJurdica = new JRadioButton("Jur\u00EDdica");
		radiobuttonPJurdica.setFont(new Font("SansSerif", Font.BOLD, 12));
		radiobuttonPJurdica.setBounds(77, 89, 71, 24);
		contentPane.add(radiobuttonPJurdica);
		
		grupo = new ButtonGroup();		
		grupo.add(radiobuttonPFisica);
		grupo.add(radiobuttonPJurdica);
		
		panelDadosPrincipais = new JPanel();
		panelDadosPrincipais.setBackground(new Color(204, 204, 204));
		panelDadosPrincipais.setBounds(10, 118, 634, 165);
		panelDadosPrincipais.setVisible(true);
		
		panelEndereco = new JPanel();
		panelEndereco.setBounds(10, 288, 634, 116);
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
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"ACRE (AC)", "ALAGOAS (AL)", "AMAP\u00C1 (AP)", "AMAZONAS (AM)", "BAHIA (BA)", "CEAR\u00C1 (CE)", "DISTRITO FEDERAL (DF)", "ESP\u00CDRITO SANTO (ES)", "GOI\u00C1S (GO)", "MARANH\u00C3O (MA)", "MATO GROSSO (MT)", "MATO GROSSO DO SUL (MS)", "MINAS GERAIS (MG)", "PAR\u00C1(PA) ", "PARA\u00CDBA (PB)", "PARAN\u00C1 (PR)", "PERNAMBUCO (PE)", "PIAU\u00CD (PI)", "RIO DE JANEIRO (RJ)", "RIO GRANDE DO NORTE (RN)", "RIO GRANDE DO SUL (RS)", "ROND\u00D4NIA (RO)", "RORAIMA (RR)", "SANTA CATARINA (SC)", "S\u00C3O PAULO (SP)", "SERGIPE (SE)", "TOCANTINS (TO)"}));
		comboBox.setBounds(49, 71, 189, 20);
		panelEndereco.add(comboBox);
		
		labelCidade = new JLabel("Cidade:");
		labelCidade.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelCidade.setBounds(262, 49, 42, 16);
		panelEndereco.add(labelCidade);
		
		fieldCidade = new JTextField();
		fieldCidade.setBounds(307, 47, 180, 20);
		panelEndereco.add(fieldCidade);
		fieldCidade.setColumns(10);
		
		labelBairro = new JLabel("Bairro:");
		labelBairro.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelBairro.setBounds(8, 49, 38, 16);
		panelEndereco.add(labelBairro);
		
		fieldBairro = new JTextField();
		fieldBairro.setBounds(49, 47, 202, 20);
		panelEndereco.add(fieldBairro);
		fieldBairro.setColumns(10);
		
		fieldRua = new JTextField();
		fieldRua.setColumns(10);
		fieldRua.setBounds(49, 23, 345, 20);
		panelEndereco.add(fieldRua);
		
		labelRua = new JLabel("Rua:");
		labelRua.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelRua.setBounds(21, 25, 25, 16);
		panelEndereco.add(labelRua);
		
		fieldNumero = new JTextField();
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
		labelCPF.setBounds(21, 47, 25, 20);
		labelCPF.setFont(new Font("SansSerif", Font.BOLD, 12));
		panelDadosPrincipais.add(labelCPF);
		
		fieldCPF = new JFormattedTextField(Mascara("###.###.###-##"));
		fieldCPF.setBounds(49, 47, 95, 20);
		panelDadosPrincipais.add(fieldCPF);
		fieldCPF.setColumns(10);
		
		fieldHabilitacao = new JFormattedTextField(Mascara("###########"));
		fieldHabilitacao.setColumns(10);
		fieldHabilitacao.setBounds(250, 73, 85, 20);
		panelDadosPrincipais.add(fieldHabilitacao);
		
		labelHabilitacao = new JLabel("N\u00FAmero da CNH:");
		labelHabilitacao.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelHabilitacao.setBounds(154, 73, 92, 20);
		panelDadosPrincipais.add(labelHabilitacao);
		
		labelDataNascimento = new JLabel("Data de Nascimento:");
		labelDataNascimento.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelDataNascimento.setBounds(14, 100, 122, 16);
		panelDadosPrincipais.add(labelDataNascimento);
		
		labelVencHabilitacao = new JLabel("Vencimento da CNH:");
		labelVencHabilitacao.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelVencHabilitacao.setBounds(343, 75, 122, 16);
		panelDadosPrincipais.add(labelVencHabilitacao);
		
		labelSexo = new JLabel("Sexo:");
		labelSexo.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelSexo.setBounds(14, 73, 32, 20);
		panelDadosPrincipais.add(labelSexo);
		
		comboBoxSexo = new JComboBox();
		comboBoxSexo.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino"}));
		comboBoxSexo.setBounds(49, 73, 95, 20);
		panelDadosPrincipais.add(comboBoxSexo);
		
		labelInscEstadual = new JLabel("Insc. Estadual:");
		labelInscEstadual.setBounds(320, 47, 82, 20);
		panelDadosPrincipais.add(labelInscEstadual);
		labelInscEstadual.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		labelCNPJ = new JLabel("CNPJ:");
		labelCNPJ.setBounds(154, 47, 34, 20);
		panelDadosPrincipais.add(labelCNPJ);
		labelCNPJ.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		fieldCNPJ = new JFormattedTextField(Mascara("##.###.###/####-##"));
		fieldCNPJ.setEditable(false);
		fieldCNPJ.setBounds(190, 47, 117, 20);
		panelDadosPrincipais.add(fieldCNPJ);
		fieldCNPJ.setColumns(10);
		
		fieldInscEstadual = new JFormattedTextField(Mascara("############"));
		fieldInscEstadual.setEditable(false);
		fieldInscEstadual.setBounds(404, 47, 125, 20);
		panelDadosPrincipais.add(fieldInscEstadual);
		fieldInscEstadual.setColumns(10);
		
		labelNome = new JLabel("Nome:");
		labelNome.setBounds(10, 22, 36, 20);
		panelDadosPrincipais.add(labelNome);
		labelNome.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		fieldNome = new JTextField();
		fieldNome.setBounds(49, 22, 345, 20);
		panelDadosPrincipais.add(fieldNome);
		fieldNome.setColumns(10);
		
		labelDadosPrincipais = new JLabel("Dados Principais");
		labelDadosPrincipais.setForeground(new Color(0, 0, 102));
		labelDadosPrincipais.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelDadosPrincipais.setBounds(4, 0, 96, 16);
		panelDadosPrincipais.add(labelDadosPrincipais);
		
		dateChooserNascimento = new JDateChooser();
		dateChooserNascimento.setBounds(136, 98, 92, 20);
		panelDadosPrincipais.add(dateChooserNascimento);
		
		dateChooserCNH = new JDateChooser();
		dateChooserCNH.setBounds(463, 73, 92, 20);
		panelDadosPrincipais.add(dateChooserCNH);
		
		buttonCadastrar = new JButton("Cadastrar");
		buttonCadastrar.setBackground(new Color(204, 255, 255));
		buttonCadastrar.setForeground(new Color(0, 102, 0));
		buttonCadastrar.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonCadastrar.setBounds(259, 80, 105, 23);
		contentPane.add(buttonCadastrar);
		
		buttonCancelar = new JButton("Cancelar");
		buttonCancelar.setForeground(new Color(255, 0, 0));
		buttonCancelar.setBackground(new Color(255, 204, 255));
		buttonCancelar.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonCancelar.setBounds(409, 79, 105, 23);
		contentPane.add(buttonCancelar);
		
		labelPessoa = new JLabel("Pessoa");
		labelPessoa.setForeground(new Color(0, 0, 102));
		labelPessoa.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelPessoa.setBounds(14, 74, 43, 16);
		contentPane.add(labelPessoa);
		
		radiobuttonPFisica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (radiobuttonPFisica.isSelected()){
					fieldCPF.setEditable(true);
					fieldHabilitacao.setEditable(true);
					comboBoxSexo.setEnabled(true);
					fieldCNPJ.setEditable(false);
					fieldInscEstadual.setEditable(false);
				}
			}
		});

		radiobuttonPJurdica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radiobuttonPJurdica.isSelected()){
					fieldCPF.setEditable(false);
					fieldHabilitacao.setEditable(false);
					comboBoxSexo.setEnabled(false);
					fieldCNPJ.setEditable(true);
					fieldInscEstadual.setEditable(true);
				}
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
}
