package WaterSortGame;

import java.util.*;
import java.io.*;

// Clase que implementa la gestión de un tablero de tubos de letras.
public class TableroDeJuego 
{
	private int numTubos;				// Número de tubos sin incluir los dos vacíos.
	private ArrayList<Tubo> tablero;	// ArrayList que guarda los tubos del juego.
	
	// Constructor de un tablero aleatorio.
	public TableroDeJuego()
	{
		numTubos = ((int)(Math.random()*(11-4))+4)+2;
		tablero = new ArrayList<Tubo>();
		ArrayList <String> letras = new ArrayList<String>();
		for (int i = 0; i < numTubos; i++)
		{
			Tubo tubo = new Tubo();
			tablero.add(tubo);
		}
		for (int i = 0; i < numTubos-2; i++)
		{
			for (int j = 0; j < tablero.get(i).getTamaño(); j++)
			{
				int contador;
				String letra;
				do {
					letra= String.valueOf((char)((int)(Math.random()*((65+numTubos-2)-65))+65));
					letras.add(letra);
					contador = 0;
					for(int k = 0 ; k < letras.size() ; k++)
					{
						if(letras.get(k).equals(letra))
						{
							contador++;
						}
					}
				}while(contador > 4);
				tablero.get(i).apilar(letra);
			}
		}
	}
	
	// Constructor a partir de un archivo de texto.
	public TableroDeJuego(String archivo)
	{
		tablero = new ArrayList<Tubo>();
		try
		{
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			numTubos = ((int)(Math.random()*(11-4))+4)+2;
			for (int i = 0; i < numTubos; i++)
			{
				Tubo tubo = new Tubo();
				tablero.add(i,tubo);
			}
			for (int i = 0; i < numTubos-2; i++)
			{
				linea = br.readLine();
				for (int j = 0; j < linea.length() ; j++)
				{
					if(linea.charAt(j) != ' ')
					{
						tablero.get(i).apilar(String.valueOf(linea.charAt(j)));
					}
				}
			}
			br.close();
		}
		catch (IOException e)
		{
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	// Método get que devuelve la variable tablero.
	public ArrayList<Tubo> getTablero()
	{
		return tablero;
	}
	
	// Método que realiza el trasvase del tubo origen al tubo destino.
	// Debe comprobar que se puede realizar dicho trasvase y realizarlo.
	// Si no se puede hacer, no modifica el tablero.
	public void mover(int origen, int destino)
	{
		// Comprobamos si se puede realizar el trasvase
		if (origen < 0 || origen > numTubos-1 || destino < 0 || destino > numTubos-1)
		{
			System.out.println("Los tubos deben estar entre 0 y " + (numTubos-1));
		}
		else if (origen == destino)
		{
			System.out.println("No se puede trasvasar un tubo a sí mismo.");
		}
		else if (tablero.get(origen).estaVacio())
		{
			System.out.println("El tubo origen está vacío.");
		}
		else if(!tablero.get(destino).hayHueco()) {
			System.out.println("El tubo destino está lleno.");
		}
		else if(!(tablero.get(destino).estaVacio()) && !(tablero.get(destino).cima().equals(tablero.get(origen).cima())))
		{
			System.out.println("El tubo destino no tiene la misma letra que el tubo origen");
		}
		else
		{
			// Contamos la capacidad del tubo origen y destino
			int origenTam = 0, destinoTam = 0;
			Tubo tuboAuxDestino = new Tubo(), tuboAuxOrigen = new Tubo();
			for(int i = 0 ; i < tablero.get(destino).getTamaño() ; i++)
			{
				if(!tablero.get(destino).estaVacio())
				{
					tuboAuxDestino.apilar(tablero.get(destino).desapilar());
					destinoTam++;
				}
				if(!tablero.get(origen).estaVacio())
				{
					tuboAuxOrigen.apilar(tablero.get(origen).desapilar());
					origenTam++;
				}
			}
			for (int i = 0; i < destinoTam; i++)
			{
				tablero.get(destino).apilar(tuboAuxDestino.desapilar());
			}
			for (int i = 0; i < origenTam; i++)
			{
				tablero.get(origen).apilar(tuboAuxOrigen.desapilar());
			}
			// Condiciones para que se pueda realizar el trasvase.
			if (destinoTam < tablero.get(destino).getTamaño())
			{
				for (int i = 0 ; i < tablero.get(destino).getTamaño()-destinoTam; i++)
				{
					if(!(tablero.get(origen).estaVacio()) || tablero.get(destino).estaVacio())
					{
						if(tablero.get(destino).estaVacio() || tablero.get(destino).cima().equals(tablero.get(origen).cima()))
						{
							tablero.get(destino).apilar(tablero.get(origen).desapilar());
						}
					}
				}
			}
		}
	}
	public boolean estaCompleto()
	{
		int contador = 0;
		for (int i = 0; i < numTubos; i++)
		{
			if (tablero.get(i).estaCompleto())
			{
				contador++;
			}
		}
		return contador == numTubos - 2;
	}
	
	// Método que compara el contenido del tablero con otro que se pasa por argumento.
	// Devuelve true si son iguales; false, si hay alguna diferencia.
	public boolean equals(TableroDeJuego tablero)
	{
		return this.tablero.equals(tablero.getTablero());
	}
	
	// Método que muestra por pantalla el contenido del tablero.
	public void mostrar()
	{
		for (int i = 0; i < tablero.size(); i++)
		{
			System.out.print("Tubo " + i + " | ");
			tablero.get(i).mostrar();
		}
	}
}
