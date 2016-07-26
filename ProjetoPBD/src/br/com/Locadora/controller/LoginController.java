package br.com.Locadora.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import br.com.Locadora.model.Usuario;
import br.com.Locadora.view.DialogConectaBanco;
import br.com.Locadora.view.TelaInicial;
import br.com.Locadora.view.TelaLogin;

public class LoginController implements ActionListener{

	private TelaLogin telalogin;
	private EntityManager managedEntity;
	private DialogConectaBanco conectaBanco;
	
	public LoginController(TelaLogin telalogin){
		try {
			this.telalogin = telalogin;
			conectaBanco = new DialogConectaBanco();
			managedEntity = HibernateSingleton.getInstance(HibernateSingleton.HIBERNATE_MYSQL).createEntityManager();
			conectaBanco.dispose();
			conectaBanco = null;
			this.telalogin.setVisible(true);
		} catch (Exception e) {
			conectaBanco.setMessage(DialogConectaBanco.ERRO_CONNECTION);
			telalogin.showMensseger(TelaLogin.ERROR_CONNECT_DB);
			System.exit(0);
		}
	}

	public void controll(){
		telalogin.getButtonEntrar().addActionListener(this);
		telalogin.getFieldUser().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					if (validaFields()) {
						if (logar(new Usuario(telalogin.getFieldUser().getText(), new String(telalogin.getPasswordField().getPassword())))) {
							telalogin.dispose();
							new TelaInicial(new UsuarioController().consultaLogin(telalogin.getFieldUser().getText()).get(0)).setVisible(true);
							telalogin = null;
						}
					}else {
						telalogin.showMensseger(TelaLogin.FIELDS_EMPTY);
					}
				}
			}
		});
		telalogin.getPasswordField().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					if (validaFields()) {
						if (logar(new Usuario(telalogin.getFieldUser().getText(), new String(telalogin.getPasswordField().getPassword())))) {
							telalogin.dispose();
							new TelaInicial(new UsuarioController().consultaLogin(telalogin.getFieldUser().getText()).get(0)).setVisible(true);
							telalogin = null;
						}else {
							telalogin.showMensseger(TelaLogin.LOGIN_INVALID);
						}
					}else {
						telalogin.showMensseger(TelaLogin.FIELDS_EMPTY);
					}
				}
			}
		});
	}

	@SuppressWarnings("deprecation")
	public boolean validaFields(){
		if (!telalogin.getFieldUser().getText().isEmpty()&&!telalogin.getPasswordField().getText().isEmpty()) {
			return true;
		}else {
			return false;
		}
	}

	public Boolean logar(Usuario usuario){
		
		managedEntity.getTransaction().begin();
		StoredProcedureQuery storedProcedure = managedEntity.createStoredProcedureQuery("VALIDAR_USUARIO");
		storedProcedure.registerStoredProcedureParameter("P_LOGIN", String.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("P_SENHA", String.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("P_VALIDO", Integer.class, ParameterMode.OUT);
		
		storedProcedure.setParameter("P_LOGIN", usuario.getLogin());
		storedProcedure.setParameter("P_SENHA", usuario.getSenha());
		
		storedProcedure.execute();
		
		managedEntity.getTransaction().commit();

		if(storedProcedure.getOutputParameterValue("P_VALIDO").toString().equals("1")){ 
			closeManaged();
			return true;
		}else {
			closeManaged();
			return false;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (validaFields()) {
			if (logar(new Usuario(telalogin.getFieldUser().getText(), new String(telalogin.getPasswordField().getPassword())))) {
				telalogin.dispose();
				new TelaInicial(new UsuarioController().consultaLogin(telalogin.getFieldUser().getText()).get(0)).setVisible(true);
				telalogin = null;
			}
		}else {
			telalogin.showMensseger(TelaLogin.FIELDS_EMPTY);
		}
	}

	public void closeManaged(){
		managedEntity.close();
	}

}
