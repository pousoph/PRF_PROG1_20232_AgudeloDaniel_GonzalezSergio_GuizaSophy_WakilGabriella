package co.edu.unbosque.test;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.model.ChanceDTO;
import co.edu.unbosque.model.persistence.ChanceDAO;

/**
 * 
 * Clase de pruebas unitarias para la funcionalidad relacionada con Chance.
 * Utiliza la biblioteca JUnit para realizar las pruebas.
 *
 * <p>
 * Esta clase prueba las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) de
 * la clase ChanceDAO.
 * </p>
 *
 * <p>
 * Se utilizan métodos anotados con {@code @BeforeClass}, {@code @Before},
 * {@code @Test}, {@code @After}, y {@code @AfterClass} para indicar la
 * secuencia de ejecución de las pruebas y realizar acciones antes y después de
 * las mismas.
 * </p>
 *
 * <p>
 * La prueba incluye la creación de un objeto ChanceDTO, su inserción en
 * ChanceDAO, y la verificación del tamaño de la lista resultante.
 * </p>
 *
 * <p>
 * La salida de las pruebas se imprime en la consola.
 * </p>
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 *
 */

public class ChanceTest {

	private ChanceDAO chance = new ChanceDAO();
	static int numeroDePrueba = 2;

	/**
	 * Método ejecutado antes de todas las pruebas.
	 */

	@BeforeClass
	public static void antesDeTodo() {
		System.out.println("Iniciando las pruebas unitarias del chance");
	}

	/**
	 * Método ejecutado antes de cada prueba.
	 */

	@Before
	public void antesDeCadaPrueba() {
		System.out.println("Empezando la prueba " + numeroDePrueba);
	}

	/**
	 * Prueba unitaria para la creación de un objeto Chance y su inserción en
	 * ChanceDAO.
	 */

	@Test
	public void testeandoCrear() {
		System.out.println("Empezando la prueba de crear el chance");
		chance.getApChance().clear();

		LocalDate dia = LocalDate.now();
		double valorApuesta = 100;
		String nombreLoteria = "hola";
		int id = 23;
		int[] numeros = new int[10];
		long cedulaAp = 123;
		String sedeAp = "usaquen";

		ChanceDTO cdao = new ChanceDTO(dia, valorApuesta, nombreLoteria, id, numeros, cedulaAp, sedeAp);
		chance.create(cdao);

		int size = chance.getApChance().size();
		assertTrue(size == 2);
	}

	/**
	 * Método ejecutado después de cada prueba.
	 */

	@After
	public void despuesDeCadaPrueba() {
		System.out.println("Finalizando la prueba" + numeroDePrueba);
		numeroDePrueba++;

	}

	/**
	 * Método ejecutado después de todas las pruebas.
	 */

	@AfterClass
	public static void despuesDeTodo() {
		System.out.println("Finalizando pruebas unitarias del chance");
	}
}
