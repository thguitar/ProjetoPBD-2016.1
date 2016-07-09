package br.com.Locadora.view;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.Locadora.controller.VeiculoController;
import br.com.Locadora.model.FixedLengthJTextField;
import br.com.Locadora.model.Veiculo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;


public class ConsultaVeiculo extends JDialog {

	private static final long serialVersionUID = -7616001911230736284L;

	private JPanel contentPane;
	private JPanel panelTable;
	private JLabel labelCodigo;
	private JLabel labelNome;
	private JTextField fieldCodigo;
	private JFormattedTextField formattedTextFieldPlaca;
	private JButton buttonResearch;
	private JButton buttonSelect;
	private JTable tableEmpresas;
	private JSeparator separator;
	private JScrollPane scrollPaneTable;
	private DefaultTableModel modelTalble; 

	private VeiculoController controller;
	
	@SuppressWarnings("serial")
	public ConsultaVeiculo(TelaCadastroVeiculo telaCadastroVeiculo) {
		setResizable(false);
		setTitle("Consulta Ve\u00EDculos");
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

		labelCodigo = new JLabel("Chassi:");
		labelCodigo.setBounds(10, 15, 49, 14);
		contentPane.add(labelCodigo);

		fieldCodigo = new JTextField(10);
		fieldCodigo.setDocument(new FixedLengthJTextField(15));
		fieldCodigo.setBounds(58, 12, 58, 20);
		contentPane.add(fieldCodigo);
		fieldCodigo.setColumns(10);

		labelNome = new JLabel("Placa:");
		labelNome.setBounds(203, 15, 40, 14);
		contentPane.add(labelNome);

		formattedTextFieldPlaca = new JFormattedTextField(Mascara("UUU-####"));
		formattedTextFieldPlaca.setBounds(245, 12, 92, 20);
		contentPane.add(formattedTextFieldPlaca);
		formattedTextFieldPlaca.setColumns(10);

		controller = new VeiculoController();
		
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

				telaCadastroVeiculo.setFields((Integer) (tableEmpresas.getValueAt(tableEmpresas.getSelectedRow(), 0)));

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
				new String [] {"CÓDIGO","CHASSI", "PLACA", "TIPO", "CATEGORIA", "ANO MODELO", "ANO FABRICAÇÃO"}){      

			boolean[] canEdit = new boolean []{false, false, false, false, false, false, false};        

			@Override  
			public boolean isCellEditable(int rowIndex, int columnIndex) {        
				return canEdit [columnIndex];        
			}      
		};    

		tableEmpresas = new JTable(modelTalble);
		tableEmpresas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPaneTable.setViewportView(tableEmpresas);
		tableEmpresas.getColumnModel().getColumn(0).setPreferredWidth(120);
		tableEmpresas.getColumnModel().getColumn(1).setPreferredWidth(70);
		tableEmpresas.getColumnModel().getColumn(2).setPreferredWidth(100);
		tableEmpresas.getColumnModel().getColumn(3).setPreferredWidth(200);
		tableEmpresas.getColumnModel().getColumn(4).setPreferredWidth(100);
		tableEmpresas.getColumnModel().getColumn(5).setPreferredWidth(110);

	}

	private MaskFormatter Mascara(String mascara){
		MaskFormatter formatter;

		try {
			formatter = new MaskFormatter();
			formatter.setMask(mascara);
			return formatter;
		} catch (Exception e) {
			return null;
		}
	}
	
	public void pesquisar() {
		String tipo;
		if (formattedTextFieldPlaca.getText().equals("   -    ")&&fieldCodigo.getText().isEmpty()) {
			modelTalble.setNumRows(0);
			List<Veiculo> veiculos = controller.ListAll();
			for (int i = 0; i < veiculos.size(); i++) {
				if(veiculos.get(i).getTipo()=='A')
					tipo = "Automóvel";
				else if(veiculos.get(i).getTipo()=='C')
					tipo = "Caminhotene";
				else
					tipo = "Caminhotene de Carga";
				
				modelTalble.addRow(new Object[]{veiculos.get(i).getID(), veiculos.get(i).getNumeroChassi(),veiculos.get(i).getPlaca(), tipo, veiculos.get(i).getCategoria().getDescricao(), veiculos.get(i).getAnoModelo(), veiculos.get(i).getAnoFabricacao()});
			}
		}else if (!formattedTextFieldPlaca.getText().equals("   -    ")) {
			modelTalble.setNumRows(0);
			Veiculo veiculo = controller.consultaPlaca(formattedTextFieldPlaca.getText().replaceAll("[.-]", ""));
			if(veiculo.getTipo()=='A')
				tipo = "Automóvel";
			else if(veiculo.getTipo()=='C')
				tipo = "Caminhotene";
			else
				tipo = "Caminhotene de Carga";
			modelTalble.addRow(new Object[]{veiculo.getID(), veiculo.getNumeroChassi(),veiculo.getPlaca(), tipo, veiculo.getCategoria().getDescricao(), veiculo.getAnoModelo(), veiculo.getAnoFabricacao()});
		}else {
			modelTalble.setNumRows(0);
			Veiculo veiculo = controller.consultaId(Integer.parseInt(fieldCodigo.getText()));
			if(veiculo.getTipo()=='A')
				tipo = "Automóvel";
			else if(veiculo.getTipo()=='C')
				tipo = "Caminhotene";
			else
				tipo = "Caminhotene de Carga";
			modelTalble.addRow(new Object[]{veiculo.getID(), veiculo.getNumeroChassi(),veiculo.getPlaca(), tipo, veiculo.getCategoria().getDescricao(), veiculo.getAnoModelo(), veiculo.getAnoFabricacao()});
		}
		
		buttonSelect.setEnabled(true);

	}
}
