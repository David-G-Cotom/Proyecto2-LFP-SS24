package parser.DDL.modifiers;

import jflex.TokenConstant;
import parser.Data;
import parser.AnalizadorSintactico;

public class ConstraintUnique extends AnalizadorSintactico {

    public ConstraintUnique(Data data) {
        super(data);
    }

    @Override
    public void analyze() {
        if (data.validateLexeme("(")){
            data.next();
            identifierStatus();
        } else {
            errorStatus("Se esperaba un token (");
        }
    }

    private void identifierStatus(){
        if (data.validateName(TokenConstant.ID)){
            data.setModifiedTableColumn();
            data.next();
            endParth();
        } else {
            errorStatus("Se esperaba un token Identificador");
        }
    }

    private void endParth(){
        if (data.validateLexeme(")")){
            data.next();
            finalStatus();
        } else {
            errorStatus("Se esperaba un token )");
        }
    }

    private void finalStatus(){
        if (data.validateLexeme(";")){
            data.saveModifiedTable();
            data.increaseAlters();
        } else{
            errorStatus("Se esperaba un token ;");
        }
    }
}
