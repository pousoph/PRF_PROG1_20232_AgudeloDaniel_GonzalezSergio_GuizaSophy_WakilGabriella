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

/**
 * 
 * La clase `PanelAgApBetplay` representa un panel para realizar apuestas de
 * Betplay en la aplicación. Proporciona interfaces gráficas para seleccionar la
 * sede, cédula, partido, resultado y valor de la apuesta.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class PanelAgApBetplay extends JPanel {

	/**
	 * JComboBox que almacena nombres de sedes como cadenas de texto.
	 */
	private JComboBox<String> comboBoxSede;

	/**
	 * JComboBox que almacena nombres de partidos como cadenas de texto.
	 */
	private JComboBox<String> comboBoxPartidos;

	/**
	 * JComboBox que almacena resultados de apuestas como cadenas de texto.
	 */
	private JComboBox<String> comboBoxResultado;

	/**
	 * JComboBox que almacena números de cédula como valores long.
	 */
	private JComboBox<Long> comboBoxCedula;

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
	 * Constructor de la clase `PanelAgApBetplay`. Inicializa y configura los
	 * componentes gráficos del panel.
	 */

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

	/**
	 * Agrega un listener para el cambio de sede.
	 *
	 * @param listener El listener a agregar.
	 */

	public void addSedeChangeListener(ActionListener listener) {
		sedeChangeListeners.add(listener);
	}

	/**
	 * Elimina un listener para el cambio de sede.
	 *
	 * @param listener El listener a eliminar.
	 */

	public void removeSedeChangeListener(ActionListener listener) {
		sedeChangeListeners.remove(listener);
	}

	/**
	 * Obtiene la sede seleccionada en el JComboBox.
	 *
	 * @return La sede seleccionada.
	 */

	public String getSedeSeleccionada() {
		return (String) comboBoxSede.getSelectedItem();
	}

	/**
	 * Actualiza las opciones del JComboBox de cédulas.
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
	 * Método privado que dispara un evento de cambio de sede.
	 */

	private void fireSedeChangeEvent() {
		String sedeSeleccionada = getSedeSeleccionada();
		for (ActionListener listener : sedeChangeListeners) {
			listener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, sedeSeleccionada));
		}
	}

	private final List<ActionListener> sedeChangeListeners = new LinkedList<>();

	/**
	 * Muestra un recibo de apuesta mediante un cuadro de diálogo.
	 *
	 * @param dia             La fecha de la apuesta.
	 * @param sede            La sede de la apuesta.
	 * @param cedulaApostador La cédula del apostador.
	 * @param partido         El partido seleccionado.
	 * @param resultado       El resultado seleccionado.
	 * @param valorApuesta    El valor de la apuesta.
	 * @param id              El identificador de la apuesta.
	 */

	public void mostrarRecibo(LocalDate dia, String sede, Long cedulaApostador, String partido, String resultado,
			Double valorApuesta, int id) {
		String mensajeRecibo = "Fecha: " + dia.toString() + "\n" + "Sede: " + sede + "\n" + "Cédula Apostador: "
				+ cedulaApostador + "\n" + "Partido: " + partido + "\n" + "Resultado: " + resultado + "\n"
				+ "Valor Apuesta: " + valorApuesta + "\n" + "ID: " + id;

		JOptionPane.showMessageDialog(null, mensajeRecibo, "Recibo de Apuesta", JOptionPane.INFORMATION_MESSAGE);
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
	 * Obtiene el JComboBox que representa la selección de los partidos.
	 *
	 * @return El JComboBox que representa la selección de los partidos.
	 */

	public JComboBox<String> getComboBoxPartidos() {
		return comboBoxPartidos;
	}

	/**
	 * Establece el JComboBox que representa la selección de los partidos.
	 *
	 * @param comboBoxPartidos El JComboBox que se establecerá como la selección de
	 *                         los partidos.
	 */

	public void setComboBoxPartidos(JComboBox<String> comboBoxPartidos) {
		this.comboBoxPartidos = comboBoxPartidos;
	}

	/**
	 * Obtiene el JComboBox que representa la selección de los resultados.
	 *
	 * @return El JComboBox que representa la selección de los resultados.
	 */

	public JComboBox<String> getComboBoxResultado() {
		return comboBoxResultado;
	}

	/**
	 * Establece el JComboBox que representa la selección de los resultados.
	 *
	 * @param comboBoxResultado El JComboBox que se establecerá como la selección de
	 *                          los resultados.
	 */

	public void setComboBoxResultado(JComboBox<String> comboBoxResultado) {
		this.comboBoxResultado = comboBoxResultado;
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