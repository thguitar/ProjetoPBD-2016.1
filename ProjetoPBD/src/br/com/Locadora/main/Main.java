package br.com.Locadora.main;


import br.com.Locadora.controller.LoginController;
import br.com.Locadora.view.TelaCadastroUsuario;
import br.com.Locadora.view.TelaConsultaUsuarios;
import br.com.Locadora.view.TelaLogin;

public class Main {

	public static void main(String[] args) {
		new TelaConsultaUsuarios().setVisible(true);
//		TelaLogin telaLogin = new TelaLogin();
//		LoginController controller = new LoginController(telaLogin);
//		controller.controll();
	}	

}
