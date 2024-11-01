package parser.DDL.creates;

import jflex.TokenConstant;
import parser.Data;
import parser.AnalizadorSintactico;

public class AnalizadorContenidoTabla extends AnalizadorSintactico {

    private final AnalizadorEstructuraKey analizadorEstructuraKey;

    public AnalizadorContenidoTabla(Data data) {
        super(data);
        this.analizadorEstructuraKey = new AnalizadorEstructuraKey(data, new FinAnalizadorTabla(data));
    }

    @Override
    public void analyze() {
        if (data.validateName(TokenConstant.ID)){
            data.newColumnAndPart();
            data.next();
            AnalizadorTipoDato dataTypeAnalyzer = new AnalizadorTipoDato(data, new FinDeclaracion(data), true);
            dataTypeAnalyzer.analyze();
        } else if (data.validateLexeme("CONSTRAINT")){
            data.next();
            analizadorEstructuraKey.analyze();
        } else {
            data.addSyntaxError("Secuencia de token invalida se espera un Identificador o CONSTRAINT");
        }
    }
}
