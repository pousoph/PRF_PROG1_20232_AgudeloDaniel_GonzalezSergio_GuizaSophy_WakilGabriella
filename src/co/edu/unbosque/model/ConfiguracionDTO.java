package co.edu.unbosque.model;

public class ConfiguracionDTO {

	private String nombreCasa;
	private int numeroSedes;
	private double presupuestoTotal;

	public ConfiguracionDTO() {
		// TODO Auto-generated constructor stub
	}

	public ConfiguracionDTO(String nombreCasa, int numeroSedes, double presupuestoTotal) {
		super();
		this.nombreCasa = nombreCasa;
		this.numeroSedes = numeroSedes;
		this.presupuestoTotal = presupuestoTotal;
	}

	public String getNombreCasa() {
		return nombreCasa;
	}

	public void setNombreCasa(String nombreCasa) {
		this.nombreCasa = nombreCasa;
	}

	public int getNumeroSedes() {
		return numeroSedes;
	}

	public void setNumeroSedes(int numeroSedes) {
		this.numeroSedes = numeroSedes;
	}

	public double getPresupuestoTotal() {
		return presupuestoTotal;
	}

	public void setPresupuestoTotal(double presupuestoTotal) {
		this.presupuestoTotal = presupuestoTotal;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nombre de la casa: " + nombreCasa);
		sb.append("Numero de sedes: " + numeroSedes);
		sb.append("Presupuesto Total: " + presupuestoTotal);

		return sb.toString();
	}

}
