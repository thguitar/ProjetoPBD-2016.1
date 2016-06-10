package br.com.Locadora.view;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;

public class TelaInicial extends JFrame {

	private static final long serialVersionUID = -2773811355479248366L;
	
	private JPanel contentPane;
	private JPanel panelInformacoes;
	private JMenuBar menuBar;
	private JMenu mnArquivo;
	private JMenu mnCadastros;
	private JMenu mnReservas;
	private JMenu mnLocao;
	private JMenu mnRelatrios;
	private JMenu mnSobre;
	private JMenuItem menuItem;
	private JMenuItem mntmVeculos;
	private JMenuItem mntmClientes;
	private JMenuItem mntmEmpresasfiliais;
	private JLabel labelEmpresa;
	private JLabel labelData;
	private JLabel labelData2;
	private JLabel labelUsuario;
	private DateFormat format;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		mnCadastros = new JMenu("Cadastros");
		menuBar.add(mnCadastros);
		
		mntmClientes = new JMenuItem("Clientes");
		mnCadastros.add(mntmClientes);
		
		mntmEmpresasfiliais = new JMenuItem("Empresas (Matriz e Filiais)");
		mnCadastros.add(mntmEmpresasfiliais);
		
		mntmVeculos = new JMenuItem("Ve\u00EDculos");
		mnCadastros.add(mntmVeculos);
		
		menuItem = new JMenuItem("New menu item");
		mnCadastros.add(menuItem);
		
		mnReservas = new JMenu("Reservas");
		menuBar.add(mnReservas);
		
		mnLocao = new JMenu("Loca\u00E7\u00E3o");
		menuBar.add(mnLocao);
		
		mnRelatrios = new JMenu("Relat\u00F3rios");
		menuBar.add(mnRelatrios);
		
		mnSobre = new JMenu("Sobre");
		menuBar.add(mnSobre);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelInformacoes = new JPanel();
		panelInformacoes.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelInformacoes.setBounds(0, 662, 500, 23);
		contentPane.add(panelInformacoes);
		panelInformacoes.setLayout(null);
		
		labelUsuario = new JLabel("Usu\u00E1rio: TESTANDO");
		labelUsuario.setBounds(2, 3, 128, 16);
		panelInformacoes.add(labelUsuario);
		
		labelEmpresa = new JLabel("Empresa: LOCADORA DE CARROS LTDA");
		labelEmpresa.setBounds(142, 3, 242, 16);
		panelInformacoes.add(labelEmpresa);
		
		labelData = new JLabel("Data:");
		labelData.setBounds(386, 3, 34, 16);
		panelInformacoes.add(labelData);
		
		format = new SimpleDateFormat("dd/MM/YYYY");
		labelData2 = new JLabel(format.format(new Date()));
		labelData2.setBounds(419, 3, 69, 16);
		panelInformacoes.add(labelData2);
	}
}
