package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelBotonesRegistro extends JPanel{
	
	private JButton btn4, btn5;
	
	public PanelBotonesRegistro() {
		// TODO Auto-generated constructor stub
		btn4 = new JButton("Registrarse");
		btn4.setActionCommand("REGISTRARSE");
		btn4.setBackground(new Color(134, 124, 157));
		ImageIcon temporal3 = new ImageIcon("./imgs/button_registrarse1.png");
		Image imTemporal3 = temporal3.getImage();
		int anchoD4 = 231;
		int alto4 = 54;
		Image imagenRed4 = imTemporal3.getScaledInstance(anchoD4, alto4, Image.SCALE_SMOOTH);
		btn4.setIcon(new ImageIcon(imagenRed4));
		btn4.setPreferredSize(new Dimension(231,54));
		add(btn4);
		
		btn5 = new JButton("Salir");
		btn5.setActionCommand("SALIR REGISTRO");
		btn5.setBackground(new Color(134, 124, 157));
		ImageIcon temporal4 = new ImageIcon("./imgs/button_salir.png");
		Image imTemporal4 = temporal4.getImage();
		int anchoD5 = 180;
		int alto5 = 54;
		Image imagenRed5 = imTemporal4.getScaledInstance(anchoD5, alto5, Image.SCALE_SMOOTH);
		btn5.setIcon(new ImageIcon(imagenRed5));
		btn5.setPreferredSize(new Dimension(180,54));
		add(btn5);
		
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
	

}
