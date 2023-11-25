package co.edu.unbosque.test;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.model.SuperAstroDTO;
import co.edu.unbosque.model.persistence.SuperAstroDAO;

public class SuperAstroTest {

	private SuperAstroDAO superastro = new SuperAstroDAO();
	static int numeroDePrueba = 5;

	@BeforeClass
	public static void antesDeTodo() {
		System.out.println("Iniciando las pruebas unitarias del superastro");
	}

	@Before
	public void antesDeCadaPrueba() {
		System.out.println("Empezando la prueba " + numeroDePrueba);
	}

	@Test
	public void testeandoCrear() {
		System.out.println("Empezando la prueba de crear el superastro");
		superastro.getApSuperAstro().clear();

		LocalDate dia = LocalDate.now();
		double valorApuesta = 100;
		int id = 23;
		int[] numeros = new int[10];
		String signoZodiacal = "tauro";
		long cedulaAp = 123;
		String sedeAp = "usaquen";

		SuperAstroDTO sadao = new SuperAstroDTO(dia, valorApuesta, id, numeros, signoZodiacal, cedulaAp, sedeAp);
		superastro.create(sadao);

		int size = superastro.getApSuperAstro().size();
		assertTrue(size == 5);
	}

	@After
	public void despuesDeCadaPrueba() {
		System.out.println("Finalizando la prueba" + numeroDePrueba);
		numeroDePrueba++;

	}

	@AfterClass
	public static void despuesDeTodo() {
		System.out.println("Finalizando pruebas unitarias del superastro");
	}

}