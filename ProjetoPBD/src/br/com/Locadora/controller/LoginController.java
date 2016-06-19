package br.com.Locadora.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import br.com.Locadora.model.Usuario;
import br.com.Locadora.view.TelaInicial;
import br.com.Locadora.view.TelaLogin;

public class LoginController implements ActionListener{

	//private Login login;
	private TelaLogin telalogin;
	private EntityManager managedEntity;

	public LoginController(TelaLogin telalogin){
		managedEntity = HibernateSingleton.getInstance("HibMysql").createEntityManager();
		this.telalogin = telalogin;
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
							telalogin = null;
							new TelaInicial().setVisible(true);
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
							telalogin = null;
							new TelaInicial().setVisible(true);
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
		managedEntity.getTransaction().begin();
		Query query = managedEntity.createQuery("select u from Usuario u where u.login = :param");
		query.setParameter("param", usuario.getLogin());
		List<Usuario> list = query.getResultList(); 
		managedEntity.getTransaction().commit();
		
		if (usuario.getLogin().equalsIgnoreCase(list.get(0).getLogin())&&usuario.getSenha().equals(list.get(0).getSenha())) {
			closeManaged();
			return true;
		}else {
			JOptionPane.showMessageDialog(null, "Login Inv\u00E1lido",null ,JOptionPane.WARNING_MESSAGE);
			return false;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (validaFields()) {
			if (logar(new Usuario(telalogin.getFieldUser().getText(), new String(telalogin.getPasswordField().getPassword())))) {
				telalogin.dispose();
				telalogin = null;
				new TelaInicial().setVisible(true);
			}
		}
	}
	
	public void closeManaged(){
		managedEntity.close();
	}

}
