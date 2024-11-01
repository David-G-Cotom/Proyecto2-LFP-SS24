package parser.updates;

import jflex.TokenConstant;
import parser.Data;
import parser.AnalizadorSintactico;

public class AnalizadorElementoSet extends AnalizadorSintactico {

    public AnalizadorElementoSet(Data data) {
        super(data);
    }

    @Override
    public void analyze() {
        if (data.validateName(TokenConstant.ID)){
            data.next();
            equalStatus();
        } else {
            errorStatus("Se esperaba un token Identificador");
        }
    }

    private void equalStatus(){
        if (data.validateLexeme("=")){
            data.next();
            UpdateData updateData = new UpdateData(data, new FinElementoSet(data));
            updateData.analyze();
        } else  {
            errorStatus("Se esperaba un token =");
        }
    }
}
