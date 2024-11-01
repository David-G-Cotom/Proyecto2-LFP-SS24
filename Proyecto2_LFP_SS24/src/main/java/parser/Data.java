package parser;

import java.util.ArrayList;
import jflex.Token;
import jflex.TokenConstant;

public class Data {

    private final ArrayList<Token> tokens;
    private final ArrayList<SyntaxError> syntaxErrors = new ArrayList<>();
    private final ArrayList<Table> tables = new ArrayList<>();
    private final ArrayList<ModifiedTable> modifiedTables = new ArrayList<>();

    private Table table;
    private ModifiedTable modifiedTable;
    private Column column;
    private int creates = 0;
    private int deletes = 0;
    private int updates = 0;
    private int inserts = 0;
    private int selects = 0;
    private int alters = 0;
    private int drops = 0;
    private int index = 0;
    private int stack = 0;

    public Data(ArrayList<Token> tokens) {
        this.tokens = tokens;
    }

    ////////////CONTROLADORES DE PILA//////////////
    public boolean isParenthesis() {
        if (validateLexeme("(")) {
            stack++;
        } else if (validateLexeme(")")) {
            if (stack < 0) {
                return false;
            } else {
                stack--;
            }
        } else {
            return false;
        }
        System.out.println("pila: " + stack);
        return true;
    }

    public boolean validateStackFinalState() {
        return (stack == 0);
    }

    public boolean identifierIdentifier() {
        if (validateName(TokenConstant.ID)) {
            next();
            if (validateLexeme(".")) {
                next();
                if (validateName(TokenConstant.ID)) {
                    return true;
                } else {
                    addSyntaxError("Se esperaba un token Identificador");
                }
            } else {
                addSyntaxError("Se esperaba un token .");
            }
        } else {
            addSyntaxError("Se esperaba un token Identificador");
        }
        return false;
    }

    //////////////////////
    /*Lectura de datos*/
    public boolean isData() {
        TokenConstant kind = currentToken().getTipoToken();
        return (kind == TokenConstant.ENTERO
                || kind == TokenConstant.DECIMAL
                || kind == TokenConstant.FECHA
                || kind == TokenConstant.CADENA
                || kind == TokenConstant.BOOLEAN);
    }

    public boolean isUpdateData() {
        TokenConstant kind = currentToken().getTipoToken();
        return (kind == TokenConstant.ENTERO
                || kind == TokenConstant.DECIMAL
                || kind == TokenConstant.FECHA
                || kind == TokenConstant.CADENA
                || kind == TokenConstant.BOOLEAN
                || kind == TokenConstant.ID);
    }

    public boolean isSpecialData() {
        TokenConstant kind = currentToken().getTipoToken();
        return (kind == TokenConstant.ENTERO
                || kind == TokenConstant.DECIMAL
                || kind == TokenConstant.FECHA
                || kind == TokenConstant.CADENA
                || kind == TokenConstant.BOOLEAN);
    }

    public boolean isOperator() {
        TokenConstant kind = currentToken().getTipoToken();
        return (kind == TokenConstant.ARITMETICO
                || kind == TokenConstant.RELACIONAL
                || validateLexeme("OR"));
    }

    /////////////////////////////////////
    /* Modificadores de Tabla*/
    public void setTableKey() {
        table = new Table();
        table.setKey(tokens.get(index - 1));
    }

    public void setTableName() {
        table.setName(currentToken());
    }

    public void saveTable() {
        tables.add(table);
        table = new Table();
    }

    /*Modificadores de Column*/
    public void newColumnAndPart() {
        column = new Column();
        column.addPart(currentToken());
    }

    public void saveColumn() {
        table.addColumn(column);
        column = new Column();
    }

    public void addPartColumn() {
        column.addPart(currentToken());
    }

    /* Modificadores de Tabla Modificada */
    public void setModifiedTableKey() {
        modifiedTable = new ModifiedTable();
        modifiedTable.setKey(currentToken());
    }

    public void saveModifiedTable() {
        modifiedTables.add(modifiedTable);
        modifiedTable = new ModifiedTable();
    }

    public void setModifiedTableName() {
        modifiedTable.setName(currentToken());
    }


    public void setModifiedTableKind(){
        modifiedTable.setKind(currentToken());
    }

    public void setModifiedTableColumn() {
        modifiedTable.setColumn(currentToken());
    }

    //validar si el token es el esperado
    public boolean validateLexeme(String lexeme) {
        return lexeme.equalsIgnoreCase(currentToken().getLexema());
    }

    //valida si un tipo de token esta entre paretesis
    public boolean validateName(TokenConstant name) {
        return currentToken().getTipoToken() == name;
    }

    //valida si un tipo de lexema esta entre parentesis
    public boolean betweenParenthesis(TokenConstant kind) {
        if (validateLexeme("(")) {
            next();
            if (validateName(kind)) {
                next();
                if (validateLexeme(")")) {
                    return true;
                } else {
                    addSyntaxError("Se esperaba un token )");
                    return false;
                }
            } else {
                addSyntaxError("Se esperaba un token " + kind);
                return false;
            }
        } else {
            addSyntaxError("Se esperaba un token (");
            return false;
        }
    }

    //avanzar en la lectura del arreglo
    public void next() {
        try {
            System.out.println("avanzando desde: " + currentToken().getLexema());
            do {
                index++;
            } while (currentToken().getTipoToken() == TokenConstant.COMENTARIO);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Se termino la lectura sintactica");
        }
    }

    public void back() {
        System.out.println("retrocediendo desde: " + currentToken().getLexema());
        do {
            index--;
        } while (currentToken().getTipoToken() == TokenConstant.COMENTARIO);
    }

    //aniadir el token actual a los errores
    public void addSyntaxError(String description) {
        System.out.println("se encontro un error " + description);
        stack = 0;
        syntaxErrors.add(new SyntaxError(currentToken(), description));
    }

    //obtener el token actual
    public Token currentToken() {
        try {
            return tokens.get(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Se termino la lectura sintactica");
            return new Token(TokenConstant.ERROR, -1, -1, "TERMINO");
        }
    }

    //AUMENTAR CONTADORES
    public void increaseCreates() {
        creates++;
        System.out.println("se encontro una produccion de CREATE");
    }

    public void increaseAlters() {
        System.out.println("Se encontro una produccion de ALTER");
        alters++;
    }
    
    public void increaseDrops() {
        System.out.println("se encontro una produccion de DROP");
        drops++;
    }

    public void increaseSelects() {
        selects++;
        System.out.println("Se encontro una produccion de SELECT");
    }
    
    public void increaseInserts() {
        System.out.println("se encontro un produccion de INSERT");
        inserts++;
    }

    public void increaseUpdates() {
        System.out.println("se encontro un produccion de UPDATE");
        updates++;
    }

    public void increaseDeletes() {
        System.out.println("se encontro un produccion de DELETE");
        deletes++;
    }

    //GETTERS DE LAS VARIABLES
    public int getAlters() {
        return alters;
    }

    public int getSelects() {
        return selects;
    }
    
    public int getInserts() {
        return inserts;
    }

    public int getUpdates() {
        return updates;
    }

    public int getDeletes() {
        return deletes;
    }
    
    public int getDrops() {
        return drops;
    }

    public int getCreates() {
        return creates;
    }

    public ArrayList<Token> getTokens() {
        return tokens;
    }

    public ArrayList<ModifiedTable> getModifiedTables() {
        return modifiedTables;
    }

    public ArrayList<Table> getTables() {
        return tables;
    }

    public ArrayList<SyntaxError> getSyntaxErrors() {
        return syntaxErrors;
    }

}
