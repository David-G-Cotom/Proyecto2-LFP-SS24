package parser.DDL.creates;

import jflex.TokenConstant;
import parser.Data;
import parser.AnalizadorSintactico;

public class AnalizadorDataBase extends AnalizadorSintactico {

    public static final String KEYWORD = "DATABASE";

    public AnalizadorDataBase(Data data) {
        super(data);
    }

    @Override
    public void analyze() {
        if (data.validateName(TokenConstant.ID)){
            data.next();
            idetificarStatus();
        } else {
            errorStatus("se esperaba un token: Identificador");
        }
    }

    private void idetificarStatus(){
        if (data.validateLexeme(";")){
            data.increaseCreates();
        }
    }

}
