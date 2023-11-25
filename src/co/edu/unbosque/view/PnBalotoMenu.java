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

public class PnBalotoMenu extends JPanel {

	private JButton btn1, btn2, btn3, btn4, btn5;
	private Image img1;

	public PnBalotoMenu() {
		setLayout(new GridBagLayout()); // Usar un layout de cuadrícula para centrar los componentes verticalmente

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new java.awt.Insets(5, 5, 5, 5);

		img1 = new ImageIcon("./imgs/vBalotoMenu.png").getImage();

		// Botón Agregar
		btn1 = createButton("Agregar", "AGREGAR APBALOTO", "./imgs/button_accAgregar.png");
		add(btn1, gbc);

		gbc.gridy++;
		// Botón Eliminar
		btn2 = createButton("Eliminar", "ACTUALIZAR APBALOTO", "./imgs/button_accActualizar.png");
		add(btn2, gbc);

		gbc.gridy++;
		// Botón Actualizar
		btn3 = createButton("Eliminar", "ELIMINAR APBALOTO", "./imgs/button_accEliminar.png");
		add(btn3, gbc);

		gbc.gridy++;
		// Botón Mostrar
		btn4 = createButton("Mostrar", "MOSTRAR APBALOTO", "./imgs/button_accMostrar.png");
		add(btn4, gbc);

		gbc.gridy++;
		// Botón Salir
		btn5 = createButton("Salir", "SALIR APBALOTOMENU", "./imgs/button_salir.png");
		add(btn5, gbc);
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

	public JButton getBtn1() {
		return btn1;
	}

	public void setBtn1(JButton btn1) {
		this.btn1 = btn1;
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

	public JButton getBtn4() {
		return btn4;
	}

	public void setBtn4(JButton btn4) {
		this.btn4 = btn4;
	}

	public JButton getBtn5() {
		return btn5;
	}

	public void setBtn5(JButton btn5) {
		this.btn5 = btn5;
	}

	public Image getImg1() {
		return img1;
	}

	public void setImg1(Image img1) {
		this.img1 = img1;
	}

}
