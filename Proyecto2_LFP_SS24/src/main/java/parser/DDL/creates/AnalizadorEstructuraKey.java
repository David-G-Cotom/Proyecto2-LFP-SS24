package parser.DDL.creates;

import jflex.TokenConstant;
import parser.Data;
import parser.AnalizadorSintactico;

public class AnalizadorEstructuraKey extends AnalizadorSintactico {

    private final AnalizadorSintactico finAnalizador;


    public AnalizadorEstructuraKey(Data data, AnalizadorSintactico finAnalizador) {
        super(data);
        this.finAnalizador = finAnalizador;
    }

    @Override
    public void analyze() {
        if (data.validateName(TokenConstant.ID)){
            data.next();
            foreignStatus();
        } else {
            data.addSyntaxError("Se esperaba un token de tipo Identificador");
        }
    }

    private void foreignStatus(){
        if (data.validateLexeme("FOREIGN")){
            data.next();
            keyStatus();
        } else {
            data.addSyntaxError("Se esperaba un token FOREIGN");
        }
    }

    private void keyStatus(){
        if (data.validateLexeme("KEY")){
            data.next();
            keyNameStatus();
        } else {
            data.addSyntaxError("Se esperaba un token KEY");
        }
    }

    private void keyNameStatus(){
        if (data.betweenParenthesis(TokenConstant.ID)){
            data.next();
            referenceStatus();
        } else {
            data.addSyntaxError("Se esperaba un token entre parentesis");
        }
    }

    private void referenceStatus(){
        if (data.validateLexeme("REFERENCES")){
            data.next();
            identifierStatus();
        } else {
            data.addSyntaxError("Se esperaba un token REFERENCE");
        }
    }

    private void identifierStatus(){
        if (data.validateName(TokenConstant.ID)){
            data.next();
            identifierBetween();
        } else {
            data.addSyntaxError("Se esperaba un token Identificador");
        }
    }

    private void identifierBetween(){
        if (data.betweenParenthesis(TokenConstant.ID)){
            data.next();
            finAnalizador.analyze();
        } else {
            data.addSyntaxError("Se esperaba un token Identificador entre parentesis");
        }
    }


}
