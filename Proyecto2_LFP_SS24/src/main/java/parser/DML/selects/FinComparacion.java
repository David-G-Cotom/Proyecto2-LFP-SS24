package parser.DML.selects;

import jflex.TokenConstant;
import parser.Data;
import parser.AnalizadorSintactico;


public class FinComparacion extends AnalizadorSintactico {

    private final AnalizadorSintactico end;

    public FinComparacion(Data data, AnalizadorSintactico end) {
        super(data);
        this.end = end;
    }

    @Override
    public void analyze() {
        if (data.validateName(TokenConstant.LOGICO)){
            data.next();
            DataEspecial specialData = new DataEspecial(data, new Comparacion(data, end));
            specialData.analyze();
        } else {
            if (data.validateStackFinalState()){
                end.analyze();
            } else {
                errorStatus("Secuencia de token invalida parentesis abiertos");
            }
        }
    }
}
