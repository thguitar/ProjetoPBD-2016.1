package br.com.Locadora.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.SystemColor;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class TelaCadastroCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private ButtonGroup grupo;
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
	public TelaCadastroCliente() {
		grupo = new ButtonGroup();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(0, 0, 656, 71);
		contentPane.add(panel);
		
		JLabel lblCadastroDeClientes = new JLabel("Cadastro de Clientes");
		lblCadastroDeClientes.setFont(new Font("SansSerif", Font.BOLD, 32));
		lblCadastroDeClientes.setForeground(new Color(0, 0, 102));
		panel.add(lblCadastroDeClientes);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBounds(0, 400, 656, 16);
		contentPane.add(panel_1);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNome.setBounds(10, 82, 46, 14);
		contentPane.add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(10, 107, 209, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JRadioButton rdbtnPessoaFisica = new JRadioButton("Pessoa Fisica", true);
		rdbtnPessoaFisica.setFont(new Font("SansSerif", Font.BOLD, 12));
		rdbtnPessoaFisica.setBounds(297, 92, 109, 23);
		contentPane.add(rdbtnPessoaFisica);
		
		JRadioButton rdbtnPessoaJurdica = new JRadioButton("Pessoa Jur\u00EDdica");
		rdbtnPessoaJurdica.setFont(new Font("SansSerif", Font.BOLD, 12));
		rdbtnPessoaJurdica.setBounds(444, 92, 109, 23);
		contentPane.add(rdbtnPessoaJurdica);
		
		grupo.add(rdbtnPessoaFisica);
		grupo.add(rdbtnPessoaJurdica);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 204, 204));
		panel_2.setBounds(10, 138, 209, 256);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(10, 31, 47, 16);
		lblEstado.setFont(new Font("SansSerif", Font.BOLD, 12));
		panel_2.add(lblEstado);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setBounds(74, 0, 54, 16);
		lblEndereo.setForeground(new Color(0, 0, 102));
		lblEndereo.setFont(new Font("SansSerif", Font.BOLD, 12));
		panel_2.add(lblEndereo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Acre (AC)", "Alagoas (AL)", "Amap\u00E1 (AP)", "Amazonas (AM)", "Bahia (BA)", "Cear\u00E1 (CE)", "Distrito Federal (DF)", "Esp\u00EDrito Santo (ES)", "Goi\u00E1s (GO)", "Maranh\u00E3o (MA)", "Mato Grosso (MT)", "Mato Grosso do Sul (MS)", "Minas Gerais (MG)", "Par\u00E1 (PA) ", "Para\u00EDba (PB)", "Paran\u00E1 (PR)", "Pernambuco (PE)", "Piau\u00ED (PI)", "Rio de Janeiro (RJ)", "Rio Grande do Norte (RN)", "Rio Grande do Sul (RS)", "Rond\u00F4nia (RO)", "Roraima (RR)", "Santa Catarina (SC)", "S\u00E3o Paulo (SP)", "Sergipe (SE)", "Tocantins (TO)"}));
		comboBox.setBounds(67, 30, 132, 20);
		panel_2.add(comboBox);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblCidade.setBounds(10, 64, 47, 16);
		panel_2.add(lblCidade);
		
		textField_1 = new JTextField();
		textField_1.setBounds(67, 58, 132, 20);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblBairro.setBounds(10, 95, 47, 16);
		panel_2.add(lblBairro);
		
		textField_2 = new JTextField();
		textField_2.setBounds(67, 91, 132, 20);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(67, 122, 132, 20);
		panel_2.add(textField_3);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblRua.setBounds(10, 126, 47, 16);
		panel_2.add(lblRua);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(67, 153, 71, 20);
		panel_2.add(textField_4);
		
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNmero.setBounds(10, 157, 60, 16);
		panel_2.add(lblNmero);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(204, 204, 204));
		panel_3.setBounds(229, 138, 417, 168);
		panel_3.setVisible(true);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(51, 11, 31, 16);
		lblCpf.setFont(new Font("SansSerif", Font.BOLD, 12));
		panel_3.add(lblCpf);
		
		textField_5 = new JTextField();
		textField_5.setBounds(10, 38, 115, 20);
		panel_3.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(240, 38, 115, 20);
		panel_3.add(textField_6);
		
		JLabel lblNmeroDaHabilitao = new JLabel("N\u00FAmero da Habilita\u00E7\u00E3o");
		lblNmeroDaHabilitao.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNmeroDaHabilitao.setBounds(230, 11, 128, 16);
		panel_3.add(lblNmeroDaHabilitao);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblDataDeNascimento.setBounds(10, 85, 122, 16);
		panel_3.add(lblDataDeNascimento);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_1.setBounds(132, 84, 37, 20);
		panel_3.add(comboBox_1);
		
		JLabel label_1 = new JLabel("/");
		label_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		label_1.setBounds(171, 88, 10, 16);
		panel_3.add(label_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox_2.setBounds(181, 85, 37, 20);
		panel_3.add(comboBox_2);
		
		JLabel label = new JLabel("/");
		label.setFont(new Font("SansSerif", Font.BOLD, 12));
		label.setBounds(224, 88, 10, 16);
		panel_3.add(label);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(230, 85, 53, 20);
		for (int i = 1916; i<2017; i++){
			comboBox_3.addItem(i);
		}
		panel_3.add(comboBox_3);
		
		JLabel lblVencimentoDaHab = new JLabel("Vencimento da Hab.");
		lblVencimentoDaHab.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblVencimentoDaHab.setBounds(10, 127, 122, 16);
		panel_3.add(lblVencimentoDaHab);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_4.setBounds(132, 126, 37, 20);
		panel_3.add(comboBox_4);
		
		JLabel label_2 = new JLabel("/");
		label_2.setFont(new Font("SansSerif", Font.BOLD, 12));
		label_2.setBounds(171, 130, 10, 16);
		panel_3.add(label_2);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox_5.setBounds(181, 127, 37, 20);
		panel_3.add(comboBox_5);
		
		JLabel label_3 = new JLabel("/");
		label_3.setFont(new Font("SansSerif", Font.BOLD, 12));
		label_3.setBounds(224, 130, 10, 16);
		panel_3.add(label_3);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setBounds(230, 127, 53, 20);
		for (int i = 2016; i<2022; i++){
			comboBox_6.addItem(i);
		}
		panel_3.add(comboBox_6);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblSexo.setBounds(132, 13, 31, 16);
		panel_3.add(lblSexo);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino"}));
		comboBox_7.setBounds(135, 38, 71, 20);
		panel_3.add(comboBox_7);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(204, 204, 204));
		panel_4.setBounds(229, 133, 417, 78);
		contentPane.add(panel_4);
		panel_4.setVisible(false);
		panel_4.setLayout(null);
		
		JLabel lblInscrioEstadual = new JLabel("Inscri\u00E7\u00E3o Estadual:");
		lblInscrioEstadual.setBounds(10, 11, 117, 16);
		lblInscrioEstadual.setFont(new Font("SansSerif", Font.BOLD, 12));
		panel_4.add(lblInscrioEstadual);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblCnpj.setBounds(10, 38, 40, 16);
		panel_4.add(lblCnpj);
		
		textField_7 = new JTextField();
		textField_7.setBounds(60, 38, 117, 20);
		panel_4.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(137, 10, 196, 20);
		panel_4.add(textField_8);
		textField_8.setColumns(10);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBackground(new Color(204, 255, 255));
		btnNewButton.setForeground(new Color(0, 102, 0));
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnNewButton.setBounds(301, 349, 105, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(255, 0, 0));
		btnCancelar.setBackground(new Color(255, 204, 255));
		btnCancelar.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnCancelar.setBounds(448, 350, 105, 23);
		contentPane.add(btnCancelar);
		
		rdbtnPessoaFisica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnPessoaFisica.isSelected()){
					panel_3.setVisible(true);
					panel_4.setVisible(false);
				}
			}
		});

		rdbtnPessoaJurdica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnPessoaJurdica.isSelected()){
					panel_4.setVisible(true);
					panel_3.setVisible(false);
				}
			}
		});
	}
}
