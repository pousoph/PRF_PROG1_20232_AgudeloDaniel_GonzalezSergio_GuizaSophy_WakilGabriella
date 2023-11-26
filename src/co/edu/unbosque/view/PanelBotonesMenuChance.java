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
 * Panel que contiene botones para realizar operaciones relacionadas con el
 * juego de Chance.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class PanelBotonesMenuChance extends JPanel {

	private JButton btn1, btn2, btn3, btn4, btn5;
	private Image img1;

	/**
	 * Constructor que configura el panel con un layout de cuadrícula y agrega
	 * botones con imágenes.
	 */

	public PanelBotonesMenuChance() {
		// TODO Auto-generated constructor stub
		setLayout(new GridBagLayout()); // Usar un layout de cuadrícula para centrar los componentes verticalmente

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new java.awt.Insets(5, 5, 5, 5);

		img1 = new ImageIcon("./imgs/vChanceMenu.png").getImage();

		// Botón Agregar
		btn1 = createButton("Agregar", "AGREGAR APCHANCE", "./imgs/button_accAgregar.png");
		add(btn1, gbc);

		gbc.gridy++;
		// Botón Eliminar
		btn2 = createButton("Eliminar", "ACTUALIZAR APCHANCE", "./imgs/button_accActualizar.png");
		add(btn2, gbc);

		gbc.gridy++;
		// Botón Actualizar
		btn3 = createButton("Eliminar", "ELIMINAR APBCHANCE", "./imgs/button_accEliminar.png");
		add(btn3, gbc);

		gbc.gridy++;
		// Botón Mostrar
		btn4 = createButton("Mostrar", "MOSTRAR APCHANCE", "./imgs/button_accMostrar.png");
		add(btn4, gbc);

		gbc.gridy++;
		// Botón Salir
		btn5 = createButton("Salir", "SALIR APCHANCE", "./imgs/button_salir.png");
		add(btn5, gbc);
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
	 * Sobrescribe el método paintComponent para dibujar una imagen de fondo.
	 *
	 * @param g El contexto gráfico.
	 */

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (img1 != null) {
			g.drawImage(img1, 0, 0, getWidth(), getHeight(), this);
		}
	}

	/**
	 * Obtiene el botón 1 del panel, utilizado para la operación de "Agregar" en el
	 * menú de Chance.
	 *
	 * @return El JButton asociado al botón "Agregar".
	 */

	public JButton getBtn1() {
		return btn1;
	}

	/**
	 * Establece el botón 1 del panel, utilizado para la operación de "Agregar" en
	 * el menú de Chance.
	 *
	 * @param btn1 El nuevo JButton para el botón "Agregar".
	 */

	public void setBtn1(JButton btn1) {
		this.btn1 = btn1;
	}

	/**
	 * Obtiene el botón 2 del panel, utilizado para la operación de "Actualizar" en
	 * el menú de Chance.
	 *
	 * @return El JButton asociado al botón "Actualizar".
	 */

	public JButton getBtn2() {
		return btn2;
	}

	/**
	 * Establece el botón 2 del panel, utilizado para la operación de "Actualizar"
	 * en el menú de Chance.
	 *
	 * @param btn2 El nuevo JButton para el botón "Actualizar".
	 */

	public void setBtn2(JButton btn2) {
		this.btn2 = btn2;
	}

	/**
	 * Obtiene el botón 3 del panel, utilizado para la operación de "Eliminar" en el
	 * menú de Chance.
	 *
	 * @return El JButton asociado al botón "Eliminar".
	 */

	public JButton getBtn3() {
		return btn3;
	}

	/**
	 * Establece el botón 3 del panel, utilizado para la operación de "Eliminar" en
	 * el menú de Chance.
	 *
	 * @param btn3 El nuevo JButton para el botón "Eliminar".
	 */

	public void setBtn3(JButton btn3) {
		this.btn3 = btn3;
	}

	/**
	 * Obtiene el botón 4 del panel, utilizado para la operación de "Mostrar" en el
	 * menú de Chance.
	 *
	 * @return El JButton asociado al botón "Mostrar".
	 */

	public JButton getBtn4() {
		return btn4;
	}

	/**
	 * Establece el botón 4 del panel, utilizado para la operación de "Mostrar" en
	 * el menú de Chance.
	 *
	 * @param btn4 El nuevo JButton para el botón "Mostrar".
	 */

	public void setBtn4(JButton btn4) {
		this.btn4 = btn4;
	}

	/**
	 * Obtiene el botón 5 del panel, utilizado para la operación de "Salir" en el
	 * menú de Chance.
	 *
	 * @return El JButton asociado al botón "Salir".
	 */

	public JButton getBtn5() {
		return btn5;
	}

	/**
	 * Establece el botón 5 del panel, utilizado para la operación de "Salir" en el
	 * menú de Chance.
	 *
	 * @param btn5 El nuevo JButton para el botón "Salir".
	 */

	public void setBtn5(JButton btn5) {
		this.btn5 = btn5;
	}

	/**
	 * Obtiene la imagen utilizada como fondo del panel.
	 *
	 * @return La imagen de fondo del panel.
	 */

	public Image getImg1() {
		return img1;
	}

	/**
	 * Establece la imagen utilizada como fondo del panel.
	 *
	 * @param img1 La nueva imagen de fondo del panel.
	 */

	public void setImg1(Image img1) {
		this.img1 = img1;
	}

}