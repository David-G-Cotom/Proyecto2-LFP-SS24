package parser.DML.inserts;

import parser.Data;
import parser.AnalizadorSintactico;


public class AnalizadorData extends AnalizadorSintactico {

    private final AnalizadorSintactico analizadorFin;

    public AnalizadorData(Data data, AnalizadorSintactico finalAnalyzer) {
        super(data);
        this.analizadorFin = finalAnalyzer;
    }

    @Override
    public void analyze() {
        if (data.isData()){
            data.next();
            finalStatus();
        } else if (data.validateLexeme("(")) {
            data.next();
            openParenthesisStatus();
        } else {
            errorStatus("Secuencia de token invalida");
        }
    }

    private void finalStatus(){
        if (data.isOperator()){
            data.next();
            operatorStatus();
        } else if (data.validateLexeme("(")) {
            data.next();
            openParenthesisStatus();
        } else {
            System.out.println("finalizando el analizis de los datos");
            analizadorFin.analyze();
        }
    }

    private void openParenthesisStatus(){
        if (data.isData()){
            data.next();
            dataBetweenParenthesis();
        } else {
            errorStatus("Secuencia de token invalida, se esperaba un dato");
        }
    }

    private void dataBetweenParenthesis(){
        if (data.validateLexeme(")")){
            data.next();
            finalStatus();
        } else if (data.isOperator()) {
            data.next();
            operatorBetweenParenthesis();
        } else {
            errorStatus("Secuencia de token invalida se esperaba un operador o cierre de parentesis");
        }
    }

    private void operatorBetweenParenthesis(){
        if (data.isData()){
            data.next();
            dataBetweenParenthesis();
        } else {
            errorStatus("Secuencia de token invalida se esperaba un tipo de dato");
        }
    }

    private void operatorStatus(){
        if (data.isData()){
            data.next();
            finalStatus();
        } else {
            errorStatus("Secuencia de token invalida, se esperaba un dato");
        }
    }
}
