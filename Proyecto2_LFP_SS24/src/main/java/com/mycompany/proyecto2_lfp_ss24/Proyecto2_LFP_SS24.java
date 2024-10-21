/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.proyecto2_lfp_ss24;

import java.io.IOException;
import java.io.StringReader;
import jflex.AnalizadorLexico;

/**
 *
 * @author Carlos Cotom
 */
public class Proyecto2_LFP_SS24 {

    public static void main(String[] args) {
        try {
            AnalizadorLexico analizador = new AnalizadorLexico(new StringReader("- -íádsa"));
            while (!analizador.yyatEOF()) {
                System.out.println(analizador.yylex().toString());
            }
        } catch (IOException ex) {
            System.out.println("Error " + ex);
        }
    }
}
