package parser.DDL.creates;

import parser.Data;
import parser.AnalizadorSintactico;

public class FinDeclaracion extends AnalizadorSintactico {

    private final AnalizadorContenidoTabla analizadorContenidoTabla;

    public FinDeclaracion(Data data) {
        super(data);
        analizadorContenidoTabla = new AnalizadorContenidoTabla(data);
    }

    @Override
    public void analyze() {
        if (data.validateLexeme("PRIMARY")){
            data.addPartColumn();
            data.next();
            primaryStatus();
        } else if (data.validateLexeme("NOT")){
            data.addPartColumn();
            data.next();
            notStatus();
        } else if (data.validateLexeme("UNIQUE")){
            data.addPartColumn();
            data.next();
            quoteStatus();
        } else if (data.validateLexeme(",")){
            data.saveColumn();
            quoteStatus();
        } else if (data.validateLexeme(")")){
            data.next();
            endTable();
        }else{
            data.addSyntaxError("Secuencia de token invalida");
        }
    }

    private void primaryStatus(){
        if (data.validateLexeme("KEY")){
            data.addPartColumn();
            data.next();
            quoteStatus();
        } else {
            data.addSyntaxError("Se esperaba un token: KEY");
        }
    }

    private void notStatus(){
        if (data.validateLexeme("NULL")){
            data.addPartColumn();
            data.next();
            quoteStatus();
        } else {
            data.addSyntaxError("Se esperaba un token: NULL");
        }
    }

    private void quoteStatus(){
        if (data.validateLexeme(",")){
            data.saveColumn();
            data.next();
            finalStatus();
        } else if (data.validateLexeme(")")){
            data.next();
            endTable();
        }else{
            data.addSyntaxError("Se esperaba un token: ,");
        }
    }

    private void finalStatus(){
        data.saveColumn();
        analizadorContenidoTabla.analyze();
    }

    private void endTable(){
        if (data.validateLexeme(";")){
            data.saveColumn();
            data.saveTable();
            data.increaseCreates();
        } else {
            data.addSyntaxError("Se esperaba un token: ;");
        }
    }
}
