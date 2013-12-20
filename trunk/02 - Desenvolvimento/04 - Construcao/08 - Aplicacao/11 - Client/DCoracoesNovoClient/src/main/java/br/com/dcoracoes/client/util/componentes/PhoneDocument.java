package br.com.dcoracoes.client.util.componentes;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * 
 * @author Fabio Noth
 */
public class PhoneDocument extends PlainDocument {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int NUMERO_DIGITOS_MAXIMO = 13;

        
	public void insertString(int offs, String str, AttributeSet a)
			throws BadLocationException {

            if(str.length() > 1){
                super.insertString(0, str, a);
            }
            else {
		StringBuffer texto = new StringBuffer(getText(0, getLength()));

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (!Character.isDigit(c)) {
				return;
			}
		}

		if (texto.length() < this.NUMERO_DIGITOS_MAXIMO) {
			super.remove(0, getLength());
			texto = new StringBuffer(texto.toString().replace(".", "").replace(",", ""));
						
			StringBuffer s = new StringBuffer(texto.insert(offs, str));
			StringBuffer text = replace(new StringBuffer(texto.insert(offs, str)));

			if (text.length() == 9) {
				s = replace(s);
				s.insert(4, "-");
			}
			if (text.length() == 10) {
				s = replace(s);
				s.insert(5, "-");
			}
			if (text.length() == 11) {
				s = replace(s);
				s.insert(6, "-");
				s.insert(2, " ");
			}
			if (text.length() == 12) {
				s = replace(s);
				s.insert(7, "-");
				s.insert(2, " ");
			}

			super.insertString(0, s.toString(), a);
		}
            }
	}

	private StringBuffer replace(StringBuffer s){
		s = new StringBuffer(s.toString().replace("-", ""));
		s = new StringBuffer(s.toString().replace(" ", ""));
		return s;
	}

}