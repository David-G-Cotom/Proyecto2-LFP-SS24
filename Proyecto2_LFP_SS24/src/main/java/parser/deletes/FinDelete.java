package parser.deletes;

import parser.Data;
import parser.AnalizadorSintactico;

public class FinDelete extends AnalizadorSintactico {
    public FinDelete(Data data) {
        super(data);
    }

    @Override
    public void analyze() {
        if (data.validateLexeme(";")){
            data.increaseDeletes();
        } else {
            errorStatus("Se esperaba un token ; ");
        }
    }
}
