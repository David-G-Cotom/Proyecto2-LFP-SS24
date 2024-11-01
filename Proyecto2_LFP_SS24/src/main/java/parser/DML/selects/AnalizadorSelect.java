package parser.DML.selects;

import parser.Data;
import parser.AnalizadorSintactico;


public class AnalizadorSelect extends AnalizadorSintactico {
    public static final String KEYWORD = "SELECT";

    public AnalizadorSelect(Data data) {
        super(data);
    }

    @Override
    public void analyze() {
        if (data.validateLexeme("*")){
            data.next();
            asteriskStatus();
        } else {
            AnalizadorColumna columnAnalyzer = new AnalizadorColumna(data, new SelectorColumna(data));
            columnAnalyzer.analyze();
        }
    }

    private void asteriskStatus(){
        if (data.validateLexeme("FROM")){
            data.next();
            SelectorSentence selectorSentence = new SelectorSentence(data);
            selectorSentence.analyze();
        } else {
            errorStatus("Se esperaba un token FROM");
        }
    }
}
