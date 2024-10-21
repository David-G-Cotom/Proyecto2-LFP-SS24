
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
    yyline = 1;
    yycolumn = 1;
%init}

%%

<YYINITIAL> "CREATE" {return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "DATABASE" {return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "TABLE" {return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "KEY" {return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "NULL" {return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "PRIMARY" {return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "UNIQUE" {return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "FOREIGN" {return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "REFERENCES" {return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "ALTER" {return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "ADD" {return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "COLUMN" {return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "TYPE" {return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "DROP" {return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "CONSTRAINT" {return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "IF" {return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "EXIST" {return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "CASCADE" {return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "ON" {return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "DELETE" {return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "SET" {return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "UPDATE" {return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "INSERT" {return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "INTO" {return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "VALUES" {return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "SELECT" {return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "FROM" {return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "WHERE" {return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "AS" {return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "GROUP" {return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "ORDER" {return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "BY" {return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "ASC" {return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "DESC" {return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "LIMIT" {return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}
<YYINITIAL> "JOIN" {return new Token(TokenConstant.CREATE, yyline, yycolumn, yytext());}

<YYINITIAL> "INTEGER" {return new Token(TokenConstant.TIPO_DATO, yyline, yycolumn, yytext());}
<YYINITIAL> "BIGINT" {return new Token(TokenConstant.TIPO_DATO, yyline, yycolumn, yytext());}
<YYINITIAL> "VARCHAR" {return new Token(TokenConstant.TIPO_DATO, yyline, yycolumn, yytext());}
<YYINITIAL> "DECIMAL" {return new Token(TokenConstant.TIPO_DATO, yyline, yycolumn, yytext());}
<YYINITIAL> "DATE" {return new Token(TokenConstant.TIPO_DATO, yyline, yycolumn, yytext());}
<YYINITIAL> "TEXT" {return new Token(TokenConstant.TIPO_DATO, yyline, yycolumn, yytext());}
<YYINITIAL> "BOOLEAN" {return new Token(TokenConstant.TIPO_DATO, yyline, yycolumn, yytext());}
<YYINITIAL> "SERIAL" {return new Token(TokenConstant.TIPO_DATO, yyline, yycolumn, yytext());}

<YYINITIAL> {NUMERO}+ {return new Token(TokenConstant.ENTERO, yyline, yycolumn, yytext());}
<YYINITIAL> {DECIMAL} {return new Token(TokenConstant.DECIMAL, yyline, yycolumn, yytext());}

<YYINITIAL> "'"{NUMERO}{NUMERO}{NUMERO}{NUMERO}"-"{NUMERO}{NUMERO}"-"{NUMERO}{NUMERO}"'" {return new Token(TokenConstant.FECHA, yyline, yycolumn, yytext());}

<YYINITIAL> "'".*"'" {return new Token(TokenConstant.CADENA, yyline, yycolumn, yytext());}

<YYINITIAL> {LETRA_MINUSCULA}+({LETRA_MINUSCULA}|[_]|{NUMERO})* {return new Token(TokenConstant.ID, yyline, yycolumn, yytext());}

<YYINITIAL> "TRUE" {return new Token(TokenConstant.BOOLEAN, yyline, yycolumn, yytext());}
<YYINITIAL> "FALSE" {return new Token(TokenConstant.BOOLEAN, yyline, yycolumn, yytext());}

<YYINITIAL> "SUM" {return new Token(TokenConstant.FUNCION_AGREGACION, yyline, yycolumn, yytext());}
<YYINITIAL> "AVG" {return new Token(TokenConstant.FUNCION_AGREGACION, yyline, yycolumn, yytext());}
<YYINITIAL> "COUNT" {return new Token(TokenConstant.FUNCION_AGREGACION, yyline, yycolumn, yytext());}
<YYINITIAL> "MAX" {return new Token(TokenConstant.FUNCION_AGREGACION, yyline, yycolumn, yytext());}
<YYINITIAL> "MIN" {return new Token(TokenConstant.FUNCION_AGREGACION, yyline, yycolumn, yytext());}

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

<YYINITIAL> "AND" {return new Token(TokenConstant.LOGICO, yyline, yycolumn, yytext());}
<YYINITIAL> "OR" {return new Token(TokenConstant.LOGICO, yyline, yycolumn, yytext());}
<YYINITIAL> "NOT" {return new Token(TokenConstant.LOGICO, yyline, yycolumn, yytext());}

<YYINITIAL> "-"" ""-".* {return new Token(TokenConstant.COMENTARIO, yyline, yycolumn, yytext());}


<YYINITIAL> {ESPACIO} {}
