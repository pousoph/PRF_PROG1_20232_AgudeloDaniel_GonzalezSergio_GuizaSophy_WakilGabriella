package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelAgApBetplay extends JPanel {

	private JComboBox<String> comboBoxSede;
	private JComboBox<String> comboBoxPartidos;
	private JComboBox<String> comboBoxResultado;
	private JComboBox<Long> comboBoxCedula;
	private JTextField txtValorApuesta;
	private JLabel lblValorApuesta;
	private Image backgroundImage;

	public PanelAgApBetplay() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 10, 5, 10);

		// Selector de Sede
		String[] sedes = { "Usaquen", "Chapinero", "Santa Fe", "Tunjuelito", "Bosa", "Kennedy", "Fontibon", "Engativa",
				"Suba", "Barrios Unidos", "Teusaquillo", "Los Martires", "Antonio Nariño", "Puente Aranda",
				"Candelaria", "Rafael Uribe Uribe", "Ciudad Bolivar", "Sumapaz" };
		comboBoxSede = new JComboBox<>(sedes);
		comboBoxSede.setForeground(Color.black);
		gbc.gridx = 1;
		gbc.gridy = 1;
		JLabel labelUbicacion = new JLabel("Ubicacion:");
		labelUbicacion.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelUbicacion.setForeground(Color.white);
		add(labelUbicacion, gbc);
		gbc.gridx = 2;
		gbc.gridy = 1;
		add(comboBoxSede, gbc);

		// Selector de Cédula
		comboBoxCedula = new JComboBox<>();
		comboBoxCedula.setForeground(Color.white);
		gbc.gridx = 1;
		gbc.gridy = 2;
		JLabel labelCedula = new JLabel("Cedula:");
		labelCedula.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelCedula.setForeground(Color.white);
		add(labelCedula, gbc);
		gbc.gridx = 2;
		gbc.gridy = 2;
		add(comboBoxCedula, gbc);

		String[] partidos = { "Argentina  vs España", "Portugal vs Francia", "Venezuela vs Colombia",
				"Costa Rica vs Brasi", "Inglaterra vs Panama", "Italia vs Alemania", "Africa del Sur vs Jamaica" };
		comboBoxPartidos = new JComboBox<>(partidos);
		comboBoxPartidos.setForeground(Color.white);
		gbc.gridx = 1;
		gbc.gridy = 3;
		JLabel lblPartidos = new JLabel("Partidos:");
		lblPartidos.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPartidos.setForeground(Color.white);
		add(lblPartidos, gbc);
		gbc.gridx = 2;
		gbc.gridy = 3;
		add(comboBoxPartidos, gbc);

		String[] resultados = { "Local", "Visitante", "Empate" };
		comboBoxResultado = new JComboBox<>(resultados);
		comboBoxPartidos.setForeground(Color.white);
		gbc.gridx = 3;
		gbc.gridy = 3;
		JLabel lblResultados = new JLabel("Apuesta:");
		lblResultados.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(lblResultados, gbc);
		gbc.gridx = 4;
		gbc.gridy = 3;
		add(comboBoxResultado, gbc);

		lblValorApuesta = new JLabel("Valor Apuesta: ");
		lblValorApuesta.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblValorApuesta.setForeground(Color.white);
		gbc.gridx = 1;
		gbc.gridy = 4;
		add(lblValorApuesta, gbc);

		txtValorApuesta = new JTextField(24);
		gbc.gridx = 2;
		gbc.gridy = 4;
		add(txtValorApuesta, gbc);

		// Listener para el cambio de la sede
		comboBoxSede.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fireSedeChangeEvent();
			}
		});

		backgroundImage = new ImageIcon("./imgs/vBetplay.png").getImage();
	}

	public void addSedeChangeListener(ActionListener listener) {
		sedeChangeListeners.add(listener);
	}

	public void removeSedeChangeListener(ActionListener listener) {
		sedeChangeListeners.remove(listener);
	}

	public String getSedeSeleccionada() {
		return (String) comboBoxSede.getSelectedItem();
	}

	public void actualizarCedulas(List<Long> cedulas) {
		String sedeSeleccionada = getSedeSeleccionada();
		if (sedeSeleccionada != null) {
			comboBoxCedula.removeAllItems();
			for (Long cedula : cedulas) {
				comboBoxCedula.addItem(cedula);
			}
		}
	}

	private void fireSedeChangeEvent() {
		String sedeSeleccionada = getSedeSeleccionada();
		for (ActionListener listener : sedeChangeListeners) {
			listener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, sedeSeleccionada));
		}
	}

	private final List<ActionListener> sedeChangeListeners = new LinkedList<>();

	public void mostrarRecibo(LocalDate dia, String sede, Long cedulaApostador, String partido, String resultado,
			Double valorApuesta, int id) {
		String mensajeRecibo = "Fecha: " + dia.toString() + "\n" + "Sede: " + sede + "\n" + "Cédula Apostador: "
				+ cedulaApostador + "\n" + "Partido: " + partido + "\n" + "Resultado: " + resultado + "\n"
				+ "Valor Apuesta: " + valorApuesta + "\n" + "ID: " + id;

		JOptionPane.showMessageDialog(null, mensajeRecibo, "Recibo de Apuesta", JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
	}

	public JComboBox<String> getComboBoxSede() {
		return comboBoxSede;
	}

	public void setComboBoxSede(JComboBox<String> comboBoxSede) {
		this.comboBoxSede = comboBoxSede;
	}

	public JComboBox<String> getComboBoxPartidos() {
		return comboBoxPartidos;
	}

	public void setComboBoxPartidos(JComboBox<String> comboBoxPartidos) {
		this.comboBoxPartidos = comboBoxPartidos;
	}

	public JComboBox<String> getComboBoxResultado() {
		return comboBoxResultado;
	}

	public void setComboBoxResultado(JComboBox<String> comboBoxResultado) {
		this.comboBoxResultado = comboBoxResultado;
	}

	public JComboBox<Long> getComboBoxCedula() {
		return comboBoxCedula;
	}

	public void setComboBoxCedula(JComboBox<Long> comboBoxCedula) {
		this.comboBoxCedula = comboBoxCedula;
	}

	public JTextField getTxtValorApuesta() {
		return txtValorApuesta;
	}

	public void setTxtValorApuesta(JTextField txtValorApuesta) {
		this.txtValorApuesta = txtValorApuesta;
	}

	public JLabel getLblValorApuesta() {
		return lblValorApuesta;
	}

	public void setLblValorApuesta(JLabel lblValorApuesta) {
		this.lblValorApuesta = lblValorApuesta;
	}

	public Image getBackgroundImage() {
		return backgroundImage;
	}

	public void setBackgroundImage(Image backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

	public List<ActionListener> getSedeChangeListeners() {
		return sedeChangeListeners;
	}
}
