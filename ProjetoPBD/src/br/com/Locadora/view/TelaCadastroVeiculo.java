package br.com.Locadora.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class TelaCadastroVeiculo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField txtEdc;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_4;
	private JTextField textField_7;
	private JTextField textField_8;

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

	/**
	 * Create the frame.
	 */
	public TelaCadastroVeiculo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 406);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setForeground(new Color(0, 0, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setResizable(false);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(0, 0, 637, 66);
		contentPane.add(panel);
		
		JLabel lblCadastroDeVeiculos = new JLabel("Cadastro de Veiculos");
		lblCadastroDeVeiculos.setForeground(new Color(0, 0, 102));
		lblCadastroDeVeiculos.setFont(new Font("SansSerif", Font.BOLD, 32));
		panel.add(lblCadastroDeVeiculos);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 255));
		panel_1.setBounds(0, 360, 637, 18);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("N\u00BA do chassi:");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 88, 73, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblCombustvel = new JLabel("Cappacidade de Passageiros:");
		lblCombustvel.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblCombustvel.setBounds(353, 139, 169, 14);
		contentPane.add(lblCombustvel);
		
		JLabel lblAnoDoModelo = new JLabel("Ano do modelo:");
		lblAnoDoModelo.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblAnoDoModelo.setBounds(134, 88, 87, 14);
		contentPane.add(lblAnoDoModelo);
		
		JLabel lblAnoDeFaricao = new JLabel("Ano de Farica\u00E7\u00E3o:");
		lblAnoDeFaricao.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblAnoDeFaricao.setBounds(244, 88, 101, 14);
		contentPane.add(lblAnoDeFaricao);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblPlaca.setBounds(355, 88, 35, 14);
		contentPane.add(lblPlaca);
		
		JLabel lblCor = new JLabel("Cor:");
		lblCor.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblCor.setBounds(273, 139, 23, 14);
		contentPane.add(lblCor);
		
		textField = new JTextField();
		textField.setBounds(10, 108, 120, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(273, 163, 77, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(101, 163, 92, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(134, 108, 106, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		txtEdc = new JTextField();
		txtEdc.setBounds(353, 108, 55, 20);
		contentPane.add(txtEdc);
		txtEdc.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(10, 163, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNDePortas = new JLabel("N\u00BA de portas:");
		lblNDePortas.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNDePortas.setBounds(197, 139, 73, 14);
		contentPane.add(lblNDePortas);
		
		JLabel lblNDoMotor = new JLabel("N\u00BA do motor:");
		lblNDoMotor.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNDoMotor.setBounds(101, 139, 73, 14);
		contentPane.add(lblNDoMotor);
		
		JLabel label_1 = new JLabel("Combust\u00EDvel:");
		label_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		label_1.setBounds(10, 139, 73, 14);
		contentPane.add(label_1);
		
		JLabel lblQuilometragem = new JLabel("Quilometragem:");
		lblQuilometragem.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblQuilometragem.setBounds(410, 88, 92, 14);
		contentPane.add(lblQuilometragem);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(244, 108, 106, 20);
		contentPane.add(textField_6);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1 porta", "2 portas", "3 portas", "4 portas"}));
		comboBox.setBounds(197, 163, 73, 20);
		contentPane.add(comboBox);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(410, 108, 92, 20);
		contentPane.add(textField_4);
		
		textField_7 = new JTextField();
		textField_7.setBounds(353, 164, 86, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblTorqueDoMotor = new JLabel("Torque do Motor:");
		lblTorqueDoMotor.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblTorqueDoMotor.setBounds(10, 194, 101, 14);
		contentPane.add(lblTorqueDoMotor);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(10, 219, 55, 20);
		contentPane.add(textField_8);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblCategoria.setBounds(116, 194, 58, 14);
		contentPane.add(lblCategoria);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Pequena", "M\u00E9dia", "Grande"}));
		comboBox_1.setBounds(116, 219, 73, 20);
		contentPane.add(comboBox_1);
		
		JButton btnAsd = new JButton("CONFIRMAR");
		btnAsd.setForeground(new Color(0, 100, 0));
		btnAsd.setBackground(new Color(144, 238, 144));
		btnAsd.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnAsd.setBounds(162, 287, 120, 23);
		contentPane.add(btnAsd);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setForeground(new Color(255, 0, 0));
		btnCancelar.setBackground(new Color(255, 228, 181));
		btnCancelar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnCancelar.setBounds(319, 287, 120, 23);
		contentPane.add(btnCancelar);
		
		setVisible(true);
	}
}
