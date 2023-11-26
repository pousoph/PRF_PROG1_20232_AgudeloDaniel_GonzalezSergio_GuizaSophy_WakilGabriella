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
 * Panel que contiene botones para acceder a diferentes funcionalidades
 * relacionadas con las sedes.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class PanelBotonesMenuSede extends JPanel {

	private JButton btn1, btn2, btn3;
	private Image img1;

	/**
	 * Constructor que inicializa el panel con botones para agregar sedes, modificar
	 * sedes y salir.
	 */

	public PanelBotonesMenuSede() {
		// TODO Auto-generated constructor stub

		setLayout(new GridBagLayout()); // Usar un layout de cuadrícula para centrar los componentes verticalmente

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new java.awt.Insets(5, 5, 5, 5);

		img1 = new ImageIcon("./imgs/vSedes.png").getImage();

		btn1 = createButton("Agregar Sede", "AGREGAR SEDE", "./imgs/button_accAgregar.png");
		add(btn1, gbc);

		gbc.gridy++;
		btn2 = createButton("Mod. Sede", "MODIFICAR SEDE", "./imgs/button_accModificar.png");
		add(btn2, gbc);

		gbc.gridy++;
		btn3 = createButton("Salir", "SALIR SEDE", "./imgs/button_salir.png");
		add(btn3, gbc);
	}

	/**
	 * Crea un botón personalizado con el texto, comando y ruta de imagen
	 * proporcionados.
	 *
	 * @param text          El texto que se mostrará en el botón.
	 * @param actionCommand El comando asociado al botón.
	 * @param imagePath     La ruta de la imagen que se utilizará como icono del
	 *                      botón.
	 * @return El JButton personalizado.
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
	 * Sobrescribe el método paintComponent para dibujar la imagen de fondo.
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
	 * Obtiene el botón 1.
	 *
	 * @return El botón 1.
	 */

	public JButton getBtn1() {
		return btn1;
	}

	/**
	 * Establece el botón 1.
	 *
	 * @param btn1 El nuevo botón 1.
	 */

	public void setBtn1(JButton btn1) {
		this.btn1 = btn1;
	}

	/**
	 * Obtiene el botón 2.
	 *
	 * @return El botón 2.
	 */

	public JButton getBtn2() {
		return btn2;
	}

	/**
	 * Establece el botón 2.
	 *
	 * @param btn2 El nuevo botón 2.
	 */

	public void setBtn2(JButton btn2) {
		this.btn2 = btn2;
	}

	/**
	 * Obtiene el botón 3.
	 *
	 * @return El botón 3.
	 */

	public JButton getBtn3() {
		return btn3;
	}

	/**
	 * Establece el botón 3.
	 *
	 * @param btn3 El nuevo botón 3.
	 */

	public void setBtn3(JButton btn3) {
		this.btn3 = btn3;
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