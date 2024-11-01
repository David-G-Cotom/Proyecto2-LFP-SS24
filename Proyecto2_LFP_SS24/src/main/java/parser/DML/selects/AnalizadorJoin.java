package parser.DML.selects;

import jflex.TokenConstant;
import parser.Data;
import parser.AnalizadorSintactico;


public class AnalizadorJoin extends AnalizadorSintactico {

    public AnalizadorJoin(Data data) {
        super(data);
    }

    @Override
    public void analyze() {
        if (data.validateName(TokenConstant.ID)){
            data.next();
            identifierStatus();
        } else {
            errorStatus("Se esperaba un token identificador");
        }
    }

    private void identifierStatus(){
        if (data.validateName(TokenConstant.ID)){
            data.next();
            onStatus();
        } else {
            errorStatus("Se esperaba un token identificador");
        }
    }

    private void onStatus(){
        if (data.validateLexeme("ON")){
            data.next();
            identifierOnStatus();
        } else {
            errorStatus("Se esperaba un token ON");
        }
    }

    private  void  identifierOnStatus(){
        if (data.validateName(TokenConstant.ID)) {
            data.next();
            identifierTypeStatus();
        } else {
            errorStatus("Se esperaba un token identificador");
        }
    }

    private void identifierTypeStatus(){
        if (data.validateLexeme(".")){
            data.next();
            identifierDotStatus();
        } else {
            equalStatus();
        }
    }

    private void identifierDotStatus(){
        if (data.validateName(TokenConstant.ID)){
            data.next();
            equalStatus();
        } else {
            errorStatus("Se esperaba un token identificador");
        }
    }

    private void equalStatus(){
        if (data.validateLexeme("=")){
            data.next();
            identifierIdentifierStatus();
        } else  {
            errorStatus("Se esperaba un token =");
        }
    }

    private void identifierIdentifierStatus(){
        if (data.identifierIdentifier()){
            data.next();
            FinAnalizadorSelect endSelectAnalyzer = new FinAnalizadorSelect(data);
            endSelectAnalyzer.analyze();
        }
    }
}
