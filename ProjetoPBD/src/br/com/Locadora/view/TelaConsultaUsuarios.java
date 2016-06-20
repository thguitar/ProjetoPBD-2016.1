package br.com.Locadora.view;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.SystemColor;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextField;

import br.com.Locadora.controller.UsuarioController;
import br.com.Locadora.model.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaConsultaUsuarios extends JFrame {
	private DefaultTableModel modelo = new DefaultTableModel();
	private JTable tabela;
	private JPanel contentPane;
	private JTextField idField;
	private JTextField nomeField;
	private JScrollPane barraRolagem;
	private JButton btInserir;
	private JButton btExcluir;
	private JButton btEditar;
	private JPanel painelBotoes;
	private JPanel painelTabela;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultaUsuarios frame = new TelaConsultaUsuarios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaConsultaUsuarios() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 625, 57);
		panel.setBackground(SystemColor.inactiveCaption);
		contentPane.add(panel);
		
		JLabel lblConsultaDeUsurios = new JLabel("Consulta de usu\u00E1rios");
		lblConsultaDeUsurios.setForeground(new Color(0, 0, 102));
		lblConsultaDeUsurios.setFont(new Font("SansSerif", Font.BOLD, 32));
		panel.add(lblConsultaDeUsurios);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBounds(0, 435, 625, 10);
		contentPane.add(panel_1);
		
		painelTabela = new JPanel();
		painelTabela.setBackground(new Color(153, 204, 204));
		painelTabela.setBounds(0, 129, 625, 266);
		contentPane.add(painelTabela);
		
		
		JButton button = new JButton("Cancelar");
		button.setForeground(Color.RED);
		button.setFont(new Font("SansSerif", Font.BOLD, 13));
		button.setBackground(new Color(255, 204, 255));
		button.setBounds(248, 401, 105, 23);
		contentPane.add(button);
		
		JLabel lblConsultaPorId = new JLabel("Consulta por ID");
		lblConsultaPorId.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblConsultaPorId.setBounds(10, 68, 86, 16);
		contentPane.add(lblConsultaPorId);
		
		JLabel lblConsultaPorNome = new JLabel("Consulta por nome");
		lblConsultaPorNome.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblConsultaPorNome.setBounds(186, 68, 115, 16);
		contentPane.add(lblConsultaPorNome);
		
		JLabel lblListarTodos = new JLabel("Listar todos");
		lblListarTodos.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblListarTodos.setBounds(487, 68, 77, 16);
		contentPane.add(lblListarTodos);
		
		idField = new JTextField();
		idField.setBounds(106, 67, 29, 20);
		contentPane.add(idField);
		idField.setColumns(10);
		
		nomeField = new JTextField();
		nomeField.setBounds(311, 68, 166, 20);
		contentPane.add(nomeField);
		nomeField.setColumns(10);
		
		criaJTable();
		criaJanela();
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				pesquisar(modelo, Integer.parseInt(idField.getText()));
				
			}
		});
		btnPesquisar.setForeground(new Color(0, 102, 0));
		btnPesquisar.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnPesquisar.setBackground(new Color(204, 255, 255));
		btnPesquisar.setBounds(10, 95, 105, 23);
		contentPane.add(btnPesquisar);
		
		JButton btnPesquisar_1 = new JButton("Pesquisar");
		btnPesquisar_1.setForeground(new Color(0, 102, 0));
		btnPesquisar_1.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnPesquisar_1.setBackground(new Color(204, 255, 255));
		btnPesquisar_1.setBounds(186, 95, 105, 23);
		contentPane.add(btnPesquisar_1);
		
		JButton btnPesquisar_2 = new JButton("Pesquisar");
		btnPesquisar_2.setForeground(new Color(0, 102, 0));
		btnPesquisar_2.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnPesquisar_2.setBackground(new Color(204, 255, 255));
		btnPesquisar_2.setBounds(487, 95, 105, 23);
		contentPane.add(btnPesquisar_2);
	}
	private void criaJTable() {
		tabela = new JTable(modelo);
		modelo.addColumn("Id");
		modelo.addColumn("Nome");
		modelo.addColumn("email");
		tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(120);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(120);
		
	}
	public static void pesquisar(DefaultTableModel modelo, int id) {
		modelo.setNumRows(0);
		UsuarioController usuarioController = new UsuarioController();
		Usuario u = usuarioController.consultaId(id);
		modelo.addRow(new Object[]{u.getId(),u.getNome(),u.getEmail()});
		
		
	}
	
	public void criaJanela() {
		btInserir = new JButton("Inserir");
		btExcluir = new JButton("Excluir");
		btEditar = new JButton("Editar");
		painelBotoes = new JPanel();
		barraRolagem = new JScrollPane(tabela);
		JPanel painelFundo = new JPanel();
		painelFundo.setLayout(new BorderLayout());
//		painelFundo.add(BorderLayout.CENTER, barraRolagem);
		painelBotoes.add(btInserir);
		painelBotoes.add(btEditar);
		painelBotoes.add(btExcluir);
		painelFundo.add(BorderLayout.SOUTH, painelBotoes);
		painelFundo.setSize(120, 350);
		painelTabela.add(BorderLayout.CENTER,barraRolagem);
//		painelTabela.add(painelFundo);
//		btInserir.addActionListener(new BtInserirListener());
//		btEditar.addActionListener(new BtEditarListener());
//		btExcluir.addActionListener(new BtExcluirListener());
	}
}
