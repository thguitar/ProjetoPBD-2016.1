package br.com.Locadora.model;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class OnlyNumberField extends PlainDocument {

	private static final long serialVersionUID = 4213096061012598911L;
	private int tamMax;  

	public OnlyNumberField(int tamMax) {  
		super();  
		this.tamMax = tamMax;  
	}  

	public void insertString(int offset, String str, AttributeSet attr)  
			throws BadLocationException {  

		if (str == null) 
			return;  

		//Define a condição para aceitar qualquer número de caracteres
		if (tamMax <= 0)
		{

			for (char c : str.toCharArray())
			{
				if(!Character.isDigit(c))
				{
					return;
				}
			}

			super.insertString(offset, str, attr);
			return;
		}

		int tam = (getLength() + str.length());

		//Se o tamanho final for menor, chama insertString() aceitando a String
		if (tam <= tamMax) {
			for (char c : str.toCharArray())
			{
				if(!Character.isDigit(c))
				{
					return;
				}
			}
			super.insertString(offset, str, attr);
		} 
	}

}