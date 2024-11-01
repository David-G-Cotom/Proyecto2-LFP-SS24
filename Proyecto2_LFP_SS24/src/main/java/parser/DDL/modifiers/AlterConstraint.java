package parser.DDL.modifiers;

import jflex.TokenConstant;
import parser.DDL.creates.AnalizadorTipoDato;
import parser.DDL.creates.AnalizadorEstructuraKey;
import parser.Data;
import parser.AnalizadorSintactico;

public class AlterConstraint extends AnalizadorSintactico {

    public AlterConstraint(Data data) {
        super(data);
    }

    @Override
    public void analyze() {
        if (data.validateName(TokenConstant.ID)){
            data.setModifiedTableColumn();
            data.next();
            finalStatus();
        } else{
            errorStatus("Se esperaba un token Identificador");
        }
    }

    private void finalStatus(){
        if (data.validateName(TokenConstant.TIPO_DATO)){
            AnalizadorTipoDato dataTypeAnalyzer = new AnalizadorTipoDato(data, new EndAlter(data), false);
            dataTypeAnalyzer.analyze();
        } else if (data.validateLexeme("UNIQUE")) {
            data.next();
            ConstraintUnique constraintUnique = new ConstraintUnique(data);
            constraintUnique.analyze();
        } else if (data.validateLexeme("FOREIGN")) {
            data.back();
            AnalizadorEstructuraKey keyStructureAnalyze = new AnalizadorEstructuraKey(data, new EndAlter(data));
            keyStructureAnalyze.analyze();

        } else {
            errorStatus("Se de token invalida");
        }
    }
}
