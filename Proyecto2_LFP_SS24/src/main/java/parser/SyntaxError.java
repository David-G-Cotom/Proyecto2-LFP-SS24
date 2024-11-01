/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parser;

import jflex.Token;

/**
 *
 * @author Carlos Cotom
 */
public class SyntaxError {
    
    private final Token errorToken;
    private final String description;

    public SyntaxError(Token errorToken, String description) {
        this.errorToken = errorToken;
        this.description = description;
    }

    public Token getErrorToken() {
        return errorToken;
    }

    public String getDescription() {
        return description;
    }
    
}
