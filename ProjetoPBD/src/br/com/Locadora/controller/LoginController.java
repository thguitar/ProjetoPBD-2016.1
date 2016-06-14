package br.com.Locadora.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.com.Locadora.model.Login;
import br.com.Locadora.view.TelaInicial;
import br.com.Locadora.view.TelaLogin;

public class LoginController implements ActionListener{

	//private Login login;
	private TelaLogin telalogin;

	public LoginController(TelaLogin telalogin){
		this.telalogin = telalogin;
	}

	public void controll(){
		telalogin.getButtonEntrar().addActionListener(this);
	}

	@SuppressWarnings("deprecation")
	public boolean validaFields(){
		if (!telalogin.getFieldUser().getText().isEmpty()&&!telalogin.getPasswordField().getText().isEmpty()) {
			return true;
		}else {
			JOptionPane.showMessageDialog(null,"Campos Obrigat\u00F3rios",null,JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
	}

	public Boolean logar(Login login){
		if (login.getUsuario().equals("THIAGO")&&login.getSenha().equals("123")) {
			return true;
		}else {
			JOptionPane.showMessageDialog(null, "Login Inv\u00E1lido",null ,JOptionPane.WARNING_MESSAGE);
			return false;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (validaFields()) {
			if (logar(new Login(telalogin.getFieldUser().getText(), new String(telalogin.getPasswordField().getPassword())))) {
				new TelaInicial().setVisible(true);
			}
		}
	}

}
