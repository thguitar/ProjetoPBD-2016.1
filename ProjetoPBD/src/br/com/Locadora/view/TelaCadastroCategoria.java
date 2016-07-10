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

import br.com.Locadora.controller.CategoriaController;
import br.com.Locadora.model.Categoria;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;


public class TelaCadastroCategoria extends JInternalFrame {

	private static final long serialVersionUID = 929224108722146698L;

	private JPanel contentPane;
	private JPanel panelTitulo;
	private JPanel panelCentro;
	private JPanel panelRodape;
	private JLabel labelTitulo;
	private JLabel labelCodigo;
	private JLabel labelPreco;
	private JLabel labelDescricao;
	private JTextField fieldCodigo;
	private JTextField fieldDescricao;
	private JFormattedTextField formattedTextFieldPreco;
	private JButton buttonSalvar;
	private JButton buttonCancelar;
	private JButton buttonExcluir;
	private JButton buttonLocalizar;
	private JButton buttonNovo;

	private boolean saveupdate;
	
	private CategoriaController categoriaController;
	
	public TelaCadastroCategoria() {
		setTitle("Cadastro de Categoria                                                                                                           ");
		setClosable(true);
		setResizable(false);
		setBounds(100, 100, 514, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		categoriaController = new CategoriaController();
		
		panelTitulo = new JPanel();
		panelTitulo.setBounds(0, 0, 507, 57);
		panelTitulo.setBackground(SystemColor.inactiveCaption);
		contentPane.add(panelTitulo);

		labelTitulo = new JLabel("Cadastro de Categoria");
		labelTitulo.setForeground(new Color(0, 0, 102));
		labelTitulo.setFont(new Font("SansSerif", Font.BOLD, 32));
		panelTitulo.add(labelTitulo);

		panelCentro = new JPanel();
		panelCentro.setBounds(33, 104, 441, 165);
		panelCentro.setBackground(new Color(204, 204, 204));
		contentPane.add(panelCentro);
		panelCentro.setLayout(null);

		formattedTextFieldPreco = new JFormattedTextField();
		formattedTextFieldPreco.setEditable(false);
		DecimalFormat dFormat3 = new DecimalFormat("#####.00");
		dFormat3.setMaximumIntegerDigits(5);
		NumberFormatter Formatter3 = new NumberFormatter(dFormat3);
		Formatter3.setFormat (dFormat3);
		Formatter3.setAllowsInvalid (false);
		formattedTextFieldPreco.setFormatterFactory(new DefaultFormatterFactory(Formatter3));
		formattedTextFieldPreco.setText(",00");
		formattedTextFieldPreco.setBounds(82, 61, 77, 20);
		panelCentro.add(formattedTextFieldPreco);
		formattedTextFieldPreco.setColumns(10);

		labelPreco = new JLabel("Pre\u00E7o:");
		labelPreco.setBounds(39, 63, 37, 16);
		panelCentro.add(labelPreco);

		labelDescricao = new JLabel("Descri\u00E7\u00E3o:");
		labelDescricao.setBounds(15, 39, 61, 16);
		panelCentro.add(labelDescricao);
		labelDescricao.setFont(new Font("SansSerif", Font.BOLD, 12));

		fieldDescricao = new JTextField();
		fieldDescricao.setEditable(false);
		fieldDescricao.setBounds(82, 37, 306, 20);
		panelCentro.add(fieldDescricao);
		fieldDescricao.setColumns(10);

		labelCodigo = new JLabel("C\u00F3digo:");
		labelCodigo.setBounds(34, 15, 42, 16);
		panelCentro.add(labelCodigo);

		fieldCodigo = new JTextField();
		fieldCodigo.setEditable(false);
		fieldCodigo.setBounds(82, 13, 45, 20);
		panelCentro.add(fieldCodigo);
		fieldCodigo.setColumns(10);

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
					Categoria categoria = new Categoria();
					categoria.setDescricao(fieldDescricao.getText());
					categoria.setValorAluguel(Double.parseDouble(formattedTextFieldPreco.getText().replace(',', '.')));
					if(saveupdate){ 
						categoriaController.insert(categoria);
					} else{ 
						categoria.setID(Integer.parseInt(fieldCodigo.getText()));
						categoriaController.update(categoria);
					}
					
					cleanFields();
					disableFields();
					buttonNovo.setEnabled(true);
					buttonExcluir.setEnabled(false);
					buttonSalvar.setEnabled(false);
					buttonLocalizar.setEnabled(true);
					categoria = null;
				}
			}	
		});
		
		buttonExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (JOptionPane.showConfirmDialog(null, "Deseja Realmente Excluir ?", "Excluir Categoria", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==0) {
					categoriaController.delete(Integer.parseInt(fieldCodigo.getText()));
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
				new ConsultaCategoria(TelaCadastroCategoria.this).setVisible(true);
			}
		});
		
		setVisible(true);
	}

	private boolean validarFields(){
		if (fieldDescricao.getText().isEmpty()||formattedTextFieldPreco.getText().equals(",00")) {
			JOptionPane.showMessageDialog(null, "Campos Obrigatórios", null, JOptionPane.WARNING_MESSAGE);
			return false;
		}

		return true;
	}
	
	public void cleanFields(){
		fieldCodigo.setText(null);
		fieldDescricao.setText(null);
		formattedTextFieldPreco.setValue(null);
	}
	
	public void enableFields(){
		fieldDescricao.setEditable(true);
		formattedTextFieldPreco.setEditable(true);
	}
	
	public void disableFields(){
		fieldDescricao.setEditable(false);
		formattedTextFieldPreco.setEditable(false);
	}
	
	public void setFields(int id){
		Categoria categoria = categoriaController.consultaId(id);
		fieldCodigo.setText(String.valueOf(categoria.getID()));
		fieldDescricao.setText(categoria.getDescricao());
		formattedTextFieldPreco.setText(String.valueOf(categoria.getValorAluguel()));
		buttonExcluir.setEnabled(true);
		buttonSalvar.setEnabled(true);
		buttonNovo.setEnabled(false);
		saveupdate = false;
		enableFields();
		categoria = null;
	}
	
	public void setPosicao() {
		Dimension d = this.getDesktopPane().getSize();
		this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
	}
}
