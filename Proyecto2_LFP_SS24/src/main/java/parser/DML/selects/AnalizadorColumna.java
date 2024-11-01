package parser.DML.selects;

import jflex.TokenConstant;
import parser.Data;
import parser.AnalizadorSintactico;


public class AnalizadorColumna extends AnalizadorSintactico {

    private final AnalizadorSintactico endAnalyze;
    public AnalizadorColumna(Data data, AnalizadorSintactico endAnalyzer) {
        super(data);
        this.endAnalyze = endAnalyzer;

    }

    @Override
    public void analyze() {
        if (data.validateName(TokenConstant.ID)){
            data.next();
            finalSimpleStatus();
        } else  if (
                data.validateLexeme("SUM") ||
                data.validateLexeme("AVG") ||
                data.validateLexeme("COUNT") ||
                data.validateLexeme("MIN") ||
                data.validateLexeme("MAX") ){
            data.next();
            identifierBetweenParenthesisStatus();
        } else {
            errorStatus("Secuencia de token invalido");
        }
    }

    private void finalSimpleStatus(){
        if (data.validateLexeme(".")){
            data.next();
            identifierStatus2();
        }  else if (data.validateLexeme("AS")){
            data.next();
            identifierAsStatus();
        }else {
            endAnalyze.analyze();
        }
    }

    private void identifierStatus2(){
        if (data.validateName(TokenConstant.ID)){
            data.next();
            finalComputesStatus();
        } else {
            errorStatus("Se esperaba un token identificador");
        }
    }

    private void finalComputesStatus(){
        if (data.validateLexeme("AS")){
            data.next();
            identifierAsStatus();
        } else{
            endAnalyze.analyze();
        }
    }

    private void identifierBetweenParenthesisStatus(){
        if (data.betweenParenthesis(TokenConstant.ID)){
            data.next();
            finalComputesStatus();
        }
    }

    //VALIDACION DE LA AGREGACION DE AS
    public void identifierAsStatus(){
        if (data.validateName(TokenConstant.ID)){
            data.next();
            endAnalyze.analyze();
        } else{
            errorStatus("Se esperaba un token identificador");
        }
    }
}
