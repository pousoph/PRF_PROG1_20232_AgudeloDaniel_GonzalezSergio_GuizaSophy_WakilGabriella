package co.edu.unbosque.model.persistence;

import co.edu.unbosque.util.SedeNoEncontradaException;

/**
 * 
 *         La clase ApuestaDAO representa un objeto de acceso a datos (DAO) para
 *         gestionar apuestas en diferentes juegos.
 *         
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class ApuestaDAO {

	private BalotoDAO balotoDAO;
	private BetplayDAO betplayDAO;
	private ChanceDAO chanceDAO;
	private LoteriaDAO loteriaDAO;
	private SuperAstroDAO superAstroDAO;
	private SedeDAO sedeDAO;

	/**
	 * Constructor de la clase ApuestaDAO. Inicializa instancias de los DAO
	 * necesarios para gestionar apuestas en diferentes juegos.
	 */

	public ApuestaDAO() {
		balotoDAO = new BalotoDAO();
		betplayDAO = new BetplayDAO();
		chanceDAO = new ChanceDAO();
		loteriaDAO = new LoteriaDAO();
		superAstroDAO = new SuperAstroDAO();
		sedeDAO = new SedeDAO();
	}

	/**
	 * Calcula el valor total apostado por un cliente en todos los juegos.
	 *
	 * @param cedulaApostador La cédula del apostador.
	 * @return El valor total apostado por el cliente en todos los juegos.
	 */

	public double calcularValorTotalApostadoPorClienteEnTodosJuegos(long cedulaApostador) {
		double valorTotal = 0;

		valorTotal += balotoDAO.calcularValorTotalApostadoPorCliente(cedulaApostador);
		valorTotal += betplayDAO.calcularValorTotalApostadoPorCliente(cedulaApostador);
		valorTotal += chanceDAO.calcularValorTotalApostadoPorCliente(cedulaApostador);
		valorTotal += loteriaDAO.calcularValorTotalApostadoPorCliente(cedulaApostador);
		valorTotal += superAstroDAO.calcularValorTotalApostadoPorCliente(cedulaApostador);

		return valorTotal;
	}

	/**
	 * Calcula el total de apuestas realizadas en una sede específica.
	 *
	 * @param nombreSede El nombre de la sede.
	 * @return El total de apuestas realizadas en la sede especificada.
	 */

	public double calcularTotalApuestasPorSede(String nombreSede) {
		double totalApuestas = 0;

		try {
			String sede = sedeDAO.obtenerSedePorNombre(nombreSede);

			if (sede != null) {
				totalApuestas += balotoDAO.calcularTotalApuestasPorSede(sede);
				totalApuestas += betplayDAO.calcularTotalApuestasPorSede(sede);
				totalApuestas += chanceDAO.calcularTotalApuestasPorSede(sede);
				totalApuestas += loteriaDAO.calcularTotalApuestasPorSede(sede);
				totalApuestas += superAstroDAO.calcularTotalApuestasPorSede(sede);
			} else {
				System.out.println("Sede no encontrada");
			}
		} catch (SedeNoEncontradaException e) {
			// Manejar la excepción de sede no encontrada según las necesidades de tu
			// aplicación
			System.out.println(e.getMessage());
		}

		return totalApuestas;
	}

	/**
	 * Calcula el total del valor apostado en todos los tipos de juego.
	 *
	 * @return El total del valor apostado en todos los tipos de juego.
	 */

	public double calcularTotalValorApostadoPorTipoDeJuego() {
		double totalBaloto = balotoDAO.calcularTotalValorApostado();
		double totalBetplay = betplayDAO.calcularTotalValorApostado();
		double totalChance = chanceDAO.calcularTotalValorApostado();
		double totalLoteria = loteriaDAO.calcularTotalValorApostado();
		double totalSuperAstro = superAstroDAO.calcularTotalValorApostado();

		return totalBaloto + totalBetplay + totalChance + totalLoteria + totalSuperAstro;
	}

	/**
	 * Calcula el total apostado en un tipo específico de juego.
	 *
	 * @param tipoJuego El tipo de juego (baloto, betplay, chance, loteria,
	 *                  superAstro).
	 * @return El total apostado en el tipo de juego especificado.
	 */

	public double calcularTotalApostadoPorTipoJuego(String tipoJuego) {
		double totalTipoJuego = 0;

		if (tipoJuego.equalsIgnoreCase("baloto")) {
			totalTipoJuego = balotoDAO.calcularTotalValorApostado();
		} else if (tipoJuego.equalsIgnoreCase("betplay")) {
			totalTipoJuego = betplayDAO.calcularTotalValorApostado();
		} else if (tipoJuego.equalsIgnoreCase("chance")) {
			totalTipoJuego = chanceDAO.calcularTotalValorApostado();
		} else if (tipoJuego.equalsIgnoreCase("loteria")) {
			totalTipoJuego = loteriaDAO.calcularTotalValorApostado();
		} else if (tipoJuego.equalsIgnoreCase("superAstro")) {
			totalTipoJuego = superAstroDAO.calcularTotalValorApostado();
		}

		return totalTipoJuego;
	}

}