
package jflex;

//importaciones

%%

//configuracion de jflex
%public
%class AnalizadorLexico
%char
%unicode
%line
%column
%ignorecase
%standalone

%type Token

//expresiones regulares
PALABRA = [a-zA-Z]+
LETRA_MINUSCULA = [a-z]
LETRA_MAYUSCULA = [A-Z]
NUMERO = [0-9]
DECIMAL = [0-9]+"."[0-9]+
ESPACIO = [" "\r\t\n\f]

//codigo cuando es fin de archivo
%eofval{
    return new Token(TokenConstant.EOF, -1, -1, null);
%eofval}

%init{
    yyline = 0;
    yycolumn = 0;
%init}

%{
    public PintorPalabra pintor = new PintorPalabra();
%}

%%

<YYINITIAL> "CREATE" {pintor.pintarNaranja((int)yychar, yylength()); return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "DATABASE" {pintor.pintarNaranja((int)yychar, yylength()); return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "TABLE" {pintor.pintarNaranja((int)yychar, yylength()); return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "KEY" {pintor.pintarNaranja((int)yychar, yylength()); return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "NULL" {pintor.pintarNaranja((int)yychar, yylength()); return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "PRIMARY" {pintor.pintarNaranja((int)yychar, yylength()); return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "UNIQUE" {pintor.pintarNaranja((int)yychar, yylength()); return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "FOREIGN" {pintor.pintarNaranja((int)yychar, yylength()); return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "REFERENCES" {pintor.pintarNaranja((int)yychar, yylength()); return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "ALTER" {pintor.pintarNaranja((int)yychar, yylength()); return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "ADD" {pintor.pintarNaranja((int)yychar, yylength()); return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "COLUMN" {pintor.pintarNaranja((int)yychar, yylength()); return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "TYPE" {pintor.pintarNaranja((int)yychar, yylength()); return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "DROP" {pintor.pintarNaranja((int)yychar, yylength()); return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "CONSTRAINT" {pintor.pintarNaranja((int)yychar, yylength()); return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "IF" {pintor.pintarNaranja((int)yychar, yylength()); return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "EXIST" {pintor.pintarNaranja((int)yychar, yylength()); return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "CASCADE" {pintor.pintarNaranja((int)yychar, yylength()); return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "ON" {pintor.pintarNaranja((int)yychar, yylength()); return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "DELETE" {pintor.pintarNaranja((int)yychar, yylength()); return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "SET" {pintor.pintarNaranja((int)yychar, yylength()); return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "UPDATE" {pintor.pintarNaranja((int)yychar, yylength()); return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "INSERT" {pintor.pintarNaranja((int)yychar, yylength()); return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "INTO" {pintor.pintarNaranja((int)yychar, yylength()); return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "VALUES" {pintor.pintarNaranja((int)yychar, yylength()); return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "SELECT" {pintor.pintarNaranja((int)yychar, yylength()); return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "FROM" {pintor.pintarNaranja((int)yychar, yylength()); return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "WHERE" {pintor.pintarNaranja((int)yychar, yylength()); return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "AS" {pintor.pintarNaranja((int)yychar, yylength()); return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "GROUP" {pintor.pintarNaranja((int)yychar, yylength()); return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "ORDER" {pintor.pintarNaranja((int)yychar, yylength()); return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "BY" {pintor.pintarNaranja((int)yychar, yylength()); return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "ASC" {pintor.pintarNaranja((int)yychar, yylength()); return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "DESC" {pintor.pintarNaranja((int)yychar, yylength()); return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "LIMIT" {pintor.pintarNaranja((int)yychar, yylength()); return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "JOIN" {pintor.pintarNaranja((int)yychar, yylength()); return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}

<YYINITIAL> "INTEGER" {pintor.pintarMorado((int)yychar, yylength()); return new Token(TokenConstant.TIPO_DATO, yyline, yycolumn, yytext());}
<YYINITIAL> "BIGINT" {pintor.pintarMorado((int)yychar, yylength()); return new Token(TokenConstant.TIPO_DATO, yyline, yycolumn, yytext());}
<YYINITIAL> "VARCHAR" {pintor.pintarMorado((int)yychar, yylength()); return new Token(TokenConstant.TIPO_DATO, yyline, yycolumn, yytext());}
<YYINITIAL> "DECIMAL" {pintor.pintarMorado((int)yychar, yylength()); return new Token(TokenConstant.TIPO_DATO, yyline, yycolumn, yytext());}
<YYINITIAL> "DATE" {pintor.pintarMorado((int)yychar, yylength()); return new Token(TokenConstant.TIPO_DATO, yyline, yycolumn, yytext());}
<YYINITIAL> "TEXT" {pintor.pintarMorado((int)yychar, yylength()); return new Token(TokenConstant.TIPO_DATO, yyline, yycolumn, yytext());}
<YYINITIAL> "BOOLEAN" {pintor.pintarMorado((int)yychar, yylength()); return new Token(TokenConstant.TIPO_DATO, yyline, yycolumn, yytext());}
<YYINITIAL> "SERIAL" {pintor.pintarMorado((int)yychar, yylength()); return new Token(TokenConstant.TIPO_DATO, yyline, yycolumn, yytext());}

<YYINITIAL> "TRUE" {pintor.pintarAzul((int)yychar, yylength()); return new Token(TokenConstant.BOOLEAN, yyline, yycolumn, yytext());}
<YYINITIAL> "FALSE" {pintor.pintarAzul((int)yychar, yylength()); return new Token(TokenConstant.BOOLEAN, yyline, yycolumn, yytext());}

<YYINITIAL> "SUM" {pintor.pintarAzul((int)yychar, yylength()); return new Token(TokenConstant.FUNCION_AGREGACION, yyline, yycolumn, yytext());}
<YYINITIAL> "AVG" {pintor.pintarAzul((int)yychar, yylength()); return new Token(TokenConstant.FUNCION_AGREGACION, yyline, yycolumn, yytext());}
<YYINITIAL> "COUNT" {pintor.pintarAzul((int)yychar, yylength()); return new Token(TokenConstant.FUNCION_AGREGACION, yyline, yycolumn, yytext());}
<YYINITIAL> "MAX" {pintor.pintarAzul((int)yychar, yylength()); return new Token(TokenConstant.FUNCION_AGREGACION, yyline, yycolumn, yytext());}
<YYINITIAL> "MIN" {pintor.pintarAzul((int)yychar, yylength()); return new Token(TokenConstant.FUNCION_AGREGACION, yyline, yycolumn, yytext());}

<YYINITIAL> "AND" {pintor.pintarNaranja((int)yychar, yylength()); return new Token(TokenConstant.LOGICO, yyline, yycolumn, yytext());}
<YYINITIAL> "OR" {pintor.pintarNaranja((int)yychar, yylength()); return new Token(TokenConstant.LOGICO, yyline, yycolumn, yytext());}
<YYINITIAL> "NOT" {pintor.pintarNaranja((int)yychar, yylength()); return new Token(TokenConstant.LOGICO, yyline, yycolumn, yytext());}

<YYINITIAL> {NUMERO}+ {pintor.pintarAzul((int)yychar, yylength()); return new Token(TokenConstant.ENTERO, yyline, yycolumn, yytext());}
<YYINITIAL> {DECIMAL} {pintor.pintarAzul((int)yychar, yylength()); return new Token(TokenConstant.DECIMAL, yyline, yycolumn, yytext());}

<YYINITIAL> "'"{NUMERO}{NUMERO}{NUMERO}{NUMERO}"-"{NUMERO}{NUMERO}"-"{NUMERO}{NUMERO}"'" {pintor.pintarAmarillo((int)yychar, yylength()); return new Token(TokenConstant.FECHA, yyline, yycolumn, yytext());}

<YYINITIAL> "'".*"'" {pintor.pintarVerde((int)yychar, yylength()); return new Token(TokenConstant.CADENA, yyline, yycolumn, yytext());}

<YYINITIAL> {LETRA_MINUSCULA}+({LETRA_MINUSCULA}|[_]|{NUMERO})* {pintor.pintarFucsia((int)yychar, yylength()); return new Token(TokenConstant.ID, yyline, yycolumn, yytext());}

<YYINITIAL> "(" {return new Token(TokenConstant.SIGNO, yyline, yycolumn, yytext());}
<YYINITIAL> ")" {return new Token(TokenConstant.SIGNO, yyline, yycolumn, yytext());}
<YYINITIAL> "," {return new Token(TokenConstant.SIGNO, yyline, yycolumn, yytext());}
<YYINITIAL> ";" {return new Token(TokenConstant.SIGNO, yyline, yycolumn, yytext());}
<YYINITIAL> "." {return new Token(TokenConstant.SIGNO, yyline, yycolumn, yytext());}
<YYINITIAL> "=" {return new Token(TokenConstant.SIGNO, yyline, yycolumn, yytext());}

<YYINITIAL> "+" {return new Token(TokenConstant.ARITMETICO, yyline, yycolumn, yytext());}
<YYINITIAL> "-" {return new Token(TokenConstant.ARITMETICO, yyline, yycolumn, yytext());}
<YYINITIAL> "*" {return new Token(TokenConstant.ARITMETICO, yyline, yycolumn, yytext());}
<YYINITIAL> "/" {return new Token(TokenConstant.ARITMETICO, yyline, yycolumn, yytext());}

<YYINITIAL> "<" {return new Token(TokenConstant.RELACIONAL, yyline, yycolumn, yytext());}
<YYINITIAL> ">" {return new Token(TokenConstant.RELACIONAL, yyline, yycolumn, yytext());}
<YYINITIAL> "<=" {return new Token(TokenConstant.RELACIONAL, yyline, yycolumn, yytext());}
<YYINITIAL> ">=" {return new Token(TokenConstant.RELACIONAL, yyline, yycolumn, yytext());}

<YYINITIAL> "-"" ""-".* {pintor.pintarGris((int)yychar, yylength()); return new Token(TokenConstant.COMENTARIO, yyline, yycolumn, yytext());}

<YYINITIAL> {ESPACIO} {}
