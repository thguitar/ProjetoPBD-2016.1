package br.com.Locadora.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.com.Locadora.model.Login;
import br.com.Locadora.view.TelaInicial;
import br.com.Locadora.view.telaLogin;

public class LoginController implements ActionListener{

	//private Login login;
	private telaLogin telalogin;

	public LoginController(telaLogin telalogin){
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
			JOptionPane.showMessageDialog(null,"Campos Obrigatórios",null,JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
	}

	public Boolean logar(Login login){
		if (login.getUsuario().equals("THIAGO")&&login.getSenha().equals("123")) {
			return true;
		}else {
			JOptionPane.showMessageDialog(null, "Login Inválido",null ,JOptionPane.WARNING_MESSAGE);
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
