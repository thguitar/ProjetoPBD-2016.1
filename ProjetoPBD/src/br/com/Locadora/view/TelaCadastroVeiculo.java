package br.com.Locadora.view;

import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.toedter.calendar.JYearChooser;
import javax.swing.border.TitledBorder;

public class TelaCadastroVeiculo extends JInternalFrame {

	
	private static final long serialVersionUID = 3675788004973562001L;
	
	private JPanel contentPane;
	private JPanel panelRodape;
	private JPanel panelTitulo;
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
	private JTextField fieldChassi;
	private JTextField fieldCor;
	private JTextField fieldNumMotor;
	private JFormattedTextField formattedTextFieldPlaca;
	private JFormattedTextField formattedTextFieldTorque;
	private JFormattedTextField formattedTextFieldKms;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxNumPortas;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxCategoria;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxPassageiros;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxCombustivel;
	private JButton buttonCadastrar;
	private JButton buttonCancelar;
	private JYearChooser yearChooserModelo;
	private JYearChooser yearChooserFabricacao;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroVeiculo frame = new TelaCadastroVeiculo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings("rawtypes")
	public TelaCadastroVeiculo() {
		setClosable(true);
		setTitle("Cadastro de Ve\u00EDculos");
		setResizable(false);
		setBounds(100, 100, 641, 406);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(204, 204, 255));
		panelTitulo.setBounds(0, 0, 637, 66);
		contentPane.add(panelTitulo);
		
		labelTitulo = new JLabel("Cadastro de Ve\u00EDculos");
		labelTitulo.setForeground(new Color(0, 0, 102));
		labelTitulo.setFont(new Font("SansSerif", Font.BOLD, 32));
		panelTitulo.add(labelTitulo);
		
		panelRodape = new JPanel();
		panelRodape.setBackground(new Color(204, 204, 255));
		panelRodape.setBounds(0, 360, 637, 18);
		contentPane.add(panelRodape);
		
		labelChassi = new JLabel("N\u00BA do Chassi:");
		labelChassi.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelChassi.setBounds(10, 79, 74, 16);
		contentPane.add(labelChassi);
		
		labelCapacidade = new JLabel("Capacidade de Passageiros:");
		labelCapacidade.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelCapacidade.setBounds(380, 153, 162, 16);
		contentPane.add(labelCapacidade);
		
		labelAnoModelo = new JLabel("Ano do Modelo:");
		labelAnoModelo.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelAnoModelo.setBounds(163, 105, 86, 16);
		contentPane.add(labelAnoModelo);
		
		labelAnoFabricacao = new JLabel("Ano de Farica\u00E7\u00E3o:");
		labelAnoFabricacao.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelAnoFabricacao.setBounds(323, 105, 101, 16);
		contentPane.add(labelAnoFabricacao);
		
		labelPlaca = new JLabel("Placa:");
		labelPlaca.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelPlaca.setBounds(49, 104, 35, 16);
		contentPane.add(labelPlaca);
		
		labelCor = new JLabel("Cor:");
		labelCor.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelCor.setBounds(59, 129, 23, 16);
		contentPane.add(labelCor);
		
		fieldChassi = new JTextField();
		fieldChassi.setBounds(89, 77, 120, 20);
		contentPane.add(fieldChassi);
		fieldChassi.setColumns(10);
		
		fieldCor = new JTextField();
		fieldCor.setBounds(89, 127, 120, 20);
		contentPane.add(fieldCor);
		fieldCor.setColumns(10);
		
		fieldNumMotor = new JTextField();
		fieldNumMotor.setBounds(300, 77, 92, 20);
		contentPane.add(fieldNumMotor);
		fieldNumMotor.setColumns(10);
		
		formattedTextFieldPlaca = new JFormattedTextField(Mascara("UUU-####"));
		formattedTextFieldPlaca.setBounds(89, 102, 55, 20);
		contentPane.add(formattedTextFieldPlaca);
		formattedTextFieldPlaca.setColumns(10);
		
		labelNumPortas = new JLabel("N\u00BA de portas:");
		labelNumPortas.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelNumPortas.setBounds(205, 153, 72, 16);
		contentPane.add(labelNumPortas);
		
