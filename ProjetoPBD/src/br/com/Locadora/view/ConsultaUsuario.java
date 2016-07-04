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

import br.com.Locadora.controller.UsuarioController;
import br.com.Locadora.model.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;


public class ConsultaUsuario extends JDialog {

	private static final long serialVersionUID = -7616001911230736284L;

	private JPanel contentPane;
	private JPanel panelTable;
	private JLabel labelCodigo;
	private JLabel labelNome;
	private JTextField fieldID;
	private JTextField fieldNome;
	private JButton buttonResearch;
	private JButton buttonSelect;
	private JTable tableUsuarios;
	private JSeparator separator;
	private JScrollPane scrollPaneTable;
	private DefaultTableModel modelTalble; 
	
	private UsuarioController controller;

	@SuppressWarnings("serial")
	public ConsultaUsuario(TelaCadastroUsuario telaCadastroUsuario) {
		setResizable(false);
		setTitle("Consulta Usu\u00E1rios");
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
		buttonSelect.setEnabled(false);
		buttonSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaCadastroUsuario.setFields((int) (tableUsuarios.getValueAt(tableUsuarios.getSelectedRow(), 0)));
				dispose();
			}
		});
		buttonSelect.setBounds(484, 11, 98, 23);
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
				new String [] {"Código", "Login", "Nome"}){      

			boolean[] canEdit = new boolean []{false, false, false};        

			@Override  
			public boolean isCellEditable(int rowIndex, int columnIndex) {        
				return canEdit [columnIndex];        
			}      
		};    

		tableUsuarios = new JTable(modelTalble);
		tableUsuarios.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPaneTable.setViewportView(tableUsuarios);
		tableUsuarios.getColumnModel().getColumn(0).setPreferredWidth(70);
		tableUsuarios.getColumnModel().getColumn(1).setPreferredWidth(170);
		tableUsuarios.getColumnModel().getColumn(2).setPreferredWidth(329);

	}

	public void pesquisar() {
		controller = new UsuarioController();
		
		if (fieldNome.getText().isEmpty()&&fieldID.getText().isEmpty()) {
			modelTalble.setNumRows(0);
			List<Usuario> usuarios = controller.listarTodos();
			for (int i = 0; i < usuarios.size(); i++) {
				modelTalble.addRow(new Object[]{usuarios.get(i).getId(), usuarios.get(i).getLogin(),usuarios.get(i).getNome()});
			}
		}else if (!fieldNome.getText().isEmpty()) {
			modelTalble.setNumRows(0);
			List<Usuario> usuarios = controller.consultaNome(fieldNome.getText());
			for (int i = 0; i < usuarios.size(); i++) {
				modelTalble.addRow(new Object[]{usuarios.get(i).getId(), usuarios.get(i).getLogin(),usuarios.get(i).getNome()});
			}
		}else {
			modelTalble.setNumRows(0);
			Usuario usuario = controller.consultaId(Integer.parseInt(fieldID.getText()));
			modelTalble.addRow(new Object[]{usuario.getId(),usuario.getNome()});
		}
		
		buttonSelect.setEnabled(true);
		
	}
}
