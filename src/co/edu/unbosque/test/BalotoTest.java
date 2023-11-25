package co.edu.unbosque.test;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.model.BalotoDTO;
import co.edu.unbosque.model.persistence.BalotoDAO;

public class BalotoTest {

	private BalotoDAO baloto = new BalotoDAO();
	static int numeroDePrueba = 1;

	@BeforeClass
	public static void antesDeTodo() {
		System.out.println("Iniciando las pruebas unitarias del baloto");
	}

	@Before
	public void antesDeCadaPrueba() {
		System.out.println("Empezando la prueba " + numeroDePrueba);
	}

	@Test
	public void testeandoCrear() {
		System.out.println("Empezando la prueba de crear el baloto");
		baloto.getApBalotos().clear();

		LocalDate dia = LocalDate.now();
		double valorApuesta = 100;
		int[] numeros = new int [10] ;
		int id = 23;
		long cedulaAp = 123;
		String sedeAp = "usaquen";
		
		BalotoDTO bdao = new BalotoDTO(dia, valorApuesta, numeros, id, cedulaAp, sedeAp);
		baloto.create(bdao);

		int size = baloto.getApBalotos().size();
		assertTrue(size == 1);
	}

	@After
	public void despuesDeCadaPrueba() {
		System.out.println("Finalizando la prueba" + numeroDePrueba);
		numeroDePrueba++;

	}

	@AfterClass
	public static void despuesDeTodo() {
		System.out.println("Finalizando pruebas unitarias del baloto");
	}
}
