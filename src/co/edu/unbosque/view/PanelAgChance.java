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
 * 
 * El panel PanelAgChance proporciona una interfaz gráfica para realizar
 * apuestas en el juego de chance.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class PanelAgChance extends JPanel {

	private JComboBox<String> comboBoxSede;
	private JComboBox<String> comboBoxNombreLoteriA;
	private JComboBox<Long> comboBoxCedula;
	private JComboBox<Integer>[] comboBoxNumeros;
	private JTextField txtValorApuesta;
	private JLabel lblValorApuesta;
	private Image backgroundImage;

	/**
	 * Constructor de la clase PanelAgChance. Inicializa la interfaz gráfica del
	 * panel y establece los componentes.
	 */

	public PanelAgChance() {
		// TODO Auto-generated constructor stub
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

		String[] nombreLoteria = { "Cundinamarca", "Tolima", "Cruz Roja", "Huila", "Valle", "Manizalez", "Meta",
				"Bogota", "Quindio", "Santander", "Medellin", "Risaralda", "Boyaca", "Cauca", "Extra" };
		comboBoxNombreLoteriA = new JComboBox<>(nombreLoteria);
		comboBoxNombreLoteriA.setForeground(Color.black);
		gbc.gridx = 1;
		gbc.gridy = 3;
		JLabel lblNombreLoteria = new JLabel("Loteria:");
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

		backgroundImage = new ImageIcon("./imgs/vChance.png").getImage();
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
	 * Notifica a los listeners de cambios en la sede que ha ocurrido un cambio en
	 * la selección de sede. Se dispara cuando se selecciona una sede diferente en
	 * el combo box.
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
	 * @param dia             La fecha de la apuesta.
	 * @param sede            El nombre de la sede de la apuesta.
	 * @param cedulaApostador La cédula del apostador.
	 * @param nombreLoteria   El nombre de la lotería.
	 * @param numeros         Los números seleccionados para la apuesta.
	 * @param valorApuesta    El valor de la apuesta.
	 * @param id              El identificador único de la apuesta.
	 */

	public void mostrarRecibo(LocalDate dia, String sede, Long cedulaApostador, String nombreLoteria, int[] numeros,
			Double valorApuesta, int id) {
		String mensajeRecibo = "Fecha: " + dia.toString() + "\n" + "Sede: " + sede + "\n" + "Cédula Apostador: "
				+ cedulaApostador + "\n" + "Nombre Loteria: " + nombreLoteria + "\n" + "Numeros: "
				+ Arrays.toString(numeros) + "\n" + "Valor Apuesta: " + valorApuesta + "\n" + "ID: " + id;

		JOptionPane.showMessageDialog(null, mensajeRecibo, "Recibo de Apuesta", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Sobrescribe el método paintComponent de JPanel para dibujar la imagen de
	 * fondo.
	 *
	 * @param g El contexto gráfico en el que se dibuja la imagen de fondo.
	 */

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
	}

	/**
	 * Obtiene el JComboBox que representa las sedes disponibles.
	 *
	 * @return El JComboBox de sedes.
	 */

	public JComboBox<String> getComboBoxSede() {
		return comboBoxSede;
	}

	/**
	 * Establece el JComboBox que representa las sedes disponibles.
	 *
	 * @param comboBoxSede El nuevo JComboBox de sedes.
	 */

	public void setComboBoxSede(JComboBox<String> comboBoxSede) {
		this.comboBoxSede = comboBoxSede;
	}

	/**
	 * Obtiene el JComboBox que representa las cédulas disponibles.
	 *
	 * @return El JComboBox de cédulas.
	 */

	public JComboBox<Long> getComboBoxCedula() {
		return comboBoxCedula;
	}

	/**
	 * Establece el JComboBox que representa las cédulas disponibles.
	 *
	 * @param comboBoxCedula El nuevo JComboBox de cédulas.
	 */

	public void setComboBoxCedula(JComboBox<Long> comboBoxCedula) {
		this.comboBoxCedula = comboBoxCedula;
	}

	/**
	 * Obtiene el arreglo de JComboBox que representa los números disponibles.
	 *
	 * @return El arreglo de JComboBox de números.
	 */

	public JComboBox<Integer>[] getComboBoxNumeros() {
		return comboBoxNumeros;
	}

	/**
	 * Establece el arreglo de JComboBox que representa los números disponibles.
	 *
	 * @param comboBoxNumeros El nuevo arreglo de JComboBox de números.
	 */

	public void setComboBoxNumeros(JComboBox<Integer>[] comboBoxNumeros) {
		this.comboBoxNumeros = comboBoxNumeros;
	}

	/**
	 * Obtiene el JTextField para ingresar el valor de la apuesta.
	 *
	 * @return El JTextField del valor de la apuesta.
	 */

	public JTextField getTxtValorApuesta() {
		return txtValorApuesta;
	}

	/**
	 * Establece el JTextField para ingresar el valor de la apuesta.
	 *
	 * @param txtValorApuesta El nuevo JTextField del valor de la apuesta.
	 */

	public void setTxtValorApuesta(JTextField txtValorApuesta) {
		this.txtValorApuesta = txtValorApuesta;
	}

	/**
	 * Obtiene el JLabel que muestra información sobre el valor de la apuesta.
	 *
	 * @return El JLabel del valor de la apuesta.
	 */

	public JLabel getLblValorApuesta() {
		return lblValorApuesta;
	}

	/**
	 * Establece el JLabel que muestra información sobre el valor de la apuesta.
	 *
	 * @param lblValorApuesta El nuevo JLabel del valor de la apuesta.
	 */

	public void setLblValorApuesta(JLabel lblValorApuesta) {
		this.lblValorApuesta = lblValorApuesta;
	}

	/**
	 * Obtiene la imagen de fondo del panel.
	 *
	 * @return La imagen de fondo.
	 */

	public Image getBackgroundImage() {
		return backgroundImage;
	}

	/**
	 * Establece la imagen de fondo del panel.
	 *
	 * @param backgroundImage La nueva imagen de fondo.
	 */

	public void setBackgroundImage(Image backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

	/**
	 * Obtiene la lista de listeners para cambios en la sede.
	 *
	 * @return La lista de listeners para cambios en la sede.
	 */

	public List<ActionListener> getSedeChangeListeners() {
		return sedeChangeListeners;
	}

	/**
	 * Obtiene el JComboBox que representa los nombres de las loterías disponibles.
	 *
	 * @return El JComboBox de nombres de loterías.
	 */

	public JComboBox<String> getComboBoxNombreLoteriA() {
		return comboBoxNombreLoteriA;
	}

	/**
	 * Establece el JComboBox que representa los nombres de las loterías
	 * disponibles.
	 *
	 * @param comboBoxNombreLoteriA El nuevo JComboBox de nombres de loterías.
	 */

	public void setComboBoxNombreLoteriA(JComboBox<String> comboBoxNombreLoteriA) {
		this.comboBoxNombreLoteriA = comboBoxNombreLoteriA;
	}

}