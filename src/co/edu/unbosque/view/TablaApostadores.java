package co.edu.unbosque.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.ApostadorDTO;

public class TablaApostadores {

	private ArrayList<ApostadorDTO> listaApostador;

	public TablaApostadores(ArrayList<ApostadorDTO> apostadores) {
		// TODO Auto-generated constructor stub
		listaApostador = apostadores;
	}

	String[] columnas = { "ID", "Nombre", "Cedula", "Sede", "Direccion", "Numero de Celular" };

	public JTable agregarApostadores() {
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
		for (ApostadorDTO apostador : listaApostador) {

			Object[] fila = { apostador.getId(), apostador.getName(), apostador.getCedula(), apostador.getSede(),
					apostador.getDireccion(), apostador.getNumberCell() };
			modelo.addRow(fila);
		}
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
