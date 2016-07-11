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

import br.com.Locadora.controller.LocacaoController;
import br.com.Locadora.model.Locacao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;


public class ConsultaLocacao extends JDialog {

	private static final long serialVersionUID = -7616001911230736284L;

	private JPanel contentPane;
	private JPanel panelTable;
	private JLabel labelCodigo;
	private JLabel labelDescricao;
	private JTextField fieldID;
	private JTextField fieldCliente;
	private JButton buttonResearch;
	private JButton buttonSelect;
	private JTable tableLocacao;
	private JSeparator separator;
	private JScrollPane scrollPaneTable;
	private DefaultTableModel modelTalble; 
	
	private LocacaoController controller;
	
	@SuppressWarnings("serial")
	public ConsultaLocacao(TelaLocacao telaLocacao) {
		setResizable(false);
		setTitle("Consulta Reservas");
		setType(Type.POPUP);
		setModal(true);
		setAlwaysOnTop(true);
		setSize(600, 315);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		controller = new LocacaoController();
		
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

		labelDescricao = new JLabel("Cliente:");
		labelDescricao.setBounds(105, 14, 42, 16);
		contentPane.add(labelDescricao);

		fieldCliente = new JTextField();
		fieldCliente.setBounds(149, 12, 241, 20);
		contentPane.add(fieldCliente);
		fieldCliente.setColumns(10);

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
				telaLocacao.setFields((int) (tableLocacao.getValueAt(tableLocacao.getSelectedRow(), 0)));	
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
				new String [] {"Código", "Cliente", "Data", "Data Devolução"}){      

			boolean[] canEdit = new boolean []{false, false, false, false};        

			@Override  
			public boolean isCellEditable(int rowIndex, int columnIndex) {        
				return canEdit [columnIndex];        
			}      
		};    

		tableLocacao = new JTable(modelTalble);
		tableLocacao.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPaneTable.setViewportView(tableLocacao);
		tableLocacao.getColumnModel().getColumn(0).setPreferredWidth(70);
		tableLocacao.getColumnModel().getColumn(1).setPreferredWidth(499);
		tableLocacao.getColumnModel().getColumn(2).setPreferredWidth(70);
		tableLocacao.getColumnModel().getColumn(3).setPreferredWidth(70);

	}

	public void pesquisar() {

		if (fieldCliente.getText().isEmpty()&&fieldID.getText().isEmpty()) {
			modelTalble.setNumRows(0);
			List<Locacao> locacoes = controller.listALL();
			for (int i = 0; i < locacoes.size(); i++) {
				modelTalble.addRow(new Object[]{locacoes.get(i).getID(), locacoes.get(i).getCliente().getNome(), locacoes.get(i).getDataHoraSaida(), locacoes.get(i).getDataPrevistaDevolucao()});
			}
		}else if (!fieldCliente.getText().isEmpty()) {
			modelTalble.setNumRows(0);
			List<Locacao> locacoes = controller.consultaByCliente(fieldCliente.getText());
			for (int i = 0; i < locacoes.size(); i++) {
				modelTalble.addRow(new Object[]{locacoes.get(i).getID(), locacoes.get(i).getCliente().getNome(), locacoes.get(i).getDataHoraSaida(), locacoes.get(i).getDataPrevistaDevolucao()});
			}
		}else {
			modelTalble.setNumRows(0);
			Locacao locacao = controller.consultaId(Integer.parseInt(fieldID.getText()));
			modelTalble.addRow(new Object[]{locacao.getID(), locacao.getCliente().getNome(), locacao.getDataHoraSaida(), locacao.getDataPrevistaDevolucao()});
		}
		
		buttonSelect.setEnabled(true);

	}
}
