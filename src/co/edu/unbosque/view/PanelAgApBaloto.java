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
 * La clase `PanelAgApBaloto` representa un panel para realizar apuestas de
 * Baloto en la aplicación. Proporciona interfaces gráficas para seleccionar la
 * sede, cédula, números y valor de la apuesta.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class PanelAgApBaloto extends JPanel {

	/**
	 * JComboBox que almacena nombres de sedes como cadenas de texto.
	 */
	private JComboBox<String> comboBoxSede;

	/**
	 * JComboBox que almacena números de cédula como valores long.
	 */

	private JComboBox<Long> comboBoxCedula;

	/**
	 * Arreglo de JComboBox que almacena números como valores enteros.
	 */

	private JComboBox<Integer>[] comboBoxNumeros;

	/**
	 * JTextField para ingresar un valor de apuesta.
	 */

	private JTextField txtValorApuesta;

	/**
	 * JLabel que muestra información sobre el valor de apuesta.
	 */

	private JLabel lblValorApuesta;

	/**
	 * Almacena una imagen de fondo para la interfaz gráfica.
	 */

	private Image backgroundImage;

	/**
	 * Construye una nueva instancia de PanelAgApBaloto. Configura la apariencia y
	 * disposición de los elementos en el panel.
	 */

	public PanelAgApBaloto() {
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
		gbc.gridy = 1;
		JLabel labelCedula = new JLabel("Cedula:");
		labelCedula.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(labelCedula, gbc);
		gbc.gridx = 2;
		gbc.gridy = 1;
		add(comboBoxCedula, gbc);

		// Selector de Números
		Integer[] numeros = new Integer[46];
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = i + 1;
		}

		comboBoxNumeros = new JComboBox[6];
		for (int i = 0; i < 6; i++) {
			comboBoxNumeros[i] = new JComboBox<>(numeros);
			comboBoxNumeros[i].setForeground(Color.black);
			comboBoxNumeros[i].setBackground(new Color(239, 200, 31));
			comboBoxNumeros[i].setPreferredSize(new Dimension(70, 70));
			gbc.gridx = i;
			gbc.gridy = 2;
			add(comboBoxNumeros[i], gbc);
		}

		lblValorApuesta = new JLabel("Valor Apuesta: ");
		lblValorApuesta.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblValorApuesta.setForeground(Color.BLACK);
		gbc.gridx = 1;
		gbc.gridy = 3;
		add(lblValorApuesta, gbc);

		txtValorApuesta = new JTextField(24);
		gbc.gridx = 2;
		gbc.gridy = 3;
		add(txtValorApuesta, gbc);

		// Listener para el cambio de la sede
		comboBoxSede.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fireSedeChangeEvent();
			}
		});

		backgroundImage = new ImageIcon("./imgs/vApBaloto.png").getImage();
	}

	/**
	 * Agrega un listener para el cambio de la sede.
	 *
	 * @param listener El listener a agregar.
	 */

	public void addSedeChangeListener(ActionListener listener) {
		sedeChangeListeners.add(listener);
	}

	/**
	 * Remueve un listener para el cambio de la sede.
	 *
	 * @param listener El listener a remover.
	 */

	public void removeSedeChangeListener(ActionListener listener) {
		sedeChangeListeners.remove(listener);
	}

	/**
	 * Obtiene la sede seleccionada en el panel.
	 *
	 * @return La sede seleccionada.
	 */

	public String getSedeSeleccionada() {
		return (String) comboBoxSede.getSelectedItem();
	}

	/**
	 * Actualiza las opciones del selector de cédula.
	 *
	 * @param cedulas La lista de cédulas a mostrar.
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
	 * Dispara el evento de cambio de sede a todos los listeners registrados.
	 * Notifica a cada ActionListener que la sede ha cambiado mediante la creación
	 * de un nuevo ActionEvent y la invocación del método actionPerformed en cada
	 * listener.
	 * 
	 * @see ActionListener
	 * @see ActionEvent
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
	 * @param sede            La sede de la apuesta.
	 * @param cedulaApostador La cédula del apostador.
	 * @param numeros         Los números seleccionados para la apuesta.
	 * @param valorApuesta    El valor de la apuesta.
	 * @param id              El identificador de la apuesta.
	 */

	public void mostrarRecibo(LocalDate dia, String sede, Long cedulaApostador, int[] numeros, Double valorApuesta,
			int id) {
		String mensajeRecibo = "Fecha: " + dia.toString() + "\n" + "Sede: " + sede + "\n" + "Cédula Apostador: "
				+ cedulaApostador + "\n" + "numeros: " + Arrays.toString(numeros) + "\n" + "Valor Apuesta: "
				+ valorApuesta + "\n" + "ID: " + id;

		JOptionPane.showMessageDialog(null, mensajeRecibo, "Recibo de Apuesta Baloto", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Sobrescribe el método `paintComponent` para dibujar la imagen de fondo.
	 *
	 * @param g El objeto Graphics utilizado para dibujar.
	 * @see Graphics
	 */

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
	}

	/**
	 * Obtiene el JComboBox que representa la selección de la sede.
	 *
	 * @return El JComboBox que representa la selección de la sede.
	 */

	public JComboBox<String> getComboBoxSede() {
		return comboBoxSede;
	}

	/**
	 * Establece el JComboBox que representa la selección de la sede.
	 *
	 * @param comboBoxSede El JComboBox que se establecerá como la selección de la
	 *                     sede.
	 */

	public void setComboBoxSede(JComboBox<String> comboBoxSede) {
		this.comboBoxSede = comboBoxSede;
	}

	/**
	 * Obtiene el JComboBox que representa la selección de la cédula.
	 *
	 * @return El JComboBox que representa la selección de la cédula.
	 */

	public JComboBox<Long> getComboBoxCedula() {
		return comboBoxCedula;
	}

	/**
	 * Establece el JComboBox que representa la selección de la cédula.
	 *
	 * @param comboBoxCedula El JComboBox que se establecerá como la selección de la
	 *                       cédula.
	 */

	public void setComboBoxCedula(JComboBox<Long> comboBoxCedula) {
		this.comboBoxCedula = comboBoxCedula;
	}

	/**
	 * Obtiene un arreglo de JComboBox que representa la selección de números.
	 *
	 * @return Un arreglo de JComboBox que representa la selección de números.
	 */

	public JComboBox<Integer>[] getComboBoxNumeros() {
		return comboBoxNumeros;
	}

	/**
	 * Establece un arreglo de JComboBox que representa la selección de números.
	 *
	 * @param comboBoxNumeros El arreglo de JComboBox que se establecerá como la
	 *                        selección de números.
	 */

	public void setComboBoxNumeros(JComboBox<Integer>[] comboBoxNumeros) {
		this.comboBoxNumeros = comboBoxNumeros;
	}

	/**
	 * Obtiene el JTextField que representa el valor de la apuesta.
	 *
	 * @return El JTextField que representa el valor de la apuesta.
	 */

	public JTextField getTxtValorApuesta() {
		return txtValorApuesta;
	}

	/**
	 * Establece el JTextField que representa el valor de la apuesta.
	 *
	 * @param txtValorApuesta El JTextField que se establecerá como el valor de la
	 *                        apuesta.
	 */

	public void setTxtValorApuesta(JTextField txtValorApuesta) {
		this.txtValorApuesta = txtValorApuesta;
	}

	/**
	 * Obtiene el JLabel que representa la etiqueta del valor de la apuesta.
	 *
	 * @return El JLabel que representa la etiqueta del valor de la apuesta.
	 */

	public JLabel getLblValorApuesta() {
		return lblValorApuesta;
	}

	/**
	 * Establece el JLabel que representa la etiqueta del valor de la apuesta.
	 *
	 * @param lblValorApuesta El JLabel que se establecerá como la etiqueta del
	 *                        valor de la apuesta.
	 */

	public void setLblValorApuesta(JLabel lblValorApuesta) {
		this.lblValorApuesta = lblValorApuesta;
	}

	/**
	 * Obtiene la imagen de fondo del panel.
	 *
	 * @return La imagen de fondo del panel.
	 */

	public Image getBackgroundImage() {
		return backgroundImage;
	}

	/**
	 * Establece la imagen de fondo del panel.
	 *
	 * @param backgroundImage La imagen que se establecerá como fondo del panel.
	 */

	public void setBackgroundImage(Image backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

	/**
	 * Obtiene la lista de listeners para el cambio de sede.
	 *
	 * @return La lista de listeners para el cambio de sede.
	 */

	public List<ActionListener> getSedeChangeListeners() {
		return sedeChangeListeners;
	}

}