package co.edu.unbosque.test;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.model.LoteriaDTO;
import co.edu.unbosque.model.persistence.LoteriaDAO;

public class LoteriaTest {
	
	private LoteriaDAO loteria = new LoteriaDAO();
	static int numeroDePrueba = 4;

	@BeforeClass
	public static void antesDeTodo() {
		System.out.println("Iniciando las pruebas unitarias de la loteria");
	}

	@Before
	public void antesDeCadaPrueba() {
		System.out.println("Empezando la prueba " + numeroDePrueba);
	}

	@Test
	public void testeandoCrear() {
		System.out.println("Empezando la prueba de crear la loteria");
		loteria.getApLoteria().clear();

		LocalDate dia = LocalDate.now();
		double valorApuesta = 100;
		String nombreLoteria = "hola";
		int id = 23;
		int[] numeros = new int [10] ;
		int numSerie = 345;
		long cedulaAp = 123;
		String sedeAp = "usaquen";
		
		LoteriaDTO ldao = new LoteriaDTO(dia, valorApuesta, nombreLoteria, id, numeros, numSerie, cedulaAp, sedeAp);
		loteria.create(ldao);

		int size = loteria.getApLoteria().size();
		assertTrue(size == 4);
	}

	@After
	public void despuesDeCadaPrueba() {
		System.out.println("Finalizando la prueba" + numeroDePrueba);
		numeroDePrueba++;

	}

	@AfterClass
	public static void despuesDeTodo() {
		System.out.println("Finalizando pruebas unitarias del loteria");
	}


}