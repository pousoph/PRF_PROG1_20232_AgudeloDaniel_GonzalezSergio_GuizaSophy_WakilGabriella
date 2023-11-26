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

/**
 * 
 * La clase PanelAgLoteria es un JPanel personalizado que proporciona una
 * interfaz para realizar apuestas en juegos de lotería. Contiene componentes
 * como JComboBox, JTextField, JLabel y una imagen de fondo.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class PanelAgLoteria extends JPanel {

	// Selector de la ubicación (sede) para la apuesta.
	private JComboBox<String> comboBoxSede;

	// Selector del nombre de la lotería para la apuesta.
	private JComboBox<String> comboBoxNombreLoteriA;

	// Selector de la cédula del apostador.
	private JComboBox<Long> comboBoxCedula;

	// Arreglo de selectores para los números de la apuesta.
	private JComboBox<Integer>[] comboBoxNumeros;

	// Campos de texto para ingresar el valor de la apuesta y el número de serie.
	private JTextField txtValorApuesta, txtNumeroSerie;

	// Etiquetas para los campos de valor de apuesta y número de serie.
	private JLabel lblValorApuesta, lblNumeroSerie;

	// Imagen de fondo del panel.
	private Image backgroundImage;

	/**
	 * Constructor de la clase PanelAgLoteria. Inicializa la interfaz gráfica del
	 * panel y establece los componentes.
	 */

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

	/**
	 * Agrega un listener para cambios en la sede.
	 *
	 * @param listener El listener que responderá a cambios en la sede.
	 */

	public void addSedeChangeListener(ActionListener listener) {
		sedeChangeListeners.add(listener);
	}

	/**
	 * Remueve un listener para cambios en la sede.
	 *
	 * @param listener El listener que se eliminará.
	 */

	public void removeSedeChangeListener(ActionListener listener) {
		sedeChangeListeners.remove(listener);
	}

	/**
	 * Obtiene la sede seleccionada en el combo box.
	 *
	 * @return El nombre de la sede seleccionada.
	 */

	public String getSedeSeleccionada() {
		return (String) comboBoxSede.getSelectedItem();
	}

	/**
	 * Actualiza las cédulas en el combo box de acuerdo a la sede seleccionada.
	 *
	 * @param cedulas Lista de cédulas disponibles.
	 */

	public void actualizarCedulas(List<Long> cedulas) {
		String sedeSeleccionada = getSedeSeleccionada();
		if (sedeSeleccionada != null) {
			comboBoxCedula.removeAllItems();
			for (Long cedula : cedulas) {
				comboBoxCedula.addItem(cedula);
			}
		}
	}

	/**
	 * Dispara un evento de cambio de sede a todos los listeners registrados.
	 */

	private void fireSedeChangeEvent() {
		String sedeSeleccionada = getSedeSeleccionada();
		for (ActionListener listener : sedeChangeListeners) {
			listener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, sedeSeleccionada));
		}
	}

	private final List<ActionListener> sedeChangeListeners = new LinkedList<>();

	/**
	 * Muestra un recibo de apuesta en un cuadro de diálogo.
	 *
	 * @param dia             Fecha de la apuesta.
	 * @param sede            Sede de la apuesta.
	 * @param cedulaApostador Cédula del apostador.
	 * @param numeros         Números de la apuesta.
	 * @param numSerie        Número de serie.
	 * @param valorApuesta    Valor de la apuesta.
	 * @param id              Identificador de la apuesta.
	 */

	public void mostrarRecibo(LocalDate dia, String sede, Long cedulaApostador, int[] numeros, int numSerie,
			Double valorApuesta, int id) {
		String mensajeRecibo = "Fecha: " + dia.toString() + "\n" + "Sede: " + sede + "\n" + "Cédula Apostador: "
				+ cedulaApostador + "\n" + "Numeros: " + Arrays.toString(numeros) + "\n" + "Numero de Serie: "
				+ numSerie + "\n" + "Valor Apuesta: " + valorApuesta + "\n" + "ID: " + id;

		JOptionPane.showMessageDialog(null, mensajeRecibo, "Recibo de Apuesta", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Sobrescribe el método paintComponent para dibujar la imagen de fondo.
	 *
	 * @param g Objeto Graphics para dibujar.
	 */

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
	}

	/**
	 * Obtiene el JComboBox de la sede.
	 *
	 * @return JComboBox de la sede.
	 */

	public JComboBox<String> getComboBoxSede() {
		return comboBoxSede;
	}

	/**
	 * Establece el JComboBox de la sede.
	 *
	 * @param comboBoxSede Nuevo JComboBox de la sede.
	 */

	public void setComboBoxSede(JComboBox<String> comboBoxSede) {
		this.comboBoxSede = comboBoxSede;
	}

	/**
	 * Obtiene el JComboBox del nombre de la lotería.
	 *
	 * @return JComboBox del nombre de la lotería.
	 */

	public JComboBox<String> getComboBoxNombreLoteriA() {
		return comboBoxNombreLoteriA;
	}

	/**
	 * Establece el JComboBox del nombre de la lotería.
	 *
	 * @param comboBoxNombreLoteriA Nuevo JComboBox del nombre de la lotería.
	 */

	public void setComboBoxNombreLoteriA(JComboBox<String> comboBoxNombreLoteriA) {
		this.comboBoxNombreLoteriA = comboBoxNombreLoteriA;
	}

	/**
	 * Obtiene el JComboBox de la cédula.
	 *
	 * @return JComboBox de la cédula.
	 */

	public JComboBox<Long> getComboBoxCedula() {
		return comboBoxCedula;
	}

	/**
	 * Establece el JComboBox de la cédula.
	 *
	 * @param comboBoxCedula Nuevo JComboBox de la cédula.
	 */

	public void setComboBoxCedula(JComboBox<Long> comboBoxCedula) {
		this.comboBoxCedula = comboBoxCedula;
	}

	/**
	 * Obtiene el arreglo de JComboBox de los números.
	 *
	 * @return Arreglo de JComboBox de los números.
	 */

	public JComboBox<Integer>[] getComboBoxNumeros() {
		return comboBoxNumeros;
	}

	/**
	 * Establece el arreglo de JComboBox de los números.
	 *
	 * @param comboBoxNumeros Nuevo arreglo de JComboBox de los números.
	 */

	public void setComboBoxNumeros(JComboBox<Integer>[] comboBoxNumeros) {
		this.comboBoxNumeros = comboBoxNumeros;
	}

	/**
	 * Obtiene el JTextField del valor de la apuesta.
	 *
	 * @return JTextField del valor de la apuesta.
	 */

	public JTextField getTxtValorApuesta() {
		return txtValorApuesta;
	}

	/**
	 * Establece el JTextField del valor de la apuesta.
	 *
	 * @param txtValorApuesta Nuevo JTextField del valor de la apuesta.
	 */

	public void setTxtValorApuesta(JTextField txtValorApuesta) {
		this.txtValorApuesta = txtValorApuesta;
	}

	/**
	 * Obtiene el JTextField del número de serie.
	 *
	 * @return JTextField del número de serie.
	 */

	public JTextField getTxtNumeroSerie() {
		return txtNumeroSerie;
	}

	/**
	 * Establece el JTextField del número de serie.
	 *
	 * @param txtNumeroSerie Nuevo JTextField del número de serie.
	 */

	public void setTxtNumeroSerie(JTextField txtNumeroSerie) {
		this.txtNumeroSerie = txtNumeroSerie;
	}

	/**
	 * Obtiene la JLabel del valor de la apuesta.
	 *
	 * @return JLabel del valor de la apuesta.
	 */

	public JLabel getLblValorApuesta() {
		return lblValorApuesta;
	}

	/**
	 * Establece la JLabel del valor de la apuesta.
	 *
	 * @param lblValorApuesta Nueva JLabel del valor de la apuesta.
	 */

	public void setLblValorApuesta(JLabel lblValorApuesta) {
		this.lblValorApuesta = lblValorApuesta;
	}

	/**
	 * Obtiene la JLabel del número de serie.
	 *
	 * @return JLabel del número de serie.
	 */

	public JLabel getLblNumeroSerie() {
		return lblNumeroSerie;
	}

	/**
	 * Establece la JLabel del número de serie.
	 *
	 * @param lblNumeroSerie Nueva JLabel del número de serie.
	 */

	public void setLblNumeroSerie(JLabel lblNumeroSerie) {
		this.lblNumeroSerie = lblNumeroSerie;
	}

	/**
	 * Obtiene la Image de fondo del panel.
	 *
	 * @return Image de fondo del panel.
	 */

	public Image getBackgroundImage() {
		return backgroundImage;
	}

	/**
	 * Establece la Image de fondo del panel.
	 *
	 * @param backgroundImage Nueva Image de fondo del panel.
	 */

	public void setBackgroundImage(Image backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

	/**
	 * Obtiene la lista de listeners para cambios en la sede.
	 *
	 * @return Lista de listeners para cambios en la sede.
	 */

	public List<ActionListener> getSedeChangeListeners() {
		return sedeChangeListeners;
	}

}