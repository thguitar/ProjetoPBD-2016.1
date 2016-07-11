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

import br.com.Locadora.controller.CategoriaController;
import br.com.Locadora.controller.EmpresaController;
import br.com.Locadora.controller.ReservaController;
import br.com.Locadora.model.Categoria;
import br.com.Locadora.model.Cliente;
import br.com.Locadora.model.Empresa;
import br.com.Locadora.model.Reserva;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.List;

import com.toedter.calendar.JDateChooser;
import javax.swing.JCheckBox;


public class TelaReserva extends JInternalFrame {


	private static final long serialVersionUID = 3691713444891118750L;

	private JPanel contentPane;
	private JPanel panelTitulo;
	private JPanel panelCentro;
	private JPanel panelRodape;
	private JLabel labelTitulo;
	private JLabel labelCodigo;
	private JLabel labelData;
	private JLabel labelStatus;
	private JLabel labelEmpresa;
	private JLabel labelCategoria;
	private JLabel labelCliente;
	private JLabel labelDescricao;
	private JLabel labelDataDeRetirada;
	private JTextField fieldCodigo;
	private JTextField fieldDescricao;
	private JTextField fieldData;
	private JTextField fieldStatus;
	private JTextField fieldCliente;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxEmpresa;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxCategoria;
	private JButton buttonSalvar;
	private JButton buttonCancelar;
	private JButton buttonExcluir;
	private JButton buttonLocalizar;
	private JButton buttonNovo;
	private JButton buttonLocalizarCliente;
	private JDateChooser dateChooserDataRetirada;
	
	private boolean saveupdate;

	private Date dataAtual;
	
	private EmpresaController empresaController;
	private CategoriaController categoriaController;
	private ReservaController reservaController;
	
