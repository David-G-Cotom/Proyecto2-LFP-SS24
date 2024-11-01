package parser;


import java.util.ArrayList;
import java.util.List;
import jflex.Token;

public class Column {
    private final List<Token> parts = new ArrayList<>();

    public void addPart(Token token) {
        parts.add(token);
    }

    public void reset(){
        parts.clear();
    }

    public List<Token> getParts() {
        return parts;
    }
}
