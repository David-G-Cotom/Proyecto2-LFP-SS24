package parser.DML.selects;

import jflex.TokenConstant;
import parser.Data;
import parser.AnalizadorSintactico;


public class DataEspecial extends AnalizadorSintactico {

    private final AnalizadorSintactico end;

    public DataEspecial(Data data, AnalizadorSintactico end) {
        super(data);
        this.end = end;
    }

    @Override
    public void analyze() {
        inisState();
    }

    private void inisState(){
        if (data.isSpecialData()){
            data.next();
            arithmeticStatus();
        } else if (data.validateName(TokenConstant.ID)){
            data.next();
            identifierStatus1();
        } else if (data.isParenthesis()) {
            data.next();
            inisState();
        } else {
            end.analyze();
        }
    }

    private void arithmeticStatus(){
        if (data.validateName(TokenConstant.ARITMETICO)){
            data.next();
            inisState();
        } else if (data.isParenthesis()) {
            data.next();
            arithmeticStatus();
        } else {
            end.analyze();
        }
    }

    private void identifierStatus1(){
        if (data.validateName(TokenConstant.ARITMETICO)){
            data.next();
            inisState();
        } else if (data.validateLexeme(".")) {
            data.next();
            identifierStatus2();
        } else {
            end.analyze();
        }
    }

    private void identifierStatus2(){
        if (data.validateName(TokenConstant.ID)){
            data.next();
            arithmeticStatus();
        } else {
            errorStatus("Se espereba un token identificador");
        }
    }
}
