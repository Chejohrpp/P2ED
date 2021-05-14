/*codigo de usuario*/
package com.mycompany.p2ed.ReglasGram.datos;
import com.mycompany.p2ed.ReglasGram.Token;
import java_cup.runtime.*;
import static com.mycompany.p2ed.ReglasGram.datos.symDatos.*;
import java.util.ArrayList;
import java.util.List;

%%
/*configuracion*/
%class LexerDatos
%public
%unicode
%line
%column
%cup
entero = [0-9]+
string = [\"]([^\"])*[\"]
string_otras = [\“]([^\”])*[\”]
letra = [a-zA-Z]
cadena = ({letra}|{entero})+
lineTerminator = \r|\n|\r\n
whiteSpace     = {lineTerminator} | [ \t\f]

%{
     List<String> errores = new ArrayList<String>();

     private String quitarComillas(String text){
		return text.replace("\"","");
	}
	private String quitarOtrasComillas(String text){
		text = text.replace("“","");
		text.replace("”","");
		return text;
	}
     private void estructuraError(String charError, int linea, int columna){
     	String elError = "Error: No se reconoce el caracter: " + charError + " -> {Linea: "+ linea +", Columna: "+ columna +" }" ;
     	errores.add(elError);
     }
     public List getErroresLexicos(){
     	return errores;
     }
%}

%eofval{
  return new java_cup.runtime.Symbol(symDatos.EOF);
%eofval}


%%
/*reglas*/	

/*palabras clave*/
<YYINITIAL> "Estudiante"			{return new Symbol(ESTUDIANTE,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1 )); }
<YYINITIAL> "Usuario"				{return new Symbol(USUARIO,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1 )); }
<YYINITIAL> "Catedratico"			{return new Symbol(CATEDRATICO,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1 )); }
<YYINITIAL> "Edificio"				{return new Symbol(EDIFICIO,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1 )); }
<YYINITIAL> "Salon"					{return new Symbol(SALON,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1 )); }
<YYINITIAL> "Curso"					{return new Symbol(CURSO,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1 )); }
<YYINITIAL> "Horario"				{return new Symbol(HORARIO,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1 )); }
<YYINITIAL> "Asignar"				{return new Symbol(ASIGNAR,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1 )); }

/*tipos*/
<YYINITIAL> "estudiante"			{return new Symbol(ESTUDIANTE,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1 )); }
<YYINITIAL> "colaborador"			{return new Symbol(COLABORADOR,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1 )); }

<YYINITIAL>{
	
	/*cadenas*/
	{entero}				{return new Symbol(NUMERO,yyline+1,yycolumn+1,new Token(yytext(),yyline+1,yycolumn+1 ));}
	{string}				{return new Symbol(STRING,yyline+1,yycolumn+1,new Token(quitarComillas(yytext()),yyline+1,yycolumn+1 ));}
	{cadena}				{return new Symbol(CADENA,yyline+1,yycolumn+1,new Token(yytext(),yyline+1,yycolumn+1 ));}
	{string_otras}			{return new Symbol(STRING,yyline+1,yycolumn+1,new Token(quitarOtrasComillas(yytext()),yyline+1,yycolumn+1 ));}
	/*SIMBOLOS*/
	"("									{return new Symbol(PAI,yyline+1,yycolumn+1,new Token(yytext(),yyline+1,yycolumn+1 ));}
	")"									{return new Symbol(PAD,yyline+1,yycolumn+1,new Token(yytext(),yyline+1,yycolumn+1 ));}
	","									{return new Symbol(COMA,yyline+1,yycolumn+1,new Token(yytext(),yyline+1,yycolumn+1 ));}
	";"									{return new Symbol(SEMI,yyline+1,yycolumn+1,new Token(yytext(),yyline+1,yycolumn+1 ));}

	/* espacios en blanco */
	{whiteSpace}                   		{ /* ignorar */ }
}

[^]										{return new Symbol(INVALID,yyline+1,yycolumn+1,new Token(yytext(),yyline+1,yycolumn+1 ));}