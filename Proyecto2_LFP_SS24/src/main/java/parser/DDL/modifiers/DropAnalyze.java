package parser.DDL.modifiers;

import jflex.TokenConstant;
import parser.Data;
import parser.AnalizadorSintactico;


public class DropAnalyze extends AnalizadorSintactico {

    public static final String KEYWORD = "DROP";

    public DropAnalyze(Data data) {
        super(data);
    }

    @Override
    public void analyze() {
        if (data.validateLexeme("TABLE")){
            data.next();
            ifStatus();
        } else {
            errorStatus("Se esperaba un token TABLE");
        }
    }

    private void ifStatus(){
        if (data.validateLexeme("IF")){
            data.next();
            existStatus();
        } else {
            errorStatus("Se esperaba un token IF");
        }
    }

    private void existStatus(){
        if (data.validateLexeme("EXISTS")){
            data.next();
            identifierStatus();
        } else {
            errorStatus("Se esperaba un token EXISTS");
        }
    }

    private void identifierStatus(){
        if (data.validateName(TokenConstant.ID)){
            data.setModifiedTableName();
            data.next();
            cascadeStatus();
        } else {
            errorStatus("Se esperaba un token Identificador");
        }
    }

    private void cascadeStatus(){
        if (data.validateLexeme("CASCADE")){
            data.next();
            finalStatus();
        } else {
            errorStatus("Se esperaba un token CASCADE");
        }
    }

    private void finalStatus(){
        if (data.validateLexeme(";")){
            data.saveModifiedTable();
            data.increaseDrops();
        } else {
            errorStatus("Se esperaba un token ;");

        }
    }
}
