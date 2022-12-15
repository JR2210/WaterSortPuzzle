package WaterSortGame;

import java.util.*;

// Clase que implementa la gesti�n de un tubo.
public class Tubo 
{
	private final int TAMANO = 4;	// Tama�o m�ximo de los tubos
	private Stack<String> tubo;		// Pila que almacena las letras como String
	
	// Constructor
	public Tubo()
	{
		tubo = new Stack<String>();
	}
	
	// M�todo get que devuelve la constante tama�o.
	public int getTama�o()
	{
		return TAMANO;
	}
	
	// M�todo get que devuelve la variable tubo.
	public Stack<String> getTubo()
	{
		return tubo;
	}
	
	// M�todo que permite apilar una letra en formato String.
	public void apilar(String letra)
	{
		tubo.push(letra);
	}
	
	// M�todo que permite desapilar una letra.
	public String desapilar()
	{
		return tubo.pop();
	}
	
	// M�todo que consulta la letra en la cima sin desapilar.
	public String cima()
	{
		return tubo.peek();
	}
	
	// M�todo que devuelve true si la pila est� vac�a; o false, si no lo est�.
	public boolean estaVacio()
	{
		return tubo.empty();
	}
	
	// M�todo que devuelve true si hay hueco en el tubo; o false, si no lo hay.
	public boolean hayHueco()
	{
		return tubo.size() < TAMANO;
	}
	
	// M�todo que devuelve true si el tubo est� completo con las 4 letras del 
	// mismo valor; false, si falta alguna o est�n mezcladas.
	public boolean estaCompleto()
	{
		return tubo.size() == TAMANO && tubo.get(0).equals(tubo.get(1)) && tubo.get(1).equals(tubo.get(2)) && tubo.get(2).equals(tubo.get(3));
	}
	
	// M�todo que compara el contenido del tubo con otro que se pasa por argumento.
	// Devuelve true si son iguales; false, si hay alguna diferencia.
	public boolean equals(Tubo tubo)
	{
		return this.tubo.equals(tubo.getTubo());
	}
	
	// M�todo que muestra por pantalla el contenido de un tubo.
	public void mostrar()
	{
		for (String s: tubo)
			System.out.print(s + " ");
		System.out.println();
	}
}
