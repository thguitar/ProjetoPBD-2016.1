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

import br.com.Locadora.controller.CategoriaController;
import br.com.Locadora.model.Categoria;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;


public class ConsultaCategoria extends JDialog {

	private static final long serialVersionUID = -7616001911230736284L;

	private JPanel contentPane;
	private JPanel panelTable;
	private JLabel labelCodigo;
	private JLabel labelNome;
	private JTextField fieldID;
	private JTextField fieldNome;
	private JButton buttonResearch;
	private JButton buttonSelect;
	private JTable tableCategoria;
	private JSeparator separator;
	private JScrollPane scrollPaneTable;
	private DefaultTableModel modelTalble; 

	private CategoriaController categoriaController;
	
	@SuppressWarnings("serial")
	public ConsultaCategoria(TelaCadastroCategoria telaCadastroCategoria) {
		setResizable(false);
		setTitle("Consulta Categoria");
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
		labelCodigo.setBounds(10, 15, 42, 16);
		contentPane.add(labelCodigo);

		fieldID = new JTextField(10);
		fieldID.setBounds(56, 13, 40, 20);
		contentPane.add(fieldID);
		fieldID.setColumns(10);

		labelNome = new JLabel("Descri\u00E7\u00E3o:");
		labelNome.setBounds(108, 14, 61, 16);
		contentPane.add(labelNome);

		fieldNome = new JTextField();
		fieldNome.setBounds(176, 13, 214, 20);
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
				
				telaCadastroCategoria.setFields((int) (tableCategoria.getValueAt(tableCategoria.getSelectedRow(), 0)));
				
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
				new String [] {"Código", "Descrição"}){      

			boolean[] canEdit = new boolean []{false, false};        

			@Override  
			public boolean isCellEditable(int rowIndex, int columnIndex) {        
				return canEdit [columnIndex];        
			}      
		};    

		tableCategoria = new JTable(modelTalble);
		tableCategoria.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPaneTable.setViewportView(tableCategoria);
		tableCategoria.getColumnModel().getColumn(0).setPreferredWidth(70);
		tableCategoria.getColumnModel().getColumn(1).setPreferredWidth(499);
		
	}

	public void pesquisar() {
		categoriaController = new CategoriaController();
		
		if (fieldNome.getText().isEmpty()&&fieldID.getText().isEmpty()) {
			modelTalble.setNumRows(0);
			List<Categoria> categorias = categoriaController.ListALL();
			for (int i = 0; i < categorias.size(); i++) {
				modelTalble.addRow(new Object[]{categorias.get(i).getID(),categorias.get(i).getDescricao()});
			}
						
			categorias = null;
			
		}else if (!fieldNome.getText().isEmpty()) {
			modelTalble.setNumRows(0);
			List<Categoria> categorias = categoriaController.consultaDescricao(fieldNome.getText());
			for (int i = 0; i < categorias.size(); i++) {
				modelTalble.addRow(new Object[]{categorias.get(i).getID(),categorias.get(i).getDescricao()});
			}
		}else {
			modelTalble.setNumRows(0);
			Categoria categoria = categoriaController.consultaId(Integer.parseInt(fieldID.getText()));
			modelTalble.addRow(new Object[]{categoria.getID(), categoria.getDescricao()});
		}

		buttonSelect.setEnabled(true);
		
	}
}
