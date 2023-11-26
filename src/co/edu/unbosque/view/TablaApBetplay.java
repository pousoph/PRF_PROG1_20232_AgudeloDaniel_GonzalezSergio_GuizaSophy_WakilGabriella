package co.edu.unbosque.view;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.BetplayDTO;

/**
 * 
 * Clase que representa una tabla de apuestas Betplay.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class TablaApBetplay {

	private ArrayList<BetplayDTO> listaBetplay;

	/**
	 * Constructor de la clase.
	 *
	 * @param apBetplay Lista de apuestas Betplay a mostrar en la tabla.
	 */

	public TablaApBetplay(ArrayList<BetplayDTO> apBetplay) {
		listaBetplay = apBetplay;
	}

	// Columnas de la tabla
	String[] columnas = { "ID", "Dia", "Cedula", "Sede", "Partido", "Resultado", "Valor apuesta" };

	/**
	 * Agrega las apuestas Betplay a una tabla y la muestra en una ventana.
	 *
	 * @return La tabla con las apuestas Betplay.
	 */

	public JTable agregarBetplay() {
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
		for (BetplayDTO betplay : listaBetplay) {
			Object[] fila = { betplay.getIdBetplay(), betplay.getDia(), betplay.getCedulaApostador(),
					betplay.getSedeApostador(), betplay.getPartido(), betplay.getResultado(),
					betplay.getValorApuesta() };
			modelo.addRow(fila);
		}
		// Crear la tabla y configurar la ventana
		JTable table = new JTable(modelo);
		JFrame frame = new JFrame("Tabla Apuesta Betplay");
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