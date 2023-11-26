package co.edu.unbosque.view;

import java.util.Scanner;

/**
 * 
 * La clase Console proporciona métodos para interactuar con la consola.
 * Incluye métodos para leer la entrada del usuario y mostrar la salida en la consola.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class Console {
	
	private Scanner leer;

	  /**
   * Constructor de la clase Console que inicializa un objeto Scanner para leer desde la entrada estándar.
   */
	public Console() {
		leer = new Scanner(System.in);
	}
	
	 /**
   * Lee un entero desde la consola.
   *
   * @return El entero leído desde la consola.
   */

	public int leerEntero() {
		return leer.nextInt();
	}
	
	  /**
   * Lee un valor booleano desde la consola.
   *
   * @return El valor booleano leído desde la consola.
   */

	public boolean leerBoolean() {
		return leer.nextBoolean();
	}
	
	  /**
   * Lee un número largo (long) desde la consola.
   *
   * @return El número largo leído desde la consola.
   */

	public long leerLong() {
		return leer.nextLong();
	}
	
	 /**
   * Lee un número en punto flotante (float) desde la consola.
   *
   * @return El número en punto flotante leído desde la consola.
   */

	public float leerFloat() {
		return leer.nextFloat();
	}

	  /**
   * Lee un número en punto flotante de doble precisión (double) desde la consola.
   *
   * @return El número en punto flotante de doble precisión leído desde la consola.
   */
	
	public double leerDouble() {
		return leer.nextDouble();
	}
	
	  /**
   * Lee una línea completa de texto desde la consola.
   *
   * @return La línea de texto leída desde la consola.
   */

	public String leerLineaEntera() {
		return leer.nextLine();
	}

	 /**
   * Lee una palabra (secuencia de caracteres sin espacios) desde la consola.
   *
   * @return La palabra leída desde la consola.
   */
	
	public String leerPalabra() {
		return leer.next();
	}
	
	 /**
   * Lee un carácter desde la consola.
   *
   * @return El carácter leído desde la consola.
   */

	public char leerCaracter() {
		return leer.next().charAt(0);
	}

	 /**
   * Limpia la entrada de la consola, descartando la línea actual.
   */
	
	public void quemarLinea() {
		leer.nextLine();
	}
	
	 /**
   * Imprime una cadena de texto con un salto de línea al final.
   *
   * @param dato La cadena de texto que se imprimirá en la consola.
   */

	public void imprimirConSalto(String dato) {
		System.out.println(dato);
	}

	 /**
   * Imprime una cadena de texto sin un salto de línea al final.
   *
   * @param dato La cadena de texto que se imprimirá en la consola.
   */
	
	public void imprimirSinSalto(String dato) {
		System.out.print(dato);
	}

}