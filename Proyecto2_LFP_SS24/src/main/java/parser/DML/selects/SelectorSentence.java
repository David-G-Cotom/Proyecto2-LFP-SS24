package parser.DML.selects;

import jflex.TokenConstant;
import parser.Data;
import parser.AnalizadorSintactico;


public class SelectorSentence extends AnalizadorSintactico {

    public SelectorSentence(Data data) {
        super(data);
    }

    @Override
    public void analyze() {
        if (data.validateName(TokenConstant.ID)){
            data.next();
            selectSentenceStatus();
        } else {
            errorStatus("Se esperaba un token Identificador");
        }
    }

    public void selectSentenceStatus(){
        if (data.validateLexeme("JOIN")){
            data.next();
            AnalizadorJoin joinAnalyzer = new AnalizadorJoin(data);
            joinAnalyzer.analyze();
        } else if (data.validateLexeme("WHERE")) {
            data.next();
            AnalizadorWhere whereAnalyzer = new AnalizadorWhere(data, new FinAnalizadorSelect(data));
            whereAnalyzer.analyze();
        } else if (data.validateLexeme("GROUP")) {
            data.next();
            AnalizadorGroupBy groupByAnalyzer = new AnalizadorGroupBy(data);
            groupByAnalyzer.analyze();
        } else if (data.validateLexeme("ORDER")) {
            data.next();
            AnalizadorOrderBy orderByAnalyzer = new AnalizadorOrderBy(data);
            orderByAnalyzer.analyze();
        } else if (data.validateLexeme("LIMIT")) {
            data.next();
            AnalizadorLimit limitAnalyzer = new AnalizadorLimit(data);
            limitAnalyzer.analyze();
        } else{
            FinAnalizadorSelect endSelectAnalyzer = new FinAnalizadorSelect(data);
            endSelectAnalyzer.analyze();
        }
    }
}
