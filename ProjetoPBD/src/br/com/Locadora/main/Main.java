package br.com.Locadora.main;

import br.com.Locadora.controller.LoginController;
import br.com.Locadora.view.telaLogin;

public class Main {

	public static void main(String[] args) {
		telaLogin telaLogin = new telaLogin();
		LoginController controller = new LoginController(telaLogin);
		controller.controll();
	}	

}
