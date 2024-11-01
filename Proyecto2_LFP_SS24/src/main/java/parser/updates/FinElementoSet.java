package parser.updates;

import parser.DML.selects.AnalizadorWhere;
import parser.Data;
import parser.AnalizadorSintactico;

public class FinElementoSet extends AnalizadorSintactico {

    private final FinUpdate endUpdate;

    public FinElementoSet(Data data) {
        super(data);
        this.endUpdate = new FinUpdate(data);
    }

    @Override
    public void analyze() {
        if (data.validateLexeme(",")){
            data.next();
            AnalizadorElementoSet setElementAnalyzer = new AnalizadorElementoSet(data);
            setElementAnalyzer.analyze();
        } else if (data.validateLexeme(";")) {
            endUpdate.analyze();
        } else if (data.validateLexeme("WHERE")) {
            data.next();
            AnalizadorWhere whereAnalyzer = new AnalizadorWhere(data, endUpdate);
            whereAnalyzer.analyze();
        } else {
            errorStatus("Secuencia de token invalida");
        }
    }
}
