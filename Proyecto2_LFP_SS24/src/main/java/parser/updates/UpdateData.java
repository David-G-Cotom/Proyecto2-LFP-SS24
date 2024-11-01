package parser.updates;

import parser.Data;
import parser.AnalizadorSintactico;

public class UpdateData extends AnalizadorSintactico {

    private final AnalizadorSintactico finalAnalyzer;

    public UpdateData (Data data, AnalizadorSintactico finalAnalyzer) {
        super(data);
        this.finalAnalyzer = finalAnalyzer;
    }

    @Override
    public void analyze() {
        if (data.isUpdateData()){
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
            finalAnalyzer.analyze();
        }
    }

    private void openParenthesisStatus(){
        if (data.isUpdateData()){
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
        if (data.isUpdateData()){
            data.next();
            dataBetweenParenthesis();
        } else {
            errorStatus("Secuencia de token invalida se esperaba un tipo de dato");
        }
    }

    private void operatorStatus(){
        if (data.isUpdateData()){
            data.next();
            finalStatus();
        } else {
            errorStatus("Secuencia de token invalida, se esperaba un dato");
        }
    }
}
