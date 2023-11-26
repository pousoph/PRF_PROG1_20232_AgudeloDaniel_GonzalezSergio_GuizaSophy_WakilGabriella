package co.edu.unbosque.view;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 * 
 * Panel dedicado a la gestión de apostadores, que incluye un JComboBox para
 * seleccionar opciones de filtrado.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class PanelDepApostador extends JPanel {

	private JComboBox<String> opcionesfil;
	private Image backImage;

	/**
	 * Constructor que inicializa el panel de gestión de apostadores con un
	 * JComboBox y una imagen de fondo.
	 */

	public PanelDepApostador() {
		// TODO Auto-generated constructor stub
		setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(80, 80, 80, 80);
		opcionesfil = new JComboBox<String>();
		// setLayout(new GridLayout(1, 2));
		setVisible(true);
		opcionesfil.setSize(1500, 75);
		opcionesfil.setName("Filtrado");
		opcionesfil.addItem("Nombre");
		opcionesfil.addItem("Cedula");
		opcionesfil.addItem("Sede");

		add(opcionesfil);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(opcionesfil, gbc);

		backImage = new ImageIcon("./imgs/vApostadores.png").getImage();
		revalidate();
		repaint();
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

		if (backImage != null) {
			g.drawImage(backImage, 0, 0, getWidth(), getHeight(), this);
		}
	}

	/**
	 * Obtiene el JComboBox utilizado para seleccionar opciones de filtrado.
	 *
	 * @return El JComboBox de opciones de filtrado.
	 */

	public JComboBox<String> getOpcionesfil() {
		return opcionesfil;
	}

	/**
	 * Establece el JComboBox utilizado para seleccionar opciones de filtrado.
	 *
	 * @param opcionesfil El JComboBox de opciones de filtrado.
	 */

	public void setOpcionesfil(JComboBox<String> opcionesfil) {
		this.opcionesfil = opcionesfil;
	}

	/**
	 * Obtiene la imagen de fondo del panel.
	 *
	 * @return La imagen de fondo.
	 */

	public Image getBackImage() {
		return backImage;
	}

	/**
	 * Establece la imagen de fondo del panel.
	 *
	 * @param backImage La imagen de fondo.
	 */

	public void setBackImage(Image backImage) {
		this.backImage = backImage;
	}

}