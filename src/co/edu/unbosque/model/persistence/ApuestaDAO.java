package co.edu.unbosque.model.persistence;

import co.edu.unbosque.util.SedeNoEncontradaException;

public class ApuestaDAO {

	private BalotoDAO balotoDAO;
	private BetplayDAO betplayDAO;
	private ChanceDAO chanceDAO;
	private LoteriaDAO loteriaDAO;
	private SuperAstroDAO superAstroDAO;
	private SedeDAO sedeDAO;

	public ApuestaDAO() {
		balotoDAO = new BalotoDAO();
		betplayDAO = new BetplayDAO();
		chanceDAO = new ChanceDAO();
		loteriaDAO = new LoteriaDAO();
		superAstroDAO = new SuperAstroDAO();
		sedeDAO = new SedeDAO();
	}

	public double calcularValorTotalApostadoPorClienteEnTodosJuegos(long cedulaApostador) {
		double valorTotal = 0;

		valorTotal += balotoDAO.calcularValorTotalApostadoPorCliente(cedulaApostador);
		valorTotal += betplayDAO.calcularValorTotalApostadoPorCliente(cedulaApostador);
		valorTotal += chanceDAO.calcularValorTotalApostadoPorCliente(cedulaApostador);
		valorTotal += loteriaDAO.calcularValorTotalApostadoPorCliente(cedulaApostador);
		valorTotal += superAstroDAO.calcularValorTotalApostadoPorCliente(cedulaApostador);

		return valorTotal;
	}

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
	        // Manejar la excepción de sede no encontrada según las necesidades de tu aplicación
	        System.out.println(e.getMessage());
	    }

	    return totalApuestas;
	}

	
	 public double calcularTotalValorApostadoPorTipoDeJuego() {
	        double totalBaloto = balotoDAO.calcularTotalValorApostado();
	        double totalBetplay = betplayDAO.calcularTotalValorApostado();
	        double totalChance = chanceDAO.calcularTotalValorApostado();
	        double totalLoteria = loteriaDAO.calcularTotalValorApostado();
	        double totalSuperAstro = superAstroDAO.calcularTotalValorApostado();

	        return totalBaloto + totalBetplay + totalChance + totalLoteria + totalSuperAstro;
	    }
	 
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
