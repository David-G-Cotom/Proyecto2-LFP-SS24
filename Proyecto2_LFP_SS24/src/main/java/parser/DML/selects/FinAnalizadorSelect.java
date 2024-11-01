package parser.DML.selects;

import parser.Data;
import parser.AnalizadorSintactico;


public class FinAnalizadorSelect extends AnalizadorSintactico {

    public FinAnalizadorSelect(Data data) {
        super(data);
    }

    @Override
    public void analyze() {
        if (data.validateLexeme(";")){
            data.increaseSelects();
        } else if (
                data.validateLexeme("WHERE") ||
                        data.validateLexeme("JOIN") ||
                        data.validateLexeme("LIMIT")||
                        data.validateLexeme("GROUP")||
                        data.validateLexeme("ORDER")
            ) {
            SelectorSentence selectorSentence = new SelectorSentence(data);
            selectorSentence.selectSentenceStatus();
        } else {
            errorStatus("Secuencia de token invalida se esperaba un token , o ; ");
        }
    }
}
