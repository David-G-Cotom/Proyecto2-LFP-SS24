package parser.updates;

import jflex.TokenConstant;
import parser.Data;
import parser.AnalizadorSintactico;


public class AnalizadorUpdate extends AnalizadorSintactico {
    public static final String KEYWORD = "UPDATE";

    public AnalizadorUpdate(Data data) {
        super(data);
    }

    @Override
    public void analyze() {
        if (data.validateName(TokenConstant.ID)){
            data.next();
            setStatus();
        } else {
            errorStatus("Se esperaba un token Identificador");
        }
    }

    private void setStatus(){
        if (data.validateLexeme("SET")){
            data.next();
            AnalizadorElementoSet setElementAnalyzer = new AnalizadorElementoSet(data);
            setElementAnalyzer.analyze();
        } else {
            errorStatus("Se esperaba un token SET");
        }
    }
}
