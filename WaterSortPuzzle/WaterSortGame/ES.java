package WaterSortGame;

import java.io.*;

// Clase que simplifica la entrada/salida est�ndar.
public class ES 
{
	// M�todo est�tico que lee un String del teclado.
	public static String leer()
	{
		try
		{
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			String linea = br.readLine();
			return linea;
		}
		catch (IOException exc)
		{
			return null;
		}		
	}
	
	// M�todo est�tico que escribe un String por consola.
	public static void escribir(String cadena)
	{
		System.out.println(cadena);
	}
	
	// M�todo est�tico que lee un entero del teclado.
	public static int leerInt()
	{
		String cadena = leer();
		int valor = Integer.parseInt(cadena);
		return valor;
	}
	
	// M�todo est�tico que lee un float del teclado.
	public static float leerFloat()
	{
		String cadena = leer();
		float  valor = Float.parseFloat(cadena);
		return valor;
	}
}
