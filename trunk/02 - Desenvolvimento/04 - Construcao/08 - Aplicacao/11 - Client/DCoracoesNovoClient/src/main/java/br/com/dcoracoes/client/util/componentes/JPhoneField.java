package br.com.dcoracoes.client.util.componentes;

import javax.swing.JFormattedTextField;

public class JPhoneField extends JFormattedTextField {

	private static final long serialVersionUID = 1L;
	public JPhoneField() {
		setDocument(new PhoneDocument());
	}
}
