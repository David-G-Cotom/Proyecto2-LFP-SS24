package parser.DML.selects;

import jflex.TokenConstant;
import parser.Data;
import parser.AnalizadorSintactico;


public class Comparacion extends AnalizadorSintactico {

    private final AnalizadorSintactico end;

    public Comparacion(Data data, AnalizadorSintactico end) {
        super(data);
        this.end = end;
    }

    @Override
    public void analyze() {
        if (data.validateName(TokenConstant.RELACIONAL) || data.validateLexeme("=")){
            data.next();
            DataEspecial specialData = new DataEspecial(data, new FinComparacion(data, end));
            specialData.analyze();
        } else {
            errorStatus("Se esperaba un token de comparacion");
        }
    }
}
