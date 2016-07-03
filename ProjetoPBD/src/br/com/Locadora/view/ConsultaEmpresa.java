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

import br.com.Locadora.controller.EmpresaController;
import br.com.Locadora.model.Empresa;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;


public class ConsultaEmpresa extends JDialog {

	private static final long serialVersionUID = -7616001911230736284L;

	private JPanel contentPane;
	private JPanel panelTable;
	private JLabel labelCodigo;
	private JLabel labelNome;
	private JTextField fieldID;
	private JTextField fieldNome;
	private JButton buttonResearch;
	private JButton buttonSelect;
	private JTable tableEmpresas;
	private JSeparator separator;
	private JScrollPane scrollPaneTable;
	private DefaultTableModel modelTalble; 


	public static void main(String[] args) {
		try {
			ConsultaEmpresa dialog = new ConsultaEmpresa(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("serial")
	public ConsultaEmpresa(TelaCadastroEmpresa telaCadastroEmpresa) {
		setResizable(false);
		setTitle("Consulta Empresas");
		setType(Type.POPUP);
		setModal(true);
		setAlwaysOnTop(true);
		setBounds(100, 100, 600, 315);
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

				telaCadastroEmpresa.setFields((int) (tableEmpresas.getValueAt(tableEmpresas.getSelectedRow(), 0)));

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
				new String [] {"Código", "Nome"}){      

			boolean[] canEdit = new boolean []{false, false};        

			@Override  
			public boolean isCellEditable(int rowIndex, int columnIndex) {        
				return canEdit [columnIndex];        
			}      
		};    

		tableEmpresas = new JTable(modelTalble);
		tableEmpresas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPaneTable.setViewportView(tableEmpresas);
		tableEmpresas.getColumnModel().getColumn(0).setPreferredWidth(70);
		tableEmpresas.getColumnModel().getColumn(1).setPreferredWidth(499);

	}

	public void pesquisar() {
		EmpresaController empresaController = new EmpresaController();

		if (fieldNome.getText().isEmpty()&&fieldID.getText().isEmpty()) {
			modelTalble.setNumRows(0);
			List<Empresa> empresas = empresaController.consultaEmpresas();
			for (int i = 0; i < empresas.size(); i++) {
				modelTalble.addRow(new Object[]{empresas.get(i).getId(),empresas.get(i).getNome()});
			}
		}else if (!fieldNome.getText().isEmpty()) {
			modelTalble.setNumRows(0);
			List<Empresa> empresas = empresaController.consultaNome(fieldNome.getText());
			for (int i = 0; i < empresas.size(); i++) {
				modelTalble.addRow(new Object[]{empresas.get(i).getId(),empresas.get(i).getNome()});
			}
		}else {
			modelTalble.setNumRows(0);
			Empresa empresa = empresaController.consultaId(Integer.parseInt(fieldID.getText()));
			modelTalble.addRow(new Object[]{empresa.getId(),empresa.getNome()});
		}
		
		buttonSelect.setEnabled(true);

	}
}
