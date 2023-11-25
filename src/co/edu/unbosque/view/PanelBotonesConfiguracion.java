package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelBotonesConfiguracion extends JPanel {

	private Image img1;
	private JButton btn, btn2, btn3;

	public PanelBotonesConfiguracion() {
		setLayout(new GridBagLayout()); // Usar un layout de cuadrícula para centrar los componentes verticalmente

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new java.awt.Insets(5, 5, 10, 5); // Ajustar la parte inferior a 10 píxeles

		img1 = new ImageIcon("./imgs/vConfiguracion.png").getImage();

		btn = createButton("Casa Apuestas", "CONFG CASA APUESTAS", "./imgs/button_confgCasa.png");
		add(btn, gbc);

		gbc.gridy++;
		btn2 = createButton("Juegos", "CONFG JUEGOS", "./imgs/button_congJuegos.png");
		add(btn2, gbc);

		gbc.gridy++;
		btn3 = createButton("Salir", "SALIR CONFG", "./imgs/button_salir.png");
		add(btn3, gbc);
	}

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

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (img1 != null) {
			g.drawImage(img1, 0, 0, getWidth(), getHeight(), this);
		}
	}

	public Image getImg1() {
		return img1;
	}

	public void setImg1(Image img1) {
		this.img1 = img1;
	}

	public JButton getBtn() {
		return btn;
	}

	public void setBtn(JButton btn) {
		this.btn = btn;
	}

	public JButton getBtn2() {
		return btn2;
	}

	public void setBtn2(JButton btn2) {
		this.btn2 = btn2;
	}

	public JButton getBtn3() {
		return btn3;
	}

	public void setBtn3(JButton btn3) {
		this.btn3 = btn3;
	}
}
