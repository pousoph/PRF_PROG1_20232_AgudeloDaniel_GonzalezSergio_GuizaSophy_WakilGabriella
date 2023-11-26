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
 * Panel de menú para la gestión de loterías.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class PnMenuLoteria extends JPanel {

	private JButton btn1, btn2, btn3, btn4, btn5;
	private Image img1;

	/**
	 * Crea un nuevo panel de menú para la gestión de loterías.
	 */

	public PnMenuLoteria() {
		setLayout(new GridBagLayout()); // Usar un layout de cuadrícula para centrar los componentes verticalmente

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new java.awt.Insets(5, 5, 5, 5);

		img1 = new ImageIcon("./imgs/vLoteriaMenu.png").getImage();

		// Botón Agregar
		btn1 = createButton("Agregar", "AGREGAR APLOTERIA", "./imgs/button_accAgregar.png");
		add(btn1, gbc);

		gbc.gridy++;
		// Botón Eliminar
		btn2 = createButton("Eliminar", "ACTUALIZAR APLOTERIA", "./imgs/button_accActualizar.png");
		add(btn2, gbc);

		gbc.gridy++;
		// Botón Actualizar
		btn3 = createButton("Eliminar", "ELIMINAR APLOTERIA", "./imgs/button_accEliminar.png");
		add(btn3, gbc);

		gbc.gridy++;
		// Botón Mostrar
		btn4 = createButton("Mostrar", "MOSTRAR APLOTERIA", "./imgs/button_accMostrar.png");
		add(btn4, gbc);

		gbc.gridy++;
		// Botón Salir
		btn5 = createButton("Salir", "SALIR APLOTERIA", "./imgs/button_salir.png");
		add(btn5, gbc);
	}

	/**
	 * Crea un nuevo botón con las propiedades específicas.
	 *
	 * @param text          Texto que se muestra en el botón.
	 * @param actionCommand Comando de acción asociado al botón.
	 * @param imagePath     Ruta de la imagen utilizada como ícono del botón.
	 * @return Nuevo JButton configurado con las propiedades especificadas.
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
	 * @param g Objeto Graphics utilizado para dibujar.
	 */

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (img1 != null) {
			g.drawImage(img1, 0, 0, getWidth(), getHeight(), this);
		}
	}

	/**
	 * Obtiene el primer botón del menú.
	 *
	 * @return El primer botón del menú.
	 */

	public JButton getBtn1() {
		return btn1;
	}

	/**
	 * Establece el primer botón del menú.
	 *
	 * @param btn1 Nuevo botón a establecer.
	 */

	public void setBtn1(JButton btn1) {
		this.btn1 = btn1;
	}

	/**
	 * Obtiene el segundo botón del menú.
	 *
	 * @return El segundo botón del menú.
	 */

	public JButton getBtn2() {
		return btn2;
	}

	/**
	 * Establece el segundo botón del menú.
	 *
	 * @param btn2 Nuevo botón a establecer.
	 */

	public void setBtn2(JButton btn2) {
		this.btn2 = btn2;
	}

	/**
	 * Obtiene el tercer botón del menú.
	 *
	 * @return El tercer botón del menú.
	 */

	public JButton getBtn3() {
		return btn3;
	}

	/**
	 * Establece el tercer botón del menú.
	 *
	 * @param btn3 Nuevo botón a establecer.
	 */

	public void setBtn3(JButton btn3) {
		this.btn3 = btn3;
	}

	/**
	 * Obtiene el cuarto botón del menú.
	 *
	 * @return El cuarto botón del menú.
	 */

	public JButton getBtn4() {
		return btn4;
	}

	/**
	 * Establece el cuarto botón del menú.
	 *
	 * @param btn4 Nuevo botón a establecer.
	 */

	public void setBtn4(JButton btn4) {
		this.btn4 = btn4;
	}

	/**
	 * Obtiene el quinto botón del menú.
	 *
	 * @return El quinto botón del menú.
	 */

	public JButton getBtn5() {
		return btn5;
	}

	/**
	 * Establece el quinto botón del menú.
	 *
	 * @param btn5 Nuevo botón a establecer.
	 */

	public void setBtn5(JButton btn5) {
		this.btn5 = btn5;
	}

	/**
	 * Obtiene la imagen de fondo del menú.
	 *
	 * @return La imagen de fondo del menú.
	 */

	public Image getImg1() {
		return img1;
	}

	/**
	 * Establece la imagen de fondo del menú.
	 *
	 * @param img1 Nueva imagen de fondo a establecer.
	 */

	public void setImg1(Image img1) {
		this.img1 = img1;
	}

}