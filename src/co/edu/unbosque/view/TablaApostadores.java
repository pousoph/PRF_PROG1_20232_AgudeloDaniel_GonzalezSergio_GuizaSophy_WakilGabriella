package co.edu.unbosque.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.ApostadorDTO;

/**
 * 
 * Clase que representa una tabla de apostadores.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */
public class TablaApostadores {

	private ArrayList<ApostadorDTO> listaApostador;

	/**
	 * Constructor de la clase.
	 *
	 * @param apostadores Lista de apostadores a mostrar en la tabla.
	 */

	public TablaApostadores(ArrayList<ApostadorDTO> apostadores) {
		// TODO Auto-generated constructor stub
		listaApostador = apostadores;
	}

	// Columnas de la tabla
	String[] columnas = { "ID", "Nombre", "Cedula", "Sede", "Direccion", "Numero de Celular" };

	/**
	 * Agrega los apostadores a una tabla y la muestra en una ventana.
	 *
	 * @return La tabla con los apostadores.
	 */
	public JTable agregarApostadores() {
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
		for (ApostadorDTO apostador : listaApostador) {

			Object[] fila = { apostador.getId(), apostador.getName(), apostador.getCedula(), apostador.getSede(),
					apostador.getDireccion(), apostador.getNumberCell() };
			modelo.addRow(fila);
		}
		// Crear la tabla y configurar la ventana
		JTable table = new JTable(modelo);
		JFrame frame = new JFrame("Tabla Apostadores");
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