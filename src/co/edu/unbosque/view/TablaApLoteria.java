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

public class TablaApLoteria {
	private ArrayList<LoteriaDTO> listaLoteria;

	public TablaApLoteria(ArrayList<LoteriaDTO> apLoteria) {
		listaLoteria = apLoteria;
	}

	String[] columnas = { "ID", "Dia", "Cedula", "Sede", "Nombre Loteria", "Numeros", "Numero de Serie",
			"Valor apuesta" };

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
