package parser.DDL.modifiers;

import parser.Data;
import parser.ModifiedTable;
import parser.AnalizadorSintactico;


public class AlterAddConstraint extends AnalizadorSintactico {

    private final ModifiedTable modifiedTable;

    public AlterAddConstraint(Data data, ModifiedTable modifiedTable) {
        super(data);
        this.modifiedTable = modifiedTable;
    }

    @Override
    public void analyze() {

    }
}
