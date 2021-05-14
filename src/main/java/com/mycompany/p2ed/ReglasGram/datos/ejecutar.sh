echo "STARTING JFLEX COMPILING"
java -jar ../jflex-full-1.8.2.jar lexerDatos.flex
echo "STARTING CUP COMPILING"
java -jar ../java-cup-11b.jar -parser ParserDatos -symbols symDatos parserDatos.cup
echo "PRESIONE ENTER PARA SALIR"
 read -p "$*"