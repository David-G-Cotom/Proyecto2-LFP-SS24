package parser.DDL.modifiers;

import jflex.TokenConstant;
import parser.DDL.creates.AnalizadorTipoDato;
import parser.Data;
import parser.AnalizadorSintactico;


public class AlterAdd extends AnalizadorSintactico {

    public AlterAdd(Data data ) {
        super(data);
    }

    @Override
    public void analyze() {
        if (data.validateLexeme("COLUMN")){
            data.next();
            columnNameStatus();
        } else if (data.validateLexeme("CONSTRAINT")) {
            data.next();
            AlterConstraint alterConstraint = new AlterConstraint(data);
            alterConstraint.analyze();
        } else {
            errorStatus("Se esperaba un token COLUMN");
        }
    }

    private void columnNameStatus(){
        if (data.validateName(TokenConstant.ID)){
            data.setModifiedTableColumn();
            data.next();
            AnalizadorTipoDato dataTypeAnalyzer = new AnalizadorTipoDato(data,new EndAlter(data), false);
            dataTypeAnalyzer.analyze();
        } else {
            errorStatus("Se esperaba un token Identificador");
        }
    }
}
