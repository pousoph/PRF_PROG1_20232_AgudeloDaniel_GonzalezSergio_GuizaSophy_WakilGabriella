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
 * PanelAgSuperAstro es una clase que representa un panel para agregar
 * información de una apuesta en Super Astro. Este panel incluye campos para la
 * sede, la cédula del apostador, el signo zodiacal, los números apostados y el
 * valor de la apuesta. También tiene un fondo de imagen.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class PanelAgSuperAstro extends JPanel {

	/**
	 * ComboBox para seleccionar la sede de la apuesta.
	 */
	private JComboBox<String> comboBoxSede;

	/**
	 * ComboBox para seleccionar el signo zodiacal de la apuesta.
	 */
	private JComboBox<String> comboBoxSignoZodiacal;

	/**
	 * ComboBox para seleccionar la cédula del apostador.
	 */
	private JComboBox<Long> comboBoxCedula;

	/**
	 * Arreglo de ComboBox para seleccionar los números apostados.
	 */
	private JComboBox<Integer>[] comboBoxNumeros;

	/**
	 * Campo de texto para ingresar el valor de la apuesta.
	 */
	private JTextField txtValorApuesta;

	/**
	 * Etiqueta para mostrar información sobre el valor de la apuesta.
	 */
	private JLabel lblValorApuesta;

	/**
	 * Imagen de fondo del panel.
	 */
	private Image backgroundImage;

	/**
	 * Constructor de la clase PanelAgSuperAstro. Inicializa y configura los
	 * componentes del panel.
	 */

	public PanelAgSuperAstro() {
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
		gbc.gridy = 0;
		JLabel labelUbicacion = new JLabel("Ubicacion:");
		labelUbicacion.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(labelUbicacion, gbc);
		gbc.gridx = 2;
		gbc.gridy = 0;
		add(comboBoxSede, gbc);

		// Selector de Cédula
		comboBoxCedula = new JComboBox<>();
		comboBoxCedula.setForeground(Color.black);
		gbc.gridx = 1;
		gbc.gridy = 2;
		JLabel labelCedula = new JLabel("Cedula:");
		labelCedula.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(labelCedula, gbc);
		gbc.gridx = 2;
		gbc.gridy = 2;
		add(comboBoxCedula, gbc);

		String[] signoZodiacal = { "Aries", "Tauro", "Geminis", "Cancer", "Leo", "Virgo", "Libra", "Escorpio",
				"Sagitario", "Capricornio", "Acuario", "Piscis" };
		comboBoxSignoZodiacal = new JComboBox<>(signoZodiacal);
		comboBoxSignoZodiacal.setForeground(Color.black);
		gbc.gridx = 1;
		gbc.gridy = 3;
		JLabel lblSignoZodiacal = new JLabel("Signo Zodiacal:");
		lblSignoZodiacal.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSignoZodiacal.setForeground(Color.white);
		add(lblSignoZodiacal, gbc);
		gbc.gridx = 2;
		gbc.gridy = 3;
		add(comboBoxSignoZodiacal, gbc);

		// Selector de Números
		Integer[] numeros = new Integer[10];
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = i;
		}

		comboBoxNumeros = new JComboBox[4];
		for (int i = 0; i < 4; i++) {
			comboBoxNumeros[i] = new JComboBox<>(numeros);
			comboBoxNumeros[i].setForeground(Color.black);
			comboBoxNumeros[i].setBackground(Color.WHITE);
			comboBoxNumeros[i].setPreferredSize(new Dimension(70, 70));
			gbc.gridx = i;
			gbc.gridy = 4;
			add(comboBoxNumeros[i], gbc);
		}

		lblValorApuesta = new JLabel("Valor Apuesta: ");
		lblValorApuesta.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblValorApuesta.setForeground(Color.BLACK);
		gbc.gridx = 1;
		gbc.gridy = 5;
		add(lblValorApuesta, gbc);

		txtValorApuesta = new JTextField(24);
		gbc.gridx = 2;
		gbc.gridy = 5;
		add(txtValorApuesta, gbc);

		// Listener para el cambio de la sede
		comboBoxSede.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fireSedeChangeEvent();
			}
		});

		backgroundImage = new ImageIcon("./imgs/vSuperAstro.png").getImage();
	}

	/**
	 * Agrega un listener para el cambio de sede.
	 *
	 * @param listener ActionListener a agregar.
	 */

	public void addSedeChangeListener(ActionListener listener) {
		sedeChangeListeners.add(listener);
	}

	/**
	 * Remueve un listener para el cambio de sede.
	 *
	 * @param listener ActionListener a remover.
	 */

	public void removeSedeChangeListener(ActionListener listener) {
		sedeChangeListeners.remove(listener);
	}

	/**
	 * Obtiene la sede seleccionada en el combo box.
	 *
	 * @return String con la sede seleccionada.
	 */

	public String getSedeSeleccionada() {
		return (String) comboBoxSede.getSelectedItem();
	}

	/**
	 * Actualiza las cédulas en el combo box según la sede seleccionada.
	 *
	 * @param cedulas Lista de cédulas a mostrar.
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
	 * Método privado para disparar el evento de cambio de sede.
	 */

	private void fireSedeChangeEvent() {
		String sedeSeleccionada = getSedeSeleccionada();
		for (ActionListener listener : sedeChangeListeners) {
			listener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, sedeSeleccionada));
		}
	}

	private final List<ActionListener> sedeChangeListeners = new LinkedList<>();

	/**
	 * Muestra un recibo de la apuesta con la información proporcionada.
	 *
	 * @param dia             Fecha de la apuesta.
	 * @param sede            Sede de la apuesta.
	 * @param cedulaApostador Cédula del apostador.
	 * @param numeros         Números apostados.
	 * @param signoZodiacal   Signo zodiacal apostado.
	 * @param valorApuesta    Valor de la apuesta.
	 * @param id              Identificador de la apuesta.
	 */

	public void mostrarRecibo(LocalDate dia, String sede, Long cedulaApostador, int[] numeros, String signoZodiacal,
			Double valorApuesta, int id) {
		String mensajeRecibo = "Fecha: " + dia.toString() + "\n" + "Sede: " + sede + "\n" + "Cédula Apostador: "
				+ cedulaApostador + "\n" + "Numeros: " + Arrays.toString(numeros) + "\n" + "Signo Zodical: "
				+ signoZodiacal + "\n" + "Valor Apuesta: " + valorApuesta + "\n" + "ID: " + id;

		JOptionPane.showMessageDialog(null, mensajeRecibo, "Recibo de Apuesta Baloto", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Sobrescribe el método paintComponent para dibujar la imagen de fondo en el
	 * panel.
	 *
	 * @param g Objeto Graphics utilizado para dibujar.
	 */

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
	}

	/**
	 * Obtiene el ComboBox para seleccionar la sede de la apuesta.
	 *
	 * @return ComboBox de la sede.
	 */

	public JComboBox<String> getComboBoxSede() {
		return comboBoxSede;
	}

	/**
	 * Establece el ComboBox para seleccionar la sede de la apuesta.
	 *
	 * @param comboBoxSede ComboBox de la sede a establecer.
	 */

	public void setComboBoxSede(JComboBox<String> comboBoxSede) {
		this.comboBoxSede = comboBoxSede;
	}

	/**
	 * Obtiene el ComboBox para seleccionar el signo zodiacal de la apuesta.
	 *
	 * @return ComboBox del signo zodiacal.
	 */

	public JComboBox<String> getComboBoxSignoZodiacal() {
		return comboBoxSignoZodiacal;
	}

	/**
	 * Establece el ComboBox para seleccionar el signo zodiacal de la apuesta.
	 *
	 * @param comboBoxSignoZodiacal ComboBox del signo zodiacal a establecer.
	 */

	public void setComboBoxSignoZodiacal(JComboBox<String> comboBoxSignoZodiacal) {
		this.comboBoxSignoZodiacal = comboBoxSignoZodiacal;
	}

	/**
	 * Obtiene el ComboBox para seleccionar la cédula del apostador.
	 *
	 * @return ComboBox de la cédula.
	 */

	public JComboBox<Long> getComboBoxCedula() {
		return comboBoxCedula;
	}

	/**
	 * Establece el ComboBox para seleccionar la cédula del apostador.
	 *
	 * @param comboBoxCedula ComboBox de la cédula a establecer.
	 */

	public void setComboBoxCedula(JComboBox<Long> comboBoxCedula) {
		this.comboBoxCedula = comboBoxCedula;
	}

	/**
	 * Obtiene el arreglo de ComboBox para seleccionar los números apostados.
	 *
	 * @return Arreglo de ComboBox de números.
	 */

	public JComboBox<Integer>[] getComboBoxNumeros() {
		return comboBoxNumeros;
	}

	/**
	 * Establece el arreglo de ComboBox para seleccionar los números apostados.
	 *
	 * @param comboBoxNumeros Arreglo de ComboBox de números a establecer.
	 */

	public void setComboBoxNumeros(JComboBox<Integer>[] comboBoxNumeros) {
		this.comboBoxNumeros = comboBoxNumeros;
	}

	/**
	 * Obtiene el campo de texto para ingresar el valor de la apuesta.
	 *
	 * @return Campo de texto para el valor de la apuesta.
	 */

	public JTextField getTxtValorApuesta() {
		return txtValorApuesta;
	}

	/**
	 * Establece el campo de texto para ingresar el valor de la apuesta.
	 *
	 * @param txtValorApuesta Campo de texto para el valor de la apuesta a
	 *                        establecer.
	 */

	public void setTxtValorApuesta(JTextField txtValorApuesta) {
		this.txtValorApuesta = txtValorApuesta;
	}

	/**
	 * Obtiene la etiqueta para mostrar información sobre el valor de la apuesta.
	 *
	 * @return Etiqueta para el valor de la apuesta.
	 */

	public JLabel getLblValorApuesta() {
		return lblValorApuesta;
	}

	/**
	 * Establece la etiqueta para mostrar información sobre el valor de la apuesta.
	 *
	 * @param lblValorApuesta Etiqueta para el valor de la apuesta a establecer.
	 */

	public void setLblValorApuesta(JLabel lblValorApuesta) {
		this.lblValorApuesta = lblValorApuesta;
	}

	/**
	 * Obtiene la imagen de fondo del panel.
	 *
	 * @return Imagen de fondo.
	 */

	public Image getBackgroundImage() {
		return backgroundImage;
	}

	/**
	 * Establece la imagen de fondo del panel.
	 *
	 * @param backgroundImage Imagen de fondo a establecer.
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