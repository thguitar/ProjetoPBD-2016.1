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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class TelaCadastroVeiculo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField txtEdc;
	private JTextField textField_5;
	private JTextField textField_4;
	private JTextField txtEx;

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
		setResizable(false);
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
		
		JLabel lblCadastroDeVeiculos = new JLabel("Cadastro de Ve\u00EDculos");
		lblCadastroDeVeiculos.setForeground(new Color(0, 0, 102));
		lblCadastroDeVeiculos.setFont(new Font("SansSerif", Font.BOLD, 32));
		panel.add(lblCadastroDeVeiculos);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 255));
		panel_1.setBounds(0, 360, 637, 18);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("N\u00BA do chassi");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel.setBounds(38, 88, 73, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblCombustvel = new JLabel("Cappacidade de Passageiros");
		lblCombustvel.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblCombustvel.setBounds(353, 139, 169, 14);
		contentPane.add(lblCombustvel);
		
		JLabel lblAnoDoModelo = new JLabel("Ano do modelo");
		lblAnoDoModelo.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblAnoDoModelo.setBounds(134, 88, 87, 14);
		contentPane.add(lblAnoDoModelo);
		
		JLabel lblAnoDeFaricao = new JLabel("Ano de Farica\u00E7\u00E3o");
		lblAnoDeFaricao.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblAnoDeFaricao.setBounds(244, 88, 101, 14);
		contentPane.add(lblAnoDeFaricao);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblPlaca.setBounds(365, 88, 35, 14);
		contentPane.add(lblPlaca);
		
		JLabel lblCor = new JLabel("Cor");
		lblCor.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblCor.setBounds(294, 139, 23, 14);
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
		
		txtEdc = new JTextField();
		txtEdc.setBounds(353, 108, 55, 20);
		contentPane.add(txtEdc);
		txtEdc.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(10, 163, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNDePortas = new JLabel("N\u00BA de portas");
		lblNDePortas.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNDePortas.setBounds(197, 139, 73, 14);
		contentPane.add(lblNDePortas);
		
		JLabel lblNDoMotor = new JLabel("N\u00BA do motor");
		lblNDoMotor.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNDoMotor.setBounds(114, 139, 73, 14);
		contentPane.add(lblNDoMotor);
		
		JLabel lblCombustvel_1 = new JLabel("Combust\u00EDvel");
		lblCombustvel_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblCombustvel_1.setBounds(20, 139, 73, 14);
		contentPane.add(lblCombustvel_1);
		
		JLabel lblQuilometragem = new JLabel("Quilometragem");
		lblQuilometragem.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblQuilometragem.setBounds(410, 88, 92, 14);
		contentPane.add(lblQuilometragem);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1 porta", "2 portas", "3 portas", "4 portas"}));
		comboBox.setBounds(197, 163, 73, 20);
		contentPane.add(comboBox);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(410, 108, 92, 20);
		contentPane.add(textField_4);
		
		JLabel lblTorqueDoMotor = new JLabel("Torque do Motor");
		lblTorqueDoMotor.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblTorqueDoMotor.setBounds(10, 194, 101, 14);
		contentPane.add(lblTorqueDoMotor);
		
		txtEx = new JTextField();
		txtEx.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtEx.setText("");
			}
		});
		txtEx.setText("Ex: 2.5");
		txtEx.setToolTipText("");
		txtEx.setForeground(new Color(0, 153, 255));
		txtEx.setFont(new Font("SansSerif", Font.PLAIN, 11));
		txtEx.setColumns(10);
		txtEx.setBounds(20, 219, 63, 20);
		contentPane.add(txtEx);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblCategoria.setBounds(116, 194, 58, 14);
		contentPane.add(lblCategoria);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Pequena", "M\u00E9dia", "Grande"}));
		comboBox_1.setBounds(116, 219, 73, 20);
		contentPane.add(comboBox_1);
		
		JButton btnAsd = new JButton("Cadastrar");
		btnAsd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAsd.setForeground(new Color(0, 102, 0));
		btnAsd.setBackground(new Color(204, 255, 255));
		btnAsd.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnAsd.setBounds(162, 287, 120, 23);
		contentPane.add(btnAsd);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setForeground(new Color(255, 0, 0));
		btnCancelar.setBackground(new Color(255, 204, 255));
		btnCancelar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnCancelar.setBounds(319, 287, 120, 23);
		contentPane.add(btnCancelar);
		
		JComboBox comboBox_2 = new JComboBox();
		for (int i = 2017; i>1981; i-- ){
			comboBox_2.addItem(i);
		}
		comboBox_2.setBounds(144, 108, 63, 20);
		contentPane.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		for (int i = 2016; i>1981; i-- ){
			comboBox_3.addItem(i);
		}
		comboBox_3.setBounds(265, 108, 63, 20);
		contentPane.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		for (int i = 1; i<48; i++ ){
			comboBox_4.addItem(i);
		}
		comboBox_4.setBounds(399, 164, 63, 20);
		contentPane.add(comboBox_4);
		
		setVisible(true);
	}
}
