package parser.DML.selects;

import jflex.TokenConstant;
import parser.Data;
import parser.AnalizadorSintactico;


public class AnalizadorGroupBy extends AnalizadorSintactico {

    private final FinAnalizadorSelect endSelectAnalyzer;

    public AnalizadorGroupBy(Data data) {
        super(data);
        this.endSelectAnalyzer = new FinAnalizadorSelect(data);
    }

    @Override
    public void analyze() {
        if (data.validateLexeme("BY")){
            data.next();
            identifierStatus();
        } else {
            errorStatus("Se esperaba un token BY");
        }
    }

    private void identifierStatus(){
        if (data.validateName(TokenConstant.ID)){
            data.next();
            finalStatus1();
        } else {
            errorStatus("Se esperaba un token Identificador");
        }
    }

    private void finalStatus1(){
        if (data.validateLexeme(".")){
            data.next();
            lastIdentifierStatus();
        } else {
            endSelectAnalyzer.analyze();
        }
    }

    private void lastIdentifierStatus(){
        if (data.validateName(TokenConstant.ID)){
            data.next();
            endSelectAnalyzer.analyze();
        } else {
            errorStatus("Se esperaba un token Identificador");
        }
    }
}
