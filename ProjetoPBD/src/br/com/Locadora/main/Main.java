package br.com.Locadora.main;


import br.com.Locadora.controller.LoginController;
import br.com.Locadora.view.TelaLogin;

public class Main {

	public static void main(String[] args) {
		TelaLogin telaLogin = new TelaLogin();
		LoginController controller = new LoginController(telaLogin);
		controller.controll();
	}	

}
