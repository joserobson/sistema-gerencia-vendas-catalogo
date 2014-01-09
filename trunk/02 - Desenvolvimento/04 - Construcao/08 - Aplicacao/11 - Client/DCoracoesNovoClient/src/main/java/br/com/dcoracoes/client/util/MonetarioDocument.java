/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/*
 * MonetarioDocument.java
 * 
* Formata uma caixa de texto para aparecer [0,00] quando vazia. Ao inserir
 * dados, preenche da direita para esquerda conservando apenas os zeros iniciais
 * e o cursor sempre a direita da vírgula. Por exemplo, para digitar o numero
 * 10,20:
 * 
* [ 0,00|] [ 0,01|] [ 0,10|] [ 1,02|] [ 10,20|]
 * 
* Também permite apagar os números na ordem inversa, mantendo os zeros
 * iniciais. Por exemplo, para apagar 10,20:
 * 
* [ 10,20|] [ 1,02|] [ 0,10|] [ 0,01|] [ 0,00|]
 * 
* Para usar esta classe, apenas crie uma caixa de texto formatada e configure
 * uma instância dessa classe como atributo tipo Document. Melhor também alinhar
 * a caixa a direita. Por exemplo:
 * 
* FormattedTextField valor = new FormattedTextField();
 * valor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
 * valor.setDocument(new MonetarioDocument());
 * 
* Obs.: a caixa texto permite apenas 12 digitos.
 * 
*/
/**
 *
 * @author Augusto
 */
public class MonetarioDocument extends PlainDocument {

    public static final int NUMERO_DIGITOS_MAXIMO = 15;

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {

        String texto = getText(0, getLength());

        if (str.length() == 1) {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (!Character.isDigit(c)) {
                    return;
                }
            }

            if (texto.length() < NUMERO_DIGITOS_MAXIMO) {
                super.remove(0, getLength());
                texto = texto.replace(".", "").replace(",", "");
                StringBuilder s = new StringBuilder(texto + str);

                if (s.length() > 0 && s.charAt(0) == '0') {
                    s.deleteCharAt(0);
                }

                if (s.length() < 3) {
                    if (s.length() < 1) {
                        s.insert(0, "000");
                    } else if (s.length() < 2) {
                        s.insert(0, "00");
                    } else {
                        s.insert(0, "0");
                    }
                }

                s.insert(s.length() - 2, ",");

                if (s.length() > 6) {
                    s.insert(s.length() - 6, ".");
                }

                if (s.length() > 10) {
                    s.insert(s.length() - 10, ".");
                }

                super.insertString(0, s.toString(), a);
            }
        } else {
            super.insertString(0, str.toString(), a);
        }
    }

    @Override
    public void remove(int offset, int length) throws BadLocationException {
        super.remove(offset, length);
        String texto = getText(0, getLength());
        texto = texto.replace(",", "");
        texto = texto.replace(".", "");
        super.remove(0, getLength());
        insertString(0, texto, null);
    }
}
