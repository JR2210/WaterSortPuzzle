public class Juego
{
	// Método principal que inicia el juego según la opción elegida por
	// el usuario e inicia un bucle preguntando el tubo origen del trasvase
	// y el tubo destino y termina cuando estén todas las letras ordenadas.
	public static void main(String[] args)
	{
		int origen, destino;
		boolean salir = false;

		while (!salir)
		{
			int opcion = menu();
			if (opcion == 0)
				salir = true;
			else
			{
				TableroDeJuego juego;
				if (opcion == 1)
					juego = new TableroDeJuego();
				else
					juego = new TableroDeJuego(".//Tablero.txt");
				juego.mostrar();

				while (!juego.estaCompleto())
				{
					try
					{
						System.out.print("Tubo origen: ");
						origen = ES.leerInt();
						System.out.print("Tubo destino: ");
						destino = ES.leerInt();
						juego.mover(origen, destino);
					}
					catch (NumberFormatException e)
					{
					}
					juego.mostrar();
				}
				System.out.println("TERMINADO!!!\n");
			}
		}
	}

	// Método que muestra un menú con las distintas opciones de juego.
	// Pregunta al usuario qué opción elige y devuelve ese valor.
	public static int menu()
	{
		int opcion = 0;

		System.out.println("MENU");
		System.out.println("====");
		System.out.println("1. TABLERO ALEATORIO");
		System.out.println("2. TABLERO DE ARCHIVO");
		System.out.print("ELIGE OPCIÓN: ");
		try
		{
			opcion = ES.leerInt();
			if (opcion < 1 || opcion > 2)
				opcion = 0;
		}
		catch (NumberFormatException e)
		{
			opcion = 0;
		}
		finally
		{
			System.out.println();
			return opcion;
		}
	}
}
