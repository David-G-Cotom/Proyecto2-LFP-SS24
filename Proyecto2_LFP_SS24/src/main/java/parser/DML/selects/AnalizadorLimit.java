package parser.DML.selects;

import jflex.TokenConstant;
import parser.Data;
import parser.AnalizadorSintactico;


public class AnalizadorLimit extends AnalizadorSintactico {

    private final FinAnalizadorSelect endSelectAnalyzer;

    public AnalizadorLimit(Data data) {
        super(data);
        this.endSelectAnalyzer = new FinAnalizadorSelect(data);
    }

    @Override
    public void analyze() {
        if (data.validateName(TokenConstant.ENTERO)){
            data.next();
            endSelectAnalyzer.analyze();
        } else {
            errorStatus("Se esperaba un token Entero");
        }
    }
}
