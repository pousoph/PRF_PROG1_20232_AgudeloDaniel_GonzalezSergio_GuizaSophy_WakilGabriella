package co.edu.unbosque.model.persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import co.edu.unbosque.model.ConfiguracionDTO;

public class ConfiguracionDAO {
	
	private final String CONFIG_FILE = "confi.properties";
	private ConfiguracionDTO configuracion; // Agregamos el atributo
	
	public ConfiguracionDAO() {
		cargarConfiguracion();
	}

	public void cargarConfiguracion() {
        Properties properties = new Properties();
        configuracion = new ConfiguracionDTO();

        try (InputStream input = new FileInputStream(CONFIG_FILE)) {
            properties.load(input);

            configuracion.setNombreCasa(properties.getProperty("nombre_casa"));
            configuracion.setNumeroSedes(Integer.parseInt(properties.getProperty("numero_sedes", "0")));
            configuracion.setPresupuestoTotal(Double.parseDouble(properties.getProperty("presupuesto_total", "0.0")));

        } catch (IOException e) {
            throw new RuntimeException("Error al cargar la configuración: " + e.getMessage(), e);
        }
    }

	public void guardarConfiguracion(ConfiguracionDTO configuracionDTO) {
		Properties properties = new Properties();

		try (OutputStream output = new FileOutputStream(CONFIG_FILE)) {
			properties.setProperty("nombre_casa", configuracionDTO.getNombreCasa());
			properties.setProperty("numero_sedes", String.valueOf(configuracionDTO.getNumeroSedes()));
			properties.setProperty("presupuesto_total", String.valueOf(configuracionDTO.getPresupuestoTotal()));

			properties.store(output, null);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Agregamos un método para obtener la configuración
	public ConfiguracionDTO getConfiguracion() {
		return configuracion;
	}

	// Agregamos un método para establecer la configuración
	public void setConfiguracion(ConfiguracionDTO configuracion) {
		this.configuracion = configuracion;
	}

}
