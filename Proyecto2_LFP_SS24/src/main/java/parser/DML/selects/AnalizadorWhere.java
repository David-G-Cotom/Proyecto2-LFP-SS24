package parser.DML.selects;

import jflex.TokenConstant;
import parser.DML.inserts.AnalizadorData;
import parser.Data;
import parser.AnalizadorSintactico;


public class AnalizadorWhere extends AnalizadorSintactico {

    private final AnalizadorSintactico end;

    public AnalizadorWhere(Data data, AnalizadorSintactico endAnalyzer) {
        super(data);
        this.end = endAnalyzer;
    }

    @Override
    public void analyze() {
        DataEspecial specialData = new DataEspecial(data, new Comparacion(data, end));
        specialData.analyze();
    }

    private void mm (){
        if (data.validateName(TokenConstant.ID)){
            data.next();
            selectTypeStatus();
        } else {
            errorStatus("Se esperaba un token Identificador");
        }
    }

    private void selectTypeStatus(){
        if (data.validateLexeme("=")){
            data.next();
            IdentificadorWhere SimpleWhere = new IdentificadorWhere(data, end);
            SimpleWhere.analyze();
        } else if (data.validateName(TokenConstant.RELACIONAL)) {
            data.next();
            AnalizadorData dataAnalyzer = new AnalizadorData(data, new FinOperacionRelacional(data, end));
            dataAnalyzer.analyze();
        }
    }
}
