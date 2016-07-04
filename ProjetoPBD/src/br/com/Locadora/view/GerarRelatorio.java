package br.com.Locadora.view;

import java.awt.Toolkit;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class GerarRelatorio extends JasperViewer{

	private static final long serialVersionUID = -402390280127348948L;
	
	public GerarRelatorio(JasperPrint jasperPrint, boolean isExitOnClose) {
		super(jasperPrint, isExitOnClose);
		setTitle("Visualização de Relatório");
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	
}
