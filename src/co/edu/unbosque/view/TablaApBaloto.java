package co.edu.unbosque.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays; // Agrega esta importación

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.BalotoDTO;

public class TablaApBaloto {

	private ArrayList<BalotoDTO> listaBaloto;

	public TablaApBaloto(ArrayList<BalotoDTO> apBaloto) {
		listaBaloto = apBaloto;
	}

	String[] columnas = { "ID", "Dia", "Cedula", "Sede", "Numeros", "Valor apuesta" };

	public JTable agregaBaloto() {
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
		for (BalotoDTO baloto : listaBaloto) {
			// Convertir el array de números a cadena antes de agregarlo a la fila
			String numerosComoCadena = Arrays.toString(baloto.getNumeros());

			Object[] fila = { baloto.getIdBaloto(), baloto.getDia(), baloto.getCedulaApostador(),
					baloto.getSedeApostador(), numerosComoCadena, baloto.getValorApuesta() };
			modelo.addRow(fila);
		}
		JTable table = new JTable(modelo);
		JFrame frame = new JFrame("Tabla Apuesta Baloto");
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
