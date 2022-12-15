# WaterSortPuzzle
WaterSort Puzzle implementado en Java

Consta de 4 clases: 
-ES
ES simplifica el I/O estándar.
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-Juego
Juego es la clase principal donde se ejecuta el programa con un pequeño menú.
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-TableroDeJuego
TableroDeJuego implementa un tablero con tubos que contienen letras, contiene dos constructores.
  public TableroDeJuego() --> inicializa una partida nueva en la que se generan de manera aleatoria de 4 a 10 objetos Tubo conteniendo letras + 2 vacíos.
  Estas letras no pueden superar 4 (tamaño del tubo) por lo que si por ejemplo se generan 5 tubos las letras serán A,B,C,D y E (4 de cada mezcladas aleatoriamente).
  Los objetos Tubo se guardan en un Arraylist<Tubo>
  public TableroDeJuego(String archivo) --> genera un tablero de juego con un fichero de texto.
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-Tubo
Tubo es una clase que implementa la gestión de un Tubo, utiliza la clase Stack para almacenar las letras de cada tubo
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
