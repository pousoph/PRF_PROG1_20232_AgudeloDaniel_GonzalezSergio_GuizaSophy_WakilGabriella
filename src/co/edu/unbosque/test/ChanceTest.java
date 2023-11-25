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

public class ChanceTest {

	private ChanceDAO chance = new ChanceDAO();
	static int numeroDePrueba = 2;

	@BeforeClass
	public static void antesDeTodo() {
		System.out.println("Iniciando las pruebas unitarias del chance");
	}

	@Before
	public void antesDeCadaPrueba() {
		System.out.println("Empezando la prueba " + numeroDePrueba);
	}

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

	@After
	public void despuesDeCadaPrueba() {
		System.out.println("Finalizando la prueba" + numeroDePrueba);
		numeroDePrueba++;

	}

	@AfterClass
	public static void despuesDeTodo() {
		System.out.println("Finalizando pruebas unitarias del chance");
	}
}