package br.com.Locadora.view;


import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import java.awt.BorderLayout;
import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

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

	public static final String ERROR_ICON = "imagens/error.png";
	public static final String SUCCESS_ICON = "imagens/check.png";
	public static final String WARNING_ICON = "imagens/warning.png";
	public static final String NOT_FOUND_ICON = "imagens/not.png";
	public static final String INTERROGATION_ICON = "imagens/interrogation.png";

	private JPanel panelButtons;
	private JButton buttonOK;
	private JButton btnNewButton;
	private JPanel panelMenssage;
	private JLabel labelTitleMessage;
	private JTextArea textAreaMessage;
	private JLabel lebelIcon;
	private JScrollPane scrollPaneTextMessage;


	public Warnings() {
		setModal(true);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 460, 210);
		getContentPane().setLayout(null);

		panelButtons = new JPanel();
		panelButtons.setBounds(0, 140, 444, 32);
		getContentPane().add(panelButtons);

		buttonOK = new JButton("OK");
		panelButtons.add(buttonOK);

		btnNewButton = new JButton("Fechar");
		panelButtons.add(btnNewButton);

		panelMenssage = new JPanel();
		panelMenssage.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelMenssage.setBounds(0, 0, 444, 140);
		getContentPane().add(panelMenssage);
		panelMenssage.setLayout(new BorderLayout(0, 0));

		labelTitleMessage = new JLabel("Erroo  05106056");
		panelMenssage.add(labelTitleMessage, BorderLayout.NORTH);

		lebelIcon = new JLabel();
		lebelIcon.setIcon(new ImageIcon("D:\\Projeto PBD\\check-mark.png"));
		panelMenssage.add(lebelIcon, BorderLayout.WEST);

		scrollPaneTextMessage = new JScrollPane();
		panelMenssage.add(scrollPaneTextMessage, BorderLayout.CENTER);

		textAreaMessage = new JTextArea();
		textAreaMessage.setLineWrap(true);
		scrollPaneTextMessage.setViewportView(textAreaMessage);
		textAreaMessage.setBackground(panelButtons.getBackground());
		textAreaMessage.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textAreaMessage.setEditable(false);

	}

	public static void showMessageDialog(int type, StackTraceElement []stackTraceElement){

		switch (type) {
		case ERROR_CONNECT_DB:{} break;
		case LOGIN_INVALID:{} break;
		case FIELDS_EMPTY:{} break;
		case CPF_INVALLID:{} break;
		case CNPJ_INVALLID:{} break;
		case CLIENT_NOT_FOUND:{} break;
		case CATEGORY_NOT_FOUND:{} break;
		case USER_NOT_FOUND:{} break;
		case COMPANY_NOT_FOUND:{} break;
		case CLIENT_SUCCESS:{} break;
		case CATEGORY_SUCCESS:{} break;
		case VEHICLE_SUCCESS:{} break;
		case USER_SUCCESS:{} break;
		case COMPANY_SUCCESS:{} break;
		}
		//Arrays.toString(stackTraceElement);
	}

	public static void showMessageDialog(String title, String message, String icon){

	}

	public static boolean showConfirmDialog(int type){
		return true;

	}

	public static boolean showConfirmDialog(String title, String message, String icon){
		return true;

	}

}
