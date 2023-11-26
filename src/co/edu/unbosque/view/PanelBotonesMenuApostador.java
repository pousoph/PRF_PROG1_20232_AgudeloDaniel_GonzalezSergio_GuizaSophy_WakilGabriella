package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 
 * Panel que contiene botones para acciones relacionadas con los apostadores.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */
public class PanelBotonesMenuApostador extends JPanel {

	private JButton btn1, btn2, btn3, btn4, btn5, btn6;
	private Image img1;

	/**
	 * Constructor que inicializa el panel con botones y una imagen de fondo.
	 */

	public PanelBotonesMenuApostador() {
		// TODO Auto-generated constructor stub
		setLayout(new GridBagLayout()); // Usar un layout de cuadrícula para centrar los componentes verticalmente

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new java.awt.Insets(5, 5, 5, 5);

		img1 = new ImageIcon("./imgs/vApostadores.png").getImage();

		// Botón Agregar
		btn1 = createButton("Agregar", "AGREGAR APOSTADOR", "./imgs/button_accAgregar.png");
		add(btn1, gbc);

		gbc.gridy++;
		// Botón Actualizar
		btn2 = createButton("Actualizar", "ACTUALIZAR APOSTADOR", "./imgs/button_accActualizar.png");
		add(btn2, gbc);

		gbc.gridy++;
		// Botón Eliminar
		btn3 = createButton("Eliminar", "ELIMINAR APOSTADOR", "./imgs/button_accEliminar.png");
		add(btn3, gbc);

		gbc.gridy++;
		// Botón Mostrar
		btn4 = createButton("Mostrar", "MOSTRAR APOSTADOR", "./imgs/button_accMostrar.png");
		add(btn4, gbc);

		gbc.gridy++;
		// Botón Filtrar
		btn5 = createButton("Filtrar", "FILTRAR APOSTADOR", "./imgs/button_accFiltrar.png");
		add(btn5, gbc);

		gbc.gridy++;
		// Botón Salir
		btn6 = createButton("Salir", "SALIR APOSTADOR", "./imgs/button_salir.png");
		add(btn6, gbc);
	}

	/**
	 * Crea y configura un botón con un texto, un comando de acción y una imagen.
	 *
	 * @param text          El texto que se mostrará en el botón.
	 * @param actionCommand El comando de acción asociado al botón.
	 * @param imagePath     La ruta de la imagen que se utilizará como ícono del
	 *                      botón.
	 * @return Un nuevo objeto JButton configurado con el texto, el comando de
	 *         acción y la imagen proporcionados.
	 */

	private JButton createButton(String text, String actionCommand, String imagePath) {
		JButton button = new JButton(text);
		button.setActionCommand(actionCommand);
		button.setBackground(new Color(134, 124, 157));
		ImageIcon temporal = new ImageIcon(imagePath);
		Image image = temporal.getImage();
		int ancho = 180;
		int alto = 66;
		Image imagenRed = image.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
		button.setIcon(new ImageIcon(imagenRed));
		button.setPreferredSize(new Dimension(180, 66));
		return button;
	}

	/**
	 * Método que se llama cuando se necesita repintar el componente.
	 *
	 * @param g El contexto gráfico en el que se va a pintar.
	 */

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (img1 != null) {
			g.drawImage(img1, 0, 0, getWidth(), getHeight(), this);
		}
	}

	/**
	 * Obtiene el primer botón.
	 *
	 * @return El primer botón.
	 */

	public JButton getBtn1() {
		return btn1;
	}

	/**
	 * Establece el primer botón.
	 *
	 * @param btn1 El nuevo primer botón.
	 */

	public void setBtn1(JButton btn1) {
		this.btn1 = btn1;
	}

	/**
	 * Obtiene el segundo botón.
	 *
	 * @return El segundo botón.
	 */

	public JButton getBtn2() {
		return btn2;
	}

	/**
	 * Establece el segundo botón.
	 *
	 * @param btn2 El nuevo segundo botón.
	 */

	public void setBtn2(JButton btn2) {
		this.btn2 = btn2;
	}

	/**
	 * Obtiene el tercer botón.
	 *
	 * @return El tercer botón.
	 */

	public JButton getBtn3() {
		return btn3;
	}

	/**
	 * Establece el tercer botón.
	 *
	 * @param btn3 El nuevo tercer botón.
	 */

	public void setBtn3(JButton btn3) {
		this.btn3 = btn3;
	}

	/**
	 * Obtiene el cuarto botón.
	 *
	 * @return El cuarto botón.
	 */

	public JButton getBtn4() {
		return btn4;
	}

	/**
	 * Establece el cuarto botón.
	 *
	 * @param btn4 El nuevo cuarto botón.
	 */

	public void setBtn4(JButton btn4) {
		this.btn4 = btn4;
	}

	/**
	 * Obtiene el quinto botón.
	 *
	 * @return El quinto botón.
	 */

	public JButton getBtn5() {
		return btn5;
	}

	/**
	 * Establece el quinto botón.
	 *
	 * @param btn5 El nuevo quinto botón.
	 */

	public void setBtn5(JButton btn5) {
		this.btn5 = btn5;
	}

	/**
	 * Obtiene el sexto botón.
	 *
	 * @return El sexto botón.
	 */

	public JButton getBtn6() {
		return btn6;
	}

	/**
	 * Establece el sexto botón.
	 *
	 * @param btn6 El nuevo sexto botón.
	 */

	public void setBtn6(JButton btn6) {
		this.btn6 = btn6;
	}

	/**
	 * Obtiene la imagen de fondo.
	 *
	 * @return La imagen de fondo.
	 */

	public Image getImg1() {
		return img1;
	}

	/**
	 * Establece la imagen de fondo.
	 *
	 * @param img1 La nueva imagen de fondo.
	 */

	public void setImg1(Image img1) {
		this.img1 = img1;
	}

}