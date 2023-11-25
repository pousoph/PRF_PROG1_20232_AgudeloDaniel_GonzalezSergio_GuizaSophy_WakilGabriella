package co.edu.unbosque.view;


import java.util.ArrayList;


import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.BetplayDTO;


public class TablaApBetplay {
	
	private ArrayList<BetplayDTO>listaBetplay;
	
	public TablaApBetplay(ArrayList<BetplayDTO>apBetplay) {
		listaBetplay = apBetplay;
	}
	String[] columnas = { "ID", "Dia", "Cedula", "Sede", "Partido", "Resultado", "Valor apuesta" };

	public JTable agregarBetplay() {
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
		for (BetplayDTO betplay : listaBetplay) {
			Object[] fila = { betplay.getIdBetplay(), betplay.getDia(), betplay.getCedulaApostador(),
					betplay.getSedeApostador(), betplay.getPartido(),betplay.getResultado(), betplay.getValorApuesta() };
			modelo.addRow(fila);
		}
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
