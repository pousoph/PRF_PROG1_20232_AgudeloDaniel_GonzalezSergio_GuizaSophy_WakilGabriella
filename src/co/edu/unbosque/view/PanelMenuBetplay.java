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
 * Panel que representa el menú de opciones para Betplay.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class PanelMenuBetplay extends JPanel {

	private JButton btn1, btn2, btn3, btn4, btn5;
	private Image img1;

	/**
	 * Constructor que inicializa el panel con botones y una imagen de fondo.
	 */

	public PanelMenuBetplay() {
		setLayout(new GridBagLayout()); // Usar un layout de cuadrícula para centrar los componentes verticalmente

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new java.awt.Insets(5, 5, 5, 5);

		img1 = new ImageIcon("./imgs/vBetplayMenu.png").getImage();

		// Botón Agregar
		btn1 = createButton("Agregar", "AGREGAR APBETPLAY", "./imgs/button_accAgregar.png");
		add(btn1, gbc);

		gbc.gridy++;
		// Botón Eliminar
		btn2 = createButton("Actualizar", "ACTUALIZAR APBETPLAY", "./imgs/button_accActualizar.png");
		add(btn2, gbc);

		gbc.gridy++;
		// Botón Actualizar
		btn3 = createButton("Eliminar", "ELIMINAR APBETPLAY", "./imgs/button_accEliminar.png");
		add(btn3, gbc);

		gbc.gridy++;
		// Botón Mostrar
		btn4 = createButton("Mostrar", "MOSTRAR APBETPLAY", "./imgs/button_accMostrar.png");
		add(btn4, gbc);

		gbc.gridy++;
		// Botón Salir
		btn5 = createButton("Salir", "SALIR APBETPLAY", "./imgs/button_salir.png");
		add(btn5, gbc);
	}

	/**
	 * Crea un JButton con las especificaciones dadas, incluyendo texto, comando de
	 * acción e imagen.
	 *
	 * @param text          Texto que se mostrará en el botón.
	 * @param actionCommand Comando de acción asociado al botón.
	 * @param imagePath     Ruta de la imagen que se utilizará como ícono en el
	 *                      botón.
	 * @return JButton creado con las especificaciones dadas.
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
	 * Sobrescribe el método paintComponent para dibujar una imagen de fondo en el
	 * panel.
	 *
	 * @param g El contexto de gráficos en el que se dibujará la imagen de fondo.
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
	 * @return JButton 1.
	 */

	public JButton getBtn1() {
		return btn1;
	}

	/**
	 * Establece el botón 1.
	 *
	 * @param btn1 JButton 1 a establecer.
	 */

	public void setBtn1(JButton btn1) {
		this.btn1 = btn1;
	}

	/**
	 * Obtiene el botón 2.
	 *
	 * @return JButton 2.
	 */

	public JButton getBtn2() {
		return btn2;
	}

	/**
	 * Establece el botón 2.
	 *
	 * @param btn2 JButton 2 a establecer.
	 */

	public void setBtn2(JButton btn2) {
		this.btn2 = btn2;
	}

	/**
	 * Obtiene el botón 3.
	 *
	 * @return JButton 3.
	 */

	public JButton getBtn3() {
		return btn3;
	}

	/**
	 * Establece el botón 3.
	 *
	 * @param btn3 JButton 3 a establecer.
	 */

	public void setBtn3(JButton btn3) {
		this.btn3 = btn3;
	}

	/**
	 * Obtiene el botón 4.
	 *
	 * @return JButton 4.
	 */

	public JButton getBtn4() {
		return btn4;
	}

	/**
	 * Establece el botón 4.
	 *
	 * @param btn4 JButton 4 a establecer.
	 */

	public void setBtn4(JButton btn4) {
		this.btn4 = btn4;
	}

	/**
	 * Obtiene el botón 5.
	 *
	 * @return JButton 5.
	 */

	public JButton getBtn5() {
		return btn5;
	}

	/**
	 * Establece el botón 5.
	 *
	 * @param btn5 JButton 5 a establecer.
	 */

	public void setBtn5(JButton btn5) {
		this.btn5 = btn5;
	}

	/**
	 * Obtiene la imagen de fondo.
	 *
	 * @return Imagen de fondo.
	 */

	public Image getImg1() {
		return img1;
	}

	/**
	 * Establece la imagen de fondo.
	 *
	 * @param img1 Imagen de fondo a establecer.
	 */

	public void setImg1(Image img1) {
		this.img1 = img1;
	}

}
