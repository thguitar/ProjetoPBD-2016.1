package br.com.Locadora.view;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.Locadora.controller.ReservaController;
import br.com.Locadora.model.Reserva;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;


public class ConsultaReserva extends JDialog {

	private static final long serialVersionUID = -7616001911230736284L;

	private JPanel contentPane;
	private JPanel panelTable;
	private JLabel labelCodigo;
	private JLabel labelDescricao;
	private JTextField fieldID;
	private JTextField fieldDescricao;
	private JButton buttonResearch;
	private JButton buttonSelect;
	private JTable tableReservas;
	private JSeparator separator;
	private JScrollPane scrollPaneTable;
	private DefaultTableModel modelTalble; 
	
	private TelaReserva telaReserva;
	private TelaLocacao telaLocacao;
	private ReservaController controller;
	
	@SuppressWarnings("serial")
	public ConsultaReserva(Object objectTela) {
		setResizable(false);
		setTitle("Consulta Reservas");
		setType(Type.POPUP);
		setModal(true);
		setAlwaysOnTop(true);
		setSize(600, 315);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		controller = new ReservaController();
		
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

		labelDescricao = new JLabel("Descri\u00E7\u00E3o:");
		labelDescricao.setBounds(105, 14, 61, 16);
		contentPane.add(labelDescricao);

		fieldDescricao = new JTextField();
		fieldDescricao.setBounds(169, 12, 221, 20);
		contentPane.add(fieldDescricao);
		fieldDescricao.setColumns(10);

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

				if (objectTela.getClass().equals(TelaReserva.class)) {
					telaReserva = (TelaReserva) objectTela;
					telaReserva.setFields((int) (tableReservas.getValueAt(tableReservas.getSelectedRow(), 0)));
				}else {
					telaLocacao = (TelaLocacao) objectTela;
					telaLocacao.setReserva(controller.consultaId((int) (tableReservas.getValueAt(tableReservas.getSelectedRow(), 0))));
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
				new String [] {"Código", "Descrição", "Data", "Status"}){      

			boolean[] canEdit = new boolean []{false, false, false, false};        

			@Override  
			public boolean isCellEditable(int rowIndex, int columnIndex) {        
				return canEdit [columnIndex];        
			}      
		};    

		tableReservas = new JTable(modelTalble);
		tableReservas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPaneTable.setViewportView(tableReservas);
		tableReservas.getColumnModel().getColumn(0).setPreferredWidth(70);
		tableReservas.getColumnModel().getColumn(1).setPreferredWidth(499);
		tableReservas.getColumnModel().getColumn(2).setPreferredWidth(70);
		tableReservas.getColumnModel().getColumn(3).setPreferredWidth(70);

	}

	public void pesquisar() {

		if (fieldDescricao.getText().isEmpty()&&fieldID.getText().isEmpty()) {
			modelTalble.setNumRows(0);
			List<Reserva> reservas = controller.listALL();
			if (!reservas.isEmpty()) {
				for (int i = 0; i < reservas.size(); i++) {
					modelTalble.addRow(new Object[]{reservas.get(i).getID(), reservas.get(i).getDescricao(), reservas.get(i).getData(), reservas.get(i).getStatus()});
				}
				buttonSelect.setEnabled(true);
			}else
				JOptionPane.showMessageDialog(this, "Nenhuma Reserva Encontrada", "Retorno Busca", JOptionPane.WARNING_MESSAGE);
			
			reservas = null;
		}else if (!fieldDescricao.getText().isEmpty()) {
			modelTalble.setNumRows(0);
			List<Reserva> reservas = controller.consultaNome(fieldDescricao.getText());
			if (!reservas.isEmpty()) {
				for (int i = 0; i < reservas.size(); i++) {
					modelTalble.addRow(new Object[]{reservas.get(i).getID(), reservas.get(i).getDescricao(), reservas.get(i).getData(), reservas.get(i).getStatus()});
				}
				buttonSelect.setEnabled(true);
			}else
				JOptionPane.showMessageDialog(this, "Nenhuma Reserva Encontrada", "Retorno Busca", JOptionPane.WARNING_MESSAGE);
			
			reservas = null;
		}else {
			modelTalble.setNumRows(0);
			Reserva reserva = controller.consultaId(Integer.parseInt(fieldID.getText()));
			if(reserva !=null){
				modelTalble.addRow(new Object[]{reserva.getID(), reserva.getDescricao(), reserva.getData(), reserva.getStatus()});
				buttonSelect.setEnabled(true);
			}else
				JOptionPane.showMessageDialog(this, "Nenhuma Reserva Encontrada", "Retorno Busca", JOptionPane.WARNING_MESSAGE);
			
			reserva = null;
		}
	}
}
