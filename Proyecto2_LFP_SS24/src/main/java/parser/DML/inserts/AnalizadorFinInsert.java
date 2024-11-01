package parser.DML.inserts;

import parser.Data;
import parser.AnalizadorSintactico;


public class AnalizadorFinInsert extends AnalizadorSintactico {

    public AnalizadorFinInsert(Data data) {
        super(data);
    }

    @Override
    public void analyze() {
        System.out.println("iniciando el final del insert");
        if (data.validateLexeme(",")){
            data.next();
            AnalizadorData dataAnalyzer = new AnalizadorData(data, this);
            dataAnalyzer.analyze();
        } else if (data.validateLexeme(")")){
            data.next();
            finStatus();
        }
    }

    private void finStatus(){
        if (data.validateLexeme(";")){
            data.increaseInserts();
        } if (data.validateLexeme(",")){
            data.next();
            AnalizadorInsert insertAnalyzer = new AnalizadorInsert(data);
            insertAnalyzer.openParenthesisToData();
        } else {
            errorStatus("Se esperaba un toke de tipo ; ");
        }
    }
}
