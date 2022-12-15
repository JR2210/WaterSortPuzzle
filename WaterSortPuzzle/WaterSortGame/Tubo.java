package WaterSortGame;

import java.util.*;

// Clase que implementa la gestión de un tubo.
public class Tubo 
{
	private final int TAMANO = 4;	// Tamaño máximo de los tubos
	private Stack<String> tubo;		// Pila que almacena las letras como String
	
	// Constructor
	public Tubo()
	{
		tubo = new Stack<String>();
	}
	
	// Método get que devuelve la constante tamaño.
	public int getTamaño()
	{
		return TAMANO;
	}
	
	// Método get que devuelve la variable tubo.
	public Stack<String> getTubo()
	{
		return tubo;
	}
	
	// Método que permite apilar una letra en formato String.
	public void apilar(String letra)
	{
		tubo.push(letra);
	}
	
	// Método que permite desapilar una letra.
	public String desapilar()
	{
		return tubo.pop();
	}
	
	// Método que consulta la letra en la cima sin desapilar.
	public String cima()
	{
		return tubo.peek();
	}
	
	// Método que devuelve true si la pila está vacía; o false, si no lo está.
	public boolean estaVacio()
	{
		return tubo.empty();
	}
	
	// Método que devuelve true si hay hueco en el tubo; o false, si no lo hay.
	public boolean hayHueco()
	{
		return tubo.size() < TAMANO;
	}
	
	// Método que devuelve true si el tubo está completo con las 4 letras del 
	// mismo valor; false, si falta alguna o están mezcladas.
	public boolean estaCompleto()
	{
		return tubo.size() == TAMANO && tubo.get(0).equals(tubo.get(1)) && tubo.get(1).equals(tubo.get(2)) && tubo.get(2).equals(tubo.get(3));
	}
	
	// Método que compara el contenido del tubo con otro que se pasa por argumento.
	// Devuelve true si son iguales; false, si hay alguna diferencia.
	public boolean equals(Tubo tubo)
	{
		return this.tubo.equals(tubo.getTubo());
	}
	
	// Método que muestra por pantalla el contenido de un tubo.
	public void mostrar()
	{
		for (String s: tubo)
			System.out.print(s + " ");
		System.out.println();
	}
}
