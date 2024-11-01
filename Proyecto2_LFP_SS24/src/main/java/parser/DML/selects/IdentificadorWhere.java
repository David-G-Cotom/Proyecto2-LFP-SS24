package parser.DML.selects;

import jflex.TokenConstant;
import parser.DML.inserts.AnalizadorData;
import parser.Data;
import parser.AnalizadorSintactico;


public class IdentificadorWhere extends AnalizadorSintactico {

    private final AnalizadorSintactico endSelectAnalyzer;

    public IdentificadorWhere(Data data, AnalizadorSintactico endSelectAnalyzer) {
        super(data);
        this.endSelectAnalyzer = endSelectAnalyzer;
    }

    @Override
    public void analyze() {
        selectTypeStatus();
    }

    private void selectTypeStatus(){
        if (data.validateName(TokenConstant.ID)){
            data.next();
            identifierTypeStatus();
        } else {
            AnalizadorData dataAnalyzer = new AnalizadorData(data, endSelectAnalyzer);
            dataAnalyzer.analyze();
        }
    }

    private void  identifierTypeStatus(){
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
            errorStatus("Se esperaba un token Identificador ");
        }
    }

}
