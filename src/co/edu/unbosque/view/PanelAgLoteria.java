package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelAgLoteria extends JPanel {
	private JComboBox<String> comboBoxSede;
	private JComboBox<String> comboBoxNombreLoteriA;
	private JComboBox<Long> comboBoxCedula;
	private JComboBox<Integer>[] comboBoxNumeros;
	private JTextField txtValorApuesta, txtNumeroSerie;
	private JLabel lblValorApuesta, lblNumeroSerie;
	private Image backgroundImage;

	public PanelAgLoteria() {
		// TODO Auto-generated constructor stub
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 10, 5, 10);

		// Selector de Sede
		String[] sedes = { "Usaquen", "Chapinero", "Santa Fe", "Tunjuelito", "Bosa", "Kennedy", "Fontibon", "Engativa",
				"Suba", "Barrios Unidos", "Teusaquillo", "Los Martires", "Antonio Nariño", "Puente Aranda",
				"Candelaria", "Rafael Uribe Uribe", "Ciudad Bolivar", "Sumapaz" };
		comboBoxSede = new JComboBox<>(sedes);
		comboBoxSede.setForeground(Color.white);
		comboBoxSede.setBackground(new Color(180, 16, 14));
		gbc.gridx = 1;
		gbc.gridy = 0;
		JLabel labelUbicacion = new JLabel("Ubicacion:");
		labelUbicacion.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelUbicacion.setForeground(Color.yellow);
		add(labelUbicacion, gbc);
		gbc.gridx = 2;
		gbc.gridy = 0;
		add(comboBoxSede, gbc);

		// Selector de Cédula
		comboBoxCedula = new JComboBox<>();
		comboBoxCedula.setForeground(Color.white);
		comboBoxCedula.setBackground(new Color(180, 16, 14));
		gbc.gridx = 1;
		gbc.gridy = 2;
		JLabel labelCedula = new JLabel("Cedula:");
		labelCedula.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelCedula.setForeground(Color.yellow);
		add(labelCedula, gbc);
		gbc.gridx = 2;
		gbc.gridy = 2;
		add(comboBoxCedula, gbc);

		String[] nombreLoteria = { "Cundinamarca", "Tolima", "Cruz Roja", "Huila", "Valle", "Manizalez", "Meta",
				"Bogota", "Quindio", "Santander", "Medellin", "Risaralda", "Boyaca", "Cauca", "Extra" };
		comboBoxNombreLoteriA = new JComboBox<>(nombreLoteria);
		comboBoxNombreLoteriA.setForeground(Color.white);
		comboBoxNombreLoteriA.setBackground(new Color(180, 16, 14));
		gbc.gridx = 1;
		gbc.gridy = 3;
		JLabel lblNombreLoteria = new JLabel("Loteria:");
		lblNombreLoteria.setForeground(Color.yellow);
		lblNombreLoteria.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(lblNombreLoteria, gbc);
		gbc.gridx = 2;
		gbc.gridy = 3;
		add(comboBoxNombreLoteriA, gbc);

		// Selector de Números
		Integer[] numeros = new Integer[10];
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = i;
		}

		comboBoxNumeros = new JComboBox[4];
		for (int i = 0; i < 4; i++) {
			comboBoxNumeros[i] = new JComboBox<>(numeros);
			comboBoxNumeros[i].setForeground(Color.white);
			comboBoxNumeros[i].setBackground(new Color(180, 16, 14));
			comboBoxNumeros[i].setPreferredSize(new Dimension(70, 70));
			gbc.gridx = i;
			gbc.gridy = 4;
			add(comboBoxNumeros[i], gbc);
		}

		lblNumeroSerie = new JLabel("Numero de serie: ");
		lblNumeroSerie.setForeground(Color.yellow);
		lblNumeroSerie.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNumeroSerie.setForeground(Color.white);
		gbc.gridx = 1;
		gbc.gridy = 5;
		add(lblNumeroSerie, gbc);

		txtNumeroSerie = new JTextField(24);
		gbc.gridx = 2;
		gbc.gridy = 5;
		add(txtNumeroSerie, gbc);

		lblValorApuesta = new JLabel("Valor Apuesta: ");
		lblValorApuesta.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblValorApuesta.setForeground(Color.white);
		gbc.gridx = 1;
		gbc.gridy = 7;
		add(lblValorApuesta, gbc);

		txtValorApuesta = new JTextField(24);
		gbc.gridx = 2;
		gbc.gridy = 7;
		add(txtValorApuesta, gbc);

		// Listener para el cambio de la sede
		comboBoxSede.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fireSedeChangeEvent();
			}
		});

		backgroundImage = new ImageIcon("./imgs/vLoteria.png").getImage();
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

	public void mostrarRecibo(LocalDate dia, String sede, Long cedulaApostador, int[] numeros, int numSerie,
			Double valorApuesta, int id) {
		String mensajeRecibo = "Fecha: " + dia.toString() + "\n" + "Sede: " + sede + "\n" + "Cédula Apostador: "
				+ cedulaApostador + "\n" + "Numeros: " + Arrays.toString(numeros) + "\n" + "Numero de Serie: "
				+ numSerie + "\n" + "Valor Apuesta: " + valorApuesta + "\n" + "ID: " + id;

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

	public JComboBox<String> getComboBoxNombreLoteriA() {
		return comboBoxNombreLoteriA;
	}

	public void setComboBoxNombreLoteriA(JComboBox<String> comboBoxNombreLoteriA) {
		this.comboBoxNombreLoteriA = comboBoxNombreLoteriA;
	}

	public JComboBox<Long> getComboBoxCedula() {
		return comboBoxCedula;
	}

	public void setComboBoxCedula(JComboBox<Long> comboBoxCedula) {
		this.comboBoxCedula = comboBoxCedula;
	}

	public JComboBox<Integer>[] getComboBoxNumeros() {
		return comboBoxNumeros;
	}

	public void setComboBoxNumeros(JComboBox<Integer>[] comboBoxNumeros) {
		this.comboBoxNumeros = comboBoxNumeros;
	}

	public JTextField getTxtValorApuesta() {
		return txtValorApuesta;
	}

	public void setTxtValorApuesta(JTextField txtValorApuesta) {
		this.txtValorApuesta = txtValorApuesta;
	}

	public JTextField getTxtNumeroSerie() {
		return txtNumeroSerie;
	}

	public void setTxtNumeroSerie(JTextField txtNumeroSerie) {
		this.txtNumeroSerie = txtNumeroSerie;
	}

	public JLabel getLblValorApuesta() {
		return lblValorApuesta;
	}

	public void setLblValorApuesta(JLabel lblValorApuesta) {
		this.lblValorApuesta = lblValorApuesta;
	}

	public JLabel getLblNumeroSerie() {
		return lblNumeroSerie;
	}

	public void setLblNumeroSerie(JLabel lblNumeroSerie) {
		this.lblNumeroSerie = lblNumeroSerie;
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
