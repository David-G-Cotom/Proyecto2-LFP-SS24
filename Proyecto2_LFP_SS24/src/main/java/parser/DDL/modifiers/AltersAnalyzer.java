package parser.DDL.modifiers;

import jflex.TokenConstant;
import parser.Data;
import parser.AnalizadorSintactico;

public class AltersAnalyzer extends AnalizadorSintactico {

    public static final String KEYWORD = "ALTER";

    private final AlterAlter alterAlter;
    private final AlterAdd alterAdd;

    public AltersAnalyzer(Data data) {
        super(data);
        this.alterAlter = new AlterAlter(data);
        this.alterAdd = new AlterAdd(data);
    }

    @Override
    public void analyze() {
        if (data.validateLexeme("TABLE")){
            data.next();
            identifierStatus();
        } else {
            errorStatus("Se esperaba un token TABLE");
        }
    }

    private void identifierStatus(){
        if (data.validateName(TokenConstant.ID)){
            data.setModifiedTableName();
            data.next();
            alterTypeStatus();
        }  else {
            errorStatus("Se esperaba un Identificador");
        }
    }

    private void alterTypeStatus(){
        if (data.validateLexeme("ADD")){
            data.setModifiedTableKind();
            data.next();
            alterAdd.analyze();
        } else if (data.validateLexeme("DROP")) {
            data.setModifiedTableKind();
            data.next();
            columnStatus();
        } else if (data.validateLexeme("ALTER")) {
            data.setModifiedTableKind();
            data.next();
            alterAlter.analyze();
        } else {
            errorStatus("Secuencia de token invalido");
        }
    }

    private void columnStatus(){
        if (data.validateLexeme("COLUMN")){
            data.next();
            columnNameStatus();
        } else {
            errorStatus("Se esperaba un token COLUMN");
        }
    }

    private void columnNameStatus(){
        if (data.validateName(TokenConstant.ID)){
            data.setModifiedTableColumn();
            data.next();
            finalStatus();
        } else {
            errorStatus("Se esperaba un token Identificador");
        }
    }

    private void finalStatus(){
        if (data.validateLexeme(";")){
            data.saveModifiedTable();
            data.increaseAlters();
        } else {
            errorStatus("Se esperaba un token ;");
        }
    }
}