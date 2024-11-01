package parser.DDL.modifiers;

import jflex.TokenConstant;
import parser.DDL.creates.AnalizadorTipoDato;
import parser.Data;
import parser.AnalizadorSintactico;

public class AlterAlter extends AnalizadorSintactico {

    public AlterAlter(Data data) {
        super(data);
    }

    @Override
    public void analyze() {
        if (data.validateLexeme("COLUMN")){
            data.next();
            columnNameStatus();
        } else {
            errorStatus("Se esperaba un token COLUMN");
        }
    }

    private void columnNameStatus() {
        if (data.validateName(TokenConstant.ID)) {
            data.setModifiedTableColumn();
            data.next();
            typeStatus();
        } else{
            errorStatus("Se esperaba un token Identificador");
        }
    }

    private void typeStatus(){
        if (data.validateLexeme("TYPE")) {
            data.next();
            AnalizadorTipoDato dataTypeAnalyzer = new AnalizadorTipoDato(data, new EndAlter(data), false);
            dataTypeAnalyzer.analyze();
        } else {
            errorStatus("Se esperaba un token de tipo TYPE");
        }
    }
}
