package br.com.Locadora.view;

import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JInternalFrame;
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

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;

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
	private JMenuItem mnitemRClientes;
	private JMenuItem mnitemRClientesPessoaFsica;
	private JMenuItem mnitemRClientesPessoaJurdica;
	private JMenuItem mnitemREmpresas;
	private JMenuItem mnitemRUsuarios;
	private JMenuItem mnitemRVeiculos;
	private JLabel labelBackground;
	private JLabel labelInformacoes;
	private DateFormat format;
	
	private Usuario usuarioLogado;
	
	private TelaConfiguracoes telaConfiguracoes;
	private TelaCadastroCliente cadastroCliente;
	private TelaCadastroEmpresa cadastroEmpresa;
	private TelaCadastroVeiculo cadastroVeiculo;
	private TelaCadastroUsuario cadastroUsuario;
	private TelaCadastroCategoria cadastroCategoria;
	private TelaReserva telaReserva;
	private TelaLocacao telaLocacao;
	private TelaManutencaoPreco manutencaoPreco;
	
	private GerarRelatorio gerarRelatorio;
	private JMenuItem mnitemCategorias;
	private JMenuItem mnitemManutencaoDeLocacao;
	private JMenuItem mnitemManutenoDePrecos;
	private JMenuItem mnitemManutencaoDeReservas;
	
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
						if (isCreate(telaConfiguracoes)||telaConfiguracoes.isClosed()) {
							telaConfiguracoes = null;
							telaConfiguracoes = new TelaConfiguracoes();
							desktopPane.add(telaConfiguracoes);
							try {
								telaConfiguracoes.setPosicao();
								telaConfiguracoes.setSelected(true);
							} catch (PropertyVetoException e2) {
								e2.printStackTrace();
							}
						}
						telaConfiguracoes.moveToFront();
						
					}else {
						JOptionPane.showMessageDialog(null, "Usuário sem Permissão", "Aviso de Permissão", JOptionPane.WARNING_MESSAGE);
					}
				}
			});
			mnitemSair = new JMenuItem("Sair");
			mnitemSair.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (JOptionPane.showConfirmDialog(null, "Deseja Realmente Sair ?", "Sair do Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==0){
						HibernateSingleton.closeFactory();
						System.exit(0);
					}
				}
			});
		
			menuArquivo.add(mnitemConfiguracoes);
			menuArquivo.add(mnitemSair);
		
		menuCadastros = new JMenu("Cadastros");
		menuBar.add(menuCadastros);
		
			mnitemClientes = new JMenuItem("Clientes");
			mnitemClientes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (isCreate(cadastroCliente)||cadastroCliente.isClosed()) {
						cadastroCliente = null;
						cadastroCliente = new TelaCadastroCliente();
						cadastroCliente.setVisible(true);
						desktopPane.add(cadastroCliente);
						try {
							cadastroCliente.setPosicao();
							cadastroCliente.setSelected(true);
						} catch (PropertyVetoException e) {
							e.printStackTrace();
						}	
					}
					cadastroCliente.moveToFront();
				}
			});
			mnitemEmpresas = new JMenuItem("Empresas (Matriz e Filiais)");
			mnitemEmpresas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (TelaInicial.this.usuarioLogado.isAdmin()) {
						if(isCreate(cadastroEmpresa)||cadastroEmpresa.isClosed()){
							cadastroEmpresa = null;
							cadastroEmpresa = new TelaCadastroEmpresa();
							desktopPane.add(cadastroEmpresa);
							try {
								cadastroEmpresa.setPosicao();
								cadastroEmpresa.setSelected(true);
							} catch (PropertyVetoException e) {
								e.printStackTrace();
							}
						}
						cadastroEmpresa.moveToFront();
						
					}else {
						JOptionPane.showMessageDialog(null, "Usuário sem Permissão", "Aviso de Permissão", JOptionPane.WARNING_MESSAGE);
					}
					
				}
			});
			mnitemVeiculos = new JMenuItem("Ve\u00EDculos");
			mnitemVeiculos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (isCreate(cadastroVeiculo)||cadastroVeiculo.isClosed()) {
						cadastroVeiculo = null;
						cadastroVeiculo = new TelaCadastroVeiculo();
						cadastroVeiculo.setVisible(true);
						desktopPane.add(cadastroVeiculo);
						try {
							cadastroVeiculo.setPosicao();
							cadastroVeiculo.setSelected(true);
						} catch (PropertyVetoException e) {
							e.printStackTrace();
						}
					}
					cadastroVeiculo.moveToFront();
				}
			});
			
			mnitemCategorias = new JMenuItem("Categorias");
			mnitemCategorias.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(isCreate(cadastroCategoria)||cadastroCategoria.isClosed()){
						cadastroCategoria = null;
						cadastroCategoria = new TelaCadastroCategoria();
						cadastroCategoria.setVisible(true);
						desktopPane.add(cadastroCategoria);
						try {
							cadastroCategoria.setPosicao();
							cadastroCategoria.setSelected(true);
						} catch (Exception e2) {
							e2.printStackTrace();
						}
					}
					cadastroCategoria.moveToFront();	
				}
			});
			menuCadastros.add(mnitemCategorias);

			menuCadastros.add(mnitemClientes);
			menuCadastros.add(mnitemEmpresas);
			mnitemUsuarios = new JMenuItem("Usu\u00E1rios");
			mnitemUsuarios.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (TelaInicial.this.usuarioLogado.isAdmin()) {
						if (isCreate(cadastroUsuario)||cadastroUsuario.isClosed()) {
							cadastroUsuario = null;
							cadastroUsuario = new TelaCadastroUsuario();
							cadastroUsuario.setVisible(true);
							desktopPane.add(cadastroUsuario);
							try {
								cadastroUsuario.setPosicao();
								cadastroUsuario.setSelected(true);
							} catch (PropertyVetoException e) {
								e.printStackTrace();
							}
						}
						cadastroUsuario.moveToFront();
						
					}else {
						JOptionPane.showMessageDialog(null, "Usuário sem Permissão","Aviso de Permissão", JOptionPane.WARNING_MESSAGE);
					}
				}
			});
			menuCadastros.add(mnitemUsuarios);
			menuCadastros.add(mnitemVeiculos);
		
		menuReservas = new JMenu("Reservas");
		menuBar.add(menuReservas);
		
		mnitemManutencaoDeReservas = new JMenuItem("Manuten\u00E7\u00E3o de Reservas");
		mnitemManutencaoDeReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isCreate(telaReserva)||telaReserva.isClosed()){
					telaReserva = null;
					telaReserva =  new TelaReserva();
					telaReserva.setVisible(true);
					desktopPane.add(telaReserva);
					try {
						telaReserva.setPosicao();
						telaReserva.setSelected(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
				telaReserva.moveToFront();
			}
		});
		menuReservas.add(mnitemManutencaoDeReservas);
		
		menuLocao = new JMenu("Loca\u00E7\u00E3o");
		menuBar.add(menuLocao);
		
		mnitemManutencaoDeLocacao = new JMenuItem("Manuten\u00E7\u00E3o de Loca\u00E7\u00E3o");
		mnitemManutencaoDeLocacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isCreate(telaLocacao)||telaLocacao.isClosed()){
					telaLocacao = null;
					telaLocacao =  new TelaLocacao();
					telaLocacao.setVisible(true);
					desktopPane.add(telaLocacao);
					try {
						telaLocacao.setPosicao();
						telaLocacao.setSelected(true);
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				telaLocacao.moveToFront();
			}
		});
		menuLocao.add(mnitemManutencaoDeLocacao);
		
		mnitemManutenoDePrecos = new JMenuItem("Manuten\u00E7\u00E3o de Pre\u00E7os");
		mnitemManutenoDePrecos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isCreate(manutencaoPreco)||manutencaoPreco.isClosed()){
					manutencaoPreco = null;
					manutencaoPreco =  new TelaManutencaoPreco();
					manutencaoPreco.setVisible(true);
					desktopPane.add(manutencaoPreco);
					try {
						manutencaoPreco.setPosicao();
						manutencaoPreco.setSelected(true);
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				manutencaoPreco.moveToFront();
			}
		});
		menuLocao.add(mnitemManutenoDePrecos);
