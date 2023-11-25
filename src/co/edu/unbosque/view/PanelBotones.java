package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelBotones extends JPanel {

	private JButton btn;

	public PanelBotones() {
		// TODO Auto-generated constructor stub
		btn = new JButton("Ingresar");
		btn.setActionCommand("USUARIO");
		ImageIcon temporal1 = new ImageIcon("./imgs/button_ingresar.png");
		Image imtemporal1 = temporal1.getImage();
		int anchoD = 180;
		int alto = 66;
		Image imagenRed = imtemporal1.getScaledInstance(anchoD, alto, Image.SCALE_SMOOTH);
		btn.setIcon(new ImageIcon(imagenRed));
		btn.setBackground(Color.WHITE);
		btn.setPreferredSize(new Dimension(180, 66));
		add(btn);

	}

	public JButton getBtn() {
		return btn;
	}

	public void setBtn(JButton btn) {
		this.btn = btn;
	}

}
