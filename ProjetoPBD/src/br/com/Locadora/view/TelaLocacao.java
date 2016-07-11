package br.com.Locadora.view;


import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.SystemColor;

import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.Locadora.controller.EmpresaController;
import br.com.Locadora.controller.LocacaoController;
import br.com.Locadora.model.Cliente;
import br.com.Locadora.model.Empresa;
import br.com.Locadora.model.Locacao;
import br.com.Locadora.model.PessoaFisica;
import br.com.Locadora.model.Reserva;
import br.com.Locadora.model.TiposLocacao;
import br.com.Locadora.model.Veiculo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.toedter.calendar.JDateChooser;

import javax.swing.JCheckBox;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class TelaLocacao extends JInternalFrame {


	private static final long serialVersionUID = 3691713444891118750L;

	private JPanel contentPane;
	private JPanel panelTitulo;
	private JPanel panelCentro;
	private JPanel panelRodape;
	private JLabel labelTitulo;
	private JLabel labelCodigo;
	private JLabel labelData;
	private JLabel labelStatus;
	private JLabel labelEmpresaDevolucao;
	private JLabel labelMotorista;
	private JLabel labelCliente;
	private JLabel labelDataDeRetirada;
	private JLabel labelValor;
	private JLabel lblTipo;
	private JLabel labelRS;
	private JLabel labelKms;
	private JLabel lblVeculo;
	private JTextField fieldCodigo;
	private JTextField fieldCliente;
	private JTextField fieldData;
	private JTextField fieldStatus;
	private JTextField fieldMotorista;
	private JTextField fieldValor;
	private JTextField fieldKms;
	private JTextField fieldVeiculo;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxEmpresaDevolucao;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxTipoLocacao;
	private JCheckBox chckbxCancelarLocacao;
	private JButton buttonSalvar;
	private JButton buttonCancelar;
	private JButton buttonExcluir;
	private JButton buttonLocalizar;
	private JButton buttonNovo;
	private JButton buttonLocalizarMotorista;
	private JButton buttonLocalizaVeiculo;
	private JButton buttonLocalizaCliente;
	private JDateChooser dateChooserDataDevolucao;
	
	private boolean saveupdate;
	private double valorTotal;
	private Date dataAtual;
	
	private LocacaoController locacaoController;
	private EmpresaController empresaController;
	
	private Locacao locacaoUpdate;
	private List<Empresa> empresas;
	private List<TiposLocacao> tiposLocacao;
	private Cliente cliente;
	private PessoaFisica motorista;
	private Veiculo veiculo;
	private Reserva reservaImportada;
	private JButton buttonImportReserva;
	private JButton buttonAtualizaPreco;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TelaLocacao() {
		setTitle("Loca\u00E7\u00E3o                                                                                                                                                                             ");
		setClosable(true);
		setResizable(false);
		setBounds(100, 100, 635, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		locacaoController = new LocacaoController();
		empresaController = new EmpresaController();
		
		dataAtual = new Date();
		
		panelTitulo = new JPanel();
		panelTitulo.setBounds(0, 0, 625, 57);
		panelTitulo.setBackground(SystemColor.inactiveCaption);
		contentPane.add(panelTitulo);

		labelTitulo = new JLabel("Loca\u00E7\u00E3o");
		labelTitulo.setForeground(new Color(0, 0, 102));
		labelTitulo.setFont(new Font("SansSerif", Font.BOLD, 32));
		panelTitulo.add(labelTitulo);

		panelCentro = new JPanel();
		panelCentro.setBounds(12, 104, 603, 204);
		panelCentro.setBackground(new Color(204, 204, 204));
		contentPane.add(panelCentro);
		panelCentro.setLayout(null);

		labelData = new JLabel("Data:");
		labelData.setBounds(164, 15, 29, 16);
		panelCentro.add(labelData);
		labelData.setFont(new Font("SansSerif", Font.BOLD, 12));

		labelStatus = new JLabel("Status:");
		labelStatus.setBounds(281, 15, 45, 16);
		panelCentro.add(labelStatus);
		labelStatus.setFont(new Font("SansSerif", Font.BOLD, 12));

		labelEmpresaDevolucao = new JLabel("Empresa Devolu\u00E7\u00E3o:");
		labelEmpresaDevolucao.setBounds(15, 127, 116, 16);
		panelCentro.add(labelEmpresaDevolucao);
		labelEmpresaDevolucao.setFont(new Font("SansSerif", Font.BOLD, 12));

		comboBoxEmpresaDevolucao = new JComboBox();
		empresas = empresaController.listALL();
		for(int i=0; i <empresas.size(); i++) {
			comboBoxEmpresaDevolucao.addItem(empresas.get(i).getId()+" - "+empresas.get(i).getNome());
		}
		comboBoxEmpresaDevolucao.setEnabled(false);
		comboBoxEmpresaDevolucao.setBounds(135, 125, 147, 20);
		panelCentro.add(comboBoxEmpresaDevolucao);

		labelCliente = new JLabel("Cliente:");
		labelCliente.setBounds(30, 43, 42, 16);
		panelCentro.add(labelCliente);
		labelCliente.setFont(new Font("SansSerif", Font.BOLD, 12));

		fieldCliente = new JTextField();
		fieldCliente.setEditable(false);
		fieldCliente.setBounds(82, 41, 306, 20);
		panelCentro.add(fieldCliente);
		fieldCliente.setColumns(10);

		fieldData = new JTextField();
		fieldData.setEditable(false);
		fieldData.setBounds(197, 13, 72, 20);
		panelCentro.add(fieldData);
		fieldData.setColumns(10);

		labelCodigo = new JLabel("C\u00F3digo:");
		labelCodigo.setBounds(30, 15, 42, 16);
		panelCentro.add(labelCodigo);

		fieldCodigo = new JTextField();
		fieldCodigo.setEditable(false);
		fieldCodigo.setBounds(82, 13, 64, 20);
		panelCentro.add(fieldCodigo);
		fieldCodigo.setColumns(10);
		
		fieldStatus = new JTextField();
		fieldStatus.setEditable(false);
		fieldStatus.setBounds(325, 13, 130, 20);
		panelCentro.add(fieldStatus);
		fieldStatus.setColumns(10);
		
		labelMotorista = new JLabel("Motorista:");
		labelMotorista.setBounds(18, 73, 57, 16);
		panelCentro.add(labelMotorista);
		
		fieldMotorista = new JTextField();
		fieldMotorista.setEditable(false);
		fieldMotorista.setBounds(82, 71, 306, 20);
		panelCentro.add(fieldMotorista);
		
		buttonLocalizarMotorista = new JButton();
		buttonLocalizarMotorista.setEnabled(false);
		buttonLocalizarMotorista.setToolTipText("Localizar");
		buttonLocalizarMotorista.setIcon(new ImageIcon("imagens/searchButton.png"));
		buttonLocalizarMotorista.setForeground(Color.BLACK);
		buttonLocalizarMotorista.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonLocalizarMotorista.setBackground(SystemColor.inactiveCaption);
		buttonLocalizarMotorista.setBounds(393, 68, 50, 26);
		panelCentro.add(buttonLocalizarMotorista);
		
		labelDataDeRetirada = new JLabel("Data de Devolu\u00E7\u00E3o:");
		labelDataDeRetirada.setBounds(310, 127, 108, 16);
		panelCentro.add(labelDataDeRetirada);
		
		dateChooserDataDevolucao = new JDateChooser(dataAtual);
		dateChooserDataDevolucao.setEnabled(false);
		dateChooserDataDevolucao.setBounds(423, 125, 92, 20);
		panelCentro.add(dateChooserDataDevolucao);
		
		chckbxCancelarLocacao = new JCheckBox("Cancelar Loca\u00E7\u00E3o");
		chckbxCancelarLocacao.setEnabled(false);
		chckbxCancelarLocacao.setBounds(465, 11, 128, 24);
		panelCentro.add(chckbxCancelarLocacao);
		
		labelValor = new JLabel("Valor:");
		labelValor.setFont(new Font("Dialog", Font.BOLD, 16));
		labelValor.setBounds(439, 161, 46, 21);
		panelCentro.add(labelValor);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(45, 153, 27, 16);
		panelCentro.add(lblTipo);
		
		comboBoxTipoLocacao = new JComboBox();
		tiposLocacao = locacaoController.listTipoLocacao();
		for(int i=0; i <tiposLocacao.size(); i++) {
			comboBoxTipoLocacao.addItem(tiposLocacao.get(i).getTipo());
		}
		comboBoxTipoLocacao.setEnabled(false);
		comboBoxTipoLocacao.setBounds(82, 151, 98, 20);
		panelCentro.add(comboBoxTipoLocacao);
		
		fieldValor = new JTextField();
		fieldValor.setFont(new Font("Dialog", Font.BOLD, 14));
		fieldValor.setEditable(false);
		fieldValor.setBounds(486, 161, 86, 21);
		panelCentro.add(fieldValor);
		fieldValor.setColumns(10);
		
		labelRS = new JLabel("R$");
		labelRS.setFont(new Font("Dialog", Font.BOLD, 16));
		labelRS.setBounds(572, 161, 21, 21);
		panelCentro.add(labelRS);
		
		labelKms = new JLabel("Quantidade de Km's:");
		labelKms.setBounds(197, 153, 117, 16);
		panelCentro.add(labelKms);
		
		fieldKms = new JTextField();
		fieldKms.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				atualizaValor();
			}
		});
		fieldKms.setEditable(false);
		fieldKms.setBounds(316, 151, 57, 20);
		panelCentro.add(fieldKms);
		fieldKms.setColumns(10);
		
		lblVeculo = new JLabel("Ve\u00EDculo:");
		lblVeculo.setBounds(30, 101, 45, 16);
		panelCentro.add(lblVeculo);
		
		fieldVeiculo = new JTextField();
		fieldVeiculo.setEditable(false);
		fieldVeiculo.setBounds(82, 99, 306, 20);
		panelCentro.add(fieldVeiculo);
		fieldVeiculo.setColumns(10);
		
		buttonLocalizaVeiculo = new JButton();
		buttonLocalizaVeiculo.setToolTipText("Localizar");
		buttonLocalizaVeiculo.setIcon(new ImageIcon("imagens/searchButton.png"));
		buttonLocalizaVeiculo.setForeground(Color.BLACK);
		buttonLocalizaVeiculo.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonLocalizaVeiculo.setEnabled(false);
		buttonLocalizaVeiculo.setBackground(SystemColor.inactiveCaption);
		buttonLocalizaVeiculo.setBounds(393, 96, 50, 26);
		panelCentro.add(buttonLocalizaVeiculo);
		
		buttonLocalizaCliente = new JButton();
		buttonLocalizaCliente.setToolTipText("Localizar");
		buttonLocalizaCliente.setIcon(new ImageIcon("imagens/searchButton.png"));
		buttonLocalizaCliente.setForeground(Color.BLACK);
		buttonLocalizaCliente.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonLocalizaCliente.setEnabled(false);
		buttonLocalizaCliente.setBackground(SystemColor.inactiveCaption);
		buttonLocalizaCliente.setBounds(393, 38, 50, 26);
		panelCentro.add(buttonLocalizaCliente);

		panelRodape = new JPanel();
		panelRodape.setBackground(SystemColor.inactiveCaption);
		panelRodape.setBounds(0, 320, 625, 17);
		contentPane.add(panelRodape);

		buttonNovo = new JButton();
		buttonNovo.setToolTipText("Novo");
		buttonNovo.setIcon(new ImageIcon("imagens/additionButton.png"));
		buttonNovo.setForeground(Color.BLACK);
		buttonNovo.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonNovo.setBackground(SystemColor.inactiveCaption);
		buttonNovo.setBounds(107, 69, 50, 26);
		contentPane.add(buttonNovo);
		
		buttonSalvar = new JButton();
		buttonSalvar.setToolTipText("Gravar");
		buttonSalvar.setIcon(new ImageIcon("imagens/saveButton.png"));
		buttonSalvar.setForeground(Color.BLACK);
		buttonSalvar.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonSalvar.setEnabled(false);
		buttonSalvar.setBackground(SystemColor.inactiveCaption);
		buttonSalvar.setBounds(169, 69, 50, 26);
		contentPane.add(buttonSalvar);
		
		buttonExcluir = new JButton();
		buttonExcluir.setToolTipText("Excluir");
		buttonExcluir.setIcon(new ImageIcon("imagens/deleteButton.png"));
		buttonExcluir.setForeground(Color.BLACK);
		buttonExcluir.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonExcluir.setEnabled(false);
		buttonExcluir.setBackground(SystemColor.inactiveCaption);
		buttonExcluir.setBounds(231, 69, 50, 26);
		contentPane.add(buttonExcluir);
		
		buttonCancelar = new JButton();
		buttonCancelar.setToolTipText("Desfazer");
		buttonCancelar.setIcon(new ImageIcon("imagens/undoButton.png"));
		buttonCancelar.setForeground(Color.BLACK);
		buttonCancelar.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonCancelar.setBackground(SystemColor.inactiveCaption);
		buttonCancelar.setBounds(293, 69, 50, 26);
		contentPane.add(buttonCancelar);
		
		buttonLocalizar = new JButton();
		buttonLocalizar.setToolTipText("Localizar");
		buttonLocalizar.setIcon(new ImageIcon("imagens/searchButton.png"));
		buttonLocalizar.setForeground(Color.BLACK);
		buttonLocalizar.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonLocalizar.setBackground(SystemColor.inactiveCaption);
		buttonLocalizar.setBounds(355, 69, 50, 26);
		contentPane.add(buttonLocalizar);
		
		buttonImportReserva = new JButton();
		buttonImportReserva.setEnabled(false);
		buttonImportReserva.setToolTipText("Importar Reserva");
		buttonImportReserva.setIcon(new ImageIcon("imagens/importButton.png"));
		buttonImportReserva.setForeground(Color.BLACK);
		buttonImportReserva.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonImportReserva.setBackground(SystemColor.inactiveCaption);
		buttonImportReserva.setBounds(417, 69, 50, 26);
		contentPane.add(buttonImportReserva);
		
		buttonAtualizaPreco = new JButton();
		buttonAtualizaPreco.setToolTipText("Importar Reserva");
		buttonAtualizaPreco.setIcon(new ImageIcon("imagens/refreshButton.png"));
		buttonAtualizaPreco.setForeground(Color.BLACK);
		buttonAtualizaPreco.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonAtualizaPreco.setEnabled(false);
		buttonAtualizaPreco.setBackground(SystemColor.inactiveCaption);
		buttonAtualizaPreco.setBounds(479, 69, 50, 26);
		contentPane.add(buttonAtualizaPreco);
		
		buttonNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cleanFields();
				buttonSalvar.setEnabled(true);
				buttonImportReserva.setEnabled(true);
				buttonAtualizaPreco.setEnabled(true);
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
					atualizaValor();
					if(saveupdate){ 
						Locacao locacao = new Locacao();
						locacao.setCliente(cliente);
						locacao.setMotorista(motorista);
						locacao.setVeiculo(veiculo);
						locacao.setDataPrevistaDevolucao(dateChooserDataDevolucao.getDate());
						locacao.setTipo((String) comboBoxTipoLocacao.getSelectedItem());
						locacao.setValor(Double.parseDouble(fieldValor.getText()));
						locacao.setEmpresaDestino(empresas.get(comboBoxEmpresaDevolucao.getSelectedIndex()));
						if(reservaImportada != null)
							locacao.setIdReservaImportada(reservaImportada.getID());
						if(locacaoController.insert(locacao))
							JOptionPane.showMessageDialog(null, "Locação Realizada com Sucesso", "Mensagem Locação", JOptionPane.INFORMATION_MESSAGE);
						else
							JOptionPane.showMessageDialog(null, "Erro ao Realizar Locação", "Erro Inserção", JOptionPane.ERROR_MESSAGE);
					} else{ 
						locacaoUpdate.setID(Integer.parseInt(fieldCodigo.getText()));
						locacaoUpdate.setCliente(cliente);
						locacaoUpdate.setVeiculo(veiculo);
						locacaoUpdate.setMotorista(motorista);
						locacaoUpdate.setEmpresaDestino(empresas.get(comboBoxEmpresaDevolucao.getSelectedIndex()));
						locacaoUpdate.setDataPrevistaDevolucao(dateChooserDataDevolucao.getDate());
						locacaoUpdate.setCancelada(chckbxCancelarLocacao.isSelected());
						if(locacaoController.commit()){
							JOptionPane.showMessageDialog(null, "Locação Alterada com Sucesso", "Mensagem Locação", JOptionPane.INFORMATION_MESSAGE);
							locacaoUpdate = null;
						}
						else
							JOptionPane.showMessageDialog(null, "Erro ao Alterar Locação", "Erro Autalização", JOptionPane.ERROR_MESSAGE);
						
					}
					
					cleanFields();
					disableFields();
					buttonNovo.setEnabled(true);
					buttonImportReserva.setEnabled(false);
					buttonAtualizaPreco.setEnabled(false);
					buttonExcluir.setEnabled(false);
					buttonSalvar.setEnabled(false);
					buttonLocalizar.setEnabled(true);
				}
			}	
		});
		
		buttonExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (JOptionPane.showConfirmDialog(null, "Deseja Realmente Excluir ?", "Excluir Locação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==0) {
					if(locacaoController.delete(Integer.parseInt(fieldCodigo.getText())))
						JOptionPane.showMessageDialog(null, "Locação Excluída com Sucesso", "Mensagem Locação", JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "Erro ao Deletar Locação", "Erro Remoção", JOptionPane.ERROR_MESSAGE);
					
					
					cleanFields();
					disableFields();
					buttonNovo.setEnabled(true);
					buttonAtualizaPreco.setEnabled(false);
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
				buttonImportReserva.setEnabled(false);
				buttonAtualizaPreco.setEnabled(false);
				buttonNovo.setEnabled(true);
				buttonExcluir.setEnabled(false);
				buttonLocalizar.setEnabled(true);
			}
		});

		buttonLocalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ConsultaLocacao(TelaLocacao.this).setVisible(true);
			}
		});
		
		buttonLocalizarMotorista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ConsultaCliente(TelaLocacao.this, false).setVisible(true);
			}
		});
		
		buttonLocalizaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ConsultaCliente(TelaLocacao.this, true).setVisible(true);
			}
		});
		
		buttonLocalizaVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ConsultaVeiculo(TelaLocacao.this).setVisible(true);
			}
		});
		
		comboBoxTipoLocacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comboBoxTipoLocacao.getSelectedItem().equals("Km Controle")) 
					fieldKms.setEditable(true);
				else 
					fieldKms.setEditable(false);
					fieldKms.setText(null);
					
			}
		});
		
		buttonImportReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ConsultaReserva(TelaLocacao.this).setVisible(true);
			}
		});
		
		buttonAtualizaPreco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizaValor();
			}
		});
		
		setVisible(true);
	}

	private boolean validarFields(){
		if (fieldCliente.getText().isEmpty()||fieldMotorista.getText().isEmpty()||fieldVeiculo.getText().isEmpty()||(comboBoxTipoLocacao.getSelectedIndex()==1? fieldKms.getText().isEmpty(): false)) {
			JOptionPane.showMessageDialog(null, "Campos Obrigatórios", null, JOptionPane.WARNING_MESSAGE);
			return false;
		}else if (dateChooserDataDevolucao.getDate().before(dataAtual)||dateChooserDataDevolucao.getDate().equals(dataAtual)) {
			DateFormat format = new SimpleDateFormat("dd/MM/yyy");
			JOptionPane.showMessageDialog(null, "Data de Devolução "+format.format(dateChooserDataDevolucao.getDate())+" deve ser maior que a data Atual "+format.format(dataAtual), null, JOptionPane.WARNING_MESSAGE);
			format = null;
			return false;
		}
		
		return true;
	}
	
	public void cleanFields(){
		fieldCodigo.setText(null);
		fieldCliente.setText(null);
		fieldData.setText(null);
		fieldStatus.setText(null);
		fieldMotorista.setText(null);
		fieldVeiculo.setText(null);
		comboBoxEmpresaDevolucao.setSelectedIndex(0);
		dateChooserDataDevolucao.setDate(dataAtual);
		chckbxCancelarLocacao.setSelected(false);
		fieldKms.setText(null);
	}
	
	public void enableFields(){
		comboBoxEmpresaDevolucao.setEnabled(true);
		buttonLocalizarMotorista.setEnabled(true);
		buttonLocalizaVeiculo.setEnabled(true);
		buttonLocalizaCliente.setEnabled(true);
		dateChooserDataDevolucao.setEnabled(true);
		comboBoxTipoLocacao.setEnabled(true);
		
	}
	
	public void disableFields(){
		comboBoxEmpresaDevolucao.setEnabled(false);
		buttonLocalizarMotorista.setEnabled(false);
		buttonLocalizaVeiculo.setEnabled(false);
		buttonLocalizaCliente.setEnabled(false);
		dateChooserDataDevolucao.setEnabled(false);
		chckbxCancelarLocacao.setEnabled(false);
		comboBoxTipoLocacao.setEnabled(false);
		fieldKms.setEditable(false);
	}
	
	public void setFields(int id){
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		locacaoUpdate = locacaoController.consultaUpdate(id);
		fieldCodigo.setText(String.valueOf(locacaoUpdate.getID()));
		fieldCliente.setText(locacaoUpdate.getCliente().getNome());
		fieldData.setText(String.valueOf(format.format(locacaoUpdate.getDataHoraSaida())));
		fieldStatus.setText(locacaoUpdate.getStatus());
		fieldMotorista.setText(locacaoUpdate.getMotorista().getNome());
		fieldVeiculo.setText(locacaoUpdate.getVeiculo().getID()+" - Placa: "+locacaoUpdate.getVeiculo().getPlaca()+" - Chassi: "+locacaoUpdate.getVeiculo().getNumeroChassi());
		fieldValor.setText(String.valueOf(locacaoUpdate.getValor()));
		comboBoxTipoLocacao.setSelectedItem(locacaoUpdate.getTipo());
		dateChooserDataDevolucao.setDate(locacaoUpdate.getDataPrevistaDevolucao());
		cliente = locacaoUpdate.getCliente();
		motorista = locacaoUpdate.getMotorista();
		veiculo = locacaoUpdate.getVeiculo();
		comboBoxEmpresaDevolucao.setSelectedItem(locacaoUpdate.getEmpresaDestino().getId()+" - "+locacaoUpdate.getEmpresaDestino().getNome());
		dateChooserDataDevolucao.setDate(locacaoUpdate.getDataPrevistaDevolucao());
		buttonExcluir.setEnabled(true);
		buttonImportReserva.setEnabled(false);
		buttonAtualizaPreco.setEnabled(true);
		buttonSalvar.setEnabled(true);
		buttonNovo.setEnabled(false);
		saveupdate = false;
		enableFields();
		chckbxCancelarLocacao.setEnabled(true);
		format = null;
	}
	
	public void setCliente(Cliente cliente){
		this.cliente = cliente;
		fieldCliente.setText(cliente.getId()+" - "+cliente.getNome());
	}
	
	public void setMotorista(PessoaFisica motorista){
		this.motorista = motorista;
		fieldMotorista.setText(motorista.getId()+" - "+motorista.getNome());
	}
	
	public void setVeiculo(Veiculo veiculo){
		if(reservaImportada!=null){
			if (veiculo.getCategoria().getID()==(reservaImportada.getCategoria().getID())){
				this.veiculo = veiculo;
				fieldVeiculo.setText(veiculo.getID()+" - Placa: "+veiculo.getPlaca()+" - Chassi: "+veiculo.getNumeroChassi());
				fieldValor.setText(String.valueOf(veiculo.getCategoria().getValorAluguel()));
			}
			else{
				JOptionPane.showMessageDialog(null, "Veículo Selecionado não pertence a Categoria Reservada");
			}
		} else{
			this.veiculo = veiculo;
			fieldVeiculo.setText(veiculo.getID()+" - Placa: "+veiculo.getPlaca()+" - Chassi: "+veiculo.getNumeroChassi());
			fieldValor.setText(String.valueOf(veiculo.getCategoria().getValorAluguel()));
		}
	}
	
	public void setReserva(Reserva reserva){
		this.reservaImportada = reserva;
		fieldCliente.setText(reserva.getCliente().getNome());
		cliente = reserva.getCliente();
	}
	
	public void atualizaValor(){
		if(fieldValor.getText().isEmpty()&&valorTotal==0){
			JOptionPane.showMessageDialog(null, "Não existe valores a serem atualizados","Aviso Valores", JOptionPane.WARNING_MESSAGE);
		}else{
				if(comboBoxTipoLocacao.getSelectedIndex()==0){
					valorTotal = veiculo.getCategoria().getValorAluguel()+tiposLocacao.get(comboBoxTipoLocacao.getSelectedIndex()).getValor();
					fieldValor.setText(String.valueOf(valorTotal));
				}
				else{
					System.out.println(valorTotal);
					valorTotal = veiculo.getCategoria().getValorAluguel()+(tiposLocacao.get(comboBoxTipoLocacao.getSelectedIndex()).getValor()*Integer.parseInt(fieldKms.getText()));
					fieldValor.setText(String.valueOf(valorTotal));
				}
			}
	}
	
	public void setPosicao() {
		Dimension d = this.getDesktopPane().getSize();
		this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
	}
}
