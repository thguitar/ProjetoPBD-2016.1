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


	public static void main(String[] args) {
		try {
			ConsultaUsuario dialog = new ConsultaUsuario(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("serial")
	public ConsultaUsuario(TelaCadastroUsuario telaCadastroUsuario) {
		setResizable(false);
		setTitle("Consulta Usu\u00E1rios");
		setType(Type.POPUP);
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
				new String [] {"C�digo", "Login", "Nome"}){      

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
		if (fieldNome.getText().isEmpty()&&fieldID.getText().isEmpty()) {
			//faz a consulta de todos os usuarios cadastrados
		}else if (!fieldNome.getText().isEmpty()) {
			//faz a consulta pelo nome digitado
		}else {
			//faz a consulta pelo c�digo digitado
		}

		modelTalble.setNumRows(0);
		UsuarioController usuarioController = new UsuarioController();
		Usuario usuario = usuarioController.consultaId(Integer.parseInt(fieldID.getText()));
		modelTalble.addRow(new Object[]{usuario.getId(),usuario.getNome(),usuario.getEmail()});
	}
}
