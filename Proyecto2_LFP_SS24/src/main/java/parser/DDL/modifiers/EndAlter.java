package parser.DDL.modifiers;

import parser.Data;
import parser.AnalizadorSintactico;

public class EndAlter extends AnalizadorSintactico {

    public EndAlter(Data data) {
        super(data);
    }

    @Override
    public void analyze() {
        if (data.validateLexeme(";")){
            data.saveModifiedTable();
            data.increaseAlters();
        } else {
            data.addSyntaxError("Se esperaba un token ;");
        }
    }
}
