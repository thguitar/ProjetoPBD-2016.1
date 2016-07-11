package br.com.Locadora.view;


import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import java.awt.SystemColor;

import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.Locadora.controller.TiposLocacaoController;
import br.com.Locadora.model.TiposLocacao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.util.List;


public class TelaManutencaoPreco extends JInternalFrame {


	private static final long serialVersionUID = -2513465114625279076L;
	
	private JPanel contentPane;
	private JPanel panelTitulo;
	private JPanel panelCentro;
	private JPanel panelRodape;
	private JLabel labelTitulo;
	private JLabel labelTipos;
	private JLabel labelDescricao;
	private JFormattedTextField fieldPrecoKml;
	private JTextField fieldKml;
	private JTextField fieldKmC;
	private JFormattedTextField textFieldPrecoKmc;
	private JButton buttonSalvar;
	private JButton buttonCancelar;
	private JButton buttonExcluir;
	private JButton buttonLocalizar;
	private JButton buttonNovo;

	private TiposLocacaoController controller;
	private List<TiposLocacao> tiposLocacaos;




	public TelaManutencaoPreco() {
		setTitle("Manuten\u00E7\u00E3o de Pre\u00E7os                                                                                 ");
		setClosable(true);
		setResizable(false);
		setBounds(100, 100, 439, 279);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		controller = new TiposLocacaoController();
		tiposLocacaos = controller.ConsultaUpdate();

		panelTitulo = new JPanel();
		panelTitulo.setBounds(0, 0, 430, 57);
		panelTitulo.setBackground(SystemColor.inactiveCaption);
		contentPane.add(panelTitulo);

		labelTitulo = new JLabel("Manuten\u00E7\u00E3o de Pre\u00E7os");
		labelTitulo.setForeground(new Color(0, 0, 102));
		labelTitulo.setFont(new Font("SansSerif", Font.BOLD, 32));
		panelTitulo.add(labelTitulo);

		panelCentro = new JPanel();
		panelCentro.setBounds(12, 104, 405, 101);
		panelCentro.setBackground(new Color(204, 204, 204));
		contentPane.add(panelCentro);
		panelCentro.setLayout(null);

		labelDescricao = new JLabel("Pre\u00E7os:");
		labelDescricao.setBounds(64, 51, 44, 16);
		panelCentro.add(labelDescricao);
		labelDescricao.setFont(new Font("SansSerif", Font.BOLD, 12));

		fieldPrecoKml = new JFormattedTextField();
		DecimalFormat dFormat1 = new DecimalFormat("####.00");
		dFormat1.setMaximumIntegerDigits(4);
		NumberFormatter Formatter1 = new NumberFormatter(dFormat1);
		Formatter1.setFormat (dFormat1);
		Formatter1.setAllowsInvalid (false);
		fieldPrecoKml.setFormatterFactory(new DefaultFormatterFactory(Formatter1));
		fieldPrecoKml.setText(String.valueOf(tiposLocacaos.get(0).getValor()));
		fieldPrecoKml.setBounds(111, 49, 97, 20);
		panelCentro.add(fieldPrecoKml);

		labelTipos = new JLabel("Tipos:");
		labelTipos.setBounds(74, 26, 34, 16);
		panelCentro.add(labelTipos);

		fieldKml = new JTextField(tiposLocacaos.get(0).getTipo());
		fieldKml.setEditable(false);
		fieldKml.setBounds(111, 24, 97, 20);
		panelCentro.add(fieldKml);
		fieldKml.setColumns(10);

		fieldKmC = new JTextField(tiposLocacaos.get(1).getTipo());
		fieldKmC.setEditable(false);
		fieldKmC.setBounds(220, 24, 97, 20);
		panelCentro.add(fieldKmC);
		fieldKmC.setColumns(10);

		textFieldPrecoKmc = new JFormattedTextField();
		DecimalFormat dFormat = new DecimalFormat("####.00");
		dFormat.setMaximumIntegerDigits(4);
		NumberFormatter Formatter = new NumberFormatter(dFormat);
		Formatter.setFormat (dFormat);
		Formatter.setAllowsInvalid (false);
		textFieldPrecoKmc.setFormatterFactory(new DefaultFormatterFactory(Formatter));
		textFieldPrecoKmc.setText(String.valueOf(tiposLocacaos.get(1).getValor()));
		textFieldPrecoKmc.setColumns(10);
		textFieldPrecoKmc.setBounds(220, 49, 97, 20);
		panelCentro.add(textFieldPrecoKmc);

		panelRodape = new JPanel();
		panelRodape.setBackground(SystemColor.inactiveCaption);
		panelRodape.setBounds(0, 232, 430, 17);
		contentPane.add(panelRodape);

		buttonNovo = new JButton();
		buttonNovo.setEnabled(false);
		buttonNovo.setToolTipText("Novo");
		buttonNovo.setIcon(new ImageIcon("imagens/additionButton.png"));
		buttonNovo.setForeground(Color.BLACK);
		buttonNovo.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonNovo.setBackground(SystemColor.inactiveCaption);
		buttonNovo.setBounds(63, 66, 50, 26);
		contentPane.add(buttonNovo);

		buttonSalvar = new JButton();
		buttonSalvar.setToolTipText("Gravar");
		buttonSalvar.setIcon(new ImageIcon("imagens/saveButton.png"));
		buttonSalvar.setForeground(Color.BLACK);
		buttonSalvar.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonSalvar.setBackground(SystemColor.inactiveCaption);
		buttonSalvar.setBounds(125, 66, 50, 26);
		contentPane.add(buttonSalvar);

		buttonExcluir = new JButton();
		buttonExcluir.setToolTipText("Excluir");
		buttonExcluir.setIcon(new ImageIcon("imagens/deleteButton.png"));
		buttonExcluir.setForeground(Color.BLACK);
		buttonExcluir.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonExcluir.setEnabled(false);
		buttonExcluir.setBackground(SystemColor.inactiveCaption);
		buttonExcluir.setBounds(187, 66, 50, 26);
		contentPane.add(buttonExcluir);

		buttonCancelar = new JButton();
		buttonCancelar.setToolTipText("Desfazer");
		buttonCancelar.setIcon(new ImageIcon("imagens/undoButton.png"));
		buttonCancelar.setForeground(Color.BLACK);
		buttonCancelar.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonCancelar.setBackground(SystemColor.inactiveCaption);
		buttonCancelar.setBounds(249, 66, 50, 26);
		contentPane.add(buttonCancelar);

		buttonLocalizar = new JButton();
		buttonLocalizar.setEnabled(false);
		buttonLocalizar.setToolTipText("Localizar");
		buttonLocalizar.setIcon(new ImageIcon("imagens/searchButton.png"));
		buttonLocalizar.setForeground(Color.BLACK);
		buttonLocalizar.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonLocalizar.setBackground(SystemColor.inactiveCaption);
		buttonLocalizar.setBounds(311, 66, 50, 26);
		contentPane.add(buttonLocalizar);

		buttonSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validarFields()) {

					tiposLocacaos.get(0).setValor(Double.parseDouble(fieldPrecoKml.getText().replace(',', '.')));
					tiposLocacaos.get(1).setValor(Double.parseDouble(textFieldPrecoKmc.getText().replace(',', '.')));
					if(controller.commit())
						JOptionPane.showMessageDialog(null, "Preços Alterados com Sucesso", "Mensagem Preços", JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "Erro ao Alterar Preços", "Erro Alteração", JOptionPane.ERROR_MESSAGE);
				} 

				cleanFields();
				disableFields();
			}
		});

		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cleanFields();
				disableFields();
				buttonSalvar.setEnabled(false);
			}

		});

	}


	private boolean validarFields(){
		if (fieldPrecoKml.getText().isEmpty()||fieldKml.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Campos Obrigatórios", null, JOptionPane.WARNING_MESSAGE);
			return false;
		}

		return true;
	}

	public void cleanFields(){
	}

	public void enableFields(){
		fieldPrecoKml.setEditable(true);
	}

	public void disableFields(){
		fieldPrecoKml.setEditable(false);
	}


	public void setPosicao() {
		Dimension d = this.getDesktopPane().getSize();
		this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
	}
}
