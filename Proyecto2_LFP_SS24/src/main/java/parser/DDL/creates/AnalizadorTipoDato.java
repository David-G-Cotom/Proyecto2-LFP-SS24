package parser.DDL.creates;

import jflex.TokenConstant;
import parser.Data;
import parser.AnalizadorSintactico;


public class AnalizadorTipoDato extends AnalizadorSintactico {

    private final AnalizadorSintactico finalAnalizador;

    private boolean adColumn = false;

    public AnalizadorTipoDato(Data data, AnalizadorSintactico finalAnalyzer, boolean adColumn) {
        super(data);
        this.adColumn = adColumn;
        this.finalAnalizador = finalAnalyzer;
    }

    @Override
    public void analyze() {
        if (data.validateLexeme("VARCHAR") ){
            adPart();
            data.next();
            openParenthesis();
        } else if (data.validateLexeme("DECIMAL")) {
            adPart();
            data.next();
            openPar2();
        } else if (data.validateName(TokenConstant.TIPO_DATO)) {
            adPart();
            data.next();
            finalStatus();
        } else{
            data.addSyntaxError("se esperaba un tipo de dato");
        }
    }

    private void openParenthesis(){
        if (data.validateLexeme("(")){
            adPart();
            data.next();
            intStatus();
        } else {
            data.addSyntaxError("se esperaba un: (");
        }
    }

    private void intStatus(){
        if (data.validateName(TokenConstant.ENTERO)){
            adPart();
            data.next();
            endParenthesis();
        } else {
            data.addSyntaxError("se esperaba un entero");
        }
    }

    private void endParenthesis(){
        if (data.validateLexeme(")")){
            adPart();
            data.next();
            finalStatus();
        } else {
            data.addSyntaxError("se esperaba un: )");
        }
    }

    private void openPar2(){
        if (data.validateLexeme("(")){
            adPart();
            data.next();
            int1();
        } else{
            data.addSyntaxError("se esperaba un: (");
        }
    }

    private void int1(){
        if (data.validateName(TokenConstant.ENTERO)){
            adPart();
            data.next();
            quoteStatus();
        } else {
            data.addSyntaxError("se esperaba un: Entero");
        }
    }

    private void quoteStatus(){
        if (data.validateLexeme(",")){
            adPart();
            data.next();
            int2();
        }else{
            data.addSyntaxError("se esperaba un: ,");
        }
    }

    private void int2(){
        if (data.validateName(TokenConstant.ENTERO)){
            adPart();
            data.next();
            endParenthesis();
        } else {
            data.addSyntaxError("se esperaba un: Entero");
        }
    }

    private void finalStatus(){
        finalAnalizador.analyze();
    }

    private void adPart(){
        if (adColumn){
            data.addPartColumn();
        }
    }
}
