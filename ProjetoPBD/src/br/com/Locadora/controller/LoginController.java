package br.com.Locadora.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.swing.JOptionPane;

import br.com.Locadora.model.Usuario;
import br.com.Locadora.view.TelaInicial;
import br.com.Locadora.view.TelaLogin;

public class LoginController implements ActionListener{

	private TelaLogin telalogin;
	private EntityManager managedEntity;

	public LoginController(TelaLogin telalogin){
		try {
			managedEntity = HibernateSingleton.getInstance(HibernateSingleton.HIBERNATE_MYSQL).createEntityManager();
			this.telalogin = telalogin;
			this.telalogin.setVisible(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao Connectar o Banco de Dados.\n        O Sistema será Finalizado\n","Erro de Conexão",JOptionPane.ERROR_MESSAGE);
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
							JOptionPane.showMessageDialog(null, "Login Inv\u00E1lido",null ,JOptionPane.WARNING_MESSAGE);
						}
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
			JOptionPane.showMessageDialog(null,"Campos Obrigat\u00F3rios",null,JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
	}

	public Boolean logar(Usuario usuario){
		
		managedEntity = HibernateSingleton.getInstance("HibMysql").createEntityManager();
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
		}
	}

	public void closeManaged(){
		managedEntity.close();
	}

}
