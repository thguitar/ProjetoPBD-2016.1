package br.com.Locadora.view;

import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;


public class TelaConfiguracoes extends JInternalFrame {

	private static final long serialVersionUID = 4083438630101664605L;

	private JPanel contentPane;
	private JPanel panelTitulo;
	private JPanel panelRodape;
	private JPanel panelDadosPrincipais;
	private JLabel labelTitulos;
	private JLabel labelPlanoDeFundo;
	private JLabel labelDadosPrincipais;
	private JButton buttonSalvar;
	private JButton buttonCancelar;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxPlanoDeFundo;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TelaConfiguracoes() {
		setTitle("Configura\u00E7\u00F5es                                                                                                                                                                              ");
		setClosable(true);
		setBounds(100, 100, 672, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelTitulo = new JPanel();
		panelTitulo.setBackground(SystemColor.inactiveCaption);
		panelTitulo.setBounds(0, 0, 656, 71);
		contentPane.add(panelTitulo);

		labelTitulos = new JLabel("Configura\u00E7\u00F5es");
		labelTitulos.setLocation(216, 75);
		labelTitulos.setFont(new Font("SansSerif", Font.BOLD, 32));
		labelTitulos.setForeground(new Color(0, 0, 102));
		panelTitulo.add(labelTitulos);

		panelRodape = new JPanel();
		panelRodape.setBackground(SystemColor.inactiveCaption);
		panelRodape.setBounds(0, 410, 656, 16);
		contentPane.add(panelRodape);

		panelDadosPrincipais = new JPanel();
		panelDadosPrincipais.setBackground(new Color(204, 204, 204));
		panelDadosPrincipais.setBounds(10, 118, 634, 165);
		panelDadosPrincipais.setVisible(true);
		contentPane.add(panelDadosPrincipais);
		panelDadosPrincipais.setLayout(null);

		comboBoxPlanoDeFundo = new JComboBox();
		comboBoxPlanoDeFundo.setModel(new DefaultComboBoxModel(new String[] {"Black", "White"}));
		comboBoxPlanoDeFundo.setBounds(107, 20, 66, 20);
		panelDadosPrincipais.add(comboBoxPlanoDeFundo);

		labelPlanoDeFundo = new JLabel("Plano de Fundo :");
		labelPlanoDeFundo.setBounds(10, 22, 92, 16);
		panelDadosPrincipais.add(labelPlanoDeFundo);
		labelPlanoDeFundo.setFont(new Font("SansSerif", Font.BOLD, 12));

		labelDadosPrincipais = new JLabel("Dados Principais");
		labelDadosPrincipais.setForeground(new Color(0, 0, 102));
		labelDadosPrincipais.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelDadosPrincipais.setBounds(4, 0, 96, 16);
		panelDadosPrincipais.add(labelDadosPrincipais);

		buttonCancelar = new JButton();
		buttonCancelar.setIcon(new ImageIcon("imagens/undoButton.png"));
		buttonCancelar.setToolTipText("Gravar");
		buttonCancelar.setForeground(Color.BLACK);
		buttonCancelar.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonCancelar.setEnabled(false);
		buttonCancelar.setBackground(SystemColor.inactiveCaption);
		buttonCancelar.setBounds(336, 83, 50, 26);
		contentPane.add(buttonCancelar);

		buttonSalvar = new JButton();
		buttonSalvar.setIcon(new ImageIcon("imagens/saveButton.png"));
		buttonSalvar.setToolTipText("Novo");
		buttonSalvar.setForeground(Color.BLACK);
		buttonSalvar.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonSalvar.setBackground(SystemColor.inactiveCaption);
		buttonSalvar.setBounds(274, 83, 50, 26);
		contentPane.add(buttonSalvar);

		setVisible(true);
	}

	public void setPosicao() {
		Dimension d = this.getDesktopPane().getSize();
		this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); }
}