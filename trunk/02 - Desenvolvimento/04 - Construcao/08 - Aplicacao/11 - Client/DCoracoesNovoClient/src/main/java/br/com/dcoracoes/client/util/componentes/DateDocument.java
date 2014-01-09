/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.util.componentes;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class DateDocument extends PlainDocument {

    private static int TAMANHO_TEXTO = 9;
    private static String CARACTERES_DATA = "0123456789";
    private String[] digitosData = new String[10]; // guarda os valores validos dos dígitos que forma uma data  

    public DateDocument() {
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {


        if (str != null && str.length() == 1) {

            //Verificar o tamanho maximo permitido    
            if (getLength() > TAMANHO_TEXTO) {
                return;
            }


            //Somente para validar os caracteres dígitados    
            for (int i = 0; i < str.length(); i++) {
                if (CARACTERES_DATA.indexOf(String.valueOf(str.charAt(i))) == -1 || str.length() > 1) {
                    java.awt.Toolkit.getDefaultToolkit().beep();
                    return;
                }

            }

            if (verificadorDigitoInvalido(offset, str)) {
                java.awt.Toolkit.getDefaultToolkit().beep();
                return;
            }

            //Checar a posiçao do caracter que separa a data    
            if ((offset == 2) || (offset == 5)) {
                if (!str.equals("/")) {
                    super.insertString(offset, "/" + str, attr);
                    return;
                }
            }

        }
        
        super.insertString(offset, str, attr);

        pegarDigitoValidos(offset, str);
    }

    private boolean verificadorDigitoInvalido(int posicao, String digito) {
        boolean resultado = false;
        switch (posicao) {
            case 0:
                resultado = primeiroDigitoInvalido(digito);
                break;
            case 1:
                resultado = segundoDigitoInvalido(digito);
                break;
            case 2:
                resultado = terceiroDigitoInvalido(digito);
                break;
            case 3:
                resultado = terceiroDigitoInvalido(digito);
                break;
            case 4:
                resultado = quartoDigitoInvalido(digito);
                break;
            case 5:
                resultado = quintoDigitoInvalido(digito);
                break;
            case 6:
                resultado = quintoDigitoInvalido(digito);
                break;
        }
        return resultado;
    }

    private boolean primeiroDigitoInvalido(String digito) {
        boolean resultado = false;
        if (CARACTERES_DATA.indexOf(String.valueOf(digito.charAt(0))) > 3) {
            resultado = true;
        }
        return resultado;
    }

    private boolean segundoDigitoInvalido(String digito) {
        boolean resultado = false;
        if (CARACTERES_DATA.indexOf(String.valueOf(digito.charAt(0))) > 1 && digitosData[0].equals("3")) {
            //javax.swing.JOptionPane.showMessageDialog(null,"Digito invalido!","Aviso",javax.swing.JOptionPane.WARNING_MESSAGE);   
            resultado = true;
        }
        if (CARACTERES_DATA.indexOf(String.valueOf(digito.charAt(0))) == 0 && digitosData[0].equals("0")) {
            //javax.swing.JOptionPane.showMessageDialog(null,"Digito invalido!","Aviso",javax.swing.JOptionPane.WARNING_MESSAGE);   
            resultado = true;
        }
        return resultado;
    }

    private boolean terceiroDigitoInvalido(String digito) {
        boolean resultado = false;
        if (CARACTERES_DATA.indexOf(String.valueOf(digito.charAt(0))) > 1) {
            //javax.swing.JOptionPane.showMessageDialog(null,"Digito invalido!","Aviso",javax.swing.JOptionPane.WARNING_MESSAGE);   
            resultado = true;
        }
        digitosData[3] = digito; // quando a posicao do digito for 2 guarda o valor tambem na posiçao 3  
        return resultado;
    }

    private boolean quartoDigitoInvalido(String digito) {
        boolean resultado = false;
        if (CARACTERES_DATA.indexOf(String.valueOf(digito.charAt(0))) == 0 && digitosData[3].equals("0")) {
            //javax.swing.JOptionPane.showMessageDialog(null,"Digito invalido!","Aviso",javax.swing.JOptionPane.WARNING_MESSAGE);   
            resultado = true;
        }
        if (CARACTERES_DATA.indexOf(String.valueOf(digitosData[3].charAt(0))) == 1 && CARACTERES_DATA.indexOf(String.valueOf(digito.charAt(0))) > 2) {
            //javax.swing.JOptionPane.showMessageDialog(null,"Digito invalido!","Aviso",javax.swing.JOptionPane.WARNING_MESSAGE);   
            resultado = true;
        }
        return resultado;
    }

    private boolean quintoDigitoInvalido(String digito) {
        boolean resultado = false;
        if (CARACTERES_DATA.indexOf(String.valueOf(digito.charAt(0))) < 1) {
            //javax.swing.JOptionPane.showMessageDialog(null,"Digito invalido!","Aviso",javax.swing.JOptionPane.WARNING_MESSAGE);   
            resultado = true;
        }
        return resultado;
    }

    private void pegarDigitoValidos(int posicao, String digito) {
        digitosData[posicao] = digito;
    }
}
