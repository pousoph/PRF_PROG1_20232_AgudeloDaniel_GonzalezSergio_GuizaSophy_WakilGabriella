package co.edu.unbosque.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.LoteriaDTO;

/**
 * 
 * Clase que representa una tabla de apuestas de lotería.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class TablaApLoteria {
	private ArrayList<LoteriaDTO> listaLoteria;

	/**
	 * Constructor de la clase.
	 *
	 * @param apLoteria Lista de apuestas de lotería a mostrar en la tabla.
	 */

	public TablaApLoteria(ArrayList<LoteriaDTO> apLoteria) {
		listaLoteria = apLoteria;
	}

	// Columnas de la tabla
	String[] columnas = { "ID", "Dia", "Cedula", "Sede", "Nombre Loteria", "Numeros", "Numero de Serie",
			"Valor apuesta" };

	/**
	 * Agrega las apuestas de lotería a una tabla y la muestra en una ventana.
	 *
	 * @return La tabla con las apuestas de lotería.
	 */

	public JTable agregarLoteria() {
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
		for (LoteriaDTO loteria : listaLoteria) {
			// Convertir el array de números a cadena antes de agregarlo a la fila
			String numerosComoCadena = Arrays.toString(loteria.getNumeros());

			Object[] fila = { loteria.getIdLoteria(), loteria.getDia(), loteria.getCedulaApostador(),
					loteria.getSedeApostador(), loteria.getNombreLoteria(), numerosComoCadena, loteria.getNumSerie(),
					loteria.getValorApuesta() };
			modelo.addRow(fila);
		}
		// Crear la tabla y configurar la ventana
		JTable table = new JTable(modelo);
		JFrame frame = new JFrame("Tabla Apuesta Loteria");
		frame.add(new JScrollPane(table));
		frame.pack();
		frame.setSize(800, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		table.setDefaultEditor(Object.class, null);
		table.setRowHeight(50);

		return table;
	}
}