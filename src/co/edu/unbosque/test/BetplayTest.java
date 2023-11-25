package co.edu.unbosque.test;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.model.BetplayDTO;
import co.edu.unbosque.model.persistence.BetplayDAO;

public class BetplayTest {

	private BetplayDAO betplay = new BetplayDAO();
	static int numeroDePrueba = 3;

	@BeforeClass
	public static void antesDeTodo() {
		System.out.println("Iniciando las pruebas unitarias del betplay");
	}

	@Before
	public void antesDeCadaPrueba() {
		System.out.println("Empezando la prueba " + numeroDePrueba);
	}

	@Test
	public void testeandoCrear() {
		System.out.println("Empezando la prueba de crear el betplay");
		betplay.getApBetplay().clear();

		LocalDate dia = LocalDate.now();
		double valorApuesta = 100;
		int id = 23;
		String resultado = "ganaste";
		String partido = "Vnzla vs Col";
		long cedulaAp = 123;
		String sedeAp = "usaquen";

		BetplayDTO bpdao = new BetplayDTO(dia, valorApuesta, id, resultado, partido, cedulaAp, sedeAp);
		betplay.create(bpdao);

		int size = betplay.getApBetplay().size();
		assertTrue(size == 3);
	}

	@After
	public void despuesDeCadaPrueba() {
		System.out.println("Finalizando la prueba" + numeroDePrueba);
		numeroDePrueba++;

	}

	@AfterClass
	public static void despuesDeTodo() {
		System.out.println("Finalizando pruebas unitarias del betplay");
	}
}
