package br.com.Locadora.view;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;

public class DialogConectaBanco extends JDialog {

	private static final long serialVersionUID = 1706472331625657196L;
	public static final String CONNECTING = "Conectando ao Banco de Dados";
	public static final String ERRO_CONNECTION = "Erro ao conectar Banco de Dados";
	private JLabel labelMessage;
	private JLabel labelImage;
	private JProgressBar progressBar;

	public DialogConectaBanco() {
		setResizable(false);
		setUndecorated(true);
		setType(Type.POPUP);
		setSize(450,300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		labelMessage = new JLabel(CONNECTING);
		labelMessage.setHorizontalAlignment(SwingConstants.CENTER);
		labelMessage.setFont(new Font("SansSerif", Font.BOLD, 15));
		labelMessage.setBounds(0, 220, 450, 20);
		getContentPane().add(labelMessage);

		labelImage = new JLabel("");
		labelImage.setIcon(new ImageIcon("imagens/databaseIcon.png"));
		labelImage.setBounds(125, 9, 200, 199);
		getContentPane().add(labelImage);

		progressBar = new JProgressBar();
		progressBar.setIndeterminate(true);
		progressBar.setBounds(0, 252, 450, 22);
		getContentPane().add(progressBar);
		
		setVisible(true);

	}

	public void setMessage(String message) {
		this.labelMessage.setText(message);
	}

}