// INICIO SUBMENU RELATÓRIOS		
		menuRelatorios = new JMenu("Relat\u00F3rios");
		menuBar.add(menuRelatorios);
			
			menuRCadastro = new JMenu("Cadastro");
			
				mnitemRClientes = new JMenuItem("Clientes");
				mnitemRClientes.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							if(gerarRelatorio != null)
								gerarRelatorio = null;
							
							gerarRelatorio = new GerarRelatorio(JasperFillManager.fillReport("relatorios/Clientes.jasper", null,HibernateSingleton.Connection()), false);
						} catch (JRException e) {
							gerarRelatorio = null;
							e.printStackTrace();
							JOptionPane.showMessageDialog(null, "Erro ao Gerar Relatório","Erro Relatório",JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				menuRCadastro.add(mnitemRClientes);
			
				mnitemRClientesPessoaFsica = new JMenuItem("Clientes Pessoa F\u00EDsica");
				mnitemRClientesPessoaFsica.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							if(gerarRelatorio != null)
								gerarRelatorio = null;
							
							new GerarRelatorio(JasperFillManager.fillReport("relatorios/ClientesPF.jasper", null,HibernateSingleton.Connection()), false);
						} catch (JRException e) {
							gerarRelatorio = null;
							e.printStackTrace();
							JOptionPane.showMessageDialog(null, "Erro ao Gerar Relatório","Erro Relatório",JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				menuRCadastro.add(mnitemRClientesPessoaFsica);
			
				mnitemRClientesPessoaJurdica = new JMenuItem("Clientes Pessoa Jur\u00EDdica");
				mnitemRClientesPessoaJurdica.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							if(gerarRelatorio != null)
								gerarRelatorio = null;
							
							new GerarRelatorio(JasperFillManager.fillReport("relatorios/ClientesPJ.jasper", null,HibernateSingleton.Connection()), false);
						} catch (JRException e) {
							gerarRelatorio = null;
							e.printStackTrace();
							JOptionPane.showMessageDialog(null, "Erro ao Gerar Relatório","Erro Relatório",JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				menuRCadastro.add(mnitemRClientesPessoaJurdica);
			
				mnitemREmpresas = new JMenuItem("Empresas");
				mnitemREmpresas.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							if(gerarRelatorio != null)
								gerarRelatorio = null;
							
							new GerarRelatorio(JasperFillManager.fillReport("relatorios/Empresas.jasper", null,HibernateSingleton.Connection()), false);
						} catch (JRException e) {
							gerarRelatorio = null;
							e.printStackTrace();
							JOptionPane.showMessageDialog(null, "Erro ao Gerar Relatório","Erro Relatório",JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				menuRCadastro.add(mnitemREmpresas);
			
				mnitemRUsuarios = new JMenuItem("Usu\u00E1rios");
				mnitemRUsuarios.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							if(gerarRelatorio != null)
								gerarRelatorio = null;
							
							new GerarRelatorio(JasperFillManager.fillReport("relatorios/Usuarios.jasper", null,HibernateSingleton.Connection()), false);
						} catch (JRException e) {
							gerarRelatorio = null;
							e.printStackTrace();
							JOptionPane.showMessageDialog(null, "Erro ao Gerar Relatório","Erro Relatório",JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				menuRCadastro.add(mnitemRUsuarios);
			
				mnitemRVeiculos = new JMenuItem("Ve\u00EDculos");
				mnitemRVeiculos.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							if(gerarRelatorio != null)
								gerarRelatorio = null;
							
							new GerarRelatorio(JasperFillManager.fillReport("relatorios/Veiculos.jasper", null,HibernateSingleton.Connection()), false);
						} catch (JRException e) {
							gerarRelatorio = null;
							e.printStackTrace();
							JOptionPane.showMessageDialog(null, "Erro ao Gerar Relatório","Erro Relatório",JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				menuRCadastro.add(mnitemRVeiculos);
//	FIM SUBMENU RELATÓRIOS			
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
		labelInformacoes = new JLabel("Usu\u00E1rio: "+usuarioLogado.getLogin().toUpperCase()+"    Empresa: "+usuarioLogado.getEmpresa().getNome().toUpperCase()+"    Data: "+format.format(new Date()));
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
	
	public boolean isCreate(JInternalFrame object){
		if(object == null)
			return true;
		else
			return false;
	}
}
