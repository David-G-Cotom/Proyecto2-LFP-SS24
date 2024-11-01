package parser.DML.selects;

import parser.Data;
import parser.AnalizadorSintactico;


public class SelectorColumna extends AnalizadorSintactico {

    public SelectorColumna(Data data) {
        super(data);
    }

    @Override
    public void analyze() {
        if (data.validateLexeme(",")){
            data.next();
            AnalizadorColumna columnAnalyzer = new AnalizadorColumna(data, this);
            columnAnalyzer.analyze();
        } else if (data.validateLexeme("FROM")) {
            data.next();
            SelectorSentence selectorSentence = new SelectorSentence(data);
            selectorSentence.analyze();
        }
    }

}
