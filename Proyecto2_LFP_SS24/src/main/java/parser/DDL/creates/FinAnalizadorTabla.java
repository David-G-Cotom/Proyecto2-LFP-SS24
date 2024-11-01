package parser.DDL.creates;

import parser.Data;
import parser.AnalizadorSintactico;

public class FinAnalizadorTabla extends AnalizadorSintactico {

    public FinAnalizadorTabla(Data data) {
        super(data);
    }

    @Override
    public void analyze() {
        if (data.validateLexeme(")")){
            data.next();
            finalStatus();
        } else{
            data.addSyntaxError("Se esperaba un token )");
        }
    }

    private void finalStatus(){
        if (data.validateLexeme(";")){
            data.saveTable();
            data.increaseCreates();
        } else{
            data.addSyntaxError("Se esperaba un token ; ");
        }
    }
}
