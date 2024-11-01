package parser.deletes;

import jflex.TokenConstant;
import parser.DML.selects.AnalizadorWhere;
import parser.Data;
import parser.AnalizadorSintactico;


public class AnalizadorDelete extends AnalizadorSintactico {

    public static final String  KEYWORD = "DELETE";

    private final FinDelete end;

    public AnalizadorDelete(Data data) {
        super(data);
        end = new FinDelete(data);
    }

    @Override
    public void analyze() {
        if (data.validateLexeme("FROM")){
            data.next();
            identifierStatus();
        } else {
            errorStatus("Se esperaba un token FROM");
        }
    }

    private void identifierStatus(){
        if (data.validateName(TokenConstant.ID)){
            data.next();
            selectStatus();
        } else {
            errorStatus("Se esperaba un token Identificador");
        }
    }

    private void selectStatus(){
        if (data.validateLexeme(";")){
            end.analyze();
        } else if (data.validateLexeme("WHERE")) {
            data.next();
            AnalizadorWhere whereAnalyzer = new AnalizadorWhere(data, end);
            whereAnalyzer.analyze();
        } else {
            errorStatus("Se esperaba un token WHERE o ;");
        }
    }
}
