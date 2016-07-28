package br.com.Locadora.view;


import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Warnings extends JDialog {

	private static final long serialVersionUID = 7130184973457235574L;
	public static final int ERROR_CONNECT_DB = 1;
	public static final int LOGIN_INVALID = 2;
	public static final int FIELDS_EMPTY = 3;
	public static final int CPF_INVALLID = 4;
	public static final int CNPJ_INVALLID = 5;
	public static final int CLIENT_NOT_FOUND = 6;
	public static final int CATEGORY_NOT_FOUND = 7;
	public static final int VEHICLE_NOT_FOUND = 8;
	public static final int USER_NOT_FOUND = 9;
	public static final int COMPANY_NOT_FOUND = 10;
	public static final int CLIENT_SUCCESS = 11;
	public static final int CATEGORY_SUCCESS = 12;
	public static final int VEHICLE_SUCCESS = 13;
	public static final int USER_SUCCESS = 14;
	public static final int COMPANY_SUCCESS = 15;
	public static final int CLIENT_INSERT_ERROR = 16;
	public static final int CATEGORY_INSERT_ERROR = 17;
	public static final int VEHICLE_INSERT_ERROR = 18;
	public static final int USER_INSERT_ERROR = 19;
	public static final int COMPANY_INSERT_ERROR = 20;
	public static final int CLIENT_DELETE_ERROR = 21;
	public static final int CATEGORY_DELETE_ERROR = 22;
	public static final int VEHICLE_DELETE_ERROR = 23;
	public static final int USER_DELETE_ERROR = 24;
	public static final int COMPANY_DELETE_ERROR = 25;
	public static final int CLIENT_UPDATE_ERROR = 26;
	public static final int CATEGORY_UPDATE_ERROR = 27;
	public static final int VEHICLE_UPDATE_ERROR = 28;
	public static final int USER_UPDATE_ERROR = 29;
	public static final int COMPANY_UPDATE_ERROR = 30;
	public static final int EXIT = 31;

	public static final ImageIcon ERROR_ICON = new ImageIcon("imagens/error.png");
	public static final ImageIcon SUCCESS_ICON = new ImageIcon("imagens/check.png");
	public static final ImageIcon WARNING_ICON = new ImageIcon("imagens/warning.png");
	public static final ImageIcon NOT_FOUND_ICON = new ImageIcon("imagens/not.png");
	public static final ImageIcon INTERROGATION_ICON = new ImageIcon("imagens/interrogation.png");

	private JPanel panelButtons;
	private JButton buttonOK;
	private JButton buttonClose;
	private JPanel panelMenssage;
	private JLabel labelTitleMessage;
	private JLabel labelIcon;
	private JScrollPane scrollPaneTextMessage;
	private JTextArea textAreaMessage;
	private static Warnings error = new Warnings();
	private static Warnings warnings2 = new Warnings(null);
	private JButton buttonNao;

	public Warnings() {
		setResizable(false);
		setModal(true);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 460, 210);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		panelButtons = new JPanel();
		panelButtons.setBounds(0, 146, 454, 36);
		getContentPane().add(panelButtons);

		buttonOK = new JButton("OK");
		buttonOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		panelButtons.add(buttonOK);

		buttonClose = new JButton("Fechar");
		buttonClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelButtons.add(buttonClose);

		panelMenssage = new JPanel();
		panelMenssage.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelMenssage.setBounds(0, 0, 454, 148);
		getContentPane().add(panelMenssage);
		panelMenssage.setLayout(new BorderLayout(0, 0));

		labelTitleMessage = new JLabel("");
		panelMenssage.add(labelTitleMessage, BorderLayout.NORTH);

		labelIcon = new JLabel();
		labelIcon.setIcon(new ImageIcon("D:\\Projeto PBD\\check-mark.png"));
		panelMenssage.add(labelIcon, BorderLayout.WEST);

		scrollPaneTextMessage = new JScrollPane();
		panelMenssage.add(scrollPaneTextMessage, BorderLayout.CENTER);

		textAreaMessage = new JTextArea();
		textAreaMessage.setLineWrap(true);
		scrollPaneTextMessage.setViewportView(textAreaMessage);
		textAreaMessage.setBackground(panelButtons.getBackground());
		textAreaMessage.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textAreaMessage.setEditable(false);

	}

	public Warnings(String title) {
		setModal(true);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 320, 150);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		panelMenssage = new JPanel();
		panelMenssage.setBounds(0, 0, 304, 112);
		getContentPane().add(panelMenssage);
		panelMenssage.setLayout(null);

		labelTitleMessage = new JLabel("Erroo  05106056");
		labelTitleMessage.setBounds(92, 44, 191, 16);
		panelMenssage.add(labelTitleMessage);

		labelIcon = new JLabel();
		labelIcon.setBounds(0, 12, 80, 80);
		labelIcon.setIcon(new ImageIcon("D:\\Projeto PBD\\check-mark.png"));
		panelMenssage.add(labelIcon);

		panelButtons = new JPanel();
		panelButtons.setBounds(92, 72, 148, 36);
		panelMenssage.add(panelButtons);

		buttonOK = new JButton("OK");
		panelButtons.add(buttonOK);

		buttonNao = new JButton("N\u00E3o");
		buttonNao.setVisible(false);
		panelButtons.add(buttonNao);
		buttonOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});

	}

	public JButton getButtonOK() {
		return buttonOK;
	}


	public JButton getButtonClose() {
		return buttonClose;
	}


	public void setMessage(String message) {
		this.labelTitleMessage.setText(message);
	}


	public void setTextAreaMessage(String textAreaMessage) {
		this.textAreaMessage.setText(textAreaMessage);
	}


	public void setLabelIcon(ImageIcon icon) {
		this.labelIcon.setIcon(icon);
	}


	public static void showMessageDialog(int type, String message){
		switch (type) {
		case ERROR_CONNECT_DB:{
			error.setMessage("Erro ao Conectar Banco de Dados");
			error.setTextAreaMessage("Erro ao Connectar o Banco de Dados.\nO Sistema será Finalizado\n"+message);
			error.setTitle("Erro de Conexão");
			error.setLabelIcon(Warnings.ERROR_ICON);
			error.getButtonClose().setVisible(false);
			error.setVisible(true);
		} break;
		case LOGIN_INVALID:{
			warnings2.setMessage("Login Inv\u00E1lido");
			warnings2.setTitle("Login");
			warnings2.setLabelIcon(Warnings.WARNING_ICON);
			warnings2.setVisible(true);
		} break;
		case FIELDS_EMPTY:{
			warnings2.setMessage("Campos Obrigat\u00F3rios");
			warnings2.setTitle("Atenção");
			warnings2.setLabelIcon(Warnings.WARNING_ICON);
			warnings2.setVisible(true);
		} break;
		case CPF_INVALLID:{
			warnings2.setMessage("CPF Inválido");
			warnings2.setTitle("Aviso de Inconsistência");
			warnings2.setLabelIcon(Warnings.WARNING_ICON);
			warnings2.setVisible(true);
		} break;
		case CNPJ_INVALLID:{
			warnings2.setMessage("CNPJ Inválido");
			warnings2.setTitle("Aviso de Inconsistência");
			warnings2.setLabelIcon(Warnings.WARNING_ICON);
			warnings2.setVisible(true);
		} break;
		case CLIENT_NOT_FOUND:{
			warnings2.setMessage("Nenhum Cliente Encontrado");
			warnings2.setTitle("Retorno Busca");
			warnings2.setLabelIcon(Warnings.NOT_FOUND_ICON);
			warnings2.setVisible(true);
		} break;
		case CATEGORY_NOT_FOUND:{
			warnings2.setMessage("Nenhuma Categoria Encontrada");
			warnings2.setTitle("Retorno Busca");
			warnings2.setLabelIcon(Warnings.NOT_FOUND_ICON);
			warnings2.setVisible(true);
		} break;
		case USER_NOT_FOUND:{
			warnings2.setMessage("Nenhum Usuário Encontrado");
			warnings2.setTitle("Retorno Busca");
			warnings2.setLabelIcon(Warnings.NOT_FOUND_ICON);
			warnings2.setVisible(true);
		} break;
		case COMPANY_NOT_FOUND:{
			warnings2.setMessage("Nenhuma Empresa Encontrada");
			warnings2.setTitle("Retorno Busca");
			warnings2.setLabelIcon(Warnings.NOT_FOUND_ICON);
			warnings2.setVisible(true);
		} break;
		case VEHICLE_NOT_FOUND:{
			warnings2.setMessage("Nenhum Veículo Encontrado");
			warnings2.setTitle("Retorno Busca");
			warnings2.setLabelIcon(Warnings.NOT_FOUND_ICON);
			warnings2.setVisible(true);
		} break;
		case CLIENT_SUCCESS:{
			warnings2.setMessage("Cliente Cadastrado com Sucesso");
			warnings2.setTitle("Mensagem Cadastro");
			warnings2.setLabelIcon(Warnings.SUCCESS_ICON);
			warnings2.setVisible(true);
		} break;
		case CATEGORY_SUCCESS:{
			warnings2.setMessage("Categoria Cadastrada com Sucesso");
			warnings2.setTitle("Mensagem Cadastro");
			warnings2.setLabelIcon(Warnings.SUCCESS_ICON);
			warnings2.setVisible(true);
		} break;
		case VEHICLE_SUCCESS:{
			warnings2.setMessage("Veículo Cadastrado com Sucesso");
			warnings2.setTitle("Mensagem Cadastro");
			warnings2.setLabelIcon(Warnings.SUCCESS_ICON);
			warnings2.setVisible(true);
		} break;
		case USER_SUCCESS:{
			warnings2.setMessage("Usuário Cadastrado com Sucesso");
			warnings2.setTitle("Mensagem Cadastro");
			warnings2.setLabelIcon(Warnings.SUCCESS_ICON);
			warnings2.setVisible(true);
		} break;
		case COMPANY_SUCCESS:{
			warnings2.setMessage("Empresa Cadastrada com Sucesso");
			warnings2.setTitle("Mensagem Cadastro");
			warnings2.setLabelIcon(Warnings.SUCCESS_ICON);
			warnings2.setVisible(true);
		} break;
		case CLIENT_INSERT_ERROR:{
			error.setMessage("Erro ao Gravar Cliente");
			error.setTextAreaMessage("Erro ao Gravar Cliente no Banco de Dados.\n"+message);
			error.setTitle("Erro Gravação");
			error.setLabelIcon(Warnings.ERROR_ICON);
			error.getButtonClose().setVisible(false);
			error.setVisible(true);
		}break;
		case CATEGORY_INSERT_ERROR:{
			error.setMessage("Erro ao Gravar Categoria");
			error.setTextAreaMessage("Erro ao Gravar Categoria no Banco de Dados.\n"+message);
			error.setTitle("Erro Gravação");
			error.setLabelIcon(Warnings.ERROR_ICON);
			error.getButtonClose().setVisible(false);
			error.setVisible(true);
		}break;
		case VEHICLE_INSERT_ERROR:{
			error.setMessage("Erro ao Gravar Veículo");
			error.setTextAreaMessage("Erro ao Gravar Veículo no Banco de Dados.\n"+message);
			error.setTitle("Erro Gravação");
			error.setLabelIcon(Warnings.ERROR_ICON);
			error.getButtonClose().setVisible(false);
			error.setVisible(true);
		}break;
		case USER_INSERT_ERROR:{
			error.setMessage("Erro ao Gravar Usuário");
			error.setTextAreaMessage("Erro ao Gravar Usuário no Banco de Dados.\n"+message);
			error.setTitle("Erro Gravação");
			error.setLabelIcon(Warnings.ERROR_ICON);
			error.getButtonClose().setVisible(false);
			error.setVisible(true);
		}break;
		case COMPANY_INSERT_ERROR:{
			error.setMessage("Erro ao Gravar Empresa");
			error.setTextAreaMessage("Erro ao Gravar Empresa no Banco de Dados.\n"+message);
			error.setTitle("Erro Gravação");
			error.setLabelIcon(Warnings.ERROR_ICON);
			error.getButtonClose().setVisible(false);
			error.setVisible(true);
		}break;
		case CLIENT_DELETE_ERROR:{
			error.setMessage("Erro ao Deletar Cliente");
			error.setTextAreaMessage("Erro ao Deletar Cliente.\n"+message);
			error.setTitle("Erro Delete");
			error.setLabelIcon(Warnings.ERROR_ICON);
			error.getButtonClose().setVisible(false);
			error.setVisible(true);
		}break;
		case CATEGORY_DELETE_ERROR:{
			error.setMessage("Erro ao Deletar Categoria");
			error.setTextAreaMessage("Erro ao Deletar Categoria.\n"+message);
			error.setTitle("Erro Delete");
			error.setLabelIcon(Warnings.ERROR_ICON);
			error.getButtonClose().setVisible(false);
			error.setVisible(true);
		}break;
		case VEHICLE_DELETE_ERROR:{
			error.setMessage("Erro ao Deletar Veículo");
			error.setTextAreaMessage("Erro ao Deletar Veículo.\n"+message);
			error.setTitle("Erro Delete");
			error.setLabelIcon(Warnings.ERROR_ICON);
			error.getButtonClose().setVisible(false);
			error.setVisible(true);
		}break;
		case USER_DELETE_ERROR:{
			error.setMessage("Erro ao Deletar Usuário");
			error.setTextAreaMessage("Erro ao Deletar Usuário.\n"+message);
			error.setTitle("Erro Delete");
			error.setLabelIcon(Warnings.ERROR_ICON);
			error.getButtonClose().setVisible(false);
			error.setVisible(true);
		}break;
		case COMPANY_DELETE_ERROR:{
			error.setMessage("Erro ao Deletar Empresa");
			error.setTextAreaMessage("Erro ao Deletar Empresa.\n"+message);
			error.setTitle("Erro Delete");
			error.setLabelIcon(Warnings.ERROR_ICON);
			error.getButtonClose().setVisible(false);
			error.setVisible(true);
		}break;
		case CLIENT_UPDATE_ERROR:{
			error.setMessage("Erro ao Alterar Cliente");
			error.setTextAreaMessage("Erro ao Alterar Cliente.\n"+message);
			error.setTitle("Erro Alteração");
			error.setLabelIcon(Warnings.ERROR_ICON);
			error.getButtonClose().setVisible(false);
			error.setVisible(true);
		}break;
		case CATEGORY_UPDATE_ERROR:{
			error.setMessage("Erro ao Alterar Categoria");
			error.setTextAreaMessage("Erro ao Alterar Categoria.\n"+message);
			error.setTitle("Erro Alteração");
			error.setLabelIcon(Warnings.ERROR_ICON);
			error.getButtonClose().setVisible(false);
			error.setVisible(true);
		}break;
		case VEHICLE_UPDATE_ERROR:{
			error.setMessage("Erro ao Alterar Veículo");
			error.setTextAreaMessage("Erro ao Alterar Veículo.\n"+message);
			error.setTitle("Erro Alteração");
			error.setLabelIcon(Warnings.ERROR_ICON);
			error.getButtonClose().setVisible(false);
			error.setVisible(true);
		}break;
		case USER_UPDATE_ERROR:{
			error.setMessage("Erro ao Alterar Usuário");
			error.setTextAreaMessage("Erro ao Alterar Usuário.\n"+message);
			error.setTitle("Erro Alteração");
			error.setLabelIcon(Warnings.ERROR_ICON);
			error.getButtonClose().setVisible(false);
			error.setVisible(true);
		}break;
		case COMPANY_UPDATE_ERROR:{
			error.setMessage("Erro ao Alterar Empresa");
			error.setTextAreaMessage("Erro ao Alterar Empresa.\n"+message);
			error.setTitle("Erro Alteração");
			error.setLabelIcon(Warnings.ERROR_ICON);
			error.getButtonClose().setVisible(false);
			error.setVisible(true);
		}break;

		}
	}

	public static void showMessageDialog(String title, String message, ImageIcon icon){

	}
}
