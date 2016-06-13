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
	private JMenu menuArquivo;
	private JMenu menuCadastros;
	private JMenu menuReservas;
	private JMenu menuLocao;
	private JMenu menuRelatorios;
	private JMenu menuSobre;
	private JMenu menuRCadastro;
	private JMenu menuRFinanceiro;
	private JMenu menuRLocao;
	private JMenu menuRReserva;
	private JMenuItem mnitemVeiculos;
	private JMenuItem mnitemClientes;
	private JMenuItem mnitemEmpresas;
	private JMenuItem mnitemConfiguracoes;
	private JMenuItem mnitemSair;
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
		setTitle("NOME DO SISTEMA");		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setExtendedState(MAXIMIZED_BOTH);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuArquivo = new JMenu("Arquivo");
		menuBar.add(menuArquivo);
		
			mnitemConfiguracoes = new JMenuItem("Configura\u00E7\u00F5es");
			mnitemSair = new JMenuItem("Sair");
		
			menuArquivo.add(mnitemConfiguracoes);
			menuArquivo.add(mnitemSair);
		
		menuCadastros = new JMenu("Cadastros");
		menuBar.add(menuCadastros);
		
			mnitemClientes = new JMenuItem("Clientes");
			mnitemEmpresas = new JMenuItem("Empresas (Matriz e Filiais)");
			mnitemVeiculos = new JMenuItem("Ve\u00EDculos");

			menuCadastros.add(mnitemClientes);
			menuCadastros.add(mnitemEmpresas);
			menuCadastros.add(mnitemVeiculos);
		
		menuReservas = new JMenu("Reservas");
		menuBar.add(menuReservas);
		
		menuLocao = new JMenu("Loca\u00E7\u00E3o");
		menuBar.add(menuLocao);
		
		menuRelatorios = new JMenu("Relat\u00F3rios");
		menuBar.add(menuRelatorios);
			
			menuRCadastro = new JMenu("Cadastro");
			menuRFinanceiro = new JMenu("Financeiro");
			menuRLocao = new JMenu("Loca\u00E7\u00E3o");
			menuRReserva = new JMenu("Reserva");

			menuRelatorios.add(menuRCadastro);
			menuRelatorios.add(menuRFinanceiro);
			menuRelatorios.add(menuRLocao);
			menuRelatorios.add(menuRReserva);
		
		menuSobre = new JMenu("Sobre");
		menuBar.add(menuSobre);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelInformacoes = new JPanel();
		panelInformacoes.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelInformacoes.setBounds(0, 662, 1370, 23);
		contentPane.add(panelInformacoes);
		panelInformacoes.setLayout(null);
		
		labelUsuario = new JLabel("Usu\u00E1rio: TESTANDO");
		labelUsuario.setBounds(3, 3, 150, 16);
		panelInformacoes.add(labelUsuario);
		
		labelEmpresa = new JLabel("Empresa: LOCADORA DE CARROS LTDA");
		labelEmpresa.setBounds(170, 3, 270, 16);
		panelInformacoes.add(labelEmpresa);
		
		labelData = new JLabel("Data:");
		labelData.setBounds(455, 3, 45, 16);
		panelInformacoes.add(labelData);
		
		format = new SimpleDateFormat("dd/MM/YYYY");
		labelData2 = new JLabel(format.format(new Date()));
		labelData2.setBounds(500, 3, 80, 16);
		panelInformacoes.add(labelData2);
	}

	public JMenuItem getMenuitemVeiculos() {
		return mnitemVeiculos;
	}

	public JMenuItem getMenuitemClientes() {
		return mnitemClientes;
	}

	public JMenuItem getMenuitemEmpresas() {
		return mnitemEmpresas;
	}

	public JMenu getMenuRCadastro() {
		return menuRCadastro;
	}

	public JMenu getMenuRFinanceiro() {
		return menuRFinanceiro;
	}

	public JMenu getMenuRLocao() {
		return menuRLocao;
	}

	public JMenu getMenuRReserva() {
		return menuRReserva;
	}
}
