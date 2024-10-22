/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jflex;

import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

/**
 *
 * @author Carlos Cotom
 */
public class PintorPalabra {
    
    public final JTextPane textPane;
    private final StyleContext styleContext;
    private final DefaultStyledDocument styleDoc;
    
    public PintorPalabra() {
        this.textPane = new JTextPane();
        this.styleContext = new StyleContext();
        this.styleDoc = new DefaultStyledDocument(styleContext);
    }
    
    public void establecerEstilo(String textoAPintar) {
        this.textPane.setDocument(styleDoc);
        try {
            this.styleDoc.insertString(0, textoAPintar, null);
        } catch (BadLocationException ex) {
            System.out.println("Error en establecerEstilo() + " + ex);
        }
    }
    
    public void pintarNaranja(int posInicialPalabra, int lengthPalabra) {
        Style naranja = this.styleContext.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(naranja, Color.decode("#FF8C00"));
        this.styleDoc.setCharacterAttributes(posInicialPalabra, lengthPalabra, naranja, false);
        System.out.println("Se pinto de NARANJA");
    }
    
    public void pintarMorado(int posInicialPalabra, int lengthPalabra) {
        Style morado = this.styleContext.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(morado, Color.decode("#800080"));
        this.styleDoc.setCharacterAttributes(posInicialPalabra, lengthPalabra, morado, false);
        System.out.println("Se pinto de MORADO");
    }
    
    public void pintarAzul(int posInicialPalabra, int lengthPalabra) {
        Style azul = this.styleContext.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(azul, Color.blue);
        this.styleDoc.setCharacterAttributes(posInicialPalabra, lengthPalabra, azul, false);
        System.out.println("Se pinto de AZUL");
    }
    
    public void pintarAmarillo(int posInicialPalabra, int lengthPalabra) {
        Style amarillo = this.styleContext.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(amarillo, Color.decode("#FFD700"));
        this.styleDoc.setCharacterAttributes(posInicialPalabra, lengthPalabra, amarillo, false);
        System.out.println("Se pinto de AMARILLO");
    }
    
    public void pintarVerde(int posInicialPalabra, int lengthPalabra) {
        Style verde = this.styleContext.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(verde, Color.decode("#008000"));
        this.styleDoc.setCharacterAttributes(posInicialPalabra, lengthPalabra, verde, false);
        System.out.println("Se pinto de VERDE");
    }
    
    public void pintarFucsia(int posInicialPalabra, int lengthPalabra) {
        Style fucsia = this.styleContext.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(fucsia, Color.decode("#FF00FF"));
        this.styleDoc.setCharacterAttributes(posInicialPalabra, lengthPalabra, fucsia, false);
        System.out.println("Se pinto de FUCSIA");
    }
    
    public void pintarGris(int posInicialPalabra, int lengthPalabra) {
        Style gris = this.styleContext.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(gris, Color.gray);
        this.styleDoc.setCharacterAttributes(posInicialPalabra, lengthPalabra, gris, false);
        System.out.println("Se pinto de GRIS");
    }
    
}
