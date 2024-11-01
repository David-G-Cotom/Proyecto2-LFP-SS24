package parser;

import java.util.ArrayList;
import java.util.List;
import jflex.Token;

public class Table {

    private final List<Column> columns = new ArrayList<>();
    protected Token key;
    protected Token name;

    @Override
    public String toString() {

        String columnsString = "vacio\n";
        for (Column column : columns) {
            for ( Token toke: column.getParts()){
                columnsString += toke.getLexema();
            }
        }
        return "nombre: "+ name +" \n columns: "+ columnsString;
    }

    public void reset(){
        name = null;
        key = null;
        columns.clear();
    }

    public void setKey(Token token){
        key = token;
    }

    public Token getKey(){
        return key;
    }

    public void setName(Token name) {
        this.name = name;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void addColumn(Column column) {
        columns.add(column);
    }

    public Token getName() {
        return name;
    }
}
