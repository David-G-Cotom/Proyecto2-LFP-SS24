package parser.DML.inserts;

import jflex.TokenConstant;
import parser.Data;
import parser.AnalizadorSintactico;


public class AnalizadorInsert extends AnalizadorSintactico {
    
    public static final String KEYWORD = "INSERT";

    public AnalizadorInsert(Data data) {
        super(data);
    }

    @Override
    public void analyze() {
        if (data.validateLexeme("INTO")){
            data.next();
            identifierStatus();
        } else {
            errorStatus("Se esperaba un token INTO");
        }
    }

    private void identifierStatus(){
        if (data.validateName(TokenConstant.ID)){
            data.next();
            openParenthesis();
        } else {
            errorStatus("Se esperaba un token Identificador");
        }
    }

    private void openParenthesis(){
        if (data.validateLexeme("(")){
            data.next();
            columnNameStatus();
        } else {
            errorStatus("Se esperaba un token (");
        }
    }

    private void columnNameStatus(){
        if (data.validateName(TokenConstant.ID)){
            data.next();
            finalColumnNameStatus();
        } else {
            errorStatus("Se esperaba un token Identificador");
        }
    }

    private void finalColumnNameStatus(){
        if (data.validateLexeme(",")){
            data.next();
            addColumnName();
        } else if (data.validateLexeme(")")) {
            data.next();
            valuesStatus();
        } else {
            errorStatus("Se esperaba un token ,");
        }
    }

    private void addColumnName(){
        if (data.validateName(TokenConstant.ID)){
            data.next();
            finalColumnNameStatus();
        } else {
            errorStatus("Se esperaba un token Identificador");
        }
    }

    private void valuesStatus(){
        if (data.validateLexeme("VALUES")){
            data.next();
            openParenthesisToData();
        } else {
            errorStatus("Se esperaba un token VALLUES");
        }
    }

    public void openParenthesisToData() {
        if (data.validateLexeme("(")) {
            data.next();
            AnalizadorData dataAnalyzer = new AnalizadorData(data, new AnalizadorFinInsert(data));
            dataAnalyzer.analyze();
        } else {
            errorStatus("Se esperaba un token (");
        }
    }
    
}
