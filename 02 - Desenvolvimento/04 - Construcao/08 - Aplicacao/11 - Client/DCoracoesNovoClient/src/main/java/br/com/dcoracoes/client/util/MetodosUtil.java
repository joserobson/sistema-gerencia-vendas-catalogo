/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.util;

import java.text.DateFormat;
import java.text.ParseException;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;
import java.awt.Component;
import java.awt.Container;
import java.awt.Window;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.JTextArea;

/**
 *
 * @author Robson
 */
public class MetodosUtil {

    /**
     * Pelo campo passado por parametro, só permite inserir valores númericos nos mesmos
     * @param field 
     */
    public static void validNumeric(JTextField field) {

        String value = "";
        char[] caracter = field.getText().toCharArray();
        for (char c : caracter) {
            if (Character.isDigit(c)) {
                value += c;
            }
        }

        field.setText(value);

    }
    private static final int TAMANHO_MAX_PADRAO_CODIGO = 6;

    /**
     * METODO UTIL PARA GERAR CODIGO NO PADRAO DO SISTEMA
     * @param pcodigo
     * @return
     */
    public static String gerarCodigoFormatoPadrao(int pcodigo) {
        if (pcodigo == 0) {
            return "001102";
        }

        String lCodigo = String.valueOf(pcodigo);
        int tam = lCodigo.length();
        for (int i = 0; i < TAMANHO_MAX_PADRAO_CODIGO - tam; i++) {
            lCodigo = "0" + lCodigo;
        }
        return lCodigo;
    }

    /**
     * metodo para validar o tamanho permitido em cada textfield
     * @param size
     * @param text 
     */
    public static void defineSizeMax(int size, JTextComponent text) {
        if (text.getText().length() >= size) {
            text.setText(text.getText().substring(0, size));
        }
    }

    /**
     * verifica se data em formato string está vazia
     * @param data
     * @return 
     */
    public static boolean isDataEmpty(String data){        
        return data.replace("/", "").trim().isEmpty();
    }
    
    /**
     * valida  data
     * @param data
     * @return 
     */
    public static boolean validData(String data) {
        boolean result = true;
        if (!data.replace("/", "").trim().isEmpty()) {
            try {
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                df.setLenient(false);
                df.parse(data);
            } catch (ParseException e) {
                System.out.println("isValidDate" + "ParseException=" + e.getMessage());
                result = false;
            }
        }
        return result;
    }
    
    /**
     * valida  data
     * @param data
     * @return 
     */
    public static boolean validDataDiaMes(String data) {
        boolean result = true;
        if (!data.replace("/", "").trim().isEmpty()) {
            try {
                DateFormat df = new SimpleDateFormat("dd/MM");
                df.setLenient(false);
                df.parse(data);
            } catch (ParseException e) {
                System.out.println("isValidDate" + "ParseException=" + e.getMessage());
                result = false;
            }
        }
        return result;
    }

    /**
     * Metodo que implementa logica para todas os campos do jframe pularem de campo com o Enter
     * @param frame
     */
    public static void enterPularCampos(Window frame) {
//        HashSet conj = new HashSet(frame.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
//        conj.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
//        frame.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conj);

    }
    
    /**
     * Este metodo define todos os campos de escrita da tela aceitar
     * somente letras maiusculas
     * @param frame 
     */
    public static void letrasMaiusculas(Container frame){
        Component components[] = frame.getComponents();  
        for (Component component : components) {  
            if (component instanceof JTextField && !(component instanceof JFormattedTextField)) {  
                JTextField field = (JTextField) component; 
                field.setDocument(new UpperCaseDocument());
            } else if(component instanceof JTable){
                JTable field = (JTable) component; 
                field.setDefaultEditor(String.class, new UpperCaseEditor());
            } else if(component instanceof JTextArea){
                JTextArea field = (JTextArea) component; 
                field.setDocument(new UpperCaseDocument());
            } else if (component instanceof Container) {  
                letrasMaiusculas((Container) component);  
            }  
        }  
    }
    
    public static String formatarValorDinheiro(float valor)
    {
        NumberFormat format = new DecimalFormat("#,##0.00");
        return format.format(valor);
    }
        
    public static String formatarValorDinheiro(String valor)
    {
        return formatCurrencyValue(valor);
    }
    
    private static String formatCurrencyValue(String value) {
        String mask = "###,###,##0.00";
        NumberFormat nf = new DecimalFormat(mask);
        return nf.format(currencyToDouble(value));
    }

    private static Double currencyToDouble(String value) {
        return Double.parseDouble(value);
    }
    
    /**
     * convert string to float
     * @param value
     * @return 
     */
    public static Float convertStringToFloat(String value)
    {
        return Float.parseFloat(value.trim().replace(".", "").replace(",", "."));
    }
        
}