	private Reserva reservaUpdate;
	private List<Categoria> categorias;
	private List<Empresa> empresas;
	private Cliente cliente;	
	private JCheckBox chckbxCancelarReserva;

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TelaReserva() {
		setTitle("Reservas                                                                                                                                                                            ");
		setClosable(true);
		setResizable(false);
		setBounds(100, 100, 635, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		empresaController = new EmpresaController();
		categoriaController = new CategoriaController();
		reservaController = new ReservaController();
		
		panelTitulo = new JPanel();
		panelTitulo.setBounds(0, 0, 625, 57);
		panelTitulo.setBackground(SystemColor.inactiveCaption);
		contentPane.add(panelTitulo);

		labelTitulo = new JLabel("Reservas");
		labelTitulo.setForeground(new Color(0, 0, 102));
		labelTitulo.setFont(new Font("SansSerif", Font.BOLD, 32));
		panelTitulo.add(labelTitulo);

		panelCentro = new JPanel();
		panelCentro.setBounds(12, 104, 603, 165);
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

		labelEmpresa = new JLabel("Empresa:");
		labelEmpresa.setBounds(388, 92, 54, 16);
		panelCentro.add(labelEmpresa);
		labelEmpresa.setFont(new Font("SansSerif", Font.BOLD, 12));

		comboBoxEmpresa = new JComboBox();
		empresas = empresaController.listALL();
		for(int i=0; i <empresas.size(); i++) {
			comboBoxEmpresa.addItem(empresas.get(i).getId()+" - "+empresas.get(i).getNome());
		}
		comboBoxEmpresa.setEnabled(false);
		comboBoxEmpresa.setBounds(444, 90, 147, 20);
		panelCentro.add(comboBoxEmpresa);

		labelCategoria = new JLabel("Categoria:");
		labelCategoria.setBounds(21, 92, 58, 16);
		panelCentro.add(labelCategoria);

		labelDescricao = new JLabel("Descri\u00E7\u00E3o:");
		labelDescricao.setBounds(15, 68, 64, 16);
		panelCentro.add(labelDescricao);
		labelDescricao.setFont(new Font("SansSerif", Font.BOLD, 12));

		fieldDescricao = new JTextField();
		fieldDescricao.setEditable(false);
		fieldDescricao.setBounds(82, 66, 306, 20);
		panelCentro.add(fieldDescricao);
		fieldDescricao.setColumns(10);

		fieldData = new JTextField();
		fieldData.setEditable(false);
		fieldData.setBounds(197, 13, 72, 20);
		panelCentro.add(fieldData);
		fieldData.setColumns(10);

		labelCodigo = new JLabel("C\u00F3digo:");
		labelCodigo.setBounds(37, 15, 42, 16);
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
		
		labelCliente = new JLabel("Cliente:");
		labelCliente.setBounds(34, 43, 45, 16);
		panelCentro.add(labelCliente);
		
		fieldCliente = new JTextField();
		fieldCliente.setEditable(false);
		fieldCliente.setBounds(82, 41, 288, 20);
		panelCentro.add(fieldCliente);
		fieldCliente.setColumns(10);
		
		buttonLocalizarCliente = new JButton();
		buttonLocalizarCliente.setEnabled(false);
		buttonLocalizarCliente.setToolTipText("Localizar");
		buttonLocalizarCliente.setIcon(new ImageIcon("imagens/searchButton.png"));
		buttonLocalizarCliente.setForeground(Color.BLACK);
		buttonLocalizarCliente.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonLocalizarCliente.setBackground(SystemColor.inactiveCaption);
		buttonLocalizarCliente.setBounds(382, 38, 50, 26);
		panelCentro.add(buttonLocalizarCliente);
		
		comboBoxCategoria = new JComboBox();
		comboBoxCategoria.setEnabled(false);
		comboBoxCategoria.setBounds(82, 90, 147, 20);
		categoriaController = new CategoriaController();
		categorias = categoriaController.ListALL();
		for (int i = 0; i < categorias.size(); i++) {
			comboBoxCategoria.addItem(categorias.get(i).getDescricao());
		}
		panelCentro.add(comboBoxCategoria);
		
		labelDataDeRetirada = new JLabel("Data de Retirada:");
		labelDataDeRetirada.setBounds(400, 68, 97, 16);
		panelCentro.add(labelDataDeRetirada);
		
		dateChooserDataRetirada = new JDateChooser();
		dataAtual = dateChooserDataRetirada.getDate();
		dateChooserDataRetirada.setEnabled(false);
		dateChooserDataRetirada.setBounds(499, 66, 92, 20);
		panelCentro.add(dateChooserDataRetirada);
		
		chckbxCancelarReserva = new JCheckBox("Cancelar Reserva");
		chckbxCancelarReserva.setEnabled(false);
		chckbxCancelarReserva.setBounds(465, 11, 126, 24);
		panelCentro.add(chckbxCancelarReserva);

		panelRodape = new JPanel();
		panelRodape.setBackground(SystemColor.inactiveCaption);
		panelRodape.setBounds(0, 292, 625, 17);
		contentPane.add(panelRodape);

		buttonNovo = new JButton();
		buttonNovo.setToolTipText("Novo");
		buttonNovo.setIcon(new ImageIcon("imagens/additionButton.png"));
		buttonNovo.setForeground(Color.BLACK);
		buttonNovo.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonNovo.setBackground(SystemColor.inactiveCaption);
		buttonNovo.setBounds(161, 69, 50, 26);
		contentPane.add(buttonNovo);
		
		buttonSalvar = new JButton();
		buttonSalvar.setToolTipText("Gravar");
		buttonSalvar.setIcon(new ImageIcon("imagens/saveButton.png"));
		buttonSalvar.setForeground(Color.BLACK);
		buttonSalvar.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonSalvar.setEnabled(false);
		buttonSalvar.setBackground(SystemColor.inactiveCaption);
		buttonSalvar.setBounds(223, 69, 50, 26);
		contentPane.add(buttonSalvar);
		
		buttonExcluir = new JButton();
		buttonExcluir.setToolTipText("Excluir");
		buttonExcluir.setIcon(new ImageIcon("imagens/deleteButton.png"));
		buttonExcluir.setForeground(Color.BLACK);
		buttonExcluir.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonExcluir.setEnabled(false);
		buttonExcluir.setBackground(SystemColor.inactiveCaption);
		buttonExcluir.setBounds(285, 69, 50, 26);
		contentPane.add(buttonExcluir);
		
		buttonCancelar = new JButton();
		buttonCancelar.setToolTipText("Desfazer");
		buttonCancelar.setIcon(new ImageIcon("imagens/undoButton.png"));
		buttonCancelar.setForeground(Color.BLACK);
		buttonCancelar.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonCancelar.setBackground(SystemColor.inactiveCaption);
		buttonCancelar.setBounds(347, 69, 50, 26);
		contentPane.add(buttonCancelar);
		
		buttonLocalizar = new JButton();
		buttonLocalizar.setToolTipText("Localizar");
		buttonLocalizar.setIcon(new ImageIcon("imagens/searchButton.png"));
		buttonLocalizar.setForeground(Color.BLACK);
		buttonLocalizar.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonLocalizar.setBackground(SystemColor.inactiveCaption);
		buttonLocalizar.setBounds(409, 69, 50, 26);
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
					
					if(saveupdate){ 
						Reserva reserva = new Reserva();
						reserva.setCliente(cliente);
						reserva.setCategoria(categorias.get(comboBoxCategoria.getSelectedIndex()));
						reserva.setEmpresa(empresas.get(comboBoxEmpresa.getSelectedIndex()));
						reserva.setDescricao(fieldDescricao.getText());
						reserva.setDataRetirada(dateChooserDataRetirada.getDate());
						if(reservaController.insert(reserva))
							JOptionPane.showMessageDialog(null, "Reserva Realizada com Sucesso", "Mensagem Reserva", JOptionPane.INFORMATION_MESSAGE);
						else
							JOptionPane.showMessageDialog(null, "Erro ao Realizar Reserva", "Erro Inserção", JOptionPane.ERROR_MESSAGE);
					} else{ 
						reservaUpdate.setID(Integer.parseInt(fieldCodigo.getText()));
						reservaUpdate.setCliente(cliente);
						reservaUpdate.setCategoria(categorias.get(comboBoxCategoria.getSelectedIndex()));
						reservaUpdate.setEmpresa(empresas.get(comboBoxEmpresa.getSelectedIndex()));
						reservaUpdate.setDescricao(fieldDescricao.getText());
						reservaUpdate.setDataRetirada(dateChooserDataRetirada.getDate());
						reservaUpdate.setCancelada(chckbxCancelarReserva.isSelected());
						if(reservaController.commit()){
							JOptionPane.showMessageDialog(null, "Reserva Alterada com Sucesso", "Mensagem Reserva", JOptionPane.INFORMATION_MESSAGE);
							reservaUpdate = null;
						}
						else
							JOptionPane.showMessageDialog(null, "Erro ao Alterar Reserva", "Erro Autalização", JOptionPane.ERROR_MESSAGE);
						
					}
					
					cleanFields();
					disableFields();
					buttonNovo.setEnabled(true);
					buttonExcluir.setEnabled(false);
					buttonSalvar.setEnabled(false);
					buttonLocalizar.setEnabled(true);
				}
			}	
		});
		
		buttonExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (JOptionPane.showConfirmDialog(null, "Deseja Realmente Excluir ?", "Excluir Reserva", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==0) {
					if(reservaController.delete(Integer.parseInt(fieldCodigo.getText())))
						JOptionPane.showMessageDialog(null, "Reserva Excluída com Sucesso", "Mensagem Reserva", JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "Erro ao Deletar Reserva", "Erro Remoção", JOptionPane.ERROR_MESSAGE);
					
					
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
				new ConsultaReserva(TelaReserva.this).setVisible(true);
			}
		});
		
		buttonLocalizarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ConsultaCliente(TelaReserva.this).setVisible(true);
			}
		});
		
		setVisible(true);
	}

	private boolean validarFields(){
		if (fieldDescricao.getText().isEmpty()||fieldCliente.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Campos Obrigatórios", null, JOptionPane.WARNING_MESSAGE);
			return false;
		}

		return true;
	}
	
	public void cleanFields(){
		fieldCodigo.setText(null);
		fieldDescricao.setText(null);
		fieldData.setText(null);
		fieldStatus.setText(null);
		fieldCliente.setText(null);
		comboBoxEmpresa.setSelectedIndex(0);
		comboBoxCategoria.setSelectedIndex(0);
		dateChooserDataRetirada.setDate(dataAtual);
		chckbxCancelarReserva.setSelected(false);
	}
	
	public void enableFields(){
		fieldDescricao.setEditable(true);
		comboBoxEmpresa.setEnabled(true);
		comboBoxCategoria.setEnabled(true);
		buttonLocalizarCliente.setEnabled(true);
		dateChooserDataRetirada.setEnabled(true);
		chckbxCancelarReserva.setEnabled(true);
	}
	
	public void disableFields(){
		fieldDescricao.setEditable(false);
		comboBoxEmpresa.setEnabled(false);
		comboBoxCategoria.setEnabled(false);
		buttonLocalizarCliente.setEnabled(false);
		dateChooserDataRetirada.setEnabled(false);
		chckbxCancelarReserva.setEnabled(false);
	}
	
	public void setFields(int id){
		reservaUpdate = reservaController.consultaUpdate(id);
		fieldCodigo.setText(String.valueOf(reservaUpdate.getID()));
		fieldDescricao.setText(reservaUpdate.getDescricao());
		fieldData.setText(String.valueOf(reservaUpdate.getData()));
		fieldStatus.setText(reservaUpdate.getStatus());
		fieldCliente.setText(reservaUpdate.getCliente().getNome());
		cliente = reservaUpdate.getCliente();
		comboBoxEmpresa.setSelectedItem(reservaUpdate.getEmpresa().getId()+" - "+reservaUpdate.getEmpresa().getNome());
		comboBoxCategoria.setSelectedItem(reservaUpdate.getCategoria().getDescricao());
		dateChooserDataRetirada.setDate(reservaUpdate.getDataRetirada());
		buttonExcluir.setEnabled(true);
		buttonSalvar.setEnabled(true);
		buttonNovo.setEnabled(false);
		saveupdate = false;
		enableFields();
		chckbxCancelarReserva.setEnabled(true);
	}
	
	public void setCliente(Cliente cliente){
		this.cliente = cliente;
		fieldCliente.setText(cliente.getId()+" - "+cliente.getNome());
	}
	
	public void setPosicao() {
		Dimension d = this.getDesktopPane().getSize();
		this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
	}
}
