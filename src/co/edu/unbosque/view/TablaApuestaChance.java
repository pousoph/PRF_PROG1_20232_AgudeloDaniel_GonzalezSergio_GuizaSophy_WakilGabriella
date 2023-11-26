package co.edu.unbosque.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.BalotoDTO;
import co.edu.unbosque.model.ChanceDTO;

/**
 * 
 * Clase que representa una tabla de apuestas Chance.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class TablaApuestaChance {

	private ArrayList<ChanceDTO> listaChance;

	/**
	 * Constructor de la clase.
	 *
	 * @param apChance Lista de apuestas Chance a mostrar en la tabla.
	 */
	public TablaApuestaChance(ArrayList<ChanceDTO> apChance) {
		listaChance = apChance;
	}

	// Columnas de la tabla
	String[] columnas = { "ID", "Dia", "Cedula", "Sede", "Nombre Loteria", "Numeros", "Valor apuesta" };

	/**
	 * Agrega las apuestas Chance a una tabla y la muestra en una ventana.
	 *
	 * @return La tabla con las apuestas Chance.
	 */

	public JTable agregaChance() {
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
		for (ChanceDTO chance : listaChance) {
			// Convertir el array de números a cadena antes de agregarlo a la fila
			String numerosComoCadena = Arrays.toString(chance.getNumeros());

			Object[] fila = { chance.getIdChance(), chance.getDia(), chance.getCedulaAposdor(),
					chance.getSedeApostador(), chance.getNombreLoteria(), numerosComoCadena, chance.getValorApuesta() };
			modelo.addRow(fila);
		}
		// Crear la tabla y configurar la ventana
		JTable table = new JTable(modelo);
		JFrame frame = new JFrame("Tabla Apuesta Chance");
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