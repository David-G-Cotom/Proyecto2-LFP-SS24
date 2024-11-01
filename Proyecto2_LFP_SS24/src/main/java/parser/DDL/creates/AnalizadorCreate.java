package parser.DDL.creates;

import parser.Data;
import parser.AnalizadorSintactico;

public class AnalizadorCreate extends AnalizadorSintactico {
    
    public static final String KEYWORD = "CREATE";

    private final AnalizadorTabla analizadorTabla;
    private final AnalizadorDataBase analizadorDataBase;

    public AnalizadorCreate(Data data) {
        super(data);
        this.analizadorTabla = new AnalizadorTabla(data);
        this.analizadorDataBase = new AnalizadorDataBase(data);
    }

    @Override
    public void analyze() {
        if (data.validateLexeme(AnalizadorTabla.KEYWORD)){
            data.setTableKey();
            data.next();
            analizadorTabla.analyze();
        } else if (data.validateLexeme(AnalizadorDataBase.KEYWORD)){
            data.next();
            analizadorDataBase.analyze();
        } else {
            errorStatus();
        }
    }

    private void errorStatus(){
        data.addSyntaxError("se esperaba <"+AnalizadorTabla.KEYWORD+"> o <"+AnalizadorDataBase.KEYWORD+">");
    }
    
}
