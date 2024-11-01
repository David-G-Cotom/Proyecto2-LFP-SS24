package parser.DML.selects;

import jflex.TokenConstant;
import parser.Data;
import parser.AnalizadorSintactico;


public class FinOperacionRelacional extends AnalizadorSintactico {

    private final AnalizadorSintactico endAnalyzer;

    public FinOperacionRelacional(Data data, AnalizadorSintactico endAnalyzer) {
        super(data);
        this.endAnalyzer = endAnalyzer;
    }

    @Override
    public void analyze() {
        andStatus();
    }



    private void andStatus(){
        if (data.validateLexeme("AND")){
            data.next();
            identifierStatus2();
        } else {
            errorStatus("Se esperaba un token AND");
        }
    }

    private void identifierStatus2(){
        if (data.validateName(TokenConstant.ID)){
            data.next();
            equalsStatus();
        } else {
            errorStatus("Se esperaba un token Identificador");
        }
    }

    private void equalsStatus(){
        if (data.validateLexeme("=")){
            data.next();
            identifierStatus3();
        } else {
            errorStatus("Se esperaba un token =");
        }
    }

    private void identifierStatus3(){
        if (data.identifierIdentifier()){
            data.next();
            endAnalyzer.analyze();
        } else {
            errorStatus("Se esperaba un token Identificador");
        }
    }
}
