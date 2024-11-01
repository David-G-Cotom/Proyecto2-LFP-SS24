package parser.DDL.creates;

import jflex.TokenConstant;
import parser.Data;
import parser.AnalizadorSintactico;


public class AnalizadorTabla extends AnalizadorSintactico {
    
    private final AnalizadorTipoDato analizadorTipoDato;

    public static final String KEYWORD = "TABLE";

    public AnalizadorTabla(Data data) {
        super(data);
        analizadorTipoDato = new AnalizadorTipoDato(data, new FinDeclaracion(data), true );
    }

    @Override
    public void analyze() {
        if (data.validateName(TokenConstant.ID)) {
            data.setTableName();
            data.next();
            openParenthesisStatus();
        } else {
            data.addSyntaxError("Se esparaba un token de tipo Identificador");
        }
    }

    private void openParenthesisStatus() {
        if (data.validateLexeme("(")) {
            data.next();
            identifierStatus();
        } else {
            data.addSyntaxError("Se esperaba: (");
        }
    }

    private void identifierStatus() {
        if (data.validateName(TokenConstant.ID)) {
            data.newColumnAndPart();
            data.next();
            analizadorTipoDato.analyze();
        } else {
            data.addSyntaxError("Se esparaba un token de tipo Identificador");
        }
    }
    
}