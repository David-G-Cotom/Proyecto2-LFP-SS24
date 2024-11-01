package parser.updates;

import parser.Data;
import parser.AnalizadorSintactico;

public class FinUpdate extends AnalizadorSintactico {

    public FinUpdate(Data data) {
        super(data);
    }

    @Override
    public void analyze() {
        if (data.validateLexeme(";")){
            data.increaseUpdates();
        } else {
            errorStatus("Se esperaba un token ;");
        }
    }
}
