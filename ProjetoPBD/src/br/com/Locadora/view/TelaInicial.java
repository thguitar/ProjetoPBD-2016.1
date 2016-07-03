package br.com.Locadora.view;

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
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;

import javax.swing.JDesktopPane;

import br.com.Locadora.controller.HibernateSingleton;
import br.com.Locadora.model.Usuario;
import javax.swing.ImageIcon;

public class TelaInicial extends JFrame {

	private static final long serialVersionUID = -2773811355479248366L;
	
	private JPanel contentPane;
	private JPanel panelInformacoes;
	private JDesktopPane desktopPane;
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
	private JMenuItem mnitemUsuarios;
	private JMenuItem mnitemConfiguracoes;
	private JMenuItem mnitemSair;
	private JMenuItem mnitemAjuda;
	private JMenuItem mnitemSobreOSistema;
	private JLabel labelBackground;
	private JLabel labelInformacoes;
	private DateFormat format;
	
	private Usuario usuarioLogado;
	
	public TelaInicial(Usuario usuarioLogado) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagens/iconCar.png"));
		setTitle("NARVI - 1.0");		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setExtendedState(MAXIMIZED_BOTH);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		desktopPane = new JDesktopPane();
		desktopPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		desktopPane.setBounds(1, 0, 1365, 663);
		contentPane.add(desktopPane);
		
		labelBackground = new JLabel();
		labelBackground.setIcon(new ImageIcon("imagens/backgrounds/backgroundBlack.png"));
		labelBackground.setBounds(0, 0, 1365, 660);
		desktopPane.add(labelBackground);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuArquivo = new JMenu("Arquivo");
		menuBar.add(menuArquivo);
		
			mnitemConfiguracoes = new JMenuItem("Configura\u00E7\u00F5es");
			mnitemConfiguracoes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (TelaInicial.this.usuarioLogado.isAdmin()) {
						TelaConfiguracoes telaConfiguracoes = new TelaConfiguracoes();
						desktopPane.add(telaConfiguracoes);
						try {
							telaConfiguracoes.setPosicao();
							telaConfiguracoes.setSelected(true);
						} catch (PropertyVetoException e2) {
							e2.printStackTrace();
						}
					}else {
						JOptionPane.showMessageDialog(null, "Usuário sem Permissão", "Aviso de Permissão", JOptionPane.WARNING_MESSAGE);
					}
				}
			});
			mnitemSair = new JMenuItem("Sair");
			mnitemSair.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (JOptionPane.showConfirmDialog(null, "Deseja Realmente Sair ?", "Sair do Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==0)
						HibernateSingleton.closeFactory();
						System.exit(0);
				}
			});
		
			menuArquivo.add(mnitemConfiguracoes);
			menuArquivo.add(mnitemSair);
		
		menuCadastros = new JMenu("Cadastros");
		menuBar.add(menuCadastros);
		
			mnitemClientes = new JMenuItem("Clientes");
			mnitemClientes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					TelaCadastroCliente cadastroCliente = new TelaCadastroCliente();
					cadastroCliente.setVisible(true);
					desktopPane.add(cadastroCliente);
					try {
						cadastroCliente.setPosicao();
						cadastroCliente.setSelected(true);
					} catch (PropertyVetoException e) {
						e.printStackTrace();
					}
				}
			});
			mnitemEmpresas = new JMenuItem("Empresas (Matriz e Filiais)");
			mnitemEmpresas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (TelaInicial.this.usuarioLogado.isAdmin()) {
						TelaCadastroEmpresa cadastroEmpresa = new TelaCadastroEmpresa();
						desktopPane.add(cadastroEmpresa);
						try {
							cadastroEmpresa.setPosicao();
							cadastroEmpresa.setSelected(true);
						} catch (PropertyVetoException e) {
							e.printStackTrace();
						}
					}else {
						JOptionPane.showMessageDialog(null, "Usuário sem Permissão", "Aviso de Permissão", JOptionPane.WARNING_MESSAGE);
					}
					
				}
			});
			mnitemVeiculos = new JMenuItem("Ve\u00EDculos");
			mnitemVeiculos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					TelaCadastroVeiculo cadastroVeiculo = new TelaCadastroVeiculo();
					cadastroVeiculo.setVisible(true);
					desktopPane.add(cadastroVeiculo);
					try {
						cadastroVeiculo.setSelected(true);
					} catch (PropertyVetoException e) {
						e.printStackTrace();
					}
				}
			});

			menuCadastros.add(mnitemClientes);
			menuCadastros.add(mnitemEmpresas);
			menuCadastros.add(mnitemVeiculos);
			mnitemUsuarios = new JMenuItem("Usu\u00E1rios");
			mnitemUsuarios.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (TelaInicial.this.usuarioLogado.isAdmin()) {
						TelaCadastroUsuario cadastroUsuario = new TelaCadastroUsuario();
						cadastroUsuario.setVisible(true);
						desktopPane.add(cadastroUsuario);
						try {
							cadastroUsuario.setPosicao();
							cadastroUsuario.setSelected(true);
						} catch (PropertyVetoException e) {
							e.printStackTrace();
						}
					}else {
						JOptionPane.showMessageDialog(null, "Usuário sem Permissão","Aviso de Permissão", JOptionPane.WARNING_MESSAGE);
					}
				}
			});
			menuCadastros.add(mnitemUsuarios);
		
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
		
			mnitemAjuda = new JMenuItem("Ajuda");
			menuSobre.add(mnitemAjuda);
		
			mnitemSobreOSistema = new JMenuItem("Sobre o Sistema");
			mnitemSobreOSistema.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Narvi 1.0 \nUniversidade Federal Rural de Pernambuco - UFRPE\nUnidade Acadêmica de Serra Talhada - UAST"+
							"\nProjeto Prático da Cadeira: Projeto de Banco de Dados 2016.1\nProfessor: Hidelberg Oliveira Albuquerque \nDesenvolvido por: Alan Limeira, Dhonatan Diego, Thiago Lucas");
				}
			});
		menuSobre.add(mnitemSobreOSistema);
		
		panelInformacoes = new JPanel();
		panelInformacoes.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelInformacoes.setBounds(0, 662, 1370, 23);
		contentPane.add(panelInformacoes);
		panelInformacoes.setLayout(null);
		
		this.usuarioLogado = usuarioLogado;
		format = new SimpleDateFormat("dd/MM/YYYY");
		labelInformacoes = new JLabel("Usu\u00E1rio: "+usuarioLogado.getLogin().toUpperCase()+"    Empresa: LOCADORA DE CARROS LTDA    Data: "+format.format(new Date()));
		labelInformacoes.setBounds(3, 4, 558, 14);
		panelInformacoes.add(labelInformacoes);
		
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
