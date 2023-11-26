package co.edu.unbosque.model;

/**
 * 
 *         Clase que representa la configuración de la casa de apuestas,
 *         incluyendo el nombre de la casa, el número de sedes y el presupuesto
 *         total.
 *         
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class ConfiguracionDTO {

	// Nombre de la casa de apuestas
	private String nombreCasa;

	// Número de sedes de la casa de apuestas
	private int numeroSedes;

	// Presupuesto total de la casa de apuestas
	private double presupuestoTotal;

	/**
	 * Constructor por defecto de la clase ConfiguracionDTO.
	 */

	public ConfiguracionDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor que inicializa los atributos de la configuración con valores
	 * proporcionados.
	 *
	 * @param nombreCasa       Nombre de la casa de apuestas.
	 * @param numeroSedes      Número de sedes de la casa de apuestas.
	 * @param presupuestoTotal Presupuesto total de la casa de apuestas.
	 */

	public ConfiguracionDTO(String nombreCasa, int numeroSedes, double presupuestoTotal) {
		super();
		this.nombreCasa = nombreCasa;
		this.numeroSedes = numeroSedes;
		this.presupuestoTotal = presupuestoTotal;
	}

	/**
	 * Obtiene el nombre de la casa de apuestas.
	 *
	 * @return Nombre de la casa de apuestas.
	 */

	public String getNombreCasa() {
		return nombreCasa;
	}

	/**
	 * Establece el nombre de la casa de apuestas.
	 *
	 * @param nombreCasa Nuevo nombre de la casa de apuestas.
	 */

	public void setNombreCasa(String nombreCasa) {
		this.nombreCasa = nombreCasa;
	}

	/**
	 * Obtiene el número de sedes de la casa de apuestas.
	 *
	 * @return Número de sedes de la casa de apuestas.
	 */

	public int getNumeroSedes() {
		return numeroSedes;
	}

	/**
	 * Establece el número de sedes de la casa de apuestas.
	 *
	 * @param numeroSedes Nuevo número de sedes de la casa de apuestas.
	 */

	public void setNumeroSedes(int numeroSedes) {
		this.numeroSedes = numeroSedes;
	}

	/**
	 * Obtiene el presupuesto total de la casa de apuestas.
	 *
	 * @return Presupuesto total de la casa de apuestas.
	 */

	public double getPresupuestoTotal() {
		return presupuestoTotal;
	}

	/**
	 * Establece el presupuesto total de la casa de apuestas.
	 *
	 * @param presupuestoTotal Nuevo presupuesto total de la casa de apuestas.
	 */

	public void setPresupuestoTotal(double presupuestoTotal) {
		this.presupuestoTotal = presupuestoTotal;
	}

	/**
	 * Genera una representación en cadena de la configuración de la casa de
	 * apuestas.
	 *
	 * @return Una cadena que representa la configuración con detalles como el
	 *         nombre de la casa, el número de sedes y el presupuesto total.
	 */

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nombre de la casa: " + nombreCasa);
		sb.append("Numero de sedes: " + numeroSedes);
		sb.append("Presupuesto Total: " + presupuestoTotal);

		return sb.toString();
	}

}