package br.com.Locadora.view;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.Locadora.controller.ClienteController;
import br.com.Locadora.model.Cliente;
import br.com.Locadora.model.PessoaFisica;
import br.com.Locadora.model.PessoaJuridica;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;


public class ConsultaCliente extends JDialog {

	private static final long serialVersionUID = -7616001911230736284L;

	private JPanel contentPane;
	private JPanel panelTable;
	private JLabel labelCodigo;
	private JLabel labelNome;
	private JTextField fieldID;
	private JTextField fieldNome;
	private JButton buttonResearch;
	private JButton buttonSelect;
	private JTable tableClientes;
	private JSeparator separator;
	private JScrollPane scrollPaneTable;
	private DefaultTableModel modelTalble; 

	private ClienteController clienteController;
	private TelaCadastroCliente telaCliente;
	private TelaReserva telaReserva;
	
	@SuppressWarnings("serial")
	public ConsultaCliente(Object objectTela) {
		setResizable(false);
		setTitle("Consulta Clientes");
		setType(Type.POPUP);
		setModal(true);
		setAlwaysOnTop(true);
		setSize(600, 315);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		labelCodigo = new JLabel("C\u00F3digo:");
		labelCodigo.setBounds(10, 15, 49, 14);
		contentPane.add(labelCodigo);

		fieldID = new JTextField(10);
		fieldID.setBounds(56, 12, 40, 20);
		contentPane.add(fieldID);
		fieldID.setColumns(10);

		labelNome = new JLabel("Nome:");
		labelNome.setBounds(105, 15, 40, 14);
		contentPane.add(labelNome);

		fieldNome = new JTextField();
		fieldNome.setBounds(145, 12, 245, 20);
		contentPane.add(fieldNome);
		fieldNome.setColumns(10);

		buttonResearch = new JButton("Pesquisar");
		buttonResearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pesquisar();
			}
		});
		buttonResearch.setBounds(392, 11, 92, 23);
		contentPane.add(buttonResearch);

		buttonSelect = new JButton("Selecionar");
		buttonSelect.setBounds(484, 11, 98, 23);
		buttonSelect.setEnabled(false);
		buttonSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(objectTela.getClass().equals(TelaCadastroCliente.class)){
					telaCliente = (TelaCadastroCliente) objectTela;
					if (tableClientes.getValueAt(tableClientes.getSelectedRow(), 2).equals("FÍSICA")) {
						telaCliente.setFieldsPF((int) (tableClientes.getValueAt(tableClientes.getSelectedRow(), 0)));
					}else {
						telaCliente.setFieldsPJ((int) (tableClientes.getValueAt(tableClientes.getSelectedRow(), 0)));
					}
				}else {
					telaReserva = (TelaReserva) objectTela;
					telaReserva.setCliente(clienteController.consultaId((int) (tableClientes.getValueAt(tableClientes.getSelectedRow(), 0))));
				}
				
				dispose();
			}
		});
		contentPane.add(buttonSelect);

		separator = new JSeparator();
		separator.setBounds(10, 41, 572, 2);
		contentPane.add(separator);

		panelTable = new JPanel();
		panelTable.setBounds(10, 49, 572, 217);
		contentPane.add(panelTable);
		panelTable.setLayout(null);

		scrollPaneTable = new JScrollPane();
		scrollPaneTable.setBounds(0, 0, 572, 216);
		panelTable.add(scrollPaneTable);

		modelTalble = new DefaultTableModel(null,   
				new String [] {"Código", "Nome", "Tipo Pessoa", "CPF/CNPJ", "Insc. Estadual", "Sexo"}){      

			boolean[] canEdit = new boolean []{false, false, false, false, false, false};        

			@Override  
			public boolean isCellEditable(int rowIndex, int columnIndex) {        
				return canEdit [columnIndex];        
			}      
		};    

		tableClientes = new JTable(modelTalble);
		tableClientes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPaneTable.setViewportView(tableClientes);
		tableClientes.getColumnModel().getColumn(0).setPreferredWidth(70);
		tableClientes.getColumnModel().getColumn(1).setPreferredWidth(350);
		tableClientes.getColumnModel().getColumn(2).setPreferredWidth(80);
		tableClientes.getColumnModel().getColumn(3).setPreferredWidth(100);
		tableClientes.getColumnModel().getColumn(4).setPreferredWidth(100);
		tableClientes.getColumnModel().getColumn(5).setPreferredWidth(75);
		
	}

	public void pesquisar() {
		clienteController = new ClienteController();
		
		if (fieldNome.getText().isEmpty()&&fieldID.getText().isEmpty()) {
			modelTalble.setNumRows(0);
			List<PessoaFisica> clientes = clienteController.consultaClientesPF();
			for (int i = 0; i < clientes.size(); i++) {
				modelTalble.addRow(new Object[]{clientes.get(i).getId(),clientes.get(i).getNome(), "FÍSICA", clientes.get(i).getCpf(), "ISENTO", clientes.get(i).getSexo()=='M'? "MASCULINO" : "FEMININO"});
			}
			List<PessoaJuridica> clientesPJ = clienteController.consultaClientesPJ();
			for (int i = 0; i < clientesPJ.size(); i++) {
				modelTalble.addRow(new Object[]{clientesPJ.get(i).getId(),clientesPJ.get(i).getNome(), "JURÍDICA", clientesPJ.get(i).getCnpj(), clientesPJ.get(i).getInscricaoEstadual()});
			}
			
			clientes = null;
			clientesPJ = null;
			
		}else if (!fieldNome.getText().isEmpty()) {
			modelTalble.setNumRows(0);
			List<Cliente> clientes = clienteController.consultaNome(fieldNome.getText());
			for (int i = 0; i < clientes.size(); i++) {
				modelTalble.addRow(new Object[]{clientes.get(i).getId(),clientes.get(i).getNome()});
			}
		}else {
			modelTalble.setNumRows(0);
			Cliente cliente = clienteController.consultaId(Integer.parseInt(fieldID.getText()));
			modelTalble.addRow(new Object[]{cliente.getId(),cliente.getNome()});
		}

		buttonSelect.setEnabled(true);
		
	}
}
