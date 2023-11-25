package co.edu.unbosque.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.SuperAstroDTO;

public class TablaApuestaSuperAstro {

	private ArrayList<SuperAstroDTO> listaSuperAstro;

	public TablaApuestaSuperAstro(ArrayList<SuperAstroDTO> superAstro) {
		listaSuperAstro = superAstro;
	}

	String[] columnas = { "ID", "Dia", "Cedula", "Sede", "Signo Zodiacal", "Numeros", "Valor apuesta" };

	public JTable agregarSuperAstro() {
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
		for (SuperAstroDTO superAstro : listaSuperAstro) {
			// Convertir el array de números a cadena antes de agregarlo a la fila
			String numerosComoCadena = Arrays.toString(superAstro.getNumeros());

			Object[] fila = { superAstro.getIdSuperAstro(), superAstro.getDia(), superAstro.getCedulaApostador(),
					superAstro.getUbicacionApostador(), numerosComoCadena, superAstro.getSignoZodiacal(),
					superAstro.getValorApuesta() };
			modelo.addRow(fila);
		}
		JTable table = new JTable(modelo);
		JFrame frame = new JFrame("Tabla Apuesta SuperAstro");
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