		labelNumMotor = new JLabel("N\u00BA do Motor:");
		labelNumMotor.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelNumMotor.setBounds(227, 79, 68, 16);
		contentPane.add(labelNumMotor);
		
		labelCombustivel = new JLabel("Combust\u00EDvel:");
		labelCombustivel.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelCombustivel.setBounds(229, 129, 73, 16);
		contentPane.add(labelCombustivel);
		
		labelQuilometragem = new JLabel("Quilometragem:");
		labelQuilometragem.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelQuilometragem.setBounds(426, 129, 91, 16);
		contentPane.add(labelQuilometragem);
		
		comboBoxNumPortas = new JComboBox();
		comboBoxNumPortas.setModel(new DefaultComboBoxModel(new String[] {"1 porta", "2 portas", "3 portas", "4 portas"}));
		comboBoxNumPortas.setBounds(282, 151, 73, 20);
		contentPane.add(comboBoxNumPortas);
		
		formattedTextFieldKms = new JFormattedTextField(Mascara("#########"));
		formattedTextFieldKms.setColumns(10);
		formattedTextFieldKms.setBounds(522, 127, 92, 20);
		contentPane.add(formattedTextFieldKms);
		
		labelTorqueMotor = new JLabel("Torque do Motor:");
		labelTorqueMotor.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelTorqueMotor.setBounds(410, 79, 96, 16);
		contentPane.add(labelTorqueMotor);
		
		formattedTextFieldTorque = new JFormattedTextField(Mascara("#.#"));
		formattedTextFieldTorque.setColumns(10);
		formattedTextFieldTorque.setBounds(511, 78, 23, 20);
		contentPane.add(formattedTextFieldTorque);
		
		labelCategoria = new JLabel("Categoria:");
		labelCategoria.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelCategoria.setBounds(26, 153, 58, 16);
		contentPane.add(labelCategoria);
		
		comboBoxCategoria = new JComboBox();
		comboBoxCategoria.setModel(new DefaultComboBoxModel(new String[] {"Pequena", "M\u00E9dia", "Grande"}));
		comboBoxCategoria.setBounds(89, 151, 91, 20);
		contentPane.add(comboBoxCategoria);
		
		buttonCadastrar = new JButton("Cadastrar");
		buttonCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonCadastrar.setForeground(new Color(0, 102, 0));
		buttonCadastrar.setBackground(new Color(204, 255, 255));
		buttonCadastrar.setFont(new Font("SansSerif", Font.BOLD, 14));
		buttonCadastrar.setBounds(162, 287, 120, 23);
		contentPane.add(buttonCadastrar);
		
		buttonCancelar = new JButton("Cancelar");
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonCancelar.setForeground(new Color(255, 0, 0));
		buttonCancelar.setBackground(new Color(255, 204, 255));
		buttonCancelar.setFont(new Font("SansSerif", Font.BOLD, 14));
		buttonCancelar.setBounds(319, 287, 120, 23);
		contentPane.add(buttonCancelar);
		
		comboBoxPassageiros = new JComboBox();
		for (int i = 1; i<=50; i++ ){
			comboBoxPassageiros.addItem(i);
		}
		comboBoxPassageiros.setBounds(548, 151, 63, 20);
		contentPane.add(comboBoxPassageiros);
		
		yearChooserModelo = new JYearChooser();
		yearChooserModelo.getSpinner().setLocation(0, 103);
		yearChooserModelo.getSpinner().setSize(48, 20);
		yearChooserModelo.setBounds(254, 103, 48, 20);
		contentPane.add(yearChooserModelo);
		
		yearChooserFabricacao = new JYearChooser();
		yearChooserFabricacao.setBounds(429, 103, 48, 20);
		contentPane.add(yearChooserFabricacao);
		
		comboBoxCombustivel = new JComboBox();
		comboBoxCombustivel.setModel(new DefaultComboBoxModel(new String[] {"Biodiesel", "Diesel", "Etanol", "Flex", "Gasolina", "G\u00E1s Natural", "Hidrog\u00EAnio"}));
		comboBoxCombustivel.setBounds(306, 127, 100, 20);
		contentPane.add(comboBoxCombustivel);
		
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
}
