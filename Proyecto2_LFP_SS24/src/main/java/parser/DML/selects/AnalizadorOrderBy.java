package parser.DML.selects;

import jflex.TokenConstant;
import parser.Data;
import parser.AnalizadorSintactico;


public class AnalizadorOrderBy extends AnalizadorSintactico {

    private final FinAnalizadorSelect endSelectAnalyzer;

    public AnalizadorOrderBy(Data data) {
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
            orderStatus();
        }
    }

    private void lastIdentifierStatus(){
        if (data.validateName(TokenConstant.ID)){
            data.next();
            orderStatus();
        } else {
            errorStatus("Se esperaba un token Identificador");
        }
    }

    private void orderStatus(){
        if (data.validateLexeme("ASC") || data.validateLexeme("DESC")){
            data.next();
            endSelectAnalyzer.analyze();
        } else {
            errorStatus("Se esperaba un token ASC o DESC");
        }
    }

}
