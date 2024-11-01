package parser;

import jflex.TokenConstant;
import parser.DDL.creates.AnalizadorCreate;
import parser.DDL.modifiers.AltersAnalyzer;
import parser.DDL.modifiers.DropAnalyze;
import parser.DML.inserts.AnalizadorInsert;
import parser.DML.selects.AnalizadorSelect;
import parser.deletes.AnalizadorDelete;
import parser.updates.AnalizadorUpdate;


public class StateAnalyzer {

    private final AltersAnalyzer altersAnalyzer;
    private final AnalizadorCreate createAnalyzer;
    private final AnalizadorDelete deleteAnalyzer;
    private final AnalizadorInsert insertAnalyzer;
    private final AnalizadorSelect selectAnalyzer;
    private final AnalizadorUpdate updateAnalyzer;
    private final DropAnalyze dropAnalyzer;
    private final Data data;
    public StateAnalyzer(Data data) {
        this.data = data;
        this.altersAnalyzer = new AltersAnalyzer(data);
        this.createAnalyzer = new AnalizadorCreate(data);
        this.deleteAnalyzer = new AnalizadorDelete(data);
        this.insertAnalyzer = new AnalizadorInsert(data);
        this.selectAnalyzer = new AnalizadorSelect(data);
        this.updateAnalyzer = new AnalizadorUpdate(data);
        this.dropAnalyzer = new DropAnalyze(data);
    }

    public void analyze() throws SyntaxException{
        validateStates();
    }

    private void validateStates() throws SyntaxException{
        if (data.validateLexeme(AltersAnalyzer.KEYWORD)) {
            data.setModifiedTableKey();
            data.next();
            altersAnalyzer.analyze();
            data.next();
            validateStates();
        } else if (data.validateLexeme(AnalizadorCreate.KEYWORD)) {
            data.next();
            createAnalyzer.analyze();
            data.next();
            validateStates();
        } else if (data.validateLexeme(AnalizadorDelete.KEYWORD)) {
            data.next();
            deleteAnalyzer.analyze();
            data.next();
            validateStates();
        } else if (data.validateLexeme(AnalizadorInsert.KEYWORD)) {
            data.next();
            insertAnalyzer.analyze();
            data.next();
            validateStates();
        } else if (data.validateLexeme(AnalizadorSelect.KEYWORD)) {
            data.next();
            selectAnalyzer.analyze();
            data.next();
            validateStates();
        } else if (data.validateLexeme(AnalizadorUpdate.KEYWORD)) {
            data.next();
            updateAnalyzer.analyze();
            data.next();
            validateStates();
        } else if (data.validateLexeme(DropAnalyze.KEYWORD)) {
            data.setModifiedTableKey();
            data.next();
            dropAnalyzer.analyze();
            data.next();
            validateStates();
        } else {
            errorState();
        }
    }

    private void errorState() throws SyntaxException{
        validateFinal();
        data.addSyntaxError("Secuencia de token invalida !!");
        data.next();
        validateStates();
    }

    private void validateFinal() throws SyntaxException{
        if (data.currentToken().getTipoToken() == TokenConstant.ERROR) {
            System.out.println("La lectura sintactica ha finalizado");
            throw new SyntaxException("La lectura ha finalizado");
        }
    }
}
