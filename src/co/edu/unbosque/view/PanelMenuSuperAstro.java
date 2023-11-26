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
 * Panel que contiene botones para acceder a diferentes funciones relacionadas
 * con SuperAstro.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class PanelMenuSuperAstro extends JPanel {

	private JButton btn1, btn2, btn3, btn4, btn5;
	private Image img1;

	/**
	 * Constructor de la clase PanelMenuSuperAstro. Configura el diseño del panel y
	 * agrega botones con funcionalidades específicas de SuperAstro.
	 */

	public PanelMenuSuperAstro() {
		setLayout(new GridBagLayout()); // Usar un layout de cuadrícula para centrar los componentes verticalmente

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new java.awt.Insets(5, 5, 5, 5);

		img1 = new ImageIcon("./imgs/vSuperAstroMenu.png").getImage();

		// Botón Agregar
		btn1 = createButton("Agregar", "AGREGAR APSUPERASTRO", "./imgs/button_accAgregar.png");
		add(btn1, gbc);

		gbc.gridy++;
		// Botón Eliminar
		btn2 = createButton("Actualizar", "ACTUALIZAR APSUPERASTRO", "./imgs/button_accActualizar.png");
		add(btn2, gbc);

		gbc.gridy++;
		// Botón Actualizar
		btn3 = createButton("Eliminar", "ELIMINAR APSUPERASTRO", "./imgs/button_accEliminar.png");
		add(btn3, gbc);

		gbc.gridy++;
		// Botón Mostrar
		btn4 = createButton("Mostrar", "MOSTRAR APSUPERASTRO", "./imgs/button_accMostrar.png");
		add(btn4, gbc);

		gbc.gridy++;
		// Botón Salir
		btn5 = createButton("Salir", "SALIR APSUPERASTRO", "./imgs/button_salir.png");
		add(btn5, gbc);
	}

	/**
	 * Crea un botón con un texto, comando de acción y una imagen específica.
	 *
	 * @param text          Texto que se mostrará en el botón.
	 * @param actionCommand Comando de acción asociado al botón.
	 * @param imagePath     Ruta de la imagen que se utilizará en el botón.
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
	 * Sobrescribe el método paintComponent para dibujar la imagen de fondo del
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
	 * Obtiene el primer botón del panel.
	 *
	 * @return JButton que representa el primer botón del panel.
	 */

	public JButton getBtn1() {
		return btn1;
	}

	/**
	 * Establece el primer botón del panel.
	 *
	 * @param btn1 Nuevo JButton que se establecerá como el primer botón del panel.
	 */

	public void setBtn1(JButton btn1) {
		this.btn1 = btn1;
	}

	/**
	 * Obtiene el segundo botón del panel.
	 *
	 * @return JButton que representa el segundo botón del panel.
	 */

	public JButton getBtn2() {
		return btn2;
	}

	/**
	 * Establece el segundo botón del panel.
	 *
	 * @param btn2 Nuevo JButton que se establecerá como el segundo botón del panel.
	 */

	public void setBtn2(JButton btn2) {
		this.btn2 = btn2;
	}

	/**
	 * Obtiene el tercer botón del panel.
	 *
	 * @return JButton que representa el tercer botón del panel.
	 */

	public JButton getBtn3() {
		return btn3;
	}

	/**
	 * Establece el tercer botón del panel.
	 *
	 * @param btn3 Nuevo JButton que se establecerá como el tercer botón del panel.
	 */

	public void setBtn3(JButton btn3) {
		this.btn3 = btn3;
	}

	/**
	 * Obtiene el cuarto botón del panel.
	 *
	 * @return JButton que representa el cuarto botón del panel.
	 */

	public JButton getBtn4() {
		return btn4;
	}

	/**
	 * Establece el cuarto botón del panel.
	 *
	 * @param btn4 Nuevo JButton que se establecerá como el cuarto botón del panel.
	 */

	public void setBtn4(JButton btn4) {
		this.btn4 = btn4;
	}

	/**
	 * Obtiene el quinto botón del panel.
	 *
	 * @return JButton que representa el quinto botón del panel.
	 */

	public JButton getBtn5() {
		return btn5;
	}

	/**
	 * Establece el quinto botón del panel.
	 *
	 * @param btn5 Nuevo JButton que se establecerá como el quinto botón del panel.
	 */

	public void setBtn5(JButton btn5) {
		this.btn5 = btn5;
	}

	/**
	 * Obtiene la imagen asociada al panel.
	 *
	 * @return Image que representa la imagen de fondo del panel.
	 */

	public Image getImg1() {
		return img1;
	}

	/**
	 * Establece la imagen de fondo del panel.
	 *
	 * @param img1 Nueva Image que se establecerá como la imagen de fondo del panel.
	 */

	public void setImg1(Image img1) {
		this.img1 = img1;
	}

}